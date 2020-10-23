package org.roostify.utility;

import java.io.File;
import java.io.IOException;

public class GeneralUtilities {
    public static boolean create(final String fileName) throws IOException {
        File newFile = new File(fileName);
        return newFile.createNewFile();
    }
    public static int[] seed(int nQuestions) {
        int[] result = new int[nQuestions];
        for (int i = 0; i < nQuestions; i++) {
            result[i] = i;
        }
        return result;
    }
}
