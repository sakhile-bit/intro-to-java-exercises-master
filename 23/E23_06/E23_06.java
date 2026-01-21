/*
  Write the following overloaded methods that check whether an array is ordered
  in ascending order or descending order. By default, the method checks
  ascending order. To check descending order, pass false to the ascending
  argument in the method.

  public static boolean ordered(int[] list)
  public static boolean ordered(int[] list, boolean ascending)
  public static boolean ordered(double[] list)
  public static boolean ordered(double[] list, boolean ascending)
  public static <E extends Comparable<E>> boolean ordered(E[] list)
  public static <E extends Comparable<E>> boolean ordered(E[] list,
    boolean ascending)
  public static <E> boolean ordered(E[] list, Comparator<? super E> comparator)
  public static <E> boolean ordered(E[] list, Comparator<? super E> comparator,
    boolean ascending)
*/

import java.util.Comparator;

public class E23_06 {
  public static void main(String[] args) {
    double[] list1 = {5, 4, 5, 4, 3, 2, 1};
    int[] list2 = {1, 2, 3, 3, 3, 4, 5};
    System.out.println(ordered(list1, false));
    System.out.println(ordered(list2));
  }

  public static boolean ordered(int[] list) {
    return ordered(list, true);
  }

  public static boolean ordered(int[] list, boolean ascending) {
    Integer[] intList = new Integer[list.length];
    for (int i = 0; i < list.length; i++) {
      intList[i] = list[i];
    }
    return ordered(intList, ascending);
  }

  public static boolean ordered(double[] list) {
    return ordered(list, true);
  }

  public static boolean ordered(double[] list, boolean ascending) {
    Double[] doubList = new Double[list.length];
    for (int i = 0; i < list.length; i++) {
      doubList[i] = list[i];
    }
    return ordered(doubList, ascending);
  }

  public static <E extends Comparable<E>> boolean ordered(E[] list) {
    return ordered(list, true);
  }

  public static <E extends Comparable<E>> boolean ordered(E[] list,
    boolean ascending) {
    Comparator<E> comparator = ascending ?
      new AscendingComparator<E>() : new DescendingComparator<E>();
    return ordered(list, comparator, ascending);
  }

  public static <E> boolean ordered(E[] list,
    Comparator<? super E> comparator) {
    return ordered(list, comparator, true);
  }

  public static <E> boolean ordered(E[] list, Comparator<? super E> comparator,
    boolean ascending) {
    E current = list[0];
    boolean correctOrder = true;
    for (int i = 1; i < list.length; i++) {
      int ord = comparator.compare(list[i], current);
      if (ord >= 0) { current = list[i]; }
      else { return false; }
    }
    return true;
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

    @Override
    public String toString() {
      return "Ascending Comparator";
    }
  }

  private static class DescendingComparator<E extends Comparable<E>>
    implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
      if (o1.compareTo(o2) < 0) {
        return 1;
      } else if (o1.compareTo(o2) > 0) {
        return -1;
      }
      return 0;
    }

    @Override
    public String toString() {
      return "Descending Comparator";
    }
  }
}
