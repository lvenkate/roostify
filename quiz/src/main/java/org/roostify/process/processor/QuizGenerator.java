package org.roostify.process.processor;

import org.roostify.Generating;
import org.roostify.Writing;
import org.roostify.model.Question;
import org.roostify.model.Quiz;
import org.roostify.utility.GeneralUtilities;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Responsible for accepting requests to generate quiz with options of the # of sets,
 * questions in each set and # of options for each set.
 */
//@Log4j2
@Component("quiz-generator")
public class QuizGenerator implements Generating {
    final int seed = 50;
    static int counter = 1;

    final Writing<String> answerWriter;
    final Writing<Quiz> quizWriter;
    final QuestionGenerator questionGenerator;

    public QuizGenerator(@Qualifier("answer-writer") Writing<String> pAnswerWriter,
                         @Qualifier("question-generator") QuestionGenerator pQuestionGenerator,
                         @Qualifier("quiz-writer") Writing<Quiz> pQuizWriter) {
        answerWriter = pAnswerWriter;
        questionGenerator = pQuestionGenerator;
        quizWriter = pQuizWriter;
    }

    public String generate(final int noOfQuizSets, final int batch, final int options) {
        // No. of questions that can be generated in one round for a given seed;
        int totalQuestions = seed / batch;
        System.out.println(totalQuestions);
        int nOfRounds = noOfQuizSets * batch / totalQuestions;
        String path = "/temp/roostify/";
        String answerFile = path + "/answer.txt";

        try {
            GeneralUtilities.create(answerFile);
        } catch (Exception iox) {
            // log failed to create answer file
            return "";
        }

        for (int i = 0; i < nOfRounds; i++) {
            ArrayList<Question> questions = questionGenerator.generate(totalQuestions, options);
            int b = 0;
            while (b < questions.size()) {
                List<Question> list = questions.subList(b, b + batch);

                Quiz quiz = new Quiz(counter, batch);
                quiz.setQuestions(list);
                String heading = "Quiz " + counter;
                String filename = path + heading;

                try {
                    GeneralUtilities.create(filename);
                } catch (IOException iox) {
//                    log.debug("Issue while creating a file", iox.getMessage());
                    return "";
                }
                try {
                    quizWriter.write(filename, quiz);
                }catch (IOException iox) {
//                    log.debug("Issue while writing into file", iox.getMessage());
                }

                try {
                    answerWriter.write(answerFile, heading);
                } catch (IOException ex) {
                    // log failed to update header;
                    return "";
                }
                try {
                    for (int q = 0 ; q < list.size(); q++) {
                        int val = 97 + list.get(q).getOptions().getAnswerId();
                        char c = (char) val;
                        String questionAnswer = "Question " + (q + 1) + ", Answer: " +  c;
                        answerWriter.write(answerFile, questionAnswer);
                    }

                } catch (IOException ex) {
                    // log failed to update header;
                    return "";
                }
                b += batch;
                counter++;
            }
        }
         return path;
    }

    public boolean remove(String dirName) {
        File directory = new File(dirName);
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (!file.delete()) {
                    return false;
                }
            }
        }
        return true;
    }
}
