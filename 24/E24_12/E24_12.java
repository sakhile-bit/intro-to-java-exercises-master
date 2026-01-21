/*
  Write a program to animate the enqueue and dequeue operations on a queue.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class E24_12 extends Application {
  @Override
  public void start(Stage primaryStage) {
    QueueVisualizer qv = new QueueVisualizer();

    Scene scene = new Scene(qv);
    primaryStage.setTitle("E24_12");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String args) {
    launch(args);
  }
}
