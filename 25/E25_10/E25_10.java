/*
  Add the following method in the BST class that returns an iterator for
  traversing the elements in a BST in preorder.

  Iterator<E> preorderIterator()
*/

import java.util.Iterator;

public class E25_10 {
  public static void main(String[] args) {
    String[] list = {"George", "Ben", "Mark", "Adam", "Carl", "Mack", "Nick"};
    BST<String> tree = new BST<>(list);

    Iterator<String> iter = tree.preorderIterator();
    while (iter.hasNext()) {
      System.out.print(iter.next() + " ");
    }
    System.out.println();
  }
}
