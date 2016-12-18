package it.sevenbits.formatcode.formatter;

import it.sevenbits.formatcode.core.*;
import it.sevenbits.formatcode.formatter.Formatter;
import it.sevenbits.formatcode.iostring.StrReader;
import it.sevenbits.formatcode.iostring.StrWriter;
import it.sevenbits.formatcode.lexer.Lexer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Formatter test
 */
public class FormatterTest {
    private IFormatter formatter;
    private IReader<Character> reader;
    private IWriter<String> writer;

    @Before
    public void setUp() {
        formatter = new Formatter();
    }

    @Test
    public void formatStrTest() throws FormatterException, ReaderException, WriterException {
        String s = "{abc;}}";
        reader = new StrReader(s);
        IReader<IToken> lexer = new Lexer(reader);
        IWriter<String> writer = new StrWriter();

        formatter.format(lexer, writer);
        assertEquals("{\n\tabc;\n}\n", writer.toStr());
    }

}
