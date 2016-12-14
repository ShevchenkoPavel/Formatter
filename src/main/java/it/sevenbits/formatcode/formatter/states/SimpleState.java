package it.sevenbits.formatcode.formatter.states;

import it.sevenbits.formatcode.core.IState;

/**
 * return currentState
 */
public class SimpleState implements IState {

    private String state;

    public SimpleState(final String s) {
            state = s;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SimpleState that = (SimpleState) o;

        return state.equals(that.state);

    }

    @Override
    public int hashCode() {
        return state.hashCode();
    }
}