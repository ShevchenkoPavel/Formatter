package it.sevenbits.formatcode.iostring;

import it.sevenbits.formatcode.core.FormatterException;
import it.sevenbits.formatcode.core.IWriter;
import it.sevenbits.formatcode.core.WriterException;

/**
 * It writes chars to stream(console)
 */
public class StrWriter implements IWriter {

    private StringBuilder builder = new StringBuilder();

    @Override
    public void writeChar(final char c) throws WriterException {
        try {
        builder.append(c);
        } catch (Exception e) {
            throw new WriterException("writing failed", e);
        }
    }

    /**
     *
     * @return
     * @throws WriterException exception
     */
    public String toStr() throws WriterException {
        return builder.toString();
    }

}
