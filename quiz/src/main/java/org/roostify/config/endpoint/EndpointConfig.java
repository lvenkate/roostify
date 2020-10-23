package org.roostify.config.endpoint;

/**
 * @author lvenkateswaran
 * Endpoints to access the resources.
 */
public class EndpointConfig {

    public static abstract class RequestGenerateQuiz {
        public static abstract class Path {
            public final static String NAME = "/api/v1/quizes";
        }
    }

    public static abstract class AnswerQuiz {
        public static abstract class Path {
            public final static String NAME = "/api/v1/answer";
        }
    }

}