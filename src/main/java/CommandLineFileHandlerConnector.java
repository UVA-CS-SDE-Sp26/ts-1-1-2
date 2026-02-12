
public class CommandLineFileHandlerConnector {

    private String infoToReturn = "";
    /*
    GetListOfFiles() is the method for receiving the list of file names. The list of file names
    will depend on the data type returned. I'm expecting an array of Strings or ArrayLIst etc etc.
    It seems like this part is NOT in charge of printing anything, and I should only return readable test.
     */
    public String GetListOfFiles(){
        String[] listOfFiles = {};
        //Call on the FileHandler function to receive a list of files

        //This function should be changed if there is another way of being told there are no files
        if (listOfFiles.length == 0) {
            infoToReturn = "There are no files to display.\n";
        }

        for (int i = 0; i < listOfFiles.length; i++) {
            infoToReturn = infoToReturn.concat(i + " " + listOfFiles[i] + "\n");
        }
        return infoToReturn;
    }

    /*
    GetFileContents() will return the file contents of the file that correlates to a specific
    number. Expecting command line interface to give proper params. FileNumber must be an int > 0.
     */
    public String GetFileContents(int fileNumber){
        String fileContents = "";
        //Call on the FileHandler to receive content of the specific file based on the FileNumber


        return infoToReturn;
    }

}
