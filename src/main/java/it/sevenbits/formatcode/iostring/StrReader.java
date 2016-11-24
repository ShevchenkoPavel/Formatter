package it.sevenbits.formatcode.iostring;

import it.sevenbits.formatcode.core.FormatterException;
import it.sevenbits.formatcode.core.IReader;
import it.sevenbits.formatcode.core.ReaderException;

/**
 * It reads chars from string
 */
public class StrReader implements IReader {

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
    public char readChar() throws ReaderException {
        try {
            return str.charAt(index++);
        } catch (Exception e) {
          throw new ReaderException("reading failed", e);
        }
    }
}
