import java.io.IOException;
import java.util.List;

public class ProgramControl {

    private static final List<String> listOfFiles = FileHandler.listFiles();
    /*
    GetListOfFiles() is the method for receiving the list of file names. The list of file names
    will depend on the data type returned. I'm expecting an array of Strings or ArrayLIst etc etc.
    It seems like this part is NOT in charge of printing anything, and I should only return readable test.
     */
    public String getFileList(){
        String infoToReturn = "";
        if (listOfFiles.isEmpty()) {
            return  "There are no files to display.\n";
        }

        for (int i = 0; i < listOfFiles.size(); i++) {
            infoToReturn = infoToReturn.concat(String.format("%02d", i) + "  " + listOfFiles.get(i) + "\n");
        }

        return infoToReturn;
    }

    /*
    GetFileContents() will return the file contents of the file that correlates to a specific
    number. Expecting command line interface to give proper params. FileNumber must be a string > 0.
     */
    public String getFileContents(String fileNumber) throws IOException {
        String infoToReturn = "";
        try {
            int n = Integer.parseInt(fileNumber);
            //Call on the FileHandler to receive content of the specific file based on the FileNumber
            infoToReturn = FileHandler.readFile(listOfFiles.get(n-1));
            return infoToReturn;
        }
        catch (NumberFormatException a) {
            return "Please Enter a valid number correlating to files.";
        }
    }

}
