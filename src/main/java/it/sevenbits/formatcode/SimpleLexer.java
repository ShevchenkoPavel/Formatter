package it.sevenbits.formatcode;

import it.sevenbits.formatcode.core.IReader;
import it.sevenbits.formatcode.core.IToken;
import it.sevenbits.formatcode.core.ReaderException;
import it.sevenbits.formatcode.formatter.Token;

/**
 * Created by pavel on 12/12/16.
 */
public class SimpleLexer implements IReader<IToken> {
    private final IReader<Character> in;

    public SimpleLexer(IReader<Character> reader) {
        in = reader;
    }

    @Override
    public boolean hasChar() {
        return in.hasChar();
    }

    @Override
    public IToken read() throws ReaderException {
        return new Token(in.read().toString());
    }
}
