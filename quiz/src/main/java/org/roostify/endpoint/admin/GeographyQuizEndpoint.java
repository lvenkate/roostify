package org.roostify.endpoint.admin;

import org.roostify.config.endpoint.EndpointConfig;
import org.roostify.process.processor.QuizGenerator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Requests to operate on quiz resources.
 */
@RestController
@CrossOrigin(methods = {POST, DELETE})
public class GeographyQuizEndpoint {

    final QuizGenerator generator;

    public GeographyQuizEndpoint(@Qualifier("quiz-generator") final QuizGenerator pGenerator) {
        generator = pGenerator;
    }

    @RequestMapping(
            value = EndpointConfig.RequestGenerateQuiz.Path.NAME,
            method = POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<QuizResponse> generate(
            @RequestBody final QuizRequest request) throws IOException {
        HttpStatus status = null;
        QuizResponse response = new QuizResponse();
        try {
            String path = generator.generate(request.sets, request.nQuestions, request.nOptions);
            if (!path.equals(" ")) {
                response.setMessage("The files are generated in " + path);
                status = HttpStatus.CREATED;
            } else {
                response.setMessage("The request is not served");
                status = HttpStatus.EXPECTATION_FAILED;
            }
        } catch (Exception ex) {
            status = HttpStatus.EXPECTATION_FAILED;
        }
        return new ResponseEntity<QuizResponse>(response, status);
    }

    @RequestMapping(
            value = EndpointConfig.RequestGenerateQuiz.Path.NAME,
            method = DELETE,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<QuizResponse> remove(
            @RequestBody final CleanRequest request) {
        HttpStatus status = null;
        System.out.println("Deleting:"  + request.dirName);
        QuizResponse response = new QuizResponse();
        try {
            boolean result = generator.remove(request.dirName);
            if (!result) {
                response.setMessage("Could not remove file/files from directory " + request.dirName);
                status = HttpStatus.EXPECTATION_FAILED;
            } else {
                response.setMessage("The folder is clean successfully");
                status = HttpStatus.OK;
            }
        } catch (Exception ex) {
            status = HttpStatus.EXPECTATION_FAILED;
        }
        return new ResponseEntity<QuizResponse>(response, status);
    }
}
