import java.util.ArrayList;

import task.Task;

import exceptions.BaronException;
import exceptions.IndexException;

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

    public static void markTaskAsDone(int index) throws BaronException {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).markAsDone();
        } else {
            throw new IndexException("task");
        }
    }

    public static void unmarkTask(int index) throws BaronException {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).unmark();
        } else {
            throw new IndexException("task");
        }
    }

    public static Task delete(int index) throws BaronException {
        if (index >= 0 && index < tasks.size()) {
            return tasks.remove(index);
        } else {
            throw new IndexException("task");
        }
    }
}
