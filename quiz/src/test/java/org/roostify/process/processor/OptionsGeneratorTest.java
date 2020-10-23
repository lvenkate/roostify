package org.roostify.process.processor;

import org.junit.Before;
import org.junit.Test;
import org.roostify.model.Option;
import org.roostify.repository.StatesCapital;

import java.io.IOException;

public class OptionsGeneratorTest {

    OptionsGenerator optionsGenerator;
    String[] values;
    int pnOptions;
    String capital;

    @Before
    public void setUp() throws Exception {
        optionsGenerator = new OptionsGenerator();
        values = StatesCapital.getValues();
        pnOptions = 5;
        capital = "Sacramento";
    }

    @Test
    public void generate() throws IOException {
       Option result = optionsGenerator.generate(values, pnOptions, capital);
        for (String s : result.getChoices()) {
            System.out.println(s + " " + result.getAnswerId());
        }
    }
}