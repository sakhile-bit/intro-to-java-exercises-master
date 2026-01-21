/*
  Write a program that enables the user to specify the location and size of
  the circles and displays whether two circles intersect. Enable the user to
  point the mouse inside the circle and drag it. As the circle is dragged, the
  circle's center coordinates in the text field are updated.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class E16_08 extends Application {
  @Override
  public void start(Stage primaryStage) {
    CircleAnalysisPane pane = new CircleAnalysisPane();

    Scene scene = new Scene(pane);
    primaryStage.setTitle("E16_08");
    primaryStage.setScene(scene);
    primaryStage.setResizable(false);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
