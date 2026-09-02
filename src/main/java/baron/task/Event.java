// javadocs created by AI

package baron.task;

import java.time.LocalDateTime;

import baron.data.DateHandler;
import baron.exception.BaronException;

/**
 * Represents an event task with a start and end time.
 */
public class Event extends Task {
    /** The start time or date of the event. */
    private LocalDateTime from;

    /** The end time or date of the event. */
    private LocalDateTime to;

    /**
     * Creates an event task.
     *
     * @param description the event description.
     * @param from the event start time.
     * @param to the event end time.
     */
    public Event(String description, String from, String to) throws BaronException {
        super(description);
        this.from = DateHandler.parse(from);
        this.to = DateHandler.parse(to);
    }

    /**
     * Returns the event time range to include in the task display.
     *
     * @return a formatted string containing the start and end times.
     */
    @Override
    public String extraInfo() {
        return " (from: " + DateHandler.format(from) + " to: " + DateHandler.format(to) + ")";
    }

    /**
     * Returns the type symbol for an event task.
     *
     * @return "E".
     */
    @Override
    public String getTypeSymbol() {
        return "E";
    }

    /**
     * returns the string representation of the task for saving to a file.
     *
     * @return the formatted task status and description for file storage.
     */
    @Override
    public String serialize() {
        return super.serialize() + "|" + DateHandler.format(from) + "|" + DateHandler.format(to);
    }
}
