package it.sevenbits.formatcode.iostring;

import it.sevenbits.formatcode.core.IWriter;

/**
 * It writes chars to stream(console)
 */
public class StrWriter implements IWriter {

    private StringBuilder builder = new StringBuilder();

    @Override
    public void writeChar(final char c) {
        builder.append(c);
    }

    public String toStr() {
        return builder.toString();
    }

}
