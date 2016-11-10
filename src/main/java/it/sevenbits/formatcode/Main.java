package it.sevenbits.formatcode;

import java.io.IOException;

/**
 * Main class
 */

public class Main {

    /**
     *
     * @param args in main class
     * @throws IOException input/output ex
     * @throws FormatterException exception
     */

    public static void main(final String[] args) throws IOException, FormatterException {
        IReader reader = new FileReader("1.txt");
        IWriter writer = new StrWriter();
        Formatter formatter = new Formatter();
        formatter.format(reader, writer);
    }
}
