/*
  Write a program that allows the user to enter time in seconds in the text
  field and press the Enter key to count down the seconds. The remaining
  seconds are redisplayed every one second. When the seconds are expired, the
  program starts to play music continuously.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class E16_21 extends Application {
  @Override
  public void start(Stage primaryStage){
    CountDown cd = new CountDown();

    Scene scene = new Scene(cd);
    primaryStage.setTitle("E16_21");
    primaryStage.setScene(scene);
    primaryStage.setResizable(false);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
