/*
  Write a program that enables the user to drag the vertices of a triangle
  and displays the angles dynamically as the triangle shape changes.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.MouseButton;
import javafx.event.EventHandler;

public class E15_20 extends Application {
  @Override
  public void start(Stage primaryStage) {
    final double WIDTH = 500.0;
    final double HEIGHT = 500.0;
    final double RADIUS = 10.0;

    Circle a = new Circle(100, 400, RADIUS);
    Circle b = new Circle(200, 200, RADIUS);
    Circle c = new Circle(400, 400, RADIUS);

    Text tA = new Text("A");
    Text tB = new Text("B");
    Text tC = new Text("C");

    Line ab = new Line();
    Line bc = new Line();
    Line ca = new Line();

    EventHandler<MouseEvent> dragCircle = e -> {
      if (e.getButton().equals(MouseButton.PRIMARY)) {
        Circle circle = (Circle)e.getSource();
        circle.setCenterX(e.getX());
        circle.setCenterY(e.getY());
        double angle = getAngle(bc, ca, ab);
        tA.setText(String.format("%.5f", angle));
        angle = getAngle(ca, bc, ab);
        tB.setText(String.format("%.5f", angle));
        angle = getAngle(ab, ca, bc);
        tC.setText(String.format("%.5f", angle));
      }
    };

    a.setOnMouseDragged(dragCircle);
    b.setOnMouseDragged(dragCircle);
    c.setOnMouseDragged(dragCircle);

    ab.startXProperty().bind(a.centerXProperty());
    ab.startYProperty().bind(a.centerYProperty());
    ab.endXProperty().bind(b.centerXProperty());
    ab.endYProperty().bind(b.centerYProperty());
    bc.startXProperty().bind(b.centerXProperty());
    bc.startYProperty().bind(b.centerYProperty());
    bc.endXProperty().bind(c.centerXProperty());
    bc.endYProperty().bind(c.centerYProperty());
    ca.startXProperty().bind(c.centerXProperty());
    ca.startYProperty().bind(c.centerYProperty());
    ca.endXProperty().bind(a.centerXProperty());
    ca.endYProperty().bind(a.centerYProperty());

    tA.xProperty().bind(a.centerXProperty());
    tA.yProperty().bind(a.centerYProperty().subtract(RADIUS));
    tB.xProperty().bind(b.centerXProperty());
    tB.yProperty().bind(b.centerYProperty().subtract(RADIUS));
    tC.xProperty().bind(c.centerXProperty());
    tC.yProperty().bind(c.centerYProperty().subtract(RADIUS));

    Pane pane = new Pane();
    pane.getChildren().addAll(ab, bc, ca, a, b, c, tA, tB, tC);

    Scene scene = new Scene(pane, WIDTH, HEIGHT);
    primaryStage.setTitle("E15_20");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static double getAngle(Line x, Line y, Line z) {
    double a = distance(x);
    double b = distance(y);
    double c = distance(z);
    return Math.toDegrees(Math.acos((a * a - b * b - c * c) / (-2 * b * c)));
  }

  public static double distance(Line line) {
    double x1 = line.getStartX();
    double y1 = line.getStartY();
    double x2 = line.getEndX();
    double y2 = line.getEndY();
    return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
  }

  public static void main(String[] args) {
    launch(args);
  }
}
