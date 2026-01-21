/*
  Write a program that will find a path in a maze. The maze is represented by
  an 8x8 board. The path must meet the following conditions:

  - The path is between the upper-left corner cell and the lower-right corner
    cell in the maze.
  - The program enables the user to place or remove a mark on a cell. A path
    consists of adjacent unmarked cells. Two cells are said to be adjacent if
    they are horizontal or vertical neighbors, but not if they are diagonal
    neighbors.
  - The path does not contain cells that form a square.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class E18_26 extends Application {
  @Override
  public void start(Stage primaryStage) {
    MazeSolverGUI msg = new MazeSolverGUI(8, 8);

    Scene scene = new Scene(msg);
    primaryStage.setTitle("E18_26");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
