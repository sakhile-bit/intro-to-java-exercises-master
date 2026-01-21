/*
  Write a program that animates the radix sort algorithm. Create an array that
  consists of 20 random numbers from 0 to 1,000. The array elements are
  displayed. Clicking the Step button causes the program to place a number in
  a bucket. The number that has just been placed is displayed in red. Once all
  the numbers are placed in the buckets, clicking the Step button collects
  all the numbers from the buckets and moves them back to the array. When the
  algorithm is finished, clicking the Step button displays a message to inform
  the user. Clicking the Reset button creates a new random array for a new
  start.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class E23_17 extends Application {
  @Override
  public void start(Stage primaryStage) {
    SortVisualizer sv = new SortVisualizer();

    Scene scene = new Scene(sv);
    primaryStage.setTitle("E23_17");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
