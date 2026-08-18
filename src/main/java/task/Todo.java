package task;
public class Todo extends Task {
    public Todo(String name) {
        super(name);
    }

    @Override
    public String getTypeSymbol() {
        return "[T]";
    }
}
