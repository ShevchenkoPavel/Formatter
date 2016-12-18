package it.sevenbits.formatcode;

import it.sevenbits.formatcode.core.IReader;
import it.sevenbits.formatcode.core.IState;
import it.sevenbits.formatcode.core.IToken;
import it.sevenbits.formatcode.core.ReaderException;
import it.sevenbits.formatcode.formatter.Token;
import it.sevenbits.formatcode.formatter.states.SimpleState;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Denis on 12/12/16.
 */
public class SimpleLexer implements IReader<IToken> {

    private StringBuilder lexeme = new StringBuilder();
    private final IReader<Character> in;

    private boolean hasPrevious = false;
    private String previousString = "";

    private IState defaultState = new SimpleState("defaultState");
    private IState cycleForState = new SimpleState("cycleForState");
    private IState spaceState = new SimpleState("spaceState");

    private ArrayList<String> stringList = new ArrayList<>();

    public SimpleLexer(final IReader<Character> reader) {
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
//        return new Token(in.read().toString());
    }
}
