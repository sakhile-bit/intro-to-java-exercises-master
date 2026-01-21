import java.util.ArrayList;
import java.util.Arrays;

public class BubbleState {
  private Integer[] list;
  private int index;

  public BubbleState(Integer[] list, int index) {
    this.list = list;
    this.index = index;
  }

  public static ArrayList<BubbleState> getStates(Integer[] list) {
    ArrayList<BubbleState> states = new ArrayList<>();

    boolean changed;
    do {
      changed = false;
      for (int i = 0; i < list.length - 1; i++) {
        if (list[i + 1] < list[i]) {
          int temp = list[i];
          list[i] = list[i + 1];
          list[i + 1] = temp;
          changed = true;
        }
        states.add(new BubbleState(Arrays.copyOf(list, list.length), i));
      }
    } while (changed);
    return states;
  }

  public Integer[] getList() {
    return list;
  }

  public int getIndex() {
    return index;
  }

  @Override
  public String toString() {
    StringBuilder arr = new StringBuilder("[");
    for (int i = 0; i < list.length; i++) {
      arr.append(list[i] + " ");
    }
    arr.append("]");
    return arr.toString() + " " + index;
  }
}
