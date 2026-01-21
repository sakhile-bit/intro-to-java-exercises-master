/*
  The problem for finding a largest block is described in Programming Exercise
  8.35. Design a dynamic programming algorithm for solving this problem in
  O(n^2) time. Write a test program that displays a 10-by-10 square matrix.
  Each element in the matrix is 0 or 1, randomly generated with a click of
  the refresh button. Display each number centered in a text field. Use a text
  field for each entry. Allow the user to change the entry value. Click the
  Find Largest Block button to find a largest square submatrix that consists
  of 1s. Highlight the numbers in the block.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class E22_19 extends Application {
  @Override
  public void start(Stage primaryStage) {
    MatrixGUI pane = new MatrixGUI(10, 15);

    Scene scene = new Scene(pane);
    primaryStage.setTitle("E22_19");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
