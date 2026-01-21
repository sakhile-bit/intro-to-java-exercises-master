/*
  The MyLinkedList class used in Listing 24.6 is a one-way directional linked
  list that enables one-way traversal of the list. Modify the Node class to
  add the new data field name previous to refer to the previous node in the
  list. Implement a new class named TwoWayLinkedList that uses a doubly linked
  list to store elements. The MyLinkedList class in the text extends
  MyAbstractList. Define TwoWayLinkedList to extends the
  java.util.AbstractSequentialList class. You need to implement all the methods
  defined in MyLinkedList as well as the methods listIterator() and
  listIterator(int index). Both return an instance of java.util.ListIterator<E>.
  The former sets the cursor to the head of the list and the latter to the
  element at the specified index.
*/

import java.util.Iterator;
import java.util.ListIterator;

public class E24_03 {
  public static void main(String[] args) {
    Integer[] list = {0, -2, -15, 43};
    TwoWayLinkedList<Integer> linkedList = new TwoWayLinkedList<>(list);

    System.out.println(linkedList);
    System.out.println(linkedList.getFirst());
    System.out.println(linkedList.getLast());

    linkedList.addFirst(50);
    System.out.println(linkedList);

    linkedList.addLast(102);
    System.out.println(linkedList);

    linkedList.add(0, 2);
    System.out.println(linkedList);
    linkedList.add(7, -10);
    System.out.println(linkedList);
    linkedList.add(20, -45);
    System.out.println(linkedList);

    System.out.println(linkedList.removeFirst());
    System.out.println(linkedList);

    System.out.println(linkedList.removeLast());
    System.out.println(linkedList);

    System.out.println(linkedList.remove(3));
    System.out.println(linkedList);

    System.out.println(linkedList.contains(20));
    System.out.println(linkedList.contains(-10));

    System.out.println(linkedList.size());

    System.out.println(linkedList.get(0));
    System.out.println(linkedList.get(5));
    System.out.println(linkedList.get(3));

    linkedList.addFirst(102);
    System.out.println(linkedList);

    System.out.println(linkedList.indexOf(102));
    System.out.println(linkedList.lastIndexOf(102));
    System.out.println(linkedList.indexOf(10));

    linkedList.set(2, 69);
    System.out.println(linkedList);

    Iterator<Integer> iter = linkedList.iterator();
    while (iter.hasNext()) {
      System.out.print(iter.next() + " ");
    }
    System.out.println();

    ListIterator<Integer> listIter = linkedList.listIterator();
    System.out.println(listIter.nextIndex());
    int count = 0;
    while (listIter.hasNext() && count < 4) {
      System.out.print(listIter.nextIndex() + ": " + listIter.next() + " ");
      count++;
    }
    System.out.println();

    while (listIter.hasPrevious()) {
      System.out.print(listIter.previousIndex() + ": " +
        listIter.previous() + " ");
    }
    System.out.println();

    System.out.println(listIter.nextIndex());
    System.out.println(listIter.previousIndex());

    linkedList.clear();
    System.out.println(linkedList);
  }
}
