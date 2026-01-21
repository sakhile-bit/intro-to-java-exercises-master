/*
  Write a program to display the text "Java is fun" and "Java is powerful"
  alternately with a mouse click.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.geometry.Insets;

public class E15_06 extends Application {
  @Override
  public void start(Stage primaryStage) {
    final String message1 = "Java is fun";
    final String message2 = "Java is powerful";
    Text tMessage = new Text(message1);

    tMessage.setOnMouseClicked(e -> {
      if (tMessage.getText().equals(message1)) {
        tMessage.setText(message2);
      } else {
        tMessage.setText(message1);
      }
    });

    StackPane pane = new StackPane();
    pane.setPadding(new Insets(50));
    pane.getChildren().add(tMessage);

    Scene scene = new Scene(pane);
    primaryStage.setTitle("E15_06");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
