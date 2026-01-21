/*
  Write a program that animates the bean machine introduced in Programming
  Exercise 7.21. The animation terminates after ten balls are dropped.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.geometry.Insets;

public class E15_33 extends Application {
  @Override
  public void start(Stage primaryStage) {
    GBeanMachine bm = new GBeanMachine(10, 8);

    StackPane pane = new StackPane();
    pane.getChildren().add(bm);
    pane.setMargin(bm, new Insets(20));

    Scene scene = new Scene(pane);
    primaryStage.setTitle("E15_33");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
