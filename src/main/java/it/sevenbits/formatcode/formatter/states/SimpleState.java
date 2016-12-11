package it.sevenbits.formatcode.formatter.states;

import it.sevenbits.formatcode.core.IState;

/**
 * return currentState
 */
public class SimpleState implements IState {

    private String state = "defaultState";

    public SimpleState(final String s) {
            state = s;
    }

    @Override
    public String StateIs() {
        return state;
    }

}