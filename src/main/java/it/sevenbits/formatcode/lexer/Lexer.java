package it.sevenbits.formatcode.lexer;

import it.sevenbits.formatcode.core.IReader;
import it.sevenbits.formatcode.core.IToken;
import it.sevenbits.formatcode.core.ReaderException;

import java.util.ArrayList;

/**
 * Lexical analyzer
 */
public class Lexer implements IReader<IToken> {

    private StringBuilder lexeme = new StringBuilder();
    private final IReader<Character> in;

    private boolean hasPrevious = false;
    private String previousString = "";

    private ArrayList<String> stringList = new ArrayList<>();

    public Lexer(final IReader<Character> reader) {
        in = reader;
        createList();
    }

    private void createList() {
        stringList.add(" ");
        stringList.add("\'");
        stringList.add("\"");
        stringList.add("\n");
        stringList.add("\r");
        stringList.add("{");
        stringList.add("}");
        stringList.add(";");
        stringList.add("//");
        stringList.add("/*");
        stringList.add("*/");
        stringList.add("(");
        stringList.add(")");
        stringList.add("for");
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
                if (hasPrevious) {
                    lexeme.append(previousString);
                    hasPrevious = false;
                    break;
                }
                c = in.read();

                if (stringList.contains(c.toString())) {
                    previousString = c.toString();
                    hasPrevious = true;
                    break;
                }

                lexeme.append(c);
            }
        }

        return new Token(lexeme.toString());
    }
}
