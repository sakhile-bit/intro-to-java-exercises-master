public class MergeSort {
  public static void mergeSort(int[] list) {
    mergeSort(list, 0, list.length - 1);
  }

  private static void mergeSort(int[] list, int low, int high) {
    if (high - low > 0) {
      int mid = low + (high - low) / 2;
      mergeSort(list, low, mid);
      mergeSort(list, mid + 1, high);

      merge(list, low, mid, high);
    }
  }

  private static void merge(int[] list, int low, int mid, int high) {
    int current1 = low;
    int current2 = mid + 1;
    int current3 = 0;

    int[] temp = new int[high - low + 1];

    while (current1 <= mid && current2 <= high) {
      if (list[current1] < list[current2]) {
        temp[current3++] = list[current1++];
      } else {
        temp[current3++] = list[current2++];
      }
    }

    while (current1 <= mid) {
      temp[current3++] = list[current1++];
    }

    while (current2 <= high) {
      temp[current3++] = list[current2++];
    }

    for (int i = low, j = 0; i <= high; i++, j++) {
      list[i] = temp[j];
    }
  }
}
