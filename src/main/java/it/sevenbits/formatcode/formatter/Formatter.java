package it.sevenbits.formatcode.formatter;

import it.sevenbits.formatcode.core.*;
import it.sevenbits.formatcode.formatter.actions.DefaultAction;
import it.sevenbits.formatcode.formatter.states.SimpleState;

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

        Action action = new Action();
        StateMachine currentState = new StateMachine();
        String state = "defaultState";
        char c;

        /*
        IState stat = new SimpleState("defaultState");
        String state = stat.StateIs();
        */

        try {
            while (input.hasChar()) {
                c = input.readChar();

                IAction executor = action.getAction(state, c);
                executor.execute(c, output);
                state = currentState.getNextState(state, c);

            }
        } catch (Exception e) {
            throw new FormatterException("format failed", e);
        }
    }
}