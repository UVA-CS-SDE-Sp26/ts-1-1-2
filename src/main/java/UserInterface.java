//Metin Halac
//Role A

public class UserInterface {
    private final ProgramControl control;

    public UserInterface(ProgramControl control) {
        this.control = control;
    }

    /**
     * Runs the command line interface and returns an exit code for easy testing.
     *
     * 0 = success
     * 1 = error
     */
    public int run(String[] args) {
        if (args == null) {
            args = new String[0];
        }

        // Listing files in case the program is run with no arguments.
        if (args.length == 0) {
            System.out.print(control.getFileList());
            return 0;
        }

        // Error handling in the case of too many arguments.
        if (args.length > 2) {
            System.out.println("Error: Too many arguments.");
            return 1;
        }

        // Validating file number format, it has to be 2 digits.
        String fileNumber = args[0];
        if (!fileNumber.matches("\\d{2}")) {
            System.out.println("Error: Invalid file query.");
            return 1;
        }

        // Key path assignment
        String keyPath = null;

        if (args.length == 2) {
            keyPath = args[1];
        }

        try {
            String text = control.getFileContents(fileNumber);
            System.out.print(text);
            return 0;
        } catch (IllegalArgumentException e) {
            System.out.println("Error: File not found.");
            return 1;
        } catch (Exception e) {
            System.out.println("Error: Unable to display file.");
            return 1;
        }
    }
}
