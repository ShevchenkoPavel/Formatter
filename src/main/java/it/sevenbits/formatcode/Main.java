package it.sevenbits.formatcode;

import java.io.IOException;

public class Main {

    public static void main(final String[] args) throws IOException {
        StrReader reader = new StrReader();
        StrWriter writer = new StrWriter();
        Formatter formatter = new Formatter();
        char c = 0;
        formatter.format(reader, writer, c);

    }
}
