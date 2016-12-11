package it.sevenbits.formatcode.formatter;

import it.sevenbits.formatcode.core.IState;
import it.sevenbits.formatcode.formatter.states.SimpleState;

import java.util.HashMap;
import java.util.Map;

/**
 * States for formatter
 */
public class StateMachine {

    private boolean firstLaunch = true;
    private Map<String, HashMap<Character, String>> stateMap = new HashMap<String, HashMap<Character, String>>();

    private void createMap() {
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

        if (firstLaunch) {
            createMap();
            firstLaunch = false;
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

}