package it.sevenbits.formatcode.formatter;

import it.sevenbits.formatcode.core.*;
import it.sevenbits.formatcode.formatter.actions.DefaultAction;
import it.sevenbits.formatcode.formatter.states.SimpleState;

/**
 * Reading file and formatting on rules Java.
 *
 */
public class Formatter implements IFormatter {

    /**
     *
     * @param input stream of chars from which read
     * @param output stream of chars which to write
     *
     */
    @Override
    public void format(final IReader<IToken> input, final IWriter<String> output) throws FormatterException {

        Actions action = new Actions();
        StateMachine currentState = new StateMachine();
        IState state = new SimpleState("defaultState");

        try {
            while (input.hasChar()) {

                IToken token = input.read();
                String lexeme = token.getLexeme(token);
                state = currentState.getNextState(state, lexeme);
                IAction executor = action.getAction(state, lexeme);
                executor.execute(lexeme, output);

            }
        } catch (Exception e) {
            throw new FormatterException("format failed", e);
        }
    }
}