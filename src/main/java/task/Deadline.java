// javadocs created by AI

package task;

/**
 * Represents a task that must be completed by a specified date or time.
 */
public class Deadline extends Task {
    /** The due date or time associated with the task. */
    private String dueDate;

    /**
     * Creates a deadline task.
     *
     * @param name the task description.
     * @param dueDate the deadline information.
     */
    public Deadline(String name, String dueDate) {
        super(name);
        this.dueDate = dueDate;
    }

    /**
     * Returns the deadline details to append to the task display.
     *
     * @return a formatted string containing the due date.
     */
    @Override
    public String extraInfo() {
        return " (by: " + dueDate + ")";
    }

    /**
     * Returns the type symbol for a deadline task.
     *
     * @return "[D]".
     */
    @Override
    public String getTypeSymbol() {
        return "[D]";
    }
}
