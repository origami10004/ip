public enum Commands {
    BYE("bye") {
        @Override
        public void execute(String args) {
            BaronState.exit();
        }

    },
    LIST("list") {
        @Override
        public void execute(String args) {
            Baron.printLine();
            System.out.println("Here are the tasks in your list:");
            int i = 1;
            for (Task t : BaronState.getText()) {
                System.out.println(i + "." + t);
                i++;
            }
            Baron.printLine();
        }
    };

    private final String command;
    Commands(String command) {
        this.command = command;
    }

    // AI suggested use of abstract method to execute commands
    public abstract void execute(String args);

    public static Commands parse(String input) {
        // AI suggested use of valueOf to parse the input string to enum constant
        try {
            return Commands.valueOf(input.toUpperCase());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
