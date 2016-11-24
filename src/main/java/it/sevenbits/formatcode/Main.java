package it.sevenbits.formatcode;

import it.sevenbits.formatcode.core.*;
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
     * @throws ReaderException exception
     * @throws WriterException exception
     */

    public static void main(final String[] args) throws IOException, FormatterException, ReaderException, WriterException {
//        IReader reader = new StrReader();
//        IWriter writer = new StrWriter();

        String filename = "1.txt";
        File file = new File(filename);
        IReader reader = new FileReader(file);
        IWriter writer = new FileWriter("2.txt");
        Formatter formatter = new Formatter();
        formatter.format(reader, writer);

        System.out.println(writer.toStr());
    }
}