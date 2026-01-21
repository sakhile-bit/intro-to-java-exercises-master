/*
  Revise Programming Exercise 18.38 to move the tree to where the mouse is
  dragged.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class E18_39 extends Application {
  @Override
  public void start(Stage primaryStage) {
    RecursiveTree rt = new RecursiveTree();

    Scene scene = new Scene(rt);
    primaryStage.setTitle("E18_38");
    primaryStage.setScene(scene);
    primaryStage.setResizable(false);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
