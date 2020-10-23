package org.roostify.endpoint.student;

import org.roostify.Writing;
import org.roostify.config.endpoint.EndpointConfig;
import org.roostify.endpoint.admin.QuizResponse;
import org.roostify.utility.GeneralUtilities;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Responsible routing answer requests.
 */
@RestController
@CrossOrigin(methods = {POST})
public class GeographyQuizAnswerEndpoint {
    Writing<String> answerWriter;

    public GeographyQuizAnswerEndpoint(@Qualifier("answer-writer") Writing<String> pWriter) {
        answerWriter = pWriter;
    }

    @RequestMapping(
            value = EndpointConfig.AnswerQuiz.Path.NAME,
            method = POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<QuizResponse> submit(
            @RequestBody final QuizAnswer request) {
        System.out.println(request.toString());
        HttpStatus status = null;
        QuizResponse response = new QuizResponse();
        if (request.answers == null || request.answers.length == 0) {
            response.setMessage("The request is not served, you have not answered any question");
            status = HttpStatus.EXPECTATION_FAILED;
            return new ResponseEntity<QuizResponse>(response, status);
        }

        try {
            boolean answer = GeneralUtilities.create(request.studentId);
            if (answer) {
                response.setMessage("Your file is created successfully, await the result soon");
                status = HttpStatus.CREATED;
            } else {
                response.setMessage("The request is not served");
                status = HttpStatus.EXPECTATION_FAILED;
                return new ResponseEntity<QuizResponse>(response, status);
            }

                answerWriter.write(request.studentId, request.quizID);
                for (String s : request.answers) {
                    answerWriter.write(request.studentId, s);
                }

        } catch (Exception ex) {
            status = HttpStatus.EXPECTATION_FAILED;
        }
        return new ResponseEntity<QuizResponse>(response, status);
    }

}
