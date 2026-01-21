/*
  Write a program that enables the user to add/remove points by clicking the
  left/right mouse button, and displays a non-crossed polygon that links all
  the points. A polygon is crossed if two or more sides intersect.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class E22_15 extends Application {
  @Override
  public void start(Stage primaryStage) {
    NonCrossedPolygonPane ncpp = new NonCrossedPolygonPane();

    Scene scene = new Scene(ncpp);
    primaryStage.setTitle("E22_15");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
