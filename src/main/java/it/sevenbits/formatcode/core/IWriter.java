package it.sevenbits.formatcode.core;

/**
 * It writes chars to stream or file
 */

public interface IWriter {
    /**
     *
     * @param c char
     */
    void writeChar(char c);

    /**
     *
     * @return string
     */
    String toStr();
}
