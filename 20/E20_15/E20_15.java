/*
  Improve Programming Exercise 20.13 to enable the computer to display the
  solution if one exists.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class E20_15 extends Application {
  @Override
  public void start(Stage primaryStage) {
    TwentyFourGUI tf = new TwentyFourGUI();

    Scene scene = new Scene(tf);
    primaryStage.setTitle("E20_15");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
