import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class RectInfo {
  private Rectangle rect;
  private Text text;
  private Line line;

  public RectInfo(Rectangle rect, Text text, Line line) {
    this.rect = rect;
    this.text = text;
    this.line = line;
  }

  public Rectangle getRect() {
    return rect;
  }

  public Text getText() {
    return text;
  }

  public Line getLine() {
    return line;
  }

  public void setRect(Rectangle rect) {
    this.rect = rect;
  }

  public void setText(Text text) {
    this.text = text;
  }

  public void setLine(Line line) {
    this.line = line;
  }
}
