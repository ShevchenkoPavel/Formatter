package it.sevenbits.formatcode;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * It reads chars from file
 */
public class FileReader implements IReader {

    private char c;
    private int eof = 65535;
    private String fileName = "1.txt";

    /**
     *
     * @param file name of file
     * @throws FileNotFoundException for java.io.FileReader()
     */

    public FileReader(final String file) throws FileNotFoundException {
        fileName = file;
    }

    private java.io.FileReader reader = new java.io.FileReader(fileName);


    @Override
    public boolean hasChar() {
        boolean has;
        has = ((int) c != eof);
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