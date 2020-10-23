package org.roostify;

import java.io.IOException;

/**
 * Processor for the incoming requests.
 */
public interface Generating {
    String generate(int noOfQuizSets, int batch, int options) throws IOException;
}
