package it.sevenbits.formatcode.formatter;

import it.sevenbits.formatcode.core.IAction;
import it.sevenbits.formatcode.core.IWriter;
import it.sevenbits.formatcode.core.WriterException;

import java.util.HashMap;
import java.util.Map;

/**
 * Writing operations
 */

public class Action {

    public void getA(final String state, final char c, IWriter output) throws WriterException {

        output.writeChar(c);

        if (state.equals("defaultState")) {
            switch (c) {
                case (';'):
                    output.writeChar('\n');
                    break;
                case ('}'):
                    output.writeChar('\n');
                    break;
                case ('{'):
                    output.writeChar('\n');
                    output.writeChar('\t');
            }
        }

    }


    public void getAction(final String state, final char c, final IWriter output) throws WriterException {

        output.writeChar(c);

        if (state.equals("defaultState")) {
            switch (c) {
                case (';'):
                    output.writeChar('\n');
                    break;
                case ('}'):
                    output.writeChar('\n');
                    break;
                case ('{'):
                    output.writeChar('\n');
                    output.writeChar('\t');
            }
        }
    }

}
