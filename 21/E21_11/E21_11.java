/*
  Use the data files from Programming Exercise 12.31 to write a program that
  enables the user to select a year, gender, and enter a name to display the
  ranking of the name for the selected year and gender. To achieve the best
  efficiency, create two arrays for boy's names and girl's names,
  respectively. Each array has 10 elements for 10 years. Each element is a map
  that stores a name and its ranking in a pair with the name as the key.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import java.io.IOException;

public class E21_11 extends Application {
  @Override
  public void start(Stage primaryStage) throws IOException {
    NameRankingGUI nrg = new NameRankingGUI();

    Scene scene = new Scene(nrg);
    primaryStage.setTitle("E21_11");
    primaryStage.setScene(scene);
    primaryStage.setResizable(false);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
