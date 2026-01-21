/*
  Write a program that enables the user to add/remove points by clicking the
  left/right mouse button, and displays a line that connects the pair of
  nearest points.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class E22_17 extends Application {
  @Override
  public void start(Stage primaryStage) {
    ClosestPairPane pane = new ClosestPairPane();

    Scene scene = new Scene(pane);
    primaryStage.setTitle("E22_17");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
