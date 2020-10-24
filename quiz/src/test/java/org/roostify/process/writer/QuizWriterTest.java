package org.roostify.process.writer;

import org.junit.Before;
import org.junit.Test;
import org.roostify.model.Option;
import org.roostify.model.Question;
import org.roostify.model.Quiz;
import org.roostify.utility.GeneralUtilities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class QuizWriterTest {

    QuizWriter writer;
    Quiz item;
    String fileName = "Quiztest.txt";
    @Before
    public void setUp() throws Exception {
        writer = new QuizWriter();
        GeneralUtilities.create(fileName);
        List<Question> questionList = generateQuestions();
        item = new Quiz(1, 2);
        item.setQuestions(questionList);
    }

    private List<Question> generateQuestions() {
        List<Question> questions = new ArrayList<>();
        String[] choices1 = new String[] {"Chuck", "Bill", "Norris", "Lewis"};
        Option options1 = new Option(choices1, 2);
        Question q1 = new Question("What is your name?" , options1);
        String[] choices2 = new String[] {"23", "34", "56", "67"};
        Option options2 = new Option(choices2, 2);
        Question q2 = new Question("What is your age?" , options2);
        questions.add(q1);
        questions.add(q2);
        return questions;
    }

    @Test
    public void write_or_append_when_file_in_existing_file() throws IOException {
        writer.write(fileName, item);
    }
}