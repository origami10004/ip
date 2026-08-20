// javadocs created by AI

import java.util.Scanner;

import data.BaronState;
import exceptions.BaronException;

/**
 * Entry point for the Baron task management application.
 * The program starts a command loop that reads user input, dispatches commands,
 * and manages the application state until the user exits.
 */
public class Baron {
    /** Name displayed in the welcome banner and greeting messages. */
    public static final String NAME = "Baron";

    /** ASCII banner shown when the application starts. */
    private static final String BANNER = "__________\n"
            + "\\______   \\_____ _______  ____   ____\n"
            + " |    |  _/\\__  \\\\_  __ \\/  _ \\ /    \\\n"
            + " |    |   \\ / __ \\|  | \\(  <_> )   |  \\\n"
            + " |______  /(____  /__|   \\____/|___|  /\n"
            + "        \\/      \\/                  \\/";

    /**
     * Starts the Baron application and processes user commands until termination.
     *
     */
    public Baron() {
        BaronState.init();
        greet();
        Scanner sc = new Scanner(System.in);
        while (!BaronState.getExitStatus()) {
            System.out.print("> ");
            String input = sc.nextLine();
            String command = input.split(" ")[0];
            String paramString = input.substring(command.length()).trim();

            printLine();
            try {
                Commands c = Commands.parse(command);
                c.execute(paramString);
            } catch (BaronException e) {
                System.out.println(e.getMessage());
            }
            printLine();
        }
        bye();
        sc.close();
    }


    /**
     * Prints the ASCII banner used at startup.
     */
    private static void printBanner() {
        System.out.println(BANNER);
    }

    /**
     * Prints a divider line used to separate UI sections.
     */
    public static void printLine() {
        System.out.println("____________________________________________________________");
    }

    /**
     * Displays the welcome message and startup banner.
     */
    private static void greet() {
        printLine();
        printBanner();
        System.out.println("Hello! I'm " + NAME + ".\nWhat can I do for you?");
        printLine();
    }

    /**
     * Displays the farewell message when the application exits.
     */
    private static void bye() {
        System.out.println("Bye. Hope to see you again soon!");
        printLine();
        printLine();
    }

    
    /**
     * The main method that serves as the entry point for the Baron application.
     * @param args
     */
    public static void main(String[] args) {
        new Baron();
    }
}
