/*
  An H-tree is a fractal defined as follows:

  1. Begin with a letter H. The three lines of the H are of the same length.
  2. The letter H (in its sans-serif form, H) has four endpoints. Draw an H
     centered at each of the four endpoints to an H-tree of order 1. These Hs
     are half the size of the H that contains the four endpoints.
  3. Repeat Step 2 to create an H-tree of order 2, 3, ..., and so on.

  Write a program that draws an H-tree.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class E18_35 extends Application {
  @Override
  public void start(Stage primaryStage) {
    HTree hTree = new HTree();

    Scene scene = new Scene(hTree);
    primaryStage.setTitle("E18_35");
    primaryStage.setScene(scene);
    primaryStage.setResizable(false);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
