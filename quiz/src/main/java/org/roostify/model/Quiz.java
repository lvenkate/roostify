package org.roostify.model;

import java.util.List;

public class Quiz {

    int id;
    int nQuestions;
    List<Question> questions;

    public Quiz(final int pid,
         final int pNQuestions) {
        id = pid;
        nQuestions = pNQuestions;
    }


    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> pQuestions) {
        this.questions = pQuestions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getnQuestions() {
        return nQuestions;
    }

    public void setnQuestions(int nQuestions) {
        this.nQuestions = nQuestions;
    }

}
