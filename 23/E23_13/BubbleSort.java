public class BubbleSort {
  public static void sort(int[] list) {
    boolean changed;
    do {
      changed = false;
      for (int i = 0; i < list.length - 1; i++) {
        if (list[i] > list[i + 1]) {
          int temp = list[i];
          list[i] = list[i + 1];
          list[i + 1] = temp;
          changed = true;
        }
      }
    } while (changed);
  }
}
