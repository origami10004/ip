package baron.ui;

import baron.command.Commands;
import baron.exception.BaronException;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/** Controller for the main Baron chat window. */
public class MainWindow {
    @FXML private VBox dialogContainer;
    @FXML private TextField userInput;
    @FXML private ScrollPane scrollPane;

    /** Displays the initial greeting in the conversation. */
    public void showWelcome() {
        dialogContainer.getChildren().add(DialogBox.getDialog("Hello! I'm Baron.\nWhat can I do for you?", false));
    }

    /** Executes the command entered by the user and appends both messages. */
    @FXML
    private void handleUserInput() {
        String input = userInput.getText().trim();
        if (input.isEmpty()) return;
        dialogContainer.getChildren().add(DialogBox.getDialog(input, true));
        String response;
        try {
            String command = input.split(" ", 2)[0];
            String arguments = input.length() == command.length() ? "" : input.substring(command.length()).trim();
            response = Commands.parse(command).execute(arguments);
        } catch (BaronException e) {
            response = e.getMessage();
        }
        if (!response.isEmpty()) dialogContainer.getChildren().add(DialogBox.getDialog(response, false));
        userInput.clear();
        scrollPane.layout();
        scrollPane.setVvalue(1.0);
    }
}
