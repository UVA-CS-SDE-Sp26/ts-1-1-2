import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileHandlerTest {

    @Test
    void testListFilesReturnsNonEmptyList() {
        List<String> files = FileHandler.listFiles();
        assertTrue(files.size() > 0, "Should find files in data folder");
    }

    @Test
    void testFileExistsReturnsTrueForExistingFile() {
        assertEquals(true, FileHandler.fileExists("filea.txt"), "filea.txt should exist");
    }

    @Test
    void testFileExistsReturnsFalseForNonExistingFile() {
        assertEquals(false, FileHandler.fileExists("nonexistent.txt"), "nonexistent.txt should not exist");
    }

    @Test
    void testReadFileReturnsContent() throws IOException {
        String content = FileHandler.readFile("filea.txt");
        assertNotNull(content, "File content should not be null");
        assertTrue(content.length() > 0, "File content should not be empty");
    }

    @Test
    void testReadFileThrowsExceptionForNonExistingFile() {
        assertThrows(IOException.class, () -> {
            FileHandler.readFile("nonexistent.txt");
        }, "Should throw IOException for non-existing file");
    }
}
