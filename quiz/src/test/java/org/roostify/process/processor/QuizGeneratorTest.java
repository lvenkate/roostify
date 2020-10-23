package org.roostify.process.processor;

import org.junit.Before;
import org.junit.Test;
import org.roostify.Writing;
import org.roostify.process.writer.AnswerWriter;
import org.roostify.process.writer.QuizWriter;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * This particular test corresponds to an integration testing of the system.
 */
public class QuizGeneratorTest {

    @Qualifier("answer-writer")
    Writing<String> answerWriter;

    @Qualifier("quiz-writer")
    QuizWriter quizWriter;

    @Qualifier("question-generator")
    QuestionGenerator questionGenerator;

    @Qualifier("options-generator")
    OptionsGenerator pOptionsGenerator;
    @Qualifier("duplicate-remover")
    Deduplicator deduplicator;


    QuizGenerator quizGenerator;
    @Before
    public void setUp() {
        answerWriter = new AnswerWriter();
        quizWriter = new QuizWriter();
        deduplicator = new Deduplicator();
        pOptionsGenerator = new OptionsGenerator();
        questionGenerator = new QuestionGenerator(pOptionsGenerator, deduplicator);
        quizGenerator = new QuizGenerator(answerWriter, questionGenerator, quizWriter);

    }

    @Test
    public void generate() {
        quizGenerator.generate(40, 5, 5);
    }


}