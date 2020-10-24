package org.roostify.model;

import java.util.Arrays;

/**
 * Placeholder to capture choice and the answer.
 * TODO Think about it. This might as well be coupled with Question.
 */
public class Option {
    String[] choices;
    int answerId;

    public Option(String[] pChoices, int pAnswerId) {
        this.choices = pChoices;
        this.answerId = pAnswerId;
    }

    public String[] getChoices() {
        return choices;
    }

    public void setChoices(String[] choices) {
        this.choices = choices;
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    @Override
    public String toString() {
        return "Option{" +
                "choices=" + Arrays.toString(choices) +
                ", answerId=" + answerId +
                '}';
    }

}
