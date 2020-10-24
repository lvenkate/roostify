package org.roostify.process.writer;

import org.junit.Before;
import org.junit.Test;
import org.roostify.utility.GeneralUtilities;

import java.io.IOException;

public class AnswerWriterTest {

    AnswerWriter writer;

    @Before
    public void setUp() throws Exception {
        writer = new AnswerWriter();
        String fileName = "test.txt";
        GeneralUtilities.create(fileName);
    }

    @Test
    public void write_or_append_when_file_in_existing_file() {

        String fileName = "test.txt";
        try {
            writer.write(fileName, "Hello World!");
            writer.write(fileName, "How are you?");
        } catch (IOException ex) {
            // TODO Some debug statement
        }
    }
}