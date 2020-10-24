package org.roostify.process.writer;

import org.roostify.Writing;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

@Component("answer-writer")
public class AnswerWriter implements Writing<String> {

    PrintWriter printWriter;

    public AnswerWriter() {
    }

    @Override
    public void write(final String fileName, final String questionAnswer) throws IOException {
        FileWriter fileWriter = new FileWriter(fileName, true);
        BufferedWriter bw = new BufferedWriter(fileWriter);
        printWriter = new PrintWriter(bw);
        printWriter.println(questionAnswer);
        printWriter.close();
    }

}
