/*
  Write a program that displays a checkerboard in which each white and black
  cell is a Rectangle with a fill color black or white.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import javafx.geometry.Pos;
import javafx.scene.paint.Color;

public class E14_06 extends Application {
  @Override
  public void start(Stage primaryStage) {
    CheckerPane checker = new CheckerPane(8, 50);
    checker.setAlignment(Pos.CENTER);

    Scene scene = new Scene(checker);
    primaryStage.setTitle("E14_06");
    primaryStage.setScene(scene);
    primaryStage.setResizable(false);
    primaryStage.show();
  }

  class CheckerPane extends GridPane {
    CheckerPane(int n, int squareSize) {
      for (int col = 0; col < n; col++) {
        boolean isWhite = col % 2 == 0 ? true : false;
        for (int row = 0; row < n; row++) {
          Rectangle rect = new Rectangle(0, 0, squareSize, squareSize);
          rect.setFill(isWhite ? Color.WHITE : Color.BLACK);
          isWhite = !isWhite;
          add(rect, col, row);
        }
      }
    }
  }

  public static void main(String[] args) {
    Application.launch(args);
  }
}
