package it.sevenbits.formatcode.formatter;

import it.sevenbits.formatcode.core.IToken;

/**
 * Token impl
 */
public class Token implements IToken {

    private String lexeme = "";

    public Token(String lexeme) {
        this.lexeme = lexeme;
    }

    @Override
    public String getLexeme(IToken token) {
        return lexeme;
    }
}
