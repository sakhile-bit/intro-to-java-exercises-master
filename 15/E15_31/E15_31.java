/*
  Write a program that animates a pendulum swinging. Press the UP arrow key to
  increase the speed and the DOWN key to decrease it. Press the S key to stop
  animation and the R key to resume it.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.paint.Color;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class E15_31 extends Application {
  @Override
  public void start(Stage primaryStage) {
    final double WIDTH = 500.0;
    final double HEIGHT = 500.0;
    final double CENTER_X = WIDTH / 2;
    final double CENTER_Y = HEIGHT / 2;
    Pane pane = new Pane();

    // create the hook and ball
    Circle hook = new Circle(CENTER_X, 40, 5);
    Circle ball = new Circle(20);

    // create the chain connecting them
    Line line = new Line();
    line.startXProperty().bind(hook.centerXProperty());
    line.startYProperty().bind(hook.centerYProperty());
    line.endXProperty().bind(ball.translateXProperty());
    line.endYProperty().bind(ball.translateYProperty());

    // create an invisible arc for the path transition
    Arc arc = new Arc(CENTER_X, HEIGHT / 5 * 3, 200, 100, 200, 140);
    arc.setType(ArcType.OPEN);
    arc.setFill(Color.WHITE);
    arc.setStroke(Color.BLACK);

    // create the path transition
    PathTransition pt = new PathTransition(Duration.millis(3000),
      arc, ball);
    pt.setCycleCount(Timeline.INDEFINITE);
    pt.setAutoReverse(true);
    pt.play();

    pane.getChildren().addAll(line, hook, ball);

    pane.setOnKeyPressed(e -> {
      switch (e.getCode()) {
        case UP:
          pt.setRate(pt.getRate() + 1);
          break;
        case DOWN:
          pt.setRate(pt.getRate() - 1);
          break;
        case S: pt.pause(); break;
        case R: pt.play();
      }
    });

    Scene scene = new Scene(pane, WIDTH, HEIGHT);
    primaryStage.setTitle("E15_31");
    primaryStage.setScene(scene);
    primaryStage.show();

    pane.requestFocus();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
