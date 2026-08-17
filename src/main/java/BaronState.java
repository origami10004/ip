import java.util.ArrayList;

public class BaronState {
    private static boolean isExit = false;
    private static ArrayList<Task> tasks;

    public static void init() {
        isExit = false;
        tasks = new ArrayList<>();
    }


    public static void exit() {
        isExit = true;
    }

    public static boolean getExitStatus() {
        return isExit;
    }

    public static ArrayList<Task> getTasks() {
        return tasks;
    }

    public static void addText(String input) {
        tasks.add(new Task(input));
    }

    public static void markTaskAsDone(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).markAsDone();
        } else {
            System.out.println("Invalid task index.");
        }
    }

    public static void unmarkTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).unmark();
        } else {
            System.out.println("Invalid task index.");
        }
    }
}
