/*
  The Eight Queens problem is to find a solution to place a queen in each row
  on a chessboard such that no two queens can attack each other. Write a program
  to solve the Eight Queens problem using recursion and display the result
  graphically.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class E18_34 extends Application {
  @Override
  public void start(Stage primaryStage) {
    EightQueensGUI eqg = new EightQueensGUI();

    Scene scene = new Scene(eqg);
    primaryStage.setTitle("E18_34");
    primaryStage.setScene(scene);
    primaryStage.setResizable(false);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
