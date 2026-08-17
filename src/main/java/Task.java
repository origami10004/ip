public class Task {
    private String name;
    private boolean isDone;
    public Task(String name) {
        this.name = name;
        this.isDone = false;
    }

    public String getName() {
        return name;
    }

    public boolean isDone() {
        return isDone;
    }

    public void markAsDone() {
        isDone = true;
    }

    public void unmark() {
        isDone = false;
    }

    public String toString() {
        return (isDone ? "[X] " : "[ ] ") + name;
    }
}
