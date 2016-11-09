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
     *
     * @value mode      show formatting mode  (1 - // commited text)
     *                                        (2 - /* commited text)
     *                                        (3 - " " string literals)
     *                                        (4 - ' ' char literals)
     */
    @Override
    public void format(final IReader input, final IWriter output) {
        char c = 0;
        char cPrevious = 0;
        char cMostPrevious;
        int mode = 0;

        while (input.hasChar()) {
            cMostPrevious = cPrevious;
            cPrevious = c;
            c = input.readChar();

            if ((cMostPrevious == '\n') && (cPrevious == '\r') && (c == '\n')) {
                continue;
            }

            output.writeChar(c);

            if ((cPrevious == '/') && (c == '/')) {
                mode = 1;
            }

            if ((mode == 1) && (c == '\n')) {
                mode = 0;
            }

            if ((cPrevious == '/') && (c == '*')) {
                mode = 2;
            }

            if ((mode == 2) && ((c == '/') && (cPrevious == '*'))) {
                mode = 0;
            }


            if ((mode != 3) && (c == '\"')) {
                mode = 3;
                c = input.readChar();
            }

            if ((mode == 3) && (c == '\"')) {
                mode = 0;
            }

            if ((mode != 4) && (c == '\'')) {
                mode = 4;
                c = input.readChar();
            }

            if ((mode == 4) && (c == '\'') && (cPrevious != '\'')) {
                mode = 0;
            }



            if ((mode == 0) && ((c == (';')) || c == ('}'))) {
                output.writeChar('\n');
            }
            if ((mode == 0) && (c == ('{'))) {
                output.writeChar('\n');
                output.writeChar('\t');
            }
        }
    }
}
