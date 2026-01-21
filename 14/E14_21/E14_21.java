/*
  Write a program that draws two filled circles with radius 15 pixels, centered
  at random locations, with a line connecting the two circles. The distance
  between the two centers is displayed on the line.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;

public class E14_21 extends Application {
  @Override
  public void start(Stage primaryStage) {
    final double WIDTH = 500.0;
    final double HEIGHT = 500.0;

    // Create two circles
    Circle c1 = new Circle(getRandom(WIDTH), getRandom(HEIGHT), 15);
    Circle c2 = new Circle(getRandom(WIDTH), getRandom(HEIGHT), 15);

    // Create a line between the centers of the two circles
    Line line = new Line(c1.getCenterX(), c1.getCenterY(),
      c2.getCenterX(), c2.getCenterY());

    // Get the length of the line
    double distance = distance(c1.getCenterX(), c1.getCenterY(),
      c2.getCenterX(), c2.getCenterY());

    // Create a text object to display the length
    double maxX = Math.max(c1.getCenterX(), c2.getCenterX());
    double minX = Math.min(c1.getCenterX(), c2.getCenterX());
    double maxY = Math.max(c1.getCenterY(), c2.getCenterY());
    double minY = Math.min(c1.getCenterY(), c2.getCenterY());
    double x = ((maxX - minX) / 2) + minX;
    double y = ((maxY - minY) / 2) + minY;
    Text tDistance = new Text(x, y, distance + "");

    Pane pane = new Pane();
    pane.getChildren().addAll(c1, c2, line, tDistance);

    Scene scene = new Scene(pane, WIDTH, HEIGHT);
    primaryStage.setTitle("E14_21");
    primaryStage.setScene(scene);
    primaryStage.setResizable(false);
    primaryStage.show();
  }

  public static double getRandom(double n) {
    return Math.random() * n;
  }

  public static double distance(double x1, double y1, double x2, double y2) {
    return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(x2 - y2, 2));
  }

  public static void main(String[] args) {
    Application.launch(args);
  }
}
