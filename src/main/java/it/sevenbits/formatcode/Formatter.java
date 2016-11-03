package it.sevenbits.formatcode;

import java.io.FileReader;
import java.io.IOException;

/**
 * Reading file and formatting on rules Java.
 * Output in the console.
 */
public class Formatter implements IFormatter {

    /**
     *
     * @param input stream of chars from which read
     * @param output stream of chars which to write
     * @param c buffer variable
     */

    @Override
    public void format(IReader input, IWriter output, char c) {
        while (input.hasChar()) {
            output.writechar(c=input.readchar());
            if ((c == (';')) || c == ('}')) {
                output.writechar('\n');
            }
            if (c == ('{')) {
                output.writechar('\n');
                output.writechar('\t');
            }
        }
    }
}
