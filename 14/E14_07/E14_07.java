/*
  Write a program that displays a 10-by-10 square matrix. Each element in the
  matrix is a 0 or 1, randomly generated. Display each number centered in a
  text field.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.control.TextField;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class E14_07 extends Application {
  @Override
  public void start(Stage primaryStage) {
    BinaryPane pane = new BinaryPane(10);
    pane.setPadding(new Insets(5));
    pane.setVgap(5);
    pane.setHgap(5);

    Scene scene = new Scene(pane);
    primaryStage.setTitle("E14_07");
    primaryStage.setScene(scene);
    primaryStage.setResizable(false);
    primaryStage.show();
  }

  class BinaryPane extends GridPane {
    BinaryPane(int n) {
      for (int col = 0; col < n; col++) {
        for (int row = 0; row < n; row++) {
          int random = (int)(Math.random() * 2);
          String binary = (random == 0) ? "0" : "1";
          TextField textField = new TextField(binary);
          textField.setPrefColumnCount(1);
          textField.setAlignment(Pos.CENTER);
          textField.setEditable(false);
          add(textField, col, row);
        }
      }
    }
  }

  public static void main(String[] args) {
    Application.launch(args);
  }
}
