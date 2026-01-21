/*
  Write a program that draws a fixed rectangle centered at (100, 60) with a
  width 100 and height 40. Whenever the mouse is moved, display a message
  indicating whether the mouse point is inside the rectangle or outside of it.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;

public class E15_13 extends Application {
  @Override
  public void start(Stage primaryStage) {
    final double WIDTH = 500.0;
    final double HEIGHT = 200.0;

    Rectangle rect = new Rectangle(50, 30, 100, 40);
    rect.setFill(Color.WHITE);
    rect.setStroke(Color.BLACK);

    Pane pane = new Pane();
    pane.getChildren().add(rect);

    pane.setOnMouseMoved(e -> {
      pane.getChildren().remove(1, pane.getChildren().size());
      double x = e.getX();
      double y = e.getY();
      StringBuilder sb = new StringBuilder();
      if (rect.contains(x, y)) {
        sb.append("Mouse point is inside the rectangle");
      } else {
        sb.append("Mouse point is outside the rectangle");
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
