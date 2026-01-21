/*
  Implement the following sort method using a heap.

  public static <E extends Comparable<E>> void sort(E[] list)
*/

public class E23_08 {
  public static void main(String[] args) {
    Integer[] list = {1, 50, -2, 2, 67, 104, 3, 0};

    System.out.println("Before heap sort");
    displayList(list);

    System.out.println("After heap sort");
    sort(list);
    displayList(list);
  }

  public static <E extends Comparable<E>> void sort(E[] list) {
    Heap<E> heap = new Heap<>();

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
}
