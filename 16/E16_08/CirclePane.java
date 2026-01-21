import javafx.scene.shape.Circle;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class CirclePane extends Pane {
  private Circle c1;
  private Circle c2;
  private double paneSize;

  public CirclePane(double paneSize) {
    this.paneSize = paneSize;
    c1 = new Circle();
    c2 = new Circle();
    drawCircles();

    getChildren().addAll(c1, c2);
  }

  public void drawCircles() {
    c1.setCenterX(paneSize / 8);
    c1.setCenterY(paneSize / 2);
    c1.setRadius(paneSize / 8);
    c2.setCenterX(paneSize / 8 * 5);
    c2.setCenterY(paneSize / 2);
    c2.setRadius(paneSize / 8);
    c1.setFill(Color.TRANSPARENT);
    c1.setStroke(Color.BLACK);
    c2.setFill(Color.TRANSPARENT);
    c2.setStroke(Color.BLACK);
  }

  public Circle getC1() {
    return c1;
  }

  public Circle getC2() {
    return c2;
  }

  public double getPaneSize() {
    return paneSize;
  }

  public boolean doIntersect() {
    return distance(c1, c2) < c1.getRadius() + c2.getRadius();
  }

  private static double distance(Circle c1, Circle c2) {
    double x1 = c1.getCenterX();
    double y1 = c1.getCenterY();
    double x2 = c2.getCenterX();
    double y2 = c2.getCenterY();
    return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
  }

  public static void updateCircle(Circle c, CircleInfoPane info) {
    c.setCenterX(Double.parseDouble(info.getTFX().getText()));
    c.setCenterY(Double.parseDouble(info.getTFY().getText()));
    c.setRadius(Double.parseDouble(info.getTFRadius().getText()));
  }
}
