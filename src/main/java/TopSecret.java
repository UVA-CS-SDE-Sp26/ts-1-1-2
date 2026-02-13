/**
 * Commmand Line Utility
 */
public class TopSecret {
    public static void main(String[] args) {
        ProgramControl control = new ProgramControl();
        UserInterface ui = new UserInterface(control);

        int exitCode = ui.run(args);
        System.exit(exitCode);
    }
}
