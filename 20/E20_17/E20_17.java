/*
  This exercise is a variation of the 24-point card game described in
  Programming Exercise 20.13. Write a program to check whether there is a
  24-point solution for the four specified numbers. The program lets the user
  enter four values, each between 1 and 13. The user can then click the Solve
  button to display the solution or display "No Solution" if none exist.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class E20_17 extends Application {
  @Override
  public void start(Stage primaryStage) {
    TwentyFourGUI tf = new TwentyFourGUI();

    Scene scene = new Scene(tf);
    primaryStage.setTitle("E20_17");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
