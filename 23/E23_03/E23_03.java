/*
  Write the following two generic methods using quick sort. The first method
  sorts the elements using the Comparable interface and the second uses the
  Comparator interface.

  public static <E extends Comparable<E>> void quickSort(E[] list)
  public static <E> void quickSort(E[] list, Comparator<? super E> comparator)
*/

import java.util.Comparator;

public class E23_03 {
  public static void main(String[] args) {
    Integer[] list = {0, 50000, 2, 5, -205, 1, -2, 3, 14, 44};
    quickSort(list);
    for (int i = 0; i < list.length; i++) {
      System.out.print(list[i] + " ");
    }
    System.out.println();
  }

  public static <E extends Comparable<E>> void quickSort(E[] list) {
    quickSort(list, new AscendingComparator<E>());
  }

  public static <E> void quickSort(E[] list, Comparator<? super E> comparator) {
    quickSort(list, 0, list.length - 1, comparator);
  }

  public static <E> void quickSort(E[] list, int first, int last,
    Comparator<? super E> comparator) {
    if (last > first) {
      int pivotIndex = partition(list, first, last, comparator);
      quickSort(list, first, pivotIndex - 1, comparator);
      quickSort(list, pivotIndex + 1, last, comparator);
    }
  }

  public static <E> int partition(E[] list, int first, int last,
    Comparator<? super E> comparator) {
    E pivot = list[first];
    int low = first + 1;
    int high = last;

    while (high > low) {
      while (low <= high && comparator.compare(list[low], pivot) <= 0) {
        low++;
      }

      while (low <= high && comparator.compare(list[high], pivot) > 0) {
        high--;
      }

      if (high > low) {
        E temp = list[high];
        list[high] = list[low];
        list[low] = temp;
      }
    }

    while (high > first && comparator.compare(list[high], pivot) >= 0) {
      high--;
    }

    if (comparator.compare(pivot, list[high]) > 0) {
      list[first] = list[high];
      list[high] = pivot;
      return high;
    } else {
      return first;
    }
  }

  private static class AscendingComparator<E extends Comparable<E>>
    implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
      if (o1.compareTo(o2) > 0) {
        return 1;
      } else if (o1.compareTo(o2) < 0) {
        return -1;
      }
      return 0;
    }
  }
}
