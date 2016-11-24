package it.sevenbits.formatcode.formatter;

import it.sevenbits.formatcode.core.IWriter;
import it.sevenbits.formatcode.core.WriterException;

/**
 * Writing operations
 */
public class Actions {

    public void action(final IWriter output, final StateMachine state, final char c) throws WriterException {

        if (state.nextState(c)) {

            output.writeChar(c);
            if ((c == (';')) || c == ('}')) {
                output.writeChar('\n');
            }
            if (c == ('{')) {
                output.writeChar('\n');
                output.writeChar('\t');
            }
        } else {
            output.writeChar(c);
        }
    }
}
