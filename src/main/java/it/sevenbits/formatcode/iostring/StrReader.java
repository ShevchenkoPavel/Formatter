package it.sevenbits.formatcode.iostring;

import it.sevenbits.formatcode.core.FormatterException;
import it.sevenbits.formatcode.core.IReader;

/**
 * It reads chars from string
 */
public class StrReader implements IReader {

    private final String str;
    private int index = 0;

    public StrReader(final String value) throws FormatterException {
        this.str = value;
    }

    @Override
    public boolean hasChar() {
        return index < str.length();
    }

    @Override
    public char readChar() {
        return str.charAt(index++);
    }
}
