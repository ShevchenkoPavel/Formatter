package it.sevenbits.formatcode.formatter;

/**
 * States for formatter
 */
public class StateMachine {

    private char cPrevious;

    private boolean defaultState = true;
    private boolean slashCommit = false;
    private boolean starCommit = false;
    private boolean charLiteralCommit = false;
    private boolean stringLiteralCommit = false;


    public boolean nextState(final char c) {

        if ((cPrevious == '/') && (c == '/')) {
            defaultState = false;
            slashCommit = true;
        }
        if ((slashCommit) && (c == '\n')) {
            slashCommit = false;
        }

        if ((cPrevious == '/') && (c == '*')) {
            defaultState = false;
            starCommit = true;
        }
        if ((starCommit) && ((c == '/') && (cPrevious == '*'))) {
            starCommit = false;
        }

        if (!starCommit && !slashCommit && !charLiteralCommit && !stringLiteralCommit) {
            defaultState = true;
        }

        cPrevious = c;

        return defaultState;
    }
}
