package it.sevenbits.formatcode;

import java.io.IOException;
import java.io.InputStreamReader;

/**
 * It reads chars from the stream
 *
 */
public class StrReader implements IReader {
    private char c;
    private InputStreamReader reader = new InputStreamReader(System.in);

    @Override
    public boolean hasChar() {
        boolean has;
        has = ((int) c != 65535);
        return has;
    }

    @Override
    public char readChar() {
        try {
            c = (char) reader.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return c;
    }
}
