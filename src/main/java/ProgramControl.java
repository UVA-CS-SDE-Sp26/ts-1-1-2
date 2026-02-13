import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

public class ProgramControl {

    private static final List<String> listOfFiles = FileHandler.listFiles();

    public String getFileList(){
        String infoToReturn = "";
        if (listOfFiles.isEmpty()) {
            return  "There are no files to display.\n";
        }

        for (int i = 0; i < listOfFiles.size(); i++) {
            infoToReturn = infoToReturn.concat(String.format("%02d", i+1) + "  " + listOfFiles.get(i) + "\n");
        }

        return infoToReturn;
    }

    public String getFileContents(String fileNumber, String pathVar) throws IOException {
        String cipherText = "";
        Cipher solve = new Cipher();
        try {
            int n = Integer.parseInt(fileNumber);

            if (n < 1 || n > listOfFiles.size())
                return "Please enter a number correlating to files.\n";
            //Call on the FileHandler to receive content of the specific file based on the FileNumber
            cipherText = FileHandler.readFile(listOfFiles.get(n-1));
        }
        catch (NumberFormatException a) {
            return "Please Enter a valid number correlating to files.\n";
        }
        try {
            //In case of null pathvar use default key; in case of given pathvar, use that instead
            return solve.decipher(cipherText, Paths.get(Objects.requireNonNullElse(pathVar, "ciphers/key.txt")));
        }
        catch (NullPointerException | NoSuchFileException ex) {
            return "Invalid key file path.";
        }
        catch (IllegalArgumentException am) {
            return "Please make sure your key is valid.";
        }
    }



}
