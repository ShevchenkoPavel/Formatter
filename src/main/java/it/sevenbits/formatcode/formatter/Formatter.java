package it.sevenbits.formatcode.formatter;

import it.sevenbits.formatcode.core.FormatterException;
import it.sevenbits.formatcode.core.IFormatter;
import it.sevenbits.formatcode.core.IReader;
import it.sevenbits.formatcode.core.IWriter;

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
     */
    @Override
    public void format(final IReader input, final IWriter output) throws FormatterException {

        Actions action = new Actions();
        StateMachine currentState = new StateMachine();
        String state = "defaultState";
        char c;


        try {
            while (input.hasChar()) {
                c = input.readChar();
                action.getAction(state, c, output);
                state = currentState.getNextState(state, c);

            }
        } catch (Exception e) {
            throw new FormatterException("format failed", e);
        }
    }
}