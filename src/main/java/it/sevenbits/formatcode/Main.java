package it.sevenbits.formatcode;

import java.io.IOException;

public class Main {

    public static void main(final String[] args) throws IOException {
        IReader reader = new FileReader("1.txt");
        IWriter writer = new StrWriter();
        Formatter formatter = new Formatter();
        formatter.format(reader, writer);
    }
}
