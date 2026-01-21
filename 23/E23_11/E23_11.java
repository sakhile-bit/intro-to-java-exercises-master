/*
  Implement the clone and equals methods in the Heap class.
*/

public class E23_11 {
  public static void main(String[] args) throws CloneNotSupportedException {
    Integer[] list1 = {5, 10, 2, -1, 0, 15};
    Integer[] list2 = {42, 31, 5, 0};

    Heap<Integer> heap1 = new Heap<>();
    Heap<Integer> heap2 = new Heap<>();
    for (int i = 0; i < list1.length; i++) {
      heap1.add(list1[i]);
      heap2.add(list1[i]);
    }

    System.out.println("heap1 and heap2 equal? " + heap1.equals(heap2));

    for (int i = 0; i < list2.length; i++) {
      heap2.add(list2[i]);
    }

    System.out.println("heap1 and heap2 equal? " + heap1.equals(heap2));

    Heap<Integer> heap3 = (Heap<Integer>)heap1.clone();

    System.out.println("heap1 and heap3 equal? " + heap1.equals(heap3));
  }
}
