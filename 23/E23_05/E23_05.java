/*
  Write the following two generic methods using heap sort. The first method
  sorts the elements using the Comparable interface and the second uses the
  Comparator interface.

  public static <E extends Comparable<E>> void heapSort(E[] list)
  public static <E> void heapSort(E[] list, Comparator<? super E> comparator)
*/

import java.util.Comparator;

public class E23_05 {
  public static void main(String[] args) {
    Integer[] list = {-44, -5, -3, 3, 3, 1, -4, 0, 1, 2, 4, 5, 53};
    heapSort(list, new DescendingComparator<Integer>());
    for (int i = 0; i < list.length; i++) {
      System.out.print(list[i] + " ");
    }
    System.out.println();
  }

  public static <E extends Comparable<E>> void heapSort(E[] list) {
    heapSort(list, new AscendingComparator<E>());
  }

  public static <E> void heapSort(E[] list, Comparator<? super E> comparator) {
    Heap<E> heap = new Heap<>(comparator);

    for (int i = 0; i < list.length; i++) {
      heap.add(list[i]);
    }

    for (int i = list.length - 1; i >= 0; i--) {
      list[i] =  heap.remove();
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

  private static class DescendingComparator<E extends Comparable<E>>
    implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
      if (o1.compareTo(o2) > 0) {
        return -1;
      } else if (o1.compareTo(o2) < 0) {
        return 1;
      }
      return 0;
    }
  }
}
