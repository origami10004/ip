// javadocs created by AI

package baron;

import java.util.Scanner;

import baron.command.Commands;
import baron.data.BaronState;
import baron.exception.BaronException;
import baron.ui.Ui;

/**
 * Entry point for the Baron task management application.
 * The program starts a command loop that reads user input, dispatches commands,
 * and manages the application state until the user exits.
 */
public class Baron {
    /**
     * Starts the Baron application and processes user commands until termination.
     *
     */
    public Baron() {
        BaronState.init();
        Ui.start();
        Scanner sc = new Scanner(System.in);
        while (!BaronState.getExitStatus()) {
            System.out.print("> ");
            String input = sc.nextLine();
            String command = input.split(" ")[0];
            String paramString = input.substring(command.length()).trim();

            try {
                Commands c = Commands.parse(command);
                Ui.displayResult(c.execute(paramString));
            } catch (BaronException e) {
                Ui.displayError(e);
            }
        }
        Ui.close();
        sc.close();
    }

    /**
     * The main method that serves as the entry point for the Baron application.
     * @param args
     */
    public static void main(String[] args) {
        new Baron();
    }
}
