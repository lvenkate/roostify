package org.roostify.endpoint.student;

import java.util.Arrays;

/**
 * Format to respond to a quiz.
 */
public class QuizAnswer {
    String quizID;
    String[] answers;

    String studentId;

    public String getQuizID() {
        return quizID;
    }

    public void setQuizID(String quizID) {
        this.quizID = quizID;
    }

    public String[] getAnswers() {
        return answers;
    }

    public void setAnswers(String[] answers) {
        this.answers = answers;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "QuizAnswer{" +
                "quizID='" + quizID + '\'' +
                ", answers=" + Arrays.toString(answers) +
                ", studentId='" + studentId + '\'' +
                '}';
    }

}
