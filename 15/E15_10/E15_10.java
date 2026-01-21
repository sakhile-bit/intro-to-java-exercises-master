/*
  Write a program that receives a string from the keyboard and displays it on
  a pane. The Enter key signals the end of the string. Whenever a new string
  is entered, it is displayed on the pane.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.input.KeyCode;

public class E15_10 extends Application {
  @Override
  public void start(Stage primaryStage) {
    final double WIDTH = 500.0;
    final double HEIGHT = 500.0;

    Pane pane = new Pane();
    StringBuilder sb = new StringBuilder();

    pane.setOnKeyPressed(e -> {
      if (e.getCode() == KeyCode.ENTER) {
        pane.getChildren().clear();
        Text text = new Text(WIDTH / 4, HEIGHT / 2, sb.toString());
        pane.getChildren().add(text);
        sb.delete(0, sb.length());
      } else {
        sb.append(e.getText());
      }
    });

    Scene scene = new Scene(pane, WIDTH, HEIGHT);
    primaryStage.setTitle("E15_10");
    primaryStage.setScene(scene);
    primaryStage.show();

    pane.requestFocus();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
