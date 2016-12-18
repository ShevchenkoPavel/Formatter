package it.sevenbits.formatcode.lexer;

import it.sevenbits.formatcode.core.IToken;

/**
 * Token impl
 */
public class Token implements IToken {

    private String lexeme = "";

    public Token(final String lexeme) {
        this.lexeme = lexeme;
    }

    @Override
    public String getLexeme(final IToken token) {
        return lexeme;
    }

}
