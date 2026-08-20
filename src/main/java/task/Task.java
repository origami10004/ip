// javadocs created by AI

package task;

/**
 * Represents a general task in the Baron application.
 * Subclasses can specify additional details such as deadlines or event ranges.
 */
public class Task {
    /** The human-readable task description. */
    private String name;

    /** Indicates whether the task has been completed. */
    private boolean isDone;

    /**
     * Creates a new task with the specified description.
     *
     * @param name the description of the task.
     */
    public Task(String name) {
        this.name = name;
        this.isDone = false;
    }

    /**
     * Returns the task description.
     *
     * @return the task description.
     */
    public String getName() {
        return name;
    }

    /**
     * Checks whether the task is marked as done.
     *
     * @return true if the task is complete; false otherwise.
     */
    public boolean isDone() {
        return isDone;
    }

    /**
     * Marks the task as complete.
     */
    public void markAsDone() {
        isDone = true;
    }

    /**
     * Marks the task as not complete.
     */
    public void unmark() {
        isDone = false;
    }

    /**
     * Returns any additional task-specific information to display.
     *
     * @return an empty string by default.
     */
    public String extraInfo() {
        return "";
    }

    /**
     * Returns the symbol representing the task type.
     *
     * @return a type label such as "T" or "D".
     */
    public String getTypeSymbol() {
        return " ";
    }

    /**
     * Returns the string representation of the task for display in the command line.
     *
     * @return the formatted task status and description.
     */
    public String toString() {
        return "[" + getTypeSymbol() + "]" + (isDone ? "[X] " : "[ ] ") + name + extraInfo();
    }

    /**
     * returns the string representation of the task for saving to a file.
     * 
     * @return the formatted task status and description for file storage.
     */
    public String serialize() {
        return getTypeSymbol() + "|" + (isDone ? "1" : "0") + "|" + name;
    }
}
