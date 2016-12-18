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
    private Map<IState, HashMap<String, IState>> stateMap = new HashMap<>();

    private IState defaultState = new SimpleState("defaultState");
    private IState stringLiteralState = new SimpleState("stringLiteralState");
    private IState charLiteralState = new SimpleState("charLiteralState");
    private IState stringCommitState = new SimpleState("stringCommitState");
    private IState commitSequenceState = new SimpleState("commitSequenceState");

    private IState cycleForState = new SimpleState("cycleForState");
    private IState cycleForIteratorState = new SimpleState("cycleForIteratorState");

    private void createMap() {
        HashMap<String, IState> defaultMap = new HashMap<>();
        defaultMap.put("\"", stringLiteralState);
        defaultMap.put("\'", charLiteralState);
        defaultMap.put("//", stringCommitState);
        defaultMap.put("/*", commitSequenceState);
        defaultMap.put("for", cycleForState);

        HashMap<String, IState> stringLiteralMap = new HashMap<>();
        stringLiteralMap.put("\"", defaultState);

        HashMap<String, IState> charLiteralMap = new HashMap<>();
        charLiteralMap.put("\'", defaultState);

        HashMap<String, IState> stringCommitMap = new HashMap<>();
        stringCommitMap.put("\n", defaultState);

        HashMap<String, IState> commitSequenceMap = new HashMap<>();
        commitSequenceMap.put("*/", defaultState);

        HashMap<String, IState> cycleForMap = new HashMap<>();
        cycleForMap.put("(", cycleForIteratorState);
        cycleForMap.put("}", defaultState);

        HashMap<String, IState> cycleForIteratorMap = new HashMap<>();
        cycleForIteratorMap.put(")", cycleForState);

        stateMap.put(defaultState, defaultMap);
        stateMap.put(stringLiteralState, stringLiteralMap);
        stateMap.put(charLiteralState, charLiteralMap);
        stateMap.put(stringCommitState, stringCommitMap);
        stateMap.put(commitSequenceState, commitSequenceMap);
        stateMap.put(cycleForState, cycleForMap);
        stateMap.put(cycleForIteratorState, cycleForIteratorMap);
    }

    public IState getNextState(final IState currentState, final String s) {

        if (firstLaunch) {
            createMap();
            firstLaunch = false;
        }

        IState state = currentState;
        Map<String, IState> map = new HashMap<>();

        Object key;
        Object value;

        for (Map.Entry entry : stateMap.entrySet()) {

            key = entry.getKey();
            value = entry.getValue();

            if (key.equals(currentState)) {
                map.putAll((HashMap<String, IState>) value);
                break;
            }
        }

        for (Map.Entry entry : map.entrySet()) {
            key = entry.getKey();
            value = entry.getValue();
            if (key.equals(s)) {
                state = (IState) value;
                break;
            }
        }

        return state;
    }

}