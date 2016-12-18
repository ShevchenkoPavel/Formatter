package it.sevenbits.formatcode;

import it.sevenbits.formatcode.core.IReader;
import it.sevenbits.formatcode.core.IToken;
import it.sevenbits.formatcode.core.ReaderException;
import it.sevenbits.formatcode.formatter.Token;

/**
 * Created by Denis on 12/12/16.
 */
public class SimpleLexer implements IReader<IToken> {

    private StringBuilder lexeme = new StringBuilder();
    private final IReader<Character> in;

    public SimpleLexer(final IReader<Character> reader) {
        in = reader;
    }

    @Override
    public boolean hasChar() {
        return in.hasChar();
    }

    @Override
    public IToken read() throws ReaderException {

        lexeme.delete(0, lexeme.length());
        Character c = 'c';

        if (in.hasChar()) {
            while ((!c.toString().equals(" ")) && (in.hasChar())) {
                c = in.read();
                lexeme.append(c);
            }
        }

        return new Token(lexeme.toString());
//        return new Token(in.read().toString());
    }
}
