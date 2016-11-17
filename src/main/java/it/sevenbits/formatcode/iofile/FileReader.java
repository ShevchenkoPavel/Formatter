package it.sevenbits.formatcode.iofile;

import it.sevenbits.formatcode.core.FormatterException;
import it.sevenbits.formatcode.core.IReader;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * It reads chars from file
 */
public class FileReader implements IReader {

    private char c;
    private final int eof = 65535;
    private String fileName = "1.txt";

    /**
     *
     * @param file name of file
     * @throws FileNotFoundException for java.io.FileReader()
     * @exception FormatterException exception
     */

    public FileReader(final String file) throws FileNotFoundException, FormatterException {
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
        } catch (Exception e) {
            try {
                throw new FormatterException("reading failed", e);
            } catch (FormatterException e1) {
                e1.getMessage();
            }
        }
        return c;
    }
}