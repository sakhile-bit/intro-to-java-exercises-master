/*
  Write a GUI program for Programming Exercise 8.19. Let the user enter the
  numbers in the text fields in a grid of 6 rows and 7 columns. The user can
  click the Solve button to highlight a sequence of four equal numbers, if it
  exists. Initially, the values in the text fields are filled with numbers from
  0 to 9 randomly.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class E16_30 extends Application {
  @Override
  public void start(Stage primaryStage) {
    Consecutives c = new Consecutives();

    Scene scene = new Scene(c);
    primaryStage.setTitle("E16_30");
    primaryStage.setScene(scene);
    primaryStage.setResizable(false);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
