import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.*;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserInterfaceTest {
    private final PrintStream console = System.out;
    private ByteArrayOutputStream output;

    @Mock
    private ProgramControl control;

    @BeforeEach
    void setupOutputRecording() {
        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    void resetOutputRecording() {
        System.setOut(console);
    }

    @Test
    void noArgsListsFiles() {
        when(control.getFileList()).thenReturn("01  filea.txt\n");

        int code = new UserInterface(control).run(new String[0]);

        assertEquals(0, code);
        assertEquals("01  filea.txt\n", output.toString());
    }

    @Test
    void invalidFileNumberError() {
        int code = new UserInterface(control).run(new String[]{"4"});

        assertEquals(1, code);
        assertEquals("Error: Invalid file query.\n", output.toString());
    }

    @Test
    void validFilePrintsContents() throws Exception {
        when(control.getFileContents("04", null)).thenReturn("hello");

        int code = new UserInterface(control).run(new String[]{"04"});

        assertEquals(0, code);
        assertEquals("hello", output.toString());
    }

    @Test
    void ioExceptionReturnsError() throws Exception {
        when(control.getFileContents("04", null)).thenThrow(new IOException());

        int code = new UserInterface(control).run(new String[]{"04"});

        assertEquals(1, code);
    }
}

