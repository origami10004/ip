import java.util.Scanner;
import java.util.ArrayList;

public class Baron {
    public static final String NAME = "Baron";

    private static boolean isExit;
    private static ArrayList<String> text = new ArrayList<>();
    public static void main(String[] args) {
        greet();

        Scanner sc = new Scanner(System.in);
        isExit = false;
        text.clear();
        while (!isExit) {
            System.out.print("> ");
            String input = sc.nextLine();
            if (input.equals("bye")) {
                isExit = true;
            } else if (input.equals("list")) {
                printLine();
                for (int i = 0; i < text.size(); i++) {
                    System.out.println((i + 1) + ". " + text.get(i));
                }
                printLine();
            } else {
                printLine();
                System.out.println("added: " + input);
                printLine();
                text.add(input);
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
