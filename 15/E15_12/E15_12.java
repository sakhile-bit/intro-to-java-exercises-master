/*
  Write a program that draws a fixed circle centered at (100, 60) with radius
  50. Whenever the mouse is moved, display a message indicating whether the
  mouse point is inside the circle at the mouse point or outside of it.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;

public class E15_12 extends Application {
  @Override
  public void start(Stage primaryStage) {
    final double WIDTH = 500.0;
    final double HEIGHT = 200.0;

    Circle circle = new Circle(100, 60, 50);
    circle.setFill(Color.WHITE);
    circle.setStroke(Color.BLACK);

    Pane pane = new Pane();
    pane.getChildren().add(circle);

    pane.setOnMouseMoved(e -> {
      pane.getChildren().remove(1, pane.getChildren().size());
      double x = e.getX();
      double y = e.getY();
      StringBuilder sb = new StringBuilder();
      if (circle.contains(x, y)) {
        sb.append("Mouse point is inside the circle");
      } else {
        sb.append("Mouse point is outside the circle");
      }
      Text text = new Text(x, y, sb.toString());
      pane.getChildren().add(text);
    });

    Scene scene = new Scene(pane, WIDTH, HEIGHT);
    primaryStage.setTitle("E15_12");
    primaryStage.setScene(scene);
    primaryStage.show();

    pane.requestFocus();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
