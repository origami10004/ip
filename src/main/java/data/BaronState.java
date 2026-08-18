// javadocs created by AI

package data;

import java.util.ArrayList;

import task.Task;

import exceptions.BaronException;
import exceptions.IndexException;

/**
 * Stores the application state for the Baron task manager.
 * This includes the exit flag and the current list of tasks.
 */
public class BaronState {
    /** Indicates whether the user has requested to exit the application. */
    private static boolean isExit = false;

    /** The list of tasks currently managed by the application. */
    private static ArrayList<Task> tasks;

    /**
     * Resets the application state for a fresh session.
     */
    public static void init() {
        isExit = false;
        tasks = new ArrayList<>();
    }

    /**
     * Marks the application to exit at the next loop iteration.
     */
    public static void exit() {
        isExit = true;
    }

    /**
     * Returns whether the application should terminate.
     *
     * @return true if the user has chosen to exit; false otherwise.
     */
    public static boolean getExitStatus() {
        return isExit;
    }

    /**
     * Returns the task list currently stored in the application state.
     *
     * @return the list of tasks.
     */
    public static ArrayList<Task> getTasks() {
        return tasks;
    }

    /**
     * Adds a plain text task to the current task list.
     *
     * @param input the task description.
     */
    public static void addText(String input) {
        tasks.add(new Task(input));
    }

    /**
     * Marks a task as done if the given index is valid.
     *
     * @param index zero-based index of the task to mark as done.
     * @throws BaronException if the index is outside the valid range.
     */
    public static void markTaskAsDone(int index) throws BaronException {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).markAsDone();
        } else {
            throw new IndexException("task");
        }
    }

    /**
     * Marks a task as not done if the given index is valid.
     *
     * @param index zero-based index of the task to unmark.
     * @throws BaronException if the index is outside the valid range.
     */
    public static void unmarkTask(int index) throws BaronException {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).unmark();
        } else {
            throw new IndexException("task");
        }
    }

    /**
     * Removes a task from the list using its zero-based index.
     *
     * @param index zero-based index of the task to remove.
     * @return the task that was removed.
     * @throws BaronException if the index is outside the valid range.
     */
    public static Task delete(int index) throws BaronException {
        if (index >= 0 && index < tasks.size()) {
            return tasks.remove(index);
        } else {
            throw new IndexException("task");
        }
    }
}
