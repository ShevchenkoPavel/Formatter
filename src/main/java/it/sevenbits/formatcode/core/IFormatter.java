package it.sevenbits.formatcode.core;

/**
 * Format read chars
 *
 */
public interface IFormatter {
    /**
     *
     * @param input stream
     * @param output stream
     * @throws FormatterException exception
     *
     */
    void format(IReader input, IWriter output) throws FormatterException;
}
