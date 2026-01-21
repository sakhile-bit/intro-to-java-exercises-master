/*
  Write a program to animate search, insertion, andn deletion in an array list.
  The Search button searches the specified value in the list. The Delete button
  deletes the specified value from the list. The Insert button appends the value
  into the list if the index is not specified; otherwise, it inserts the value
  into the specified index in the list.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class E24_08 extends Application {
  @Override
  public void start(Stage primaryStage) {
    ArrayListVisualizer av = new ArrayListVisualizer();

    Scene scene = new Scene(av);
    primaryStage.setTitle("E24_08");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
