package org.roostify.process.processor;

import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * @author lvenkateswaran
 * Removes an entry of correct answers to facilitate generating random values.
 */
@Component("duplicate-remover")
public class Deduplicator implements PreProcessing {

    @Override
    public String[] process(final Collection<String> values, final String value) {
        values.remove(value);
        String[] v = new String[values.size()];
        return values.toArray(v);
    }
}
