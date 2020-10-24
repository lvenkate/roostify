package org.roostify.process.processor;

import org.roostify.model.Option;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * Responsible for generating unique list of choices with the answer embedded.
 */
@Component("options-generator")
public class OptionsGenerator {

    public Option generate(final String[] values, final int pnOptions, final String capital) throws IllegalArgumentException{

        if (pnOptions == 0 || capital == null || capital.equals("")) {
            throw new IllegalArgumentException();
        }

        String[] result = new String[pnOptions + 1];
        result[pnOptions] = capital;
        int[] idxs = new int[pnOptions];

        int i = 0;
        for (; i < pnOptions; i++) {
            idxs[i] = i;
        }
        Random random = new Random();
        for (i = pnOptions; i < values.length; i++) {
            int idx = random.nextInt(i);
            if (idx < pnOptions) {
                idxs[idx] = i;
            }
        }
        int count = 0;
        for (int idx : idxs) {
            result[count++] = values[idx];
        }

        int idx = random.nextInt(pnOptions + 1);
        swap(result, idx);
        final Option option = new Option(result, idx);
        return option;
    }

    void swap(String[] result, final int idx) {
        String temp = result[idx];
        result[idx] = result[result.length - 1];
        result[result.length - 1] = temp;
    }
}
