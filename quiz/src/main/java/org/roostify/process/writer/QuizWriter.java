package org.roostify.process.writer;

import org.roostify.Writing;
import org.roostify.model.Question;
import org.roostify.model.Quiz;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

@Component("quiz-writer")
//@Log4j2
public class QuizWriter implements Writing<Quiz> {

    @Override
    public void write(final String filename, final Quiz item) throws IOException {
        FileWriter fileWriter = new FileWriter(filename, true);
        BufferedWriter bw = new BufferedWriter(fileWriter);
        PrintWriter printWriter = new PrintWriter(bw);
        int counter = 0;
        for (Question q : item.getQuestions()) {
            printWriter.println("Q" + ++counter +" " + q.getQuestion());
            String[] choices = q.getOptions().getChoices();
            int aLength = choices.length;
            for(int i = 0; i < aLength && i < 26; i++) {
                int c = i + 97;
                char o = (char) c;
                printWriter.println(o + ")" + choices[i]);
            }
        }
        printWriter.close();
    }
}
