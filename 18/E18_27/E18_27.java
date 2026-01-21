/*
  The text presented the Sierpinski triangle fractal. In this exercise, you will
  write a program to display another fractal, called the Koch snowflake, named
  after a famous Swedish mathematician. A Koch snowflake is created as follows:

  1. Begin with an equilateral triangle, which is considered to be the Koch
     fractal of order (or level) 0.
  2. Divide each line in the shape into three equal line segments and draw an
     outward equilateral triangle with the middle line segment as the base to
     create a Koch fractal of order 1.
  3. Repeat Step 2 to create a Koch fractal of order 2, 3, ..., and so on.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class E18_27 extends Application {
  @Override
  public void start(Stage primaryStage) {
    KochPane kp = new KochPane();

    Scene scene = new Scene(kp);
    primaryStage.setTitle("E18_27");
    primaryStage.setScene(scene);
    primaryStage.setResizable(false);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
