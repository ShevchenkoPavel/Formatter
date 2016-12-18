package it.sevenbits.formatcode.formatter;

import it.sevenbits.formatcode.core.IAction;
import it.sevenbits.formatcode.core.IState;
import it.sevenbits.formatcode.core.WriterException;
import it.sevenbits.formatcode.formatter.actions.CloseBraceAction;
import it.sevenbits.formatcode.formatter.actions.DefaultAction;
import it.sevenbits.formatcode.formatter.actions.OpenBraceAction;
import it.sevenbits.formatcode.formatter.actions.SemicolonAction;
import it.sevenbits.formatcode.formatter.states.SimpleState;

import java.util.HashMap;
import java.util.Map;

/**
 * Writing operations for lexer
 */
public class Actions {

    private IAction defaultA = new DefaultAction();
    private IAction openBraceA = new OpenBraceAction();
    private IAction closeBraceA = new CloseBraceAction();
    private IAction semicolonA = new SemicolonAction();

    private boolean firstLaunch = true;
    private Map<IState, HashMap<String, IAction>> actionMap = new HashMap<>();

    private void createMap() {
        IState defaultState = new SimpleState("defaultState");
        IState cycleForState = new SimpleState("cycleForState");

        HashMap<String, IAction> defaultMap = new HashMap<>();
        defaultMap.put("{", openBraceA);
        defaultMap.put("}", closeBraceA);
        defaultMap.put(";", semicolonA);

        HashMap<String, IAction> cycleForMap = new HashMap<>();
        cycleForMap.put("{", openBraceA);
        cycleForMap.put("}", closeBraceA);
        cycleForMap.put(";", semicolonA);

        actionMap.put(defaultState, defaultMap);
        actionMap.put(cycleForState, cycleForMap);
    }

    private IAction action = defaultA;

    public IAction getAction(final IState state, final String s) throws WriterException {

        if (firstLaunch) {
            createMap();
            firstLaunch = false;
        }

        Map<String, IAction> map = new HashMap<>();

        Object key;
        Object value;

        for (Map.Entry entry : actionMap.entrySet()) {

            key = entry.getKey();
            value = entry.getValue();

            if (key.equals(state)) {
                map.putAll((HashMap<String, IAction>) value);
                break;
            }
        }

        for (Map.Entry entry : map.entrySet()) {
            key = entry.getKey();
            value = entry.getValue();
            if (key.equals(s)) {
                action = (IAction) value;
                break;
            }
            action = defaultA;
        }

        return action;
    }

}
