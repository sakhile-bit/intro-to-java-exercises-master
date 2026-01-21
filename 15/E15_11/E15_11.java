/*
  Write a program that moves a circle up, down, left, or right using the
  arrow keys.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;

public class E15_11 extends Application {
  @Override
  public void start(Stage primaryStage) {
    final double WIDTH = 500.0;
    final double HEIGHT = 500.0;

    Circle circle = new Circle(Math.min(HEIGHT, WIDTH) / 10);
    circle.setCenterX(WIDTH / 2);
    circle.setCenterY(HEIGHT / 2);
    circle.setFill(Color.WHITE);
    circle.setStroke(Color.BLACK);

    circle.setOnKeyPressed(e -> {
      switch (e.getCode()) {
        case UP: circle.setCenterY(circle.getCenterY() - 10); break;
        case DOWN: circle.setCenterY(circle.getCenterY() + 10); break;
        case LEFT: circle.setCenterX(circle.getCenterX() - 10); break;
        case RIGHT: circle.setCenterX(circle.getCenterX() + 10);
      }
    });

    Pane pane = new Pane();
    pane.getChildren().add(circle);

    Scene scene = new Scene(pane, WIDTH, HEIGHT);
    primaryStage.setTitle("E15_11");
    primaryStage.setScene(scene);
    primaryStage.show();

    circle.requestFocus();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
