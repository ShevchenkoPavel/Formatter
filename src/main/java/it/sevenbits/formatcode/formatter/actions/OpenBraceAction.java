package it.sevenbits.formatcode.formatter.actions;

import it.sevenbits.formatcode.core.IAction;
import it.sevenbits.formatcode.core.IWriter;
import it.sevenbits.formatcode.core.WriterException;

/**
 * Action, when char is '{'
 */
public class OpenBraceAction implements IAction {
    @Override
    public void execute(final char c, final IWriter out) throws WriterException {
        out.writeChar(c);
        out.writeChar('\n');
        out.writeChar('\t');
    }
}
