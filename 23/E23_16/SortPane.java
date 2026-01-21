import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import java.util.ArrayList;
import java.util.Arrays;

public class SortPane extends Pane {
  private int stateIndex;
  private Integer[] originalList;
  private ArrayList<BubbleState> states;

  public SortPane() {
    set();
  }

  private void drawPane(boolean orig) {
    getChildren().clear();

    final double WIDTH = 600.0;
    final double HEIGHT = 300.0;
    setPrefSize(WIDTH, HEIGHT);

    final double MAX_BAR_HEIGHT = HEIGHT - 25.0;
    final double BAR_WIDTH = (WIDTH - 20) / 20;

    Integer[] list = orig ? originalList : states.get(stateIndex).getList();
    int index = orig ? -1 : states.get(stateIndex).getIndex();

    double xPos = 10.0;
    for (int i = 0; i < list.length; i++) {
      Rectangle r = new Rectangle(BAR_WIDTH, (list[i] / 20.0) * MAX_BAR_HEIGHT);
      r.setX(xPos);
      r.setY(HEIGHT - r.getHeight());
      r.setFill(i == index && !orig ? Color.GRAY : Color.WHITE);
      r.setStroke(Color.BLACK);
      Text t = new Text(xPos + 10, r.getY() - 10, list[i] + "");
      getChildren().addAll(r, t);
      xPos += BAR_WIDTH;
    }
  }

  public boolean step() {
    if (stateIndex >= states.size()) { return true; }
    drawPane(false);
    stateIndex++;
    return false;
  }

  public void reset() {
    set();
  }

  private void set() {
    stateIndex = 0;
    originalList = getRandomList();
    states =
      BubbleState.getStates(Arrays.copyOf(originalList, originalList.length));
    drawPane(true);
  }

  private static Integer[] getRandomList() {
    Integer[] list = new Integer[20];
    for (int i = 1; i <= list.length; i++) {
      list[i - 1] = i;
    }
    for (int i = 0; i < list.length; i++) {
      int randomIndex = (int)(Math.random() * list.length);
      if (i != randomIndex) {
        int temp = list[i];
        list[i] = list[randomIndex];
        list[randomIndex] = temp;
      }
    }
    return list;
  }
}
