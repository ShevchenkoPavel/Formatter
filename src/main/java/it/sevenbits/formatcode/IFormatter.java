package it.sevenbits.formatcode;

/**
 * Format read chars
 *
 */
public interface IFormatter {
    /**
     *
     * @param input stream
     * @param output stream
     * @throws FormatterException ex
     *
     */
    void format(IReader input, IWriter output) throws FormatterException;
}
