/*
  Write a program that simulates a stopwatch. When the user clicks the Start
  button, the button's label is changed to Pause. When the user clicks the
  Pause button, the button's label is changed to Resume. The Clear button
  resets the count to 0 and reset the button's label to Start.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class E16_20 extends Application {
  @Override
  public void start(Stage primaryStage) {
    StopWatch sw = new StopWatch();

    Scene scene = new Scene(sw);
    primaryStage.setTitle("E16_20");
    primaryStage.setScene(scene);
    primaryStage.setResizable(false);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
