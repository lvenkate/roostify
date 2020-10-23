package org.roostify.process.processor;

import org.junit.Before;
import org.junit.Test;
import org.roostify.model.Question;
import org.roostify.utility.GeneralUtilities;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuestionGeneratorTest {

    QuestionGenerator questionGenerator;
    OptionsGenerator optionsGenerator;
    Deduplicator deduplicator;

    @Before
    public void setUp() throws Exception {
        optionsGenerator = new OptionsGenerator();
        deduplicator = new Deduplicator();
        questionGenerator = new QuestionGenerator(optionsGenerator, deduplicator);
    }

    @Test
    public void generate() {
        List<Question> list = questionGenerator.generate(20, 5);
        for (Question l : list)
            System.out.println(l.toString());
    }

    @Test
    public void randomness_of_the_shuffle_algorithm_is_equal() {
        int[] captureIndex7 = new int[50];
        int[] captureIndex49 = new int[50];
        for (int i = 0; i < 50; i++) {
            int[] result = GeneralUtilities.seed(50);
            questionGenerator.shuffle(result);
            captureIndex7[i] = result[6];
            captureIndex49[i] = result[48];
        }
        showResult(captureIndex7);
        System.out.println("===============================================================================================================");
        showResult(captureIndex49);
    }

    void showResult(int[] captureIndex) {
        System.out.println(Arrays.toString(captureIndex));
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < captureIndex.length; i++) {
            int key = captureIndex[i];
            if (map.containsKey(key))
                map.put(key, map.get(key) + 1);
            else {
                map.put(key, 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println("Probability of occurance of " + entry.getKey() + " is " + (double) entry.getValue() / 50);
        }
    }
}