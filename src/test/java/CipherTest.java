import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

public class CipherTest {
    @TempDir
    Path tempDir;

    // Helper to create temporary key files
    private Path createKeyFile(String line1, String line2) throws IOException {
        Path keyFile = tempDir.resolve("key.txt");
        Files.write(keyFile, (line1 + System.lineSeparator() + line2).getBytes());
        return keyFile;
    }

    @Test
    void decipher_validKey_returnsCorrectPlainText() throws IOException {
        Path keyFile = createKeyFile(
                "ABCDEFGHIJKLMNOPQRSTUVWXYZ",
                "QWERTYUIOPASDFGHJKLZXCVBNM"
        );

        Cipher cipher = new Cipher();
        String result = cipher.decipher("ITSSG", keyFile);

        assertEquals("HELLO", result);
    }

    @Test
    void decipher_missingKeyFile_throwsException() {
        Cipher cipher = new Cipher();
        Path nonExistent = Path.of("doesNotExist.txt");

        assertThrows(IOException.class, () ->
                cipher.decipher("TEST", nonExistent)
        );
    }

    @Test
    void decipher_keyWithDifferentLineLengths_throwsException() throws IOException {
        Path keyFile = createKeyFile(
                "ABCDE",
                "XYZ"
        );

        Cipher cipher = new Cipher();

        assertThrows(IllegalArgumentException.class, () ->
                cipher.decipher("ABC", keyFile)
        );
    }

    @Test
    void decipher_keyWithDuplicateCharacters_throwsException() throws IOException {
        Path keyFile = createKeyFile(
                "ABCDE",
                "XXYZW"
        );

        Cipher cipher = new Cipher();

        assertThrows(IllegalArgumentException.class, () ->
                cipher.decipher("ABC", keyFile)
        );
    }

    @Test
    void decipher_preservesSpacesAndPunctuation() throws IOException {
        Path keyFile = createKeyFile(
                "ABCDEFGHIJKLMNOPQRSTUVWXYZ",
                "QWERTYUIOPASDFGHJKLZXCVBNM"
        );

        Cipher cipher = new Cipher();
        String result = cipher.decipher("ITSSG, VGKSR!", keyFile);

        assertEquals("HELLO, WORLD!", result);
    }

    @Test
    void decipher_withAlternateKey_worksCorrectly() throws IOException {
        Path keyFile = createKeyFile(
                "ABC",
                "XYZ"
        );

        Cipher cipher = new Cipher();
        String result = cipher.decipher("XYZ", keyFile);

        assertEquals("ABC", result);
    }

}
