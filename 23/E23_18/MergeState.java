import java.util.ArrayList;
import java.util.Arrays;

public class MergeState {
  private int current1;
  private int current2;
  private int current3;
  private int[] list1;
  private int[] list2;
  private int[] temp;

  public MergeState(int current1, int current2, int current3,
    int[] list1, int[] list2, int[] temp) {
    this.current1 = current1;
    this.current2 = current2;
    this.current3 = current3;
    this.list1 = list1;
    this.list2 = list2;
    this.temp = temp;
  }

  public int getCurrent1() {
    return current1;
  }

  public int getCurrent2() {
    return current2;
  }

  public int getCurrent3() {
    return current3;
  }

  public int[] getList1() {
    return list1;
  }

  public int[] getList2() {
    return list2;
  }

  public int[] getTemp() {
    return temp;
  }

  public static ArrayList<MergeState> getStates(int[] list1, int[] list2,
    int[] temp) {
    ArrayList<MergeState> states = new ArrayList<>();

    int current1 = 0;
    int current2 = 0;
    int current3 = 0;

    while (current1 < list1.length && current2 < list2.length) {
      if (list1[current1] < list2[current2]) {
        temp[current3++] = list1[current1++];
      } else {
        temp[current3++] = list2[current2++];
      }
      states.add(new MergeState(current1, current2, current3,
        Arrays.copyOf(list1, list1.length), Arrays.copyOf(list2, list2.length),
        Arrays.copyOf(temp, temp.length)));
    }

    while (current1 < list1.length) {
      temp[current3++] = list1[current1++];
      states.add(new MergeState(current1, current2, current3,
        Arrays.copyOf(list1, list1.length), Arrays.copyOf(list2, list2.length),
        Arrays.copyOf(temp, temp.length)));
    }

    while (current2 < list2.length) {
      temp[current3++] = list2[current2++];
      states.add(new MergeState(current1, current2, current3,
        Arrays.copyOf(list1, list1.length), Arrays.copyOf(list2, list2.length),
        Arrays.copyOf(temp, temp.length)));
    }

    return states;
  }
}
