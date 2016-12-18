package it.sevenbits.formatcode;

import it.sevenbits.formatcode.core.*;
import it.sevenbits.formatcode.formatter.Formatter;
import it.sevenbits.formatcode.formatter.FormatterForLexer;
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

        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please, input file for reading");
        String inputFile = r.readLine();
        System.out.println("Please, input file for writing");
        String outputFile = r.readLine();

        File input = new File(inputFile);
        IReader<Character> reader = new FileReader(input);
        IWriter<String> writer = new FileWriter(outputFile);
        IReader<IToken> lexer = new SimpleLexer(reader);
        FormatterForLexer formatter = new FormatterForLexer();
        formatter.format(lexer, writer);
        System.out.println(writer.toStr());
    }
}