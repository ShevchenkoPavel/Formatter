package it.sevenbits.formatcode;

import it.sevenbits.formatcode.core.FormatterException;
import it.sevenbits.formatcode.core.IReader;
import it.sevenbits.formatcode.core.IWriter;
import it.sevenbits.formatcode.formatter.Formatter;
import it.sevenbits.formatcode.iofile.FileReader;
import it.sevenbits.formatcode.iofile.FileWriter;
import it.sevenbits.formatcode.iostring.StrReader;
import it.sevenbits.formatcode.iostring.StrWriter;

import java.io.*;

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
//        IReader reader = new StrReader();
//        IWriter writer = new StrWriter();

        IReader reader = new FileReader("1.txt");
        IWriter writer = new FileWriter("2.txt");
        Formatter formatter = new Formatter();
        formatter.format(reader, writer);

        System.out.println(writer.toStr());
    }
}