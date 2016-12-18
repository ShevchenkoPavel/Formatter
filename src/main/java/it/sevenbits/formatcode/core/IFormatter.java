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
    void format(IReader<IToken> input, IWriter<String> output) throws FormatterException;
}
