package it.sevenbits.formatcode.iostring;

import it.sevenbits.formatcode.core.*;

/**
 * It reads chars from string
 */
public class StrReader implements IReader<Character> {

    private final String str;
    private int index = 0;

    public StrReader(final String value) throws ReaderException {
        this.str = value;
    }

    @Override
    public boolean hasChar() {
        return index < str.length();
    }

    @Override
    public Character read() throws ReaderException {
        try {
            return str.charAt(index++);
        } catch (Exception e) {
          throw new ReaderException("reading failed", e);
        }
    }
}
