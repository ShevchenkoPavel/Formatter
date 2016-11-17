package it.sevenbits.formatcode.iofile;

import it.sevenbits.formatcode.core.FormatterException;
import it.sevenbits.formatcode.core.IWriter;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Write chars to file
 */
public class FileWriter implements IWriter {

    private String fileName = "2.txt";
    private File file = new File(fileName);
    private PrintWriter out = new PrintWriter(file.getAbsoluteFile());

    /**
     *
     * @param fName name of file
     * @throws IOException exception
     */
    public FileWriter(final String fName) throws IOException {
        fileName = fName;
        if (!file.exists()) {
            file.createNewFile();
        }
    }

    @Override
    public void writeChar(final char c) {
        try {
            out.append(c);
        } catch (Exception e) {
            try {
                throw new FormatterException("writing failed" ,e);
            } catch (FormatterException e1) {
                e1.getMessage();
            }
            e.getMessage();
        }
    }

    @Override
    public String toStr() {
        out.close();
        return null;
    }
}
