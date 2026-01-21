/*
  Write a program that animates the AVL tree insert, delete, and search methods.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class E26_03 extends Application {
  @Override
  public void start(Stage primaryStage) {
    AVLVisualizer av = new AVLVisualizer();

    Scene scene = new Scene(av, 800, 400);
    primaryStage.setTitle("E26_03");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
