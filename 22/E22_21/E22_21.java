/*
  The complete solution for the Sudoku problem is given in Supplement VI.C.
  Write a program that lets the user enter the input from the text fields.
  Clicking the Solve button displays the result.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class E22_21 extends Application {
  @Override
  public void start(Stage primaryStage) {
    SudokuGUI sp = new SudokuGUI();

    Scene scene = new Scene(sp);
    primaryStage.setTitle("E22_21");
    primaryStage.setScene(scene);
    primaryStage.setResizable(false);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
