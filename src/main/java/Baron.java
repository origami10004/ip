public class Baron {
    public static final String NAME = "Baron";
    public static void main(String[] args) {
        greet();

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
        System.out.println("Bye. Hope to see you again soon!");
        printLine();
        
    }
}
