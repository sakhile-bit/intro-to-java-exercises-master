/*
  The Knight's Tour is an ancient puzzle. The objective is to move a knight,
  starting from any square on a chessboard, to every other square once. Note
  that the knight makes only L-shaped moves (two spaces in one direction and
  one space in a perpendicular direction). The knight can move to eight squares.
  Write a program that displays the moves for the knight. When you click a cell,
  the knight is placed at the cell. This cell will be the starting point for
  the knight. Click the Solve button to display the path for a solution.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class E18_33 extends Application {
  @Override
  public void start(Stage primaryStage) {
    KnightTourGUI ktg = new KnightTourGUI(8, 50);

    Scene scene = new Scene(ktg);
    primaryStage.setTitle("E18_33");
    primaryStage.setScene(scene);
    primaryStage.setResizable(false);
    primaryStage.show();
  }
  public static void main(String[] args) {
    launch(args);
  }
}
