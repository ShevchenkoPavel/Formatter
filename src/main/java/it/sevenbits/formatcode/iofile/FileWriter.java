package it.sevenbits.formatcode.iofile;

import it.sevenbits.formatcode.core.FormatterException;
import it.sevenbits.formatcode.core.IWriter;
import it.sevenbits.formatcode.core.WriterException;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Write chars to file
 */
public class FileWriter implements IWriter {

    private PrintWriter out;

    /**
     *
     * @param fName name of file
     * @throws IOException exception
     * @throws WriterException exception
     */
    public FileWriter(final String fName) throws IOException, WriterException {
        File file;
        file = new File(fName);
        out = new PrintWriter(file.getAbsoluteFile());
    }

    @Override
    public void writeChar(final char c) throws WriterException {
        try {
            out.append(c);
        } catch (Exception e) {
            throw new WriterException("writing failed" , e);
        }
    }

    @Override
    public String toStr() {
        out.close();
        return null;
    }
}
