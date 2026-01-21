/*
  Write a program that draws a fixed polygon with points at (40, 20),
  (70, 40), (60, 80), (45, 45), and (20, 60). Whenever the mouse is moved,
  display a message indicating whether the mouse is inside the polygon or
  outside of it.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;

public class E15_14 extends Application {
  @Override
  public void start(Stage primaryStage) {
    final double WIDTH = 500.0;
    final double HEIGHT = 200.0;

    Polygon polygon = new Polygon();
    polygon.setFill(Color.WHITE);
    polygon.setStroke(Color.BLACK);
    polygon.getPoints()
      .addAll(40.0, 20.0, 70.0, 40.0, 60.0, 80.0, 45.0, 45.0, 20.0, 60.0);

    Pane pane = new Pane();
    pane.getChildren().add(polygon);

    pane.setOnMouseMoved(e -> {
      pane.getChildren().remove(1, pane.getChildren().size());
      double x = e.getX();
      double y = e.getY();
      StringBuilder sb = new StringBuilder();
      if (polygon.contains(x, y)) {
        sb.append("Mouse point is inside the polygon");
      } else {
        sb.append("Mouse point is outside the polygon");
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
