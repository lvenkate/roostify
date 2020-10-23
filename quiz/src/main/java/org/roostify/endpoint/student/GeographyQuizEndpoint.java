package org.roostify.endpoint.student;

import org.roostify.Writing;
import org.roostify.config.endpoint.Endpoint;
import org.roostify.endpoint.admin.QuizResponse;
import org.roostify.utility.GeneralUtilities;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

public class GeographyQuizEndpoint {
    Writing<String> answerWriter;

    public GeographyQuizEndpoint(@Qualifier("answer-writer") Writing<String> pWriter) {
        answerWriter = pWriter;
    }

    @RequestMapping(
            value = Endpoint.RequestGenerateQuiz.Path.NAME,
            method = POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<QuizResponse> submit(
            final QuizAnswer request) {
        HttpStatus status = null;
        QuizResponse response = new QuizResponse();
        try {
            boolean answer = GeneralUtilities.create(request.studentName);
            if (answer) {
                response.setMessage("Your file is created successfully, await the result soon");
                status = HttpStatus.CREATED;
            } else {
                response.setMessage("The request is not served");
                status = HttpStatus.EXPECTATION_FAILED;
            }
            if (request.answers == null || request.answers.length == 0) {
                response.setMessage("The request is not served, you have not answered any question");
                status = HttpStatus.EXPECTATION_FAILED;
            } else {
                for (String s : request.answers) {
                    answerWriter.write(request.studentName, s);
                }
            }
        } catch (Exception ex) {
            status = HttpStatus.EXPECTATION_FAILED;
        }
        return new ResponseEntity<QuizResponse>(response, status);
    }

}
