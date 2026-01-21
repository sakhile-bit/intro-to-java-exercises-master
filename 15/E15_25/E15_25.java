/*
  Write a program that animates a ball moving along a sine curve. When the ball
  gets to the right border, it starts over from the left. Enable the user to
  resume/pause the animation with a click on the left/right mouse button.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.collections.ObservableList;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class E15_25 extends Application {
  @Override
  public void start(Stage primaryStage) {
    final double WINDOW = 400.0;

    Pane graphPane = new Pane();
    drawArrow(0, WINDOW / 5 * 4, WINDOW, WINDOW / 5 * 4, graphPane);
    drawArrow(WINDOW / 2, WINDOW, WINDOW / 2, 0, graphPane);

    Polyline sinLine = new Polyline();
    sinLine.setStroke(Color.RED);
    ObservableList<Double> list = sinLine.getPoints();
    double scaleFactor = 50;
    for (int x = -170; x <= 170; x++) {
      list.add(x + 200.0);
      list.add((WINDOW / 5 * 4) - scaleFactor * Math.sin((x / 100.0) * 2 * Math.PI));
    }

    Circle circle = new Circle(10);

    PathTransition pt = new PathTransition(Duration.millis(5000),
      sinLine, circle);
    pt.setCycleCount(Timeline.INDEFINITE);
    pt.play();

    graphPane.getChildren().addAll(sinLine, circle);

    graphPane.setOnMouseClicked(e -> {
      switch (e.getButton()) {
        case PRIMARY: pt.pause(); break;
        case SECONDARY: pt.play();
      }
    });

    Scene scene = new Scene(graphPane, WINDOW, WINDOW);
    primaryStage.setTitle("E15_25");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void drawArrow(double startX, double startY,
    double endX, double endY, Pane pane) {
    double slope = (startY - endY) / (startX - endX);
    double lineAngle = Math.atan(slope);
    double arrowAngle = endX <= startX ? Math.toRadians(45) : -Math.toRadians(225);

    Line line = new Line(startX, startY, endX, endY);

    double lineLength = Math.sqrt(Math.pow(startX - endX, 2) + Math.pow(startY - endY, 2));
    double arrowLength = lineLength / 12;
    Line arrow1 = new Line();
    arrow1.setStartX(line.getEndX());
    arrow1.setStartY(line.getEndY());
    arrow1.setEndX(line.getEndX() + arrowLength * Math.cos(lineAngle + arrowAngle));
    arrow1.setEndY(line.getEndY() + arrowLength * Math.sin(lineAngle + arrowAngle));
    Line arrow2 = new Line();
    arrow2.setStartX(line.getEndX());
    arrow2.setStartY(line.getEndY());
    arrow2.setEndX(line.getEndX() + arrowLength * Math.cos(lineAngle - arrowAngle));
    arrow2.setEndY(line.getEndY() + arrowLength * Math.sin(lineAngle - arrowAngle));

    pane.getChildren().addAll(line, arrow1, arrow2);
  }

  public static void main(String[] args) {
    Application.launch(args);
  }
}
