package org.roostify.process.writer;

import org.junit.Before;
import org.junit.Test;
import org.roostify.utility.GeneralUtilities;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class AnswerWriterTest {

    AnswerWriter writer;

    @Before
    public void setUp() throws Exception {
        writer = new AnswerWriter();
        String fileName = "/temp/roostify/test.txt";
        GeneralUtilities.create(fileName);
    }

    @Test
    public void write_or_append_when_file_in_existing_file() {

        String fileName = "/temp/roostify/test.txt";
        try {
            writer.write(fileName, "Hello World!");
            writer.write(fileName, "How are you?");
        } catch (IOException ex) {
            // TODO Some debug statement
        }
    }

    @Test
    public void when_file_does_not_exist_throws_exception() throws IOException {
        boolean thrown = false;
        String fileName = "/temp/roostify/t.txt";
        try {
            writer.write(fileName, "Hello World!");
        } catch (IndexOutOfBoundsException e) {
            thrown = true;
        }
        assertTrue(thrown);
    }



}