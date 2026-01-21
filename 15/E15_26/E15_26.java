/*
  Rewrite Programming Exercise 15.24 so that the ball's opacity is changed as
  it swings.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.animation.PathTransition;
import javafx.animation.FadeTransition;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class E15_26 extends Application {
  @Override
  public void start(Stage primaryStage) {
    final double WIDTH = 500.0;
    final double HEIGHT = 500.0;
    final double RADIUS = 200.0;

    Pane pane = new Pane();

    Arc arc = new Arc(WIDTH / 2, HEIGHT / 2, RADIUS, RADIUS, 225, 90);
    arc.setFill(Color.WHITE);
    arc.setStroke(Color.BLACK);
    arc.setType(ArcType.OPEN);

    Circle circle = new Circle(RADIUS / 20);

    PathTransition pt = new PathTransition(Duration.millis(5000),
      arc, circle);
    pt.setCycleCount(Timeline.INDEFINITE);
    pt.setAutoReverse(true);
    pt.play();

    FadeTransition ft = new FadeTransition(Duration.millis(2500), circle);
    ft.setFromValue(1.0);
    ft.setToValue(0.1);
    ft.setCycleCount(Timeline.INDEFINITE);
    ft.setAutoReverse(true);
    ft.play();

    pane.getChildren().addAll(arc, circle);
    pane.setOnMousePressed(e -> {
      pt.pause();
      ft.pause();
    });
    pane.setOnMouseReleased(e -> {
      pt.play();
      ft.play();
    });

    Scene scene = new Scene(pane, WIDTH, HEIGHT);
    primaryStage.setTitle("E15_26");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
