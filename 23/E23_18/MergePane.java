import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import java.util.ArrayList;
import java.util.Arrays;

public class MergePane extends Pane {
  private int stateIndex;
  private int[] originalList1;
  private int[] originalList2;
  private int[] emptyTemp;
  private ArrayList<MergeState> states;

  public MergePane() {
    set();
  }

  private void drawPane(boolean orig) {
    getChildren().clear();

    final double WIDTH = 600.0;
    final double HEIGHT = 125.0;
    setPrefSize(WIDTH, HEIGHT);

    int[] list1 = orig ? originalList1 : states.get(stateIndex).getList1();
    int[] list2 = orig ? originalList2 : states.get(stateIndex).getList2();
    int[] temp = orig ? emptyTemp : states.get(stateIndex).getTemp();
    int current1 = orig ? -1 : states.get(stateIndex).getCurrent1();
    int current2 = orig ? -1 : states.get(stateIndex).getCurrent2();
    int current3 = orig ? -1 : states.get(stateIndex).getCurrent3();

    double xPos = drawArray(10.0, 25.0, list1, current1, orig, "list1", "C1");
    drawArray(xPos + 30, 25.0, list2, current2, orig, "list2", "C2");
    drawArray(10.0, 75.0, temp, current3, orig, "temp", "C3");
  }

  private double drawArray(double xPos, double yPos, int[] array,
    int currentIndex, boolean orig, String arrayName, String indexName) {
    Text tArrayName = new Text(xPos, yPos + 15, arrayName);
    getChildren().add(tArrayName);
    xPos += 35.0;
    for (int i = 0; i < array.length; i++) {
      Rectangle r = new Rectangle(xPos, yPos, 25, 20);
      r.setFill(Color.WHITE);
      r.setStroke(Color.BLACK);
      Text tNum = new Text(r.getX(), r.getY() + 15, array[i] + "");
      getChildren().addAll(r, tNum);
      if (!orig && i == currentIndex) {
        Text tCurrentIndex = new Text(r.getX() + 5, r.getY() + 40, indexName);
        getChildren().add(tCurrentIndex);
      }
      xPos += 30.0;
    }
    return xPos; // returns xPos for possible use by following invocations
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
    originalList1 = getRandomList();
    originalList2 = getRandomList();
    emptyTemp = new int[16];
    states =
      MergeState.getStates(
        Arrays.copyOf(originalList1, originalList1.length),
        Arrays.copyOf(originalList2, originalList2.length),
        Arrays.copyOf(emptyTemp, emptyTemp.length)
      );
    drawPane(true);
  }

  private static int[] getRandomList() {
    int[] list = new int[8];
    for (int i = 0; i < list.length; i++) {
      list[i] = (int)(Math.random() * 999) + 1;
    }
    Arrays.sort(list);
    return list;
  }
}
