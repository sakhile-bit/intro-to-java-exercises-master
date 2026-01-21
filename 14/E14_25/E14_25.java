/*
  Modify Programming Exercise 4.6 to create five random points on a circle,
  form a polygon by connecting the points clockwise, and display the circle
  and the polygon.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.paint.Color;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

public class E14_25 extends Application {
  @Override
  public void start(Stage primaryStage){
    final double WINDOW = 300.0;
    final double RADIUS = WINDOW / 2;

    Circle circle = new Circle(RADIUS, RADIUS, RADIUS);
    circle.setFill(Color.WHITE);
    circle.setStroke(Color.BLACK);

    Pane container = new Pane();
    drawPolygonInCircle(circle, 5, container);

    StackPane pane = new StackPane();
    pane.setPadding(new Insets(20));
    pane.getChildren().add(container);

    Scene scene = new Scene(pane);
    primaryStage.setTitle("E14_25");
    primaryStage.setScene(scene);
    primaryStage.setResizable(false);
    primaryStage.show();
  }

  private static void drawPolygonInCircle(Circle circle, int numberOfPoints,
    Pane pane) {

    Point2D[] points = new Point2D[numberOfPoints];
    for (int i = 0; i < points.length; i++) {
      double randomAngle = Math.random() * 360;
      double x = circle.getCenterX() + circle.getRadius() *
        Math.cos(Math.toRadians(randomAngle));
      double y = circle.getCenterY() + circle.getRadius() *
        Math.sin(Math.toRadians(randomAngle));
      points[i] = new Point2D(x, y);
    }

    sortPointsClockwise(points, new Point2D(circle.getCenterX(),
      circle.getCenterY()));

    Polygon polygon = new Polygon();
    polygon.setFill(Color.WHITE);
    polygon.setStroke(Color.BLACK);
    ObservableList<Double> list = polygon.getPoints();
    for (int i = 0; i < points.length; i++) {
      list.add(points[i].getX());
      list.add(points[i].getY());
    }

    pane.getChildren().addAll(circle, polygon);

  }

  private static void sortPointsClockwise(Point2D[] points, Point2D center) {
    boolean changed;
    do {
      changed = false;
      for (int i = 0; i < points.length - 1; i++) {
        if (comparePoint(points[i + 1], points[i], center)) {
          Point2D temp = points[i];
          points[i] = points[i + 1];
          points[i + 1] = temp;
          changed = true;
        }
      }
    } while (changed);
  }

  // http://stackoverflow.com/questions/6989100/sort-points-in-clockwise-order
  private static boolean comparePoint(Point2D a, Point2D b, Point2D center) {

    if (a.getX() - center.getX() >= 0 && b.getX() - center.getX() < 0) {
      return true;
    }
    if (a.getX() - center.getX() < 0 && b.getX() - center.getX() >= 0) {
      return false;
    }
    if (a.getX() - center.getX() == 0 && b.getX() - center.getX() == 0) {
      if (a.getY() - center.getY() >= 0 || b.getY() - center.getY() >= 0) {
        return a.getY() > b.getY();
      }
      return b.getY() > a.getY();
    }

    // compute the cross product of vectors (center -> a) x (center -> b)
    double det = (a.getX() - center.getX()) * (b.getY() - center.getY()) -
      (b.getX() - center.getX()) * (a.getY() - center.getY());
    if (det < 0) {
      return true;
    }
    if (det > 0) {
      return false;
    }

    // points a and b are on the same line from the center
    // check which point is closer to the center
    double d1 = (a.getX() - center.getX()) * (a.getX() - center.getX()) +
      (a.getY() - center.getY()) * (a.getY() - center.getY());
    double d2 = (b.getX() - center.getX()) * (b.getX() - center.getX()) +
      (b.getY() - center.getY()) * (b.getY() - center.getY());
    return d1 > d2;
  }

  public static void main(String[] args) {
    Application.launch(args);
  }
}
