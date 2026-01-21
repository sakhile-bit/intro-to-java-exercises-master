/*
  Write a program that displays an AVL tree along with its balance factor for
  each node.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class E26_01 extends Application {
  @Override
  public void start(Stage primaryStage) {
    Integer[] list = {78, 2, 5, 18, 24, -67, 32, -1, 0, 5};
    AVLTree<Integer> tree = new AVLTree<>(list);
    AVLPane aPane = new AVLPane(tree);

    Scene scene = new Scene(aPane, 800, 600);
    primaryStage.setTitle("E26_01");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
