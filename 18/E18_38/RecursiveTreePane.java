import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.geometry.Point2D;

public class RecursiveTreePane extends Pane {
  private int order;
  private static final double LENGTH = 100.0;
  private static final double STARTING_ANGLE = 90.0;

  public RecursiveTreePane() {
    order = 0;
    setMinSize(400, 400);
    draw();
  }

  private void draw() {
    getChildren().clear();
    // this line is the trunk of the tree, handled outside of the recursive
    // method since it's a special case of only adding one line
    getChildren().add(new Line(200, 400, 200, 400 - LENGTH));
    // call the recursive method with the top point of the trunk
    draw(200, 400 - LENGTH, STARTING_ANGLE, LENGTH * 0.6, order);
  }

  private void draw(
    double x, double y, double angle, double length, double order) {
    if (order == 0) { return; } // do nothing since 0 is handled in draw()
    // the angle by which the passed-in angle will be modified
    double angleModifier = 35;
    double x2 = x + length * Math.cos(Math.toRadians(angle + angleModifier));
    double y2 = y - length * Math.sin(Math.toRadians(angle + angleModifier));
    double x3 = x + length * Math.cos(Math.toRadians(angle - angleModifier));
    double y3 = y - length * Math.sin(Math.toRadians(angle - angleModifier));
    getChildren().add(new Line(x, y, x2, y2));
    getChildren().add(new Line(x, y, x3, y3));

    // call recursively, modifying the passed-in angle, length, and order
    draw(x2, y2, angle + angleModifier, length * 0.6, order - 1);
    draw(x3, y3, angle - angleModifier, length * 0.6, order - 1);
  }

  public void setOrder(int order) {
    this.order = order;
    draw();
  }
}
