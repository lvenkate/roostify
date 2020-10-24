package org.roostify.model;

/**
 * Placeholder that describes structure of a question.
 */
public class Question {

    String question;
    Option options;

    public void setOptions(Option options) {
        this.options = options;
    }

    public Option getOptions() {
        return options;
    }

    public Question(String question, Option pOptions) {
        this.question = question;
        this.options = pOptions;

    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "Question{" +
                "question='" + question + '\'' +
                ", options=" + options +
                '}';
    }
}
