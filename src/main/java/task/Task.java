// javadocs created by AI

package task;

import exceptions.BaronException;

/**
 * Represents a general task in the Baron application.
 * Subclasses can specify additional details such as deadlines or event ranges.
 */
public abstract class Task {
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

    /**
     * Creates a Task object from its serialized string representation.
     * @param serializedTask the serialized task string
     * @return the deserialized Task object
     * @throws BaronException if the serialized task format is invalid
     */
    public static Task deserialize(String serializedTask) throws BaronException {
        String[] parts = serializedTask.split("\\|");
        if (parts.length < 3) {
            throw new BaronException("Invalid task format.");
        }

        String type = parts[0];
        boolean isDone = false;
        if (parts[1].equals("1")) {
            isDone = true;
        } else if (!parts[1].equals("0")) {
            throw new BaronException("Invalid task completion status.");
        }
        String name = parts[2];

        Task task;
        switch (type) {
            case "T":
                task = new Todo(name);
                break;
            case "D":
                if (parts.length < 4) {
                    throw new BaronException("Invalid deadline format.");
                }
                String dueDate = parts[3];
                task = new Deadline(name, dueDate);
                break;
            case "E":
                if (parts.length < 5) {
                    throw new BaronException("Invalid event format.");
                }
                String from = parts[3];
                String to = parts[4];
                task = new Event(name, from, to);
                break;
            default:
                throw new BaronException("Unknown task type: " + type);
        }

        if (isDone) {
            task.markAsDone();
        }

        return task;
    }
}
