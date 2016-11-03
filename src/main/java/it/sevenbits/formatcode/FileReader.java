package it.sevenbits.formatcode;

/**
 * It reads chars from file
 */
public class FileReader implements IReader {

    FileReader reader = new FileReader();

    @Override
    public boolean hasChar() {
        return false;
    }

    @Override
    public char readChar() {
        return 0;
    }
}