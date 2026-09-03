package baron.ui;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;

/** A single chat message rendered with the appropriate avatar. */
public class DialogBox extends HBox {
    private DialogBox(String text, boolean isUser) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/DialogBox.fxml"));
            loader.setRoot(this);
            loader.setController(this);
            loader.load();
            javafx.scene.control.Label dialog = (javafx.scene.control.Label) lookup("#dialog");
            javafx.scene.image.ImageView picture = (javafx.scene.image.ImageView) lookup("#displayPicture");
            dialog.setText(text);
            picture.setImage(new javafx.scene.image.Image(getClass().getResourceAsStream(
                    isUser ? "/images/user.png" : "/images/baron.png")));
            if (!isUser) {
                setAlignment(javafx.geometry.Pos.TOP_LEFT);
                dialog.getStyleClass().add("reply-label");
                getChildren().remove(picture);
                getChildren().add(0, picture);
            }
        } catch (IOException e) {
            throw new IllegalStateException("Unable to load dialog box", e);
        }
    }

    /** Creates a chat message for the given speaker. */
    public static DialogBox getDialog(String text, boolean isUser) {
        return new DialogBox(text, isUser);
    }
}
