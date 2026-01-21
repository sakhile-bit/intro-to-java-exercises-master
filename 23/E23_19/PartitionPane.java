import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import java.util.ArrayList;
import java.util.Arrays;

public class PartitionPane extends Pane {
  private int stateIndex;
  private int[] originalList;
  private ArrayList<PartitionState> states;

  public PartitionPane() {
    set();
  }

  private void drawPane(boolean orig) {
    getChildren().clear();

    final double WIDTH = 600.0;
    final double HEIGHT = 100.0;
    final double SLOT_WIDTH = (WIDTH - 20.0) / 20.0;
    final double SLOT_HEIGHT = 30.0;
    setPrefSize(WIDTH, HEIGHT);

    int[] list = orig ? originalList : states.get(stateIndex).getList();
    int low = orig ? -1 : states.get(stateIndex).getLow();
    int high = orig ? -1 : states.get(stateIndex).getHigh();
    int pivot = orig ? -1 : states.get(stateIndex).getPivot();

    double xPos = 10.0;
    double yPos = 25.0;
    for (int i = 0; i < list.length; i++) {
      Rectangle r = new Rectangle(xPos, yPos, SLOT_WIDTH, SLOT_HEIGHT);
      r.setFill(Color.WHITE);
      r.setStroke(Color.BLACK);
      Text tNum = new Text(r.getX(), r.getY() + 15, list[i] + "");
      getChildren().addAll(r, tNum);
      if (!orig) {
        if (list[i] == pivot) {
          Text tPivot = new Text(r.getX() + 10, r.getY() + 45, "P");
          getChildren().add(tPivot);
        }
        if (i == low) {
          Text tLow = new Text(r.getX() + 10, r.getY() - 5, "L");
          getChildren().add(tLow);
        }
        if (i == high) {
          Text tHigh = new Text(r.getX() + 10, r.getY() - 5, "H");
          getChildren().add(tHigh);
        }
      }
      xPos += SLOT_WIDTH;
    }
  }

  public boolean step() {
    if (stateIndex >= states.size() - 1) { drawPane(false); return true; }
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
    states = PartitionState.getStates(Arrays.copyOf(originalList,
      originalList.length));
    drawPane(true);
  }

  private static int[] getRandomList() {
    int[] list = new int[20];
    for (int i = 0; i < list.length; i++) {
      list[i] = (int)(Math.random() * 999) + 1;
    }
    return list;
  }
}
