package it.sevenbits.formatcode.formatter.actions;

import it.sevenbits.formatcode.core.IAction;
import it.sevenbits.formatcode.core.IWriter;
import it.sevenbits.formatcode.core.WriterException;

/**
 * Action when char is '}'
 */
public class CloseBraceAction implements IAction {
    @Override
    public void execute(final char c, final IWriter out) throws WriterException {
        out.writeChar(c);
        out.writeChar('\n');
    }

    @Override
    public void execute(final String s, final IWriter out) throws WriterException {
        out.writeLexeme(s);
        out.writeLexeme("\n");
    }
}
