import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import java.util.Stack;

public class StackPane extends Pane {
  Stack<Integer> stack;

  public StackPane() {
    setUp();
  }

  private void setUp() {
    stack = new Stack<>();
    drawPane();
  }

  private void drawPane() {
    getChildren().clear();

    final double WIDTH = 300.0;
    final double HEIGHT = 600.0;
    final double SLOT_WIDTH = 40.0;
    final double SLOT_HEIGHT = 20.0;
    setPrefSize(WIDTH, HEIGHT);

    Text title = new Text(10.0, 20.0, "Stack Animation");
    getChildren().add(title);

    double xPos = (WIDTH / 2) - (SLOT_WIDTH / 2);
    double yPos = HEIGHT - SLOT_HEIGHT - 20;
    for (int i = 0; i < stack.size(); i++) {
      Rectangle r = new Rectangle(xPos, yPos, SLOT_WIDTH, SLOT_HEIGHT);
      r.setFill(Color.WHITE);
      r.setStroke(Color.BLACK);
      Text t = new Text(xPos + 5, yPos + 15, stack.get(i) + "");
      getChildren().addAll(r, t);
      if (i == stack.size() - 1) {
        Text topText = new Text(xPos - 30, yPos + 15, "TOP");
        getChildren().add(topText);
      }
      yPos -= SLOT_HEIGHT;
    }
  }

  public void push(int value) {
    stack.push(value);
    drawPane();
  }

  public void pop() {
    if (stack.isEmpty()) { return; }
    stack.pop();
    drawPane();
  }
}
