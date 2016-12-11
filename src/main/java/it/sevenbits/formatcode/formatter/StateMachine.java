package it.sevenbits.formatcode.formatter;

import it.sevenbits.formatcode.core.IState;
import it.sevenbits.formatcode.formatter.states.SimpleState;

import java.util.HashMap;
import java.util.Map;

/**
 * States for formatter
 */
public class StateMachine {

    private boolean first = true;
    private Map<String, HashMap<Character, String>> stateMap = new HashMap<String, HashMap<Character, String>>();

    private  void createMap() {
        HashMap<Character, String> defaultMap = new HashMap<Character, String>();
        defaultMap.put('\"', "stringLiteralState");
        defaultMap.put('\'', "charLiteralState");
        defaultMap.put('/', "halfState");

        HashMap<Character, String> stringLiteralMap = new HashMap<Character, String>();
        stringLiteralMap.put('\"', "defaultState");

        HashMap<Character, String> charLiteralMap = new HashMap<Character, String>();
        charLiteralMap.put('\'', "defaultState");

        HashMap<Character, String> halfMap = new HashMap<Character, String>();
        halfMap.put('/', "stringCommitState");
        halfMap.put('*', "commitSequenceState");

        HashMap<Character, String> stringCommitMap = new HashMap<Character, String>();
        stringCommitMap.put('\n', "defaultState");

        HashMap<Character, String> commitSequenceMap = new HashMap<Character, String>();
        commitSequenceMap.put('*', "halfCSS");

        HashMap<Character, String> halfCSMap = new HashMap<Character, String>();
        halfCSMap.put('/', "defaultState");


        stateMap.put("defaultState", defaultMap);
        stateMap.put("stringLiteralState", stringLiteralMap);
        stateMap.put("charLiteralState", charLiteralMap);
        stateMap.put("halfState", halfMap);
        stateMap.put("stringCommitState", stringCommitMap);
        stateMap.put("commitSequenceState", commitSequenceMap);
        stateMap.put("halfCSS", halfCSMap);
    }

    public String getNextState(final String currentState, final char c) {

        if (first) {
            createMap();
            first = false;
        }

        String state = currentState;
        Map<Character, String> map = new HashMap<>();

        Object key;
        Object value;

        for (Map.Entry entry : stateMap.entrySet()) {

            key = entry.getKey();
            value = entry.getValue();

            if (key.toString().equals(currentState)) {
                map.putAll((HashMap<Character, String>) value);
                break;
            }
        }

        for (Map.Entry entry : map.entrySet()) {
            key = entry.getKey();
            value = entry.getValue();
            if ((Character) key == c) {
                state = (String) value;
                break;
            }
        }

        return state;
    }

    /*

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
*/

}