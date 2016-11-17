package it.sevenbits.formatcode.core;

/**
 * It reads chars from the stream or file
 */

public interface IReader {
    boolean hasChar();
    char readChar();
}
