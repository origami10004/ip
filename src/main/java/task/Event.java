package task;
public class Event extends Task {
    private String from;
    private String to;

    public Event(String description, String from, String to) {
        super(description);
        this.from = from;
        this.to = to;
    }

    @Override
    public String extraInfo() {
        return " (from: " + from + " to: " + to + ")";
    }

    @Override
    public String getTypeSymbol() {
        return "[E]";
    }
    
}
