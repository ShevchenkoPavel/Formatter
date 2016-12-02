package it.sevenbits.formatcode.formatter;

import java.util.HashMap;
import java.util.Map;

/**
 * States for formatter
 */
public class StateMachine {

    public String getNextState(final String currentState, final char c) {

        String state = currentState;

        if (currentState.equals("defaultState")) {
            switch (c) {
                case '\"':
                    state = "stringLiteral";
                    break;
                case '\'':
                    state = "charLiteral";
                    break;
                case '/':
                    state = "half";
                    break;
            }
        }

        if (currentState.equals("stringLiteral")) {
            switch (c) {
                case '\"':
                    state = "defaultState";
                    break;
            }
        }

        if (currentState.equals("charLiteral")) {
            switch (c) {
                case '\'':
                    state = "defaultState";
                    break;
            }
        }

        if (currentState.equals("half")) {
            if ((c != '/') || (c != '*')) {
                state = "defaultState";
            }
        }

        if (currentState.equals("half")) {
            switch (c) {
                case '/':
                    state = "stringCommit";
                    break;
                case '*':
                    state = "commitSequence";
                    break;
            }
        }

        if (currentState.equals("stringCommit")) {
            switch (c) {
                case '\n':
                    state = "defaultState";
            }
        }

        if (currentState.equals("commitSequence")) {
            switch (c) {
                case '*':
                    state = "halfCS";
                    break;
            }
        }

        if (currentState.equals("halfCS")) {
            if (c != '/') {
                state = "commitSequence";
            } else {
                state = "defaultState";
            }
        }

        return state;
    }

}