/*
  Revise Heap in Listing 23.9, using a generic parameter and a Comparator for
  comparing objects. Define a new constructor with a Comparator as its
  argument as follows:

  Heap(Comparator<? super E> comparator)
*/

import java.util.Comparator;

public class E23_09 {
  public static void main(String[] args) {
    Integer[] list = {15, -20, 0, 42, 8, 10, 102, -3};

    System.out.println("before heapsort");
    displayList(list);

    System.out.println("after heapsort");
    heapSort(list, new AscendingComparator<Integer>());
    displayList(list);
  }

  public static <E extends Comparable<E>> void heapSort(E[] list,
    Comparator<? super E> comparator) {
    Heap<E> heap = new Heap<>(comparator);

    for (int i = 0; i < list.length; i++) {
      heap.add(list[i]);
    }

    for (int i = list.length - 1; i >= 0; i--) {
      list[i] = heap.remove();
    }
  }

  public static <E> void displayList(E[] list) {
    for (int i = 0; i < list.length; i++) {
      System.out.print(list[i] + " ");
    }
    System.out.println();
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
