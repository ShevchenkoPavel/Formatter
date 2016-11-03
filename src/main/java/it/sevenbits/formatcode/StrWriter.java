package it.sevenbits.formatcode;

/**
 * It writes chars to stream(console)
 */
public class StrWriter implements IWriter {
    @Override
    public void writeChar(final char c) {
        System.out.print(c);
    }
}
