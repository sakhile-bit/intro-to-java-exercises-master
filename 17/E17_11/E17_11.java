/*
  Rewrite Exercise 17.10 with a GUI.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class E17_11 extends Application {
  @Override
  public void start(Stage primaryStage) {
    Splitter s = new Splitter();

    Scene scene = new Scene(s);
    primaryStage.setTitle("E17_11");
    primaryStage.setScene(scene);
    primaryStage.setResizable(false);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
