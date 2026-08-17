import java.util.Scanner;

public class Baron {
    public static final String NAME = "Baron";
    public static void main(String[] args) {
        greet();

        Scanner sc = new Scanner(System.in);
        boolean isExit = false;
        while (!isExit) {
            System.out.print("> ");
            String input = sc.nextLine();
            if (input.equals("bye")) {
                isExit = true;
            } else {
                printLine();
                System.out.println(input);
                printLine();
            }
        }
        bye();
        sc.close();
    }


    private static String banner() {
        return "__________\n"
            + "\\______   \\_____ _______  ____   ____\n"
            + " |    |  _/\\__  \\\\_  __ \\/  _ \\ /    \\\n"
            + " |    |   \\ / __ \\|  | \\(  <_> )   |  \\\n"
            + " |______  /(____  /__|   \\____/|___|  /\n"
            + "        \\/      \\/                  \\/";
    }

    private static void printLine() {
        System.out.println("____________________________________________________________");
    }

    private static void greet() {
        printLine();
        System.out.println(banner());
        System.out.println("Hello! I'm " + NAME + ".\nWhat can I do for you?");
        printLine();
    }

    private static void bye() {
        printLine();
        System.out.println("Bye. Hope to see you again soon!");
        printLine();
    }
}
