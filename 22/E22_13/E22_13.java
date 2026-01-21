/*
  Programming Exercise 22.11 finds a convex hull for a set of points entered
  from the console. Write a program that enables the user to add/remove points
  by clicking the left/right mouse button, and displays a convex hull.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class E22_13 extends Application {
  @Override
  public void start(Stage primaryStage) {
    HullPane hp = new HullPane();

    Scene scene = new Scene(hp);
    primaryStage.setTitle("E22_13");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
