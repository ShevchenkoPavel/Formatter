package it.sevenbits.formatcode.iofile;

import it.sevenbits.formatcode.core.FormatterException;
import it.sevenbits.formatcode.core.IReader;
import it.sevenbits.formatcode.core.IToken;
import it.sevenbits.formatcode.core.ReaderException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * It reads chars from file
 */
public class FileReader implements IReader<Character> {

    private int c;
    private java.io.FileReader reader;

    /**
     *
     * @param file name of file
     * @throws FileNotFoundException for java.io.FileReader()
     * @exception ReaderException exception
     */

    public FileReader(final File file) throws FileNotFoundException, ReaderException {
        reader = new java.io.FileReader(file);
    }


    @Override
    public boolean hasChar() {
        final int eof = -1;
        boolean has;
        has = (c != eof);
        return has;
    }

    @Override
    public Character read() throws ReaderException {
        try {
            c = reader.read();
        } catch (Exception e) {
           throw new ReaderException("reading failed", e);
        }
        return (char) c;
    }
}