/*
  Write a program that animates the partition for a quick sort. The program
  creates a list that consists of 20 random numbers from 1 to 999. The list is
  displayed. Clicking the Step button causes the program to move low to the
  right or high to the left, or swap the elements at low and high. Clicking the
  reset Button creates a new list of random numbers for a new start. When the
  algorithm is finished, clicking the Step button displays a message to inform
  the user.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class E23_19 extends Application {
  @Override
  public void start(Stage primaryStage) {
    PartitionVisualizer pv = new PartitionVisualizer();

    Scene scene = new Scene(pv);
    primaryStage.setTitle("E23_19");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
