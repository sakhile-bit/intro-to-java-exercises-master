/*
  Write the following two generic methods using bubble sort. The first method
  sorts the elements using the Comparable interface and the second uses the
  Comparator interface.

  public static <E extends Comparable<E>> void bubbleSort(E[] list)
  public static <E> void bubbleSort(E[] list, Comparator<? super E> comparator)
*/

import java.util.Comparator;

public class E23_01 {
  public static void main(String[] args) {
    Integer[] list = {16, 2, 10, 18, 15, -20, 52, -100, 10001};
    Integer[] copy1 = new Integer[list.length];
    Integer[] copy2 = new Integer[list.length];
    System.arraycopy(list, 0, copy1, 0, list.length);
    System.arraycopy(list, 0, copy2, 0, list.length);

    bubbleSort(copy1);
    System.out.println("bubbleSort (Comparable):");
    displayList(copy1);

    bubbleSort(copy2, new Comparator<Integer>(){
      @Override
      public int compare(Integer o1, Integer o2) {
        if (o1.compareTo(o2) > 0) {
          return -1;
        } else if (o1.compareTo(o2) < 0) {
          return 1;
        }
        return 0;
      }
    });
    System.out.println("bubbleSort (Comparator - descending):");
    displayList(copy2);
  }

  public static <E extends Comparable<E>> void bubbleSort(E[] list) {
    bubbleSort(list, new AscendingComparator<E>());
  }

  public static <E> void bubbleSort(E[] list,
    Comparator<? super E> comparator) {
    boolean changed;
    do {
      changed = false;
      for (int i = 0; i < list.length - 1; i++) {
        if (comparator.compare(list[i + 1], list[i]) < 0) {
          E temp = list[i];
          list[i] = list[i + 1];
          list[i + 1] = temp;
          changed = true;
        }
      }
    } while (changed);
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
      if (o1.compareTo(o2) < 0) {
        return -1;
      } else if (o1.compareTo(o2) > 0) {
        return 1;
      }
      return 0;
    }
  }
}
