package it.sevenbits.formatcode.iofile;

import it.sevenbits.formatcode.core.FormatterException;
import it.sevenbits.formatcode.core.IReader;
import it.sevenbits.formatcode.core.ReaderException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * It reads chars from file
 */
public class FileReader implements IReader {

    private char c;
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
        final int eof = 65535;
        boolean has;
        has = ((int) c != eof);
        return has;
    }

    @Override
    public char readChar() throws ReaderException {
        try {
            c = (char) reader.read();
        } catch (Exception e) {
           throw new ReaderException("reading failed", e);
        }
        return c;
    }
}