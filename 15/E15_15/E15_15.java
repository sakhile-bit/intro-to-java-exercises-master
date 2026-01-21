/*
  Write a program that lets the user click on a pane to dynamically create and
  remove points. When the user left-clicks the mouse, a point is created and
  displayed at the mouse point. The user can remove a point by pointing to it
  and right-clicking the mouse.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;

public class E15_15 extends Application {
  @Override
  public void start(Stage primaryStage) {
    final double WIDTH = 500.0;
    final double HEIGHT = 500.0;
    final double RADIUS = Math.min(WIDTH, HEIGHT) / 30;

    Pane pane = new Pane();

    pane.setOnMouseClicked(e -> {
      switch (e.getButton()) {
        case PRIMARY:
          Circle circle = new Circle(e.getX(), e.getY(), RADIUS);
          circle.setFill(Color.WHITE);
          circle.setStroke(Color.BLACK);
          circle.setOnMouseClicked(f -> {
            pane.getChildren().remove(f.getSource());
          });
          pane.getChildren().add(circle);
          break;
      }
    });

    Scene scene = new Scene(pane, WIDTH, HEIGHT);
    primaryStage.setTitle("E15_15");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
