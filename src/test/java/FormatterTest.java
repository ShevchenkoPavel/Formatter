import it.sevenbits.formatcode.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Formatter test
 */
public class FormatterTest {

    private IFormatter formatter;

    @Before
    public void setUp() {
        formatter = new Formatter();
    }

    @Test
    public void TestFormatter() {
        IReader input = new StrReader();
        IWriter output = new StrWriter();
        formatter.format(input, output);
    }
}
