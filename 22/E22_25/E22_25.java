/*
  Revise Programming Exercise 22.21 to display all solutions for the Sudoku
  game. When you click the Solve button, the program stores all solutions in
  an ArrayList. Each element in the list is a two-dimensional 9-by-9 grid. If
  the program has multiple solutions, the Next button appears. You can click
  the Next button to display the next solution and also a label to show the
  solution count. When the Clear button is clicked, the cells are cleared and
  the Next button is hidden.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class E22_25 extends Application {
  @Override
  public void start(Stage primaryStage) {
    SudokuGUI sPane = new SudokuGUI();

    Scene scene = new Scene(sPane);
    primaryStage.setTitle("E22_25");
    primaryStage.setScene(scene);
    primaryStage.setResizable(false);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
