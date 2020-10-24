package org.roostify.process.processor;

import org.roostify.model.Option;
import org.roostify.model.Question;
import org.roostify.repository.StatesCapital;
import org.roostify.utility.GeneralUtilities;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Random;

/**
 * @author lvenkateswaran
 * Responsible for generating random set of questions.
 */
@Component("question-generator")
public class QuestionGenerator {

    static final int seed = StatesCapital.map.size();
    final OptionsGenerator optionsGenerator;
    final Deduplicator deduplicator;

    public QuestionGenerator(@Qualifier("options-generator") final OptionsGenerator pOptionsGenerator,
                             @Qualifier("duplicate-remover") final Deduplicator pDeduplicator) {
        optionsGenerator = pOptionsGenerator;
        deduplicator = pDeduplicator;
    }

    public ArrayList<Question> generate(final int nQuestions, final int nOptions) {
        int[] indexes = GeneralUtilities.seed(seed);
        shuffle(indexes);

        int i = 0;
        String[] states = StatesCapital.getStates();

        ArrayList<Question> questions = new ArrayList<>();
        while (i < seed) {
            String state = states[indexes[i]];
            String question = "Which is the capital of " + state + "?";
            String capital = StatesCapital.map.get(state);
            Collection<String> v = new HashSet<String>(StatesCapital.map.values());
            String[] values = deduplicator.process(v, capital);
            Option options = null;
            try {
                options = optionsGenerator.generate(values, nOptions - 1, capital);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            Question q = new Question(question, options);
            questions.add(q);
            i++;
        }
        return questions;
    }

    public void shuffle(int[] indexes) {
        Random random = new Random();
        int n = indexes.length - 1;
        for (int i = n - 1; i >= 0; i--) {
            int idx = random.nextInt(i + 1);
            swap(indexes, idx, i);
        }
    }

    private void swap(int[] indexes, int idx, int i) {
        int temp = indexes[idx];
        indexes[idx] = indexes[i];
        indexes[i] = temp;
    }


}
