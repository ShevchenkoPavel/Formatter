package it.sevenbits.formatcode;

/**
 * Format read chars
 */
public interface IFormatter {
    /**
     *
     * @param input stream
     * @param output stream
     *
     */
    void format(IReader input, IWriter output);
}
