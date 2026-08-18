import java.util.Scanner;

public class Baron {
    public static final String NAME = "Baron";
    private static final String BANNER = "__________\n"
            + "\\______   \\_____ _______  ____   ____\n"
            + " |    |  _/\\__  \\\\_  __ \\/  _ \\ /    \\\n"
            + " |    |   \\ / __ \\|  | \\(  <_> )   |  \\\n"
            + " |______  /(____  /__|   \\____/|___|  /\n"
            + "        \\/      \\/                  \\/";

    public static void main(String[] args) {
        greet();

        Scanner sc = new Scanner(System.in);
        BaronState.init();
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


    private static void printBanner() {
        System.out.println(BANNER);
    }

    public static void printLine() {
        System.out.println("____________________________________________________________");
    }

    private static void greet() {
        printLine();
        printBanner();
        System.out.println("Hello! I'm " + NAME + ".\nWhat can I do for you?");
        printLine();
    }

    private static void bye() {
        System.out.println("Bye. Hope to see you again soon!");
        printLine();
        printLine();
    }
}
