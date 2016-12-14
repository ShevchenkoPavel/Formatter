package it.sevenbits.formatcode.formatter;

import it.sevenbits.formatcode.core.IReader;
import it.sevenbits.formatcode.core.IToken;
import it.sevenbits.formatcode.core.ReaderException;

/**
 * lexer
 */
public class Lexer implements IReader<IToken> {


    @Override
    public boolean hasChar() {
        return false;
    }

    @Override
    public IToken read() throws ReaderException {
        return null;
    }
}
