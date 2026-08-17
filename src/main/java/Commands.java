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
            System.out.println("Here are the tasks in your list:");
            int i = 1;
            for (Task t : BaronState.getTasks()) {
                System.out.println(i + "." + t);
                i++;
            }
        }
    },
    MARK("mark") {
        @Override
        public void execute(String args) {
            try {
                int index = Integer.parseInt(args) - 1;
                BaronState.markTaskAsDone(index);
                System.out.println("Nice! I've marked this task as done:");
                System.out.println("  " + BaronState.getTasks().get(index));
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please provide a valid task number.");
            }
        }
    },
    UNMARK("unmark") {
        @Override
        public void execute(String args) {
            try {
                int index = Integer.parseInt(args) - 1;
                BaronState.unmarkTask(index);
                System.out.println("OK, I've marked this task as not done yet:");
                System.out.println("  " + BaronState.getTasks().get(index));
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please provide a valid task number.");
            }
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
