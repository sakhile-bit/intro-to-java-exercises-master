import java.util.ArrayList;
import java.util.Arrays;

public class SelectionState {
  private Integer[] list;
  private int index;

  public SelectionState(Integer[] list, int index) {
    this.list = list;
    this.index = index;
  }

  public static ArrayList<SelectionState> getStates(Integer[] list) {
    ArrayList<SelectionState> states = new ArrayList<>();

    for (int i = 0; i < list.length; i++) {
      int smallest = list[i];
      int smallestIndex = i;
      for (int j = i + 1; j < list.length; j++) {
        if (list[j] < smallest) {
          smallest = list[j];
          smallestIndex = j;
        }
      }
      if (smallest != list[i]) {
        int temp = list[i];
        list[i] = smallest;
        list[smallestIndex] = temp;
      }
      states.add(new SelectionState(Arrays.copyOf(list, list.length), i));
    }

    return states;
  }

  public Integer[] getList() {
    return list;
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
