package it.sevenbits.formatcode;

/**
 * Format read chars
 */
public interface IFormatter {
    /**
     *
     * @param input stream
     * @param output stream
     * @param c buffer
     */
    void format(IReader input, IWriter output, char c);
}
