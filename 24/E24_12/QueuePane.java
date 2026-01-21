import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import java.util.Queue;
import java.util.LinkedList;

public class QueuePane extends Pane {
  Queue<Integer> queue;

  public QueuePane() {
    setUp();
  }

  private void setUp() {
    queue = new LinkedList<>();
    drawPane();
  }

  private void drawPane() {
    getChildren().clear();

    final double WIDTH = 600.0;
    final double HEIGHT = 200.0;
    final double SLOT_WIDTH = 40.0;
    final double SLOT_HEIGHT = 20.0;
    setPrefSize(WIDTH, HEIGHT);

    Text title = new Text(10.0, 20.0, "Queue Visualizer");
    getChildren().add(title);

    double xPos = 10.0;
    double yPos = 100.0;

    Integer[] arr = new Integer[queue.size()];
    queue.toArray(arr);

    for (int i = 0; i < arr.length; i++) {
      Rectangle r = new Rectangle(xPos, yPos, SLOT_WIDTH, SLOT_HEIGHT);
      r.setFill(Color.WHITE);
      r.setStroke(Color.BLACK);
      Text t = new Text(xPos + 5, yPos + 15, arr[i] + "");
      getChildren().addAll(r, t);
      if (i == 0 || i == arr.length - 1) {
        Text heading;
        if (queue.size() == 1) {
          heading = new Text(xPos + 2, yPos - 10, "H/T");
        } else {
          heading = new Text(xPos + 2, yPos - 10, i == 0 ? "HEAD" : "TAIL");
        }
        getChildren().add(heading);
      }
      xPos += SLOT_WIDTH;
    }
  }

  public void enqueue(int value) {
    queue.offer(value);
    drawPane();
  }

  public void dequeue() {
    if (queue.isEmpty()) { return; }
    queue.poll();
    drawPane();
  }
}
