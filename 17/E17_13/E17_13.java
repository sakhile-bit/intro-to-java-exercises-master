/*
  Rewrite Exercise 17.12 with a GUI.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class E17_13 extends Application {
  @Override
  public void start(Stage primaryStage) {
    Combiner c = new Combiner();

    Scene scene = new Scene(c);
    primaryStage.setTitle("E17_13");
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
