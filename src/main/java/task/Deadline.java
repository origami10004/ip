package task;
public class Deadline extends Task {
    private String dueDate;

    public Deadline(String name, String dueDate) {
        super(name);
        this.dueDate = dueDate;
    }

    @Override
    public String extraInfo() {
        return " (by: " + dueDate + ")";
    }

    @Override
    public String getTypeSymbol() {
        return "[D]";
    }
    
}
