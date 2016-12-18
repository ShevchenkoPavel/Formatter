package it.sevenbits.formatcode.core;

/**
 * Action in writers
 */
public interface IAction {
    /**
     * execute action
     * @param c char
     * @param out writer
     * @throws WriterException exception
     */
    public void execute(char c, IWriter out) throws WriterException;

    public void execute(String s, IWriter out) throws WriterException;
}
