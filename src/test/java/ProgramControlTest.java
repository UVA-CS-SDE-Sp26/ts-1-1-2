import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;


class ProgramControlTest {

    @Test
    void getFileList() {
        String expectedList = "01  filea.txt\n02  fileb.txt\n03  filec.txt\n";
        ProgramControl Handler = new ProgramControl();
        assertEquals(expectedList, Handler.getFileList(), "List of files correct\n");

    }

    @Test
    void getFileContents() throws IOException {
        String expectedContents = "";
        ProgramControl Handler = new ProgramControl();
        assertEquals(expectedContents, Handler.getFileContents("01", null), "The file contents are correct!");
    }
}