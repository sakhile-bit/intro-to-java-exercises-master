/*
  The java.util.Iterator interface defines a forward iterator. The Java API
  also provides the java.util.ListIterator interface that defines a
  bidirectional iterator. Study ListIterator and define a bidirectional
  iterator for the BST class.
*/

import java.util.ListIterator;

public class E25_08 {
  public static void main(String[] args) {
    String[] list = {"George", "Ben", "Mark", "Adam", "Carl", "Mack", "Nick"};
    BST<String> tree = new BST<>(list);

    ListIterator<String> iter = tree.listIterator();
    for (int i = 0; i < 6; i++) {
      System.out.print(iter.next() + " ");
    }
    System.out.println();

    while (iter.hasPrevious()) {
      System.out.print(iter.previous() + " ");
    }
    System.out.println();
  }
}
