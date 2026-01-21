/*
  Write a program that animates the selection sort algorithm. Create an array
  that consists of 20 distinct numbers from 1 to 20 in a random order. The
  array elements are displayed in a histogram. Clicking the Step button causes
  the program to perform an iteration of the outer loop in the algorithm and
  repaints the histogram for the new array. Color the last bar in the sorted
  subarray. When the algorithm is finished, display a message to inform the
  user. Clicking the Reset button creates a new random array for a new start.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class E23_15 extends Application {
  @Override
  public void start(Stage primaryStage) {
    SortVisualizer sv = new SortVisualizer();

    Scene scene = new Scene(sv);
    primaryStage.setTitle("E23_15");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
