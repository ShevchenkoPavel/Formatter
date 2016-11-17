import it.sevenbits.formatcode.core.IWriter;
import it.sevenbits.formatcode.iostring.StrWriter;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests for StrWriter
 */
public class StrWriterTest {

    private IWriter writer;

    @Before
    public void setUp() { writer = new StrWriter(); }

    @Test
    public void writerTest() {
        char a = 'a';
        char b = 'b';
        char c = 'c';
        writer.writeChar(a);
        writer.writeChar(b);
        writer.writeChar(c);
        assertEquals("abc", writer.toStr());
    }

}
