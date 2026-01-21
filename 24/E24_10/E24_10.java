/*
  Write a program to animate push and pop in a stack.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class E24_10 extends Application {
  @Override
  public void start(Stage primaryStage) {
    StackVisualizer sv = new StackVisualizer();

    Scene scene = new Scene(sv);
    primaryStage.setTitle("E24_10");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
