/*
  The heap presented in the text is also known as a max-heap, in which each
  node is greater than or equal to any of its children. A min-heap is a heap
  in which each node is less than or equal to any of its children. Min-heaps
  are often used to implement priority queues. Revise the Heap class in
  Listing 23.9 to implement a min-heap.
*/

public class E23_07 {
  public static void main(String[] args) {
    Integer[] list = {0, 50, -22, 1, 45, 72, 3, 4, 10};

    System.out.println("Before min-heap sort");
    displayList(list);

    System.out.println("After min-heap sort");
    heapSort(list);
    displayList(list);
  }

  public static <E extends Comparable<E>> void heapSort(E[] list) {
    Heap<E> heap = new Heap<>();

    for (int i = 0; i < list.length; i++) {
      heap.add(list[i]);
    }

    for (int i = 0; i < list.length; i++) {
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
