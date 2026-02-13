import org.junit.jupiter.api.*;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProgramControlTest {

    @Test
    void getFileList() {
        String expectedList = "01  filea.txt\n02  fileb.txt\n03  filec.txt\n04  fileempty.txt\n";
        ProgramControl Handler = new ProgramControl();
        assertEquals(expectedList, Handler.getFileList(), "List of files correct\n");
    }

    @Test
    void insertingBadFileNumber() throws IOException {
        ProgramControl Handler = new ProgramControl();
        assertEquals("Please enter a number correlating to files.\n", Handler.getFileContents("00", null), "The file contents are correct!");
    }

    @Test
    void insertBadKey() throws IOException {
        ProgramControl Handler = new ProgramControl();
        assertEquals("Invalid key file path.\n", Handler.getFileContents("01", "bad.txt"), "Proper exception was thrown");
    }

    @Test
    void emptyFileTest() throws IOException {
        ProgramControl Handler = new ProgramControl();
        assertEquals("", Handler.getFileContents("04", null), "Empty file opens properly.");
    }

}