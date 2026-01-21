/*
  Write a program to animate search, insertion, and deletion in a doubly linked
  list. The Search button searches the specified value in the list. The Delete
  button deletes the specified value from the list. The Insert button appends
  the value into the list if the index is not specified; otherwise, it inserts
  the value into the specified index in the list. Also add two buttons named
  Forward Traversal and Backward Traversal for displaying the elements in a
  forward and backward order, respectively, using iterators.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class E24_11 extends Application {
  @Override
  public void start(Stage primaryStage) {
    DoublyLinkedListVisualizer dv = new DoublyLinkedListVisualizer();

    Scene scene = new Scene(dv);
    primaryStage.setTitle("E24_11");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
