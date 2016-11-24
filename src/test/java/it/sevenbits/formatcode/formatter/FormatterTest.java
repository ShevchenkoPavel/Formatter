package it.sevenbits.formatcode.formatter;

import it.sevenbits.formatcode.core.*;
import it.sevenbits.formatcode.formatter.Formatter;
import it.sevenbits.formatcode.iostring.StrReader;
import it.sevenbits.formatcode.iostring.StrWriter;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Formatter test
 */
public class FormatterTest {
    private IFormatter formatter;

    @Before
    public void setUp() { formatter = new Formatter(); }

    @Test
    public void formatStrTest() throws FormatterException, ReaderException, WriterException {
        String s = "abc";
        IReader reader = new StrReader(s);
        IWriter writer = new StrWriter();
        formatter.format(reader, writer);
        assertEquals(s, writer.toStr());
    }

}
