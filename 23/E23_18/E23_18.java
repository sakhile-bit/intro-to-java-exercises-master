/*
  Write a program that animates the merge of two sorted lists. Create two
  arrays, list1 and list2, each of which consists of 8 random numbers from 1 to
  999. The array elements are displayed. Clicking the Step button causes the
  program to move an element from list1 or list2 to temp. Clicking the Reset
  button creates two new random arrays for a new start. When the algorithm is
  finished, clicking the Step button displays a message to inform the user.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class E23_18 extends Application {
  @Override
  public void start(Stage primaryStage) {
    MergeVisualizer mv = new MergeVisualizer();

    Scene scene = new Scene(mv);
    primaryStage.setTitle("E23_18");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
