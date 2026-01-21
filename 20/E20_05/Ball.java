import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;

public class Ball extends Circle {
  private int dx;
  private int dy;

  public Ball(double x, double y, double radius, Color color) {
    super(x, y, radius);
    setFill(color);
    dx = 1;
    dy = 1;
  }

  public void setDX(int dx) {
    this.dx = dx;
  }

  public void setDY(int dy) {
    this.dy = dy;
  }

  public int getDX() {
    return dx;
  }

  public int getDY() {
    return dy;
  }
}
