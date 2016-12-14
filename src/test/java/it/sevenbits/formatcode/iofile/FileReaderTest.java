package it.sevenbits.formatcode.iofile;

import it.sevenbits.formatcode.core.IReader;
import it.sevenbits.formatcode.core.ReaderException;
import it.sevenbits.formatcode.iofile.FileReader;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.io.FileNotFoundException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Test for FileReader
 */
public class FileReaderTest {
    private IReader reader;

    @Before
    public void setUp() throws FileNotFoundException, ReaderException {
        reader = mock(FileReader.class);
        when(reader.hasChar()).thenReturn(true);
        when(reader.read()).thenReturn('c');
    }

    @Test
    public void hasCharFFTest() throws ReaderException {
        assertEquals(true, reader.hasChar());
    }

    @Test
    public void readCharFFTest() throws ReaderException {
        assertEquals('c', reader.read());
    }
}
