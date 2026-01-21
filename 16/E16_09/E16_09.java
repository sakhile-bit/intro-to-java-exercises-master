/*
  Write a program that enables the user to specify the location and size of
  the rectangles and displays whether two rectangles intersect. Enable the user
  to point the mouse inside a rectangle and drag it. As the rectangle is being
  dragged, the rectangle's center coordinates in the text field are updated.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class E16_09 extends Application {
  @Override
  public void start(Stage primaryStage) {
    RectangleAnalysisPane pane = new RectangleAnalysisPane();

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
