import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class CommandLineFileHandlerConnectorTest {

    @Test
    void getListOfFiles() {
        String expectedList = "";
        CommandLineFileHandlerConnector Handler = new CommandLineFileHandlerConnector();
        assertEquals(expectedList, Handler.GetListOfFiles(), "List of files correct");

    }

    @Test
    void getFileContents() {
        String expectedContents = "";
        CommandLineFileHandlerConnector Handler = new CommandLineFileHandlerConnector();
        assertEquals(expectedContents, Handler.GetFileContents(1), "The file contents are correct!");
    }
}