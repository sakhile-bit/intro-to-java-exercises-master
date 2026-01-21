import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Circle;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.MouseButton;
import java.util.List;
import java.util.ArrayList;

public class ClosestPairPane extends Pane {
  private List<Circle> circles;
  private Line connection;

  public ClosestPairPane() {
    circles = new ArrayList<>();
    drawPane();
  }

  private void drawPane() {
    setPrefSize(500, 500);
    setOnMouseClicked(e -> placePoint(e));
  }

  private void placePoint(MouseEvent event) {
    if (!event.getButton().equals(MouseButton.PRIMARY)) { return; }
    Circle circle = new Circle(5);
    circle.setCenterX(event.getX());
    circle.setCenterY(event.getY());
    circle.setOnMouseClicked(e -> removePoint(e));
    circles.add(circle);
    getChildren().add(circle);
    connectClosestPoints();
  }

  private void removePoint(MouseEvent event) {
    if (!event.getButton().equals(MouseButton.SECONDARY)) { return; }
    Circle circle = (Circle)event.getSource();
    circles.remove(circle);
    getChildren().remove(circle);
    connectClosestPoints();
  }

  private void connectClosestPoints() {
    if (circles.size() >= 2) {
      double[][] closest = getClosestPair(getPointsForCircles());
      double[] p1 = closest[0];
      double[] p2 = closest[1];
      getChildren().remove(connection);
      connection = new Line(p1[0], p1[1], p2[0], p2[1]);
      getChildren().add(connection);
    } else {
      getChildren().remove(connection);
    }
  }

  private double[][] getPointsForCircles() {
    double[][] points = new double[circles.size()][2];
    for (int i = 0; i < circles.size(); i++) {
      Circle c = circles.get(i);
      points[i][0] = c.getCenterX();
      points[i][1] = c.getCenterY();
    }
    return points;
  }

  private double[][] getClosestPair(double[][] s) {
    double[] p1 = s[0];
    double[] p2 = s[1];

    for (int i = 0; i < s.length; i++) {
      for (int j = i + 1; j < s.length; j++) {
        double closest = distance(p1[0], p1[1], p2[0], p2[1]);
        double candidate = distance(s[i][0], s[i][1], s[j][0], s[j][1]);
        if (candidate < closest) {
          p1 = s[i];
          p2 = s[j];
        }
      }
    }

    return new double[][]{p1, p2};
  }

  private double distance(double x1, double y1, double x2, double y2) {
    return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
  }
}
