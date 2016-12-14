package it.sevenbits.formatcode.formatter;

import it.sevenbits.formatcode.core.*;
import it.sevenbits.formatcode.formatter.states.SimpleState;

/**
 * temp formatter implementation
 */
public class FormatterForLexer implements IFormatter {

    /**
     *
     * @param input stream of chars from which read
     * @param output stream of chars which to write
     *
     */
    @Override
    public void format(final IReader<IToken> input, final IWriter output) throws FormatterException {

        Action action = new Action();
        StateMachine currentState = new StateMachine();
        IState state = new SimpleState("defaultState");

        try {
            while (input.hasChar()) {

                IToken token = input.read();
                String lexeme = token.getLexeme(token);
                Character c = lexeme.charAt(0);

                IAction executor = action.getAction(state, c);
                executor.execute(c, output);
                state = currentState.getNextState(state, c);

            }
        } catch (Exception e) {
            throw new FormatterException("format failed", e);
        }
    }

}
