import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.geometry.Point2D;

public class RectanglePane extends Pane {
  private Rectangle r1;
  private Rectangle r2;
  private double paneSize;

  public RectanglePane(double paneSize) {
    this.paneSize = paneSize;
    r1 = new Rectangle();
    r2 = new Rectangle();
    drawRectangles();

    getChildren().addAll(r1, r2);
  }

  public void drawRectangles() {
    r1.setX(paneSize / 8);
    r1.setY(paneSize / 3);
    r1.setWidth(paneSize / 8);
    r1.setHeight(paneSize / 8);
    r2.setX(paneSize / 8 * 5);
    r2.setY(paneSize / 3);
    r2.setWidth(paneSize / 8);
    r2.setHeight(paneSize / 8);
    r1.setFill(Color.TRANSPARENT);
    r1.setStroke(Color.BLACK);
    r2.setFill(Color.TRANSPARENT);
    r2.setStroke(Color.BLACK);
  }

  public Rectangle getR1() {
    return r1;
  }

  public Rectangle getR2() {
    return r2;
  }

  public double getPaneSize() {
    return paneSize;
  }

  public static double getCenterX(Rectangle r) {
    return r.getX() + (r.getWidth() / 2);
  }

  public static double getCenterY(Rectangle r) {
    return r.getY() + (r.getHeight() / 2);
  }

  public boolean doIntersect() {
    Point2D[] r1Points = getCornerPoints(r1);
    Point2D[] r2Points = getCornerPoints(r2);

    for (int i = 0; i < r1Points.length; i++) {
      if (r1.contains(r2Points[i]) || r2.contains(r1Points[i])) {
        return true;
      }
    }

    return false;
  }

  private static Point2D[] getCornerPoints(Rectangle r) {
    Point2D[] points = new Point2D[4];
    points[0] = new Point2D(r.getX(), r.getY());
    points[1] = new Point2D(r.getX() + r.getWidth(), r.getY());
    points[2] = new Point2D(r.getX() + r.getWidth(), r.getY() + r.getHeight());
    points[3] = new Point2D(r.getX(), r.getY() + r.getHeight());
    return points;
  }

  public static void updateRectangle(Rectangle r, RectangleInfoPane info) {
    r.setX(Double.parseDouble(info.getTFX().getText()) - r.getWidth() / 2);
    r.setY(Double.parseDouble(info.getTFY().getText()) - r.getHeight() / 2);
    r.setWidth(Double.parseDouble(info.getTFWidth().getText()));
    r.setHeight(Double.parseDouble(info.getTFHeight().getText()));
  }
}
