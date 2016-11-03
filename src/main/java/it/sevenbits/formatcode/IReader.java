package it.sevenbits.formatcode;

/**
 * It reads chars from the stream or file
 */

public interface IReader {
    boolean hasChar();
    char readchar();
}
