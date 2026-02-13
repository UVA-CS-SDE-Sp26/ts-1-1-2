import org.junit.jupiter.api.*;
import org.junit.jupiter.api.io.TempDir;
import org.mockito.MockedStatic;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import static org.mockito.Mockito.mockStatic;


import static org.junit.jupiter.api.Assertions.*;


class ProgramControlTest {

    @Test
    void getFileList() {
        String expectedList = "01  filea.txt\n02  fileb.txt\n03  filec.txt\n";
        ProgramControl Handler = new ProgramControl();
        assertEquals(expectedList, Handler.getFileList(), "List of files correct\n");
    }

    @TempDir
    Path tempDir;
    private String oldUserDir;
    @BeforeEach
    void setUp() throws Exception {
        oldUserDir = System.getProperty("user.dir");

        // Point the program's working directory at a clean temp folder
        System.setProperty("user.dir", tempDir.toString());

        // Create the hardcoded "data" directory (empty)
        Files.createDirectories(tempDir.resolve("data"));
    }
    @AfterEach
    void tearDown() {
        // Restore so other tests / IntelliJ isn't affected
        System.setProperty("user.dir", oldUserDir);
    }
    @Test
    void noFilesCase() {
        // I wanted to use mockito to create a case in which FileHandler return an empty list; however, I found that it's not possible
        // to use mockito on a static class due to the current setup
        ProgramControl handler = new ProgramControl();
        assertEquals("There are no files to display.\n", handler.getFileList(), "Successfully verified no files edge case");
    }

    @Test
    void getFileContents() throws IOException {
        String expectedContents = "";
        ProgramControl Handler = new ProgramControl();
        assertEquals(expectedContents, Handler.getFileContents("01", null), "The file contents are correct!");
    }
}