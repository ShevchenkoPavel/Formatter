package it.sevenbits.formatcode.iostring;

import it.sevenbits.formatcode.core.FormatterException;
import it.sevenbits.formatcode.core.IReader;
import it.sevenbits.formatcode.core.ReaderException;
import it.sevenbits.formatcode.iostring.StrReader;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests for StrReader
 */
public class StrReaderTest {

    private IReader reader;

    @Before
    public void setUp() throws ReaderException { reader = new StrReader(""); }

    @Test
    public void hasCharTrue() throws ReaderException {
        String s ="abc";
        reader = new StrReader(s);
        boolean b = reader.hasChar();
        assertEquals(true, b);
    }

    @Test
    public void hasCharFalse() {
        boolean b = reader.hasChar();
        assertEquals(false, b);
    }

    @Test
    public void readCharTest() throws ReaderException {

        String str = "abc";
        reader = new StrReader(str);
        StringBuilder builder = new StringBuilder();
        while (reader.hasChar()) {
            builder.append(reader.readChar());
        }
        assertEquals(str, builder.toString());
    }

}
