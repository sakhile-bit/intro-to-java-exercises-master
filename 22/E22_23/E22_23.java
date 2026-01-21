/*
  Write a program to display all possible solutions for the Eight Queens puzzle
  in a scroll pane. For each solution, put a label to denote the solution
  number.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class E22_23 extends Application{
  @Override
  public void start(Stage primaryStage) {
    MultipleBoardPane mbp = new MultipleBoardPane();

    Scene scene = new Scene(mbp);
    primaryStage.setTitle("E22_23");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
