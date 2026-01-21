/*
  Write a program that animates the linear search algorithm. Create an array
  that consists of 20 distinct numbers from 1 to 20 in a random order. The array
  elements are displayed in a histogram. You need to enter a search key in the
  text field. Clicking the Step button causes the program to perform one
  comparison in the algorithm and repaints the histogram with a bar indicating
  the search position. This button also freezes the text field to prevent its
  value from being changed. When the algorithm is finished, display the status
  in the label at the top of the border pane to inform the user. Clicking the
  Reset button creates a new random array for a new start. This button also
  makes the text field editable.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class E22_16 extends Application {
  @Override
  public void start(Stage primaryStage) {
    HistogramGUI pane = new HistogramGUI();

    Scene scene = new Scene(pane);
    primaryStage.setTitle("E22_16");
    primaryStage.setScene(scene);
    primaryStage.setResizable(false);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
