import it.sevenbits.formatcode.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * strReader test
 */
public class StrReaderTest {

    private IReader reader;

    @Before
    public void setUp() {
        reader = new StrReader();
    }

    @Test
    public void strReaderTest() {
        char value = 'c';
        System.out.print(value);
        assertEquals(true, reader.hasChar());
    }
}