package org.roostify.process.processor;

import java.util.Collection;

/**
 *
 */
public interface PreProcessing {
    String[] process(Collection<String> values, String value);
}
