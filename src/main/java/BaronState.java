import java.util.ArrayList;

public class BaronState {
    private static boolean isExit = false;
    private static ArrayList<String> text;

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

    public static ArrayList<String> getText() {
        return text;
    }

    public static void addText(String input) {
        text.add(input);
    }
}
