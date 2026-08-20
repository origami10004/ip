// javadocs created by AI

package baron.task;

/**
 * Represents a to-do task that does not have a date or time.
 */
public class Todo extends Task {
    /**
     * Creates a to-do task.
     *
     * @param name the task description.
     */
    public Todo(String name) {
        super(name);
    }

    /**
     * Returns the type symbol for a to-do task.
     *
     * @return "T".
     */
    @Override
    public String getTypeSymbol() {
        return "T";
    }
}
