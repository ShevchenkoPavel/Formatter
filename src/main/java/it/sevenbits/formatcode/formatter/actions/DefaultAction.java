package it.sevenbits.formatcode.formatter.actions;

import it.sevenbits.formatcode.core.IAction;
import it.sevenbits.formatcode.core.IWriter;
import it.sevenbits.formatcode.core.WriterException;

/**
 * Default action(just output)
 */
public class DefaultAction implements IAction {

    @Override
    public void execute(final char c, final IWriter out) throws WriterException {
        out.writeChar(c);
    }
}
