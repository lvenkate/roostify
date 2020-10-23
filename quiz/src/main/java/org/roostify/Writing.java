package org.roostify;

import java.io.IOException;

public interface Writing<T> {
    public void write(String filename, T item) throws IOException;
}
