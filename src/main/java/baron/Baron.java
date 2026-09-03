// javadocs created by AI

package baron;

import baron.data.BaronState;
import baron.ui.MainWindow;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Entry point for the Baron task management application.
 * The program starts a command loop that reads user input, dispatches commands,
 * and manages the application state until the user exits.
 */
public class Baron extends Application {
    /**
     * Starts the Baron application and processes user commands until termination.
     *
     */
    @Override
    public void start(Stage stage) throws Exception {
        BaronState.init();
        FXMLLoader loader = new FXMLLoader(Baron.class.getResource("/view/MainWindow.fxml"));
        Parent root = loader.load();
        MainWindow controller = loader.getController();
        controller.showWelcome();
        stage.setTitle("Baron Task Manager");
        stage.setScene(new Scene(root));
        stage.setMinWidth(400);
        stage.setMinHeight(600);
        stage.show();
    }

    /**
     * The main method that serves as the entry point for the Baron application.
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }
}
