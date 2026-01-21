/*
  Rewrite Programming Exercise 15.28 to add a slider to control the speed of
  the fan.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class E16_18 extends Application {
  @Override
  public void start(Stage primaryStage) {
    FanPane fp = new FanPane(300);

    Scene scene = new Scene(fp);
    primaryStage.setTitle("E16_18");
    primaryStage.setScene(scene);
    primaryStage.setResizable(false);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
