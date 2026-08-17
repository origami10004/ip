import java.util.ArrayList;

public class BaronState {
    private static boolean isExit = false;
    private static ArrayList<Task> text;

    public static void init() {
        isExit = false;
        text = new ArrayList<>();
    }


    public static void exit() {
        isExit = true;
    }

    public static boolean getExitStatus() {
        return isExit;
    }

    public static ArrayList<Task> getText() {
        return text;
    }

    public static void addText(String input) {
        text.add(new Task(input));
    }
}
