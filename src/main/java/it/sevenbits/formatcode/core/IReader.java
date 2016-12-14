package it.sevenbits.formatcode.core;

/**
 * It reads chars from the stream or file
 */

public interface IReader<T> {
    boolean hasChar();
    T read() throws ReaderException;
}

