/*
  Improve the animation in Exercise 24.8 by showing the insertion and deletion
  operations in slow motion.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class E24_09 extends Application {
  @Override
  public void start(Stage primaryStage) {
    ArrayListVisualizer av = new ArrayListVisualizer();

    Scene scene = new Scene(av);
    primaryStage.setTitle("E24_09");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
