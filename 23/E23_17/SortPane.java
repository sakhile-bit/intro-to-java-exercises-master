import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import java.util.ArrayList;
import java.util.Arrays;

public class SortPane extends Pane {
  private int stateIndex;
  private int[] originalList;
  private ArrayList<RadixState> states;
  
  public SortPane() {
    set();
  }

  private void drawPane(boolean orig) {
    getChildren().clear();

    final double WIDTH = 600.0;
    final double HEIGHT = 300.0;
    setPrefSize(WIDTH, HEIGHT);

    final double SLOT_WIDTH = (WIDTH - 20) / 20.0;
    final double SLOT_HEIGHT = 30.0;

    int[] list = orig ? originalList : states.get(stateIndex).getList();
    int index = orig ? -1 : states.get(stateIndex).getIndex();
    ArrayList<ArrayList<Integer>> buckets = orig || index == -1 ?
      RadixState.generateBuckets() : states.get(stateIndex).getBuckets();

    double xPos = 10.0;
    double yPos = 10.0;
    for (int i = 0; i < list.length; i++) {
      Rectangle r = new Rectangle(xPos, yPos, SLOT_WIDTH, SLOT_HEIGHT);
      r.setFill(Color.WHITE);
      r.setStroke(Color.BLACK);
      Text num = new Text(r.getX() + 2, r.getY() + 20, list[i] + "");
      num.setStroke(i == index && !orig ? Color.RED : Color.BLACK);
      getChildren().addAll(r, num);
      xPos += SLOT_WIDTH;
    }

    final double BUCKET_WIDTH = (WIDTH - 20) / 10.0;
    final double BUCKET_HEIGHT = HEIGHT / 1.5;

    xPos = 10.0;
    for (int i = 0; i < buckets.size(); i++) {
      yPos = 50.0;
      Rectangle r = new Rectangle(xPos, yPos, BUCKET_WIDTH, BUCKET_HEIGHT);
      r.setFill(Color.WHITE);
      r.setStroke(Color.BLACK);
      getChildren().add(r);
      for (int j = 0; j < buckets.get(i).size(); j++) {
        Text num = new Text(r.getX() + 2, yPos + 20, buckets.get(i).get(j) + "");
        getChildren().add(num);
        yPos += 20.0;
      }
      Text bucketNum = new Text(xPos + 20, HEIGHT - 25, "b[" + i + "]");
      getChildren().add(bucketNum);
      xPos += BUCKET_WIDTH;
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
    states =
      RadixState.getStates(Arrays.copyOf(originalList, originalList.length));
    drawPane(true);
  }

  private static int[] getRandomList() {
    int[] list = new int[20];
    for (int i = 0; i < list.length; i++) {
      list[i] = (int)(Math.random() * 1000);
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
