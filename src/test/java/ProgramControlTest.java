import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;


class ProgramControlTest {

    @Test
    void getFileList() {
        String expectedList = "";
        ProgramControl Handler = new ProgramControl();
        assertEquals(expectedList, Handler.getFileList(), "List of files correct");

    }

    @Test
    void getFileContents() throws IOException {
        String expectedContents = "";
        ProgramControl Handler = new ProgramControl();
        assertEquals(expectedContents, Handler.getFileContents("01"), "The file contents are correct!");
    }
}