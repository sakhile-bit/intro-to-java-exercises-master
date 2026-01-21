/*
  Write a program that displays a moving text. The text moves from left to
  right circularly. When it disappears in the right, it reappears from the left.
  The text freezes when the mouse is pressed and moves again when the button
  is released.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class E15_27 extends Application {
  @Override
  public void start(Stage primaryStage) {
    final double WIDTH = 400.0;
    final double HEIGHT = 100.0;

    Text text = new Text("Programming is fun");

    PathTransition pt = new PathTransition(Duration.millis(3000),
      new Line(-100, HEIGHT / 2, 500, HEIGHT / 2), text);
    pt.setCycleCount(Timeline.INDEFINITE);
    pt.play();

    Pane pane = new Pane();
    pane.getChildren().add(text);
    pane.setOnMousePressed(e -> pt.pause());
    pane.setOnMouseReleased(e -> pt.play());

    Scene scene = new Scene(pane, WIDTH, HEIGHT);
    primaryStage.setTitle("E15_27");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
