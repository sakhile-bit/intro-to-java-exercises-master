/*
  Write a program that displays a rectangle. You can point the mouse inside the
  rectangle and drag the rectangle wherever the mouse goes. The mouse point
  becomes the center of the rectangle.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

public class E15_18 extends Application {
  @Override
  public void start(Stage primaryStage) {
    final double WIDTH = 500.0;
    final double HEIGHT = 500.0;
    final double R_WIDTH = 100;
    final double R_HEIGHT = 50;

    Rectangle rect = new Rectangle(
      WIDTH / 2 - R_WIDTH / 2, HEIGHT / 2 - R_HEIGHT / 2, R_WIDTH, R_HEIGHT);
    rect.setFill(Color.WHITE);
    rect.setStroke(Color.BLACK);

    rect.setOnMouseDragged(e -> {
      rect.setX(e.getX() - R_WIDTH / 2);
      rect.setY(e.getY() - R_HEIGHT / 2);
    });

    Pane pane = new Pane();
    pane.getChildren().add(rect);

    Scene scene = new Scene(pane, WIDTH, HEIGHT);
    primaryStage.setTitle("E15_18");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
