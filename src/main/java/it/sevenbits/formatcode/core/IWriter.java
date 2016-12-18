package it.sevenbits.formatcode.core;

/**
 * It writes chars to stream or file
 */

public interface IWriter<T> {
    /**
     *
     * @param c char
     * @throws WriterException exception
     */
    void writeChar(char c) throws WriterException;

    /**
     *
     * @param s string
     * @throws WriterException exception
     */
    void writeLexeme(String s) throws WriterException;

    /**
     *
     * @return string
     * @throws WriterException exception
     */
    String toStr() throws WriterException;
}
