import it.sevenbits.formatcode.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Reader test
 */
public class ReaderTest {

    private IReader reader;

    @Before
    public void setUp() {
        IReader reader = new StrReader();
    }

    @Test
    public void readerTest(){
        char value = 'c';
        System.out.println(value);
        assertEquals(value, reader.readchar());
    }
}
