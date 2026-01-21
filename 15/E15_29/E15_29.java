/*
  Write a program that simulates car racing. The car moves from left to right.
  When it hits the right end, it restarts from the left and continues the same
  process. You can use a timer to control animation. Redraw the car with a new
  base coordinate (x, y). Also let the user pause/resume the animation with a
  button press/release and increase/decrease the car speed by pressing the UP
  and DOWN arrow keys.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.Animation;
import javafx.util.Duration;

public class E15_29 extends Application {
  static int currentXCoord = 0;

  @Override
  public void start(Stage primaryStage) {
    final double WIDTH = 500.0;
    final double HEIGHT = 200.0;

    Pane pane = new Pane();

    KeyFrame keyFrame = new KeyFrame(Duration.millis(10), e -> drawCar(currentXCoord, HEIGHT, pane));
    Timeline timeline = new Timeline(keyFrame);
    timeline.setCycleCount(Timeline.INDEFINITE);
    timeline.play();

    pane.setOnMouseClicked(e -> {
      if (timeline.getStatus().equals(Animation.Status.RUNNING)) {
        timeline.pause();
      } else {
        timeline.play();
      }
    });

    pane.setOnKeyPressed(e -> {
      switch(e.getCode()) {
        case UP: timeline.setRate(timeline.getRate() + 1); break;
        case DOWN: timeline.setRate(timeline.getRate() - 1);
      }
    });

    Scene scene = new Scene(pane, WIDTH, HEIGHT);
    primaryStage.setTitle("E15_29");
    primaryStage.setScene(scene);
    primaryStage.show();

    pane.requestFocus();
  }

  public static void drawCar(double x, double y, Pane pane) {
    pane.getChildren().clear();
    if (currentXCoord > 500) { currentXCoord = 0; }
    Rectangle body = new Rectangle(x, y - 20, 50, 10);
    Circle leftTire = new Circle(x + 15, y - 5, 5);
    Circle rightTire = new Circle(x + 35, y - 5, 5);
    Polygon top = new Polygon(x + 10, y - 20, x + 20, y - 30,
      x + 30, y - 30, x + 40, y - 20);
    pane.getChildren().addAll(body, leftTire, rightTire, top);
    currentXCoord++;
  }

  public static void main(String[] args) {
    launch(args);
  }
}
