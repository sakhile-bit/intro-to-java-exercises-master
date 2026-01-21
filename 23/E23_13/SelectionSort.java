public class SelectionSort {
  public static void sort(int[] list) {
    for (int i = 0; i < list.length; i++) {
      int low = list[i];
      int lowIndex = i;
      for (int j = i + 1; j < list.length; j++) {
        if (list[j] < low) {
          low = list[j];
          lowIndex = j;
        }
      }
      if (list[i] != low) {
        int temp = list[i];
        list[i] = list[lowIndex];
        list[lowIndex] = temp;
      }
    }
  }
}
