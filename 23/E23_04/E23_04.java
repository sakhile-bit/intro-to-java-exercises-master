/*
  The quick sort algorithm presented in the book selects the first element in
  the list as the pivot. Revise it by selecting the median among the first,
  middle, and last elements in the list.
*/

import java.util.Arrays;

public class E23_04 {
  public static void quickSort(int[] list) {
    quickSort(list, 0, list.length - 1);
  }

  public static void quickSort(int[] list, int first, int last) {
    if (last > first) {
      int pivotIndex = partition(list, first, last);
      quickSort(list, first, pivotIndex - 1);
      quickSort(list, pivotIndex + 1, last);
    }
  }

  public static int partition(int[] list, int first, int last) {
    // Put the first, last, and middle elements in an array
    int[] potentialPivots = {list[first], list[last], list[list.length / 2]};
    // Sort the array
    Arrays.sort(potentialPivots);
    // If the middle element after sorting isn't the first element in list
    if (potentialPivots[1] != list[first]) {
      // find the middle element's index in list
      int pivotIndex;
      if (potentialPivots[1] == list[last]) { pivotIndex = last; }
      else { pivotIndex = list.length / 2; }
      // and swap the first element in list with this element
      int temp = list[first];
      list[first] = potentialPivots[1];
      list[pivotIndex] = temp;
    }
    int pivot = list[first];
    int low = first + 1;
    int high = last;

    while (high > low) {
      while (low <= high && list[low] <= pivot) {
        low++;
      }

      while (low <= high && list[high] > pivot) {
        high--;
      }

      if (high > low) {
        int temp = list[high];
        list[high] = list[low];
        list[low] = temp;
      }
    }

    while (high > first && list[high] >= pivot) {
      high--;
    }

    if (pivot > list[high]) {
      list[first] = list[high];
      list[high] = pivot;
      return high;
    } else {
      return first;
    }
  }

  public static void main(String[] args) {
    int[] list = {0, 50000, 2, 5, -205, 1, -2, 3, 14, 44};
    quickSort(list);
    for (int i = 0; i < list.length; i++) {
      System.out.print(list[i] + " ");
    }
    System.out.println();
  }
}
