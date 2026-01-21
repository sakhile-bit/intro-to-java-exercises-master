/*
  Write a program that displays a tic-tac-toe board. A cell may be X, O, or
  empty. What to display at each cell is randomly decided.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class E14_02 extends Application {
  @Override
  public void start(Stage primaryStage) {
    GridPane pane = new GridPane();
    pane.setAlignment(Pos.CENTER);
    pane.setHgap(10);
    pane.setVgap(10);

    for (int col = 0; col <= 2; col++) {
      for (int row = 0; row <= 2; row++) {
        int random = (int)(Math.random() * 3);
        if (random == 0) {
          continue;
        } else {
          String marker = (random == 1) ? "x.gif" : "o.gif";
          ImageView imgView = new ImageView(new Image(marker));
          pane.add(imgView, col, row);
        }
      }
    }

    Scene scene = new Scene(pane, 300, 300);
    primaryStage.setTitle("E14_02");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    Application.launch(args);
  }
}
