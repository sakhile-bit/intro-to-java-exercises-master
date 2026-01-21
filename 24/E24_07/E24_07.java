/*
  Write a program to animate search, insertion, and deletion in a linked list.
  The Search button searches the specified value in the list. The Delete button
  deletes the specified value from the list. The Insert button appends the
  value to the list if the index is not specified; otherwise, it inserts the
  value at the specified index in the list.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class E24_07 extends Application {
  @Override
  public void start(Stage primaryStage) {
    LinkedListVisualizer lv = new LinkedListVisualizer();

    Scene scene = new Scene(lv);
    primaryStage.setTitle("E24_07");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
