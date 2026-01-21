import javafx.scene.layout.Pane;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.Line;
import javafx.geometry.Point2D;
import java.util.ArrayList;

public class LatticePane extends Pane {
  private int squares;
  private double scaleFactor;

  LatticePane(int squares, double scaleFactor) {
    this.squares = squares;
    this.scaleFactor = scaleFactor;

    drawGrid();
  }

  public void drawWalk(SelfAvoidingWalk walk) {
    Polyline poly = new Polyline();
    poly.setStrokeWidth(4);
    for (Point2D p: walk.getPath()) {
      double x = p.getX() * scaleFactor;
      double y = p.getY() * scaleFactor;
      poly.getPoints().addAll(x, y);
    }
    getChildren().add(poly);
  }

  // Convenience method for handling a step-by-step animation of a path
  public void nextStep(int step, ArrayList<Point2D> points) {
    resetGrid();
    Polyline poly = new Polyline();
    poly.setStrokeWidth(4);
    for (int i = 0; i <= step; i++) {
      Point2D p = points.get(i);
      double x = p.getX() * scaleFactor;
      double y = p.getY() * scaleFactor;
      poly.getPoints().addAll(x, y);
    }
    getChildren().add(poly);
  }

  public void drawGrid() {
    double width = getSize();
    double height = width;

    // Draw vertical and horizontal grid lines
    for (int i = 0; i <= squares; i++) {
      Line vert = new Line();
      vert.setStartX(i * scaleFactor);
      vert.setStartY(0);
      vert.setEndX(i * scaleFactor);
      vert.setEndY(height);

      Line hori = new Line();
      hori.setStartX(0);
      hori.setStartY(i * scaleFactor);
      hori.setEndX(width);
      hori.setEndY(i * scaleFactor);

      getChildren().addAll(vert, hori);
    }
  }

  public void resetGrid() {
    getChildren().clear();
    drawGrid();
  }

  public double getSize() {
    return squares * scaleFactor;
  }
}
