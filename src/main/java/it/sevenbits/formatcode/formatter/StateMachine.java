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
    private Map<IState, HashMap<Character, IState>> stateMap = new HashMap<>();

    private IState defaultState = new SimpleState("defaultState");
    private IState stringLiteralState = new SimpleState("stringLiteralState");
    private IState charLiteralState = new SimpleState("charLiteralState");
    private IState halfState = new SimpleState("halfState");
    private IState stringCommitState = new SimpleState("stringCommitState");
    private IState commitSequenceState = new SimpleState("commitSequenceState");
    private IState halfCSS = new SimpleState("halfCSS");

    private void createMap() {
        HashMap<Character, IState> defaultMap = new HashMap<>();
        defaultMap.put('\"', stringLiteralState);
        defaultMap.put('\'', charLiteralState);
        defaultMap.put('/', halfState);

        HashMap<Character, IState> stringLiteralMap = new HashMap<>();
        stringLiteralMap.put('\"', defaultState);

        HashMap<Character, IState> charLiteralMap = new HashMap<>();
        charLiteralMap.put('\'', defaultState);

        HashMap<Character, IState> halfMap = new HashMap<>();
        halfMap.put('/', stringCommitState);
        halfMap.put('*', commitSequenceState);

        HashMap<Character, IState> stringCommitMap = new HashMap<>();
        stringCommitMap.put('\n', defaultState);

        HashMap<Character, IState> commitSequenceMap = new HashMap<>();
        commitSequenceMap.put('*', halfCSS);

        HashMap<Character, IState> halfCSMap = new HashMap<>();
        halfCSMap.put('/', defaultState);

        stateMap.put(defaultState, defaultMap);
        stateMap.put(stringLiteralState, stringLiteralMap);
        stateMap.put(charLiteralState, charLiteralMap);
        stateMap.put(halfState, halfMap);
        stateMap.put(stringCommitState, stringCommitMap);
        stateMap.put(commitSequenceState, commitSequenceMap);
        stateMap.put(halfCSS, halfCSMap);
    }

    public IState getNextState(final IState currentState, final char c) {

        if (firstLaunch) {
            createMap();
            firstLaunch = false;
        }

        IState state = currentState;
        Map<Character, IState> map = new HashMap<>();

        Object key;
        Object value;

        for (Map.Entry entry : stateMap.entrySet()) {

            key = entry.getKey();
            value = entry.getValue();

            if (key.equals(currentState)) {
                map.putAll((HashMap<Character, IState>) value);
                break;
            }
        }

        for (Map.Entry entry : map.entrySet()) {
            key = entry.getKey();
            value = entry.getValue();
            if ((Character) key == c) {
                state = (IState) value;
                break;
            }
        }

        return state;
    }

}