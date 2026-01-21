/*
  Design and write a complete test program to test if the MyLinkedList class
  in Listing 24.6 meets all requirements.
*/

import java.util.Iterator;

public class E24_16 {
  public static void main(String[] args) {
    MyLinkedList<Integer> list = new MyLinkedList<>();
    System.out.println("After invoking no-arg constructor: " + list);

    Integer[] array = {0, -5, 22, 3, 78};
    list = new MyLinkedList<>(array);
    System.out.println("After invoking array-arg constructor: " + list);

    System.out.println("getFirst(): " + list.getFirst());
    System.out.println("getLast(): " + list.getLast());

    list.add(new Integer(10));
    System.out.println("add(new Integer(10)): " + list);
    list.addFirst(13);
    System.out.println("addFirst(13): " + list);
    list.addLast(600);
    System.out.println("addLast(600): " + list);
    list.add(0, -7);
    System.out.println("add(0, -7): " + list);
    list.add(20, 6);
    System.out.println("add(20, 6): " + list);
    list.add(3, -98);
    System.out.println("add(3, -98): " + list);

    System.out.println("removeFirst(): " + list.removeFirst());
    System.out.println("after removeFirst(): " + list);
    System.out.println("removeLast(): " + list.removeLast());
    System.out.println("after removeLast(): " + list);
    System.out.println("remove(new Integer(-98)): " +
      list.remove(new Integer(-98)));
    System.out.println("after remove(new Integer(-98)): " + list);
    System.out.println("remove(4): " + list.remove(4));
    System.out.println("after remove(4): " + list);

    System.out.println("contains(22): " + list.contains(22));
    System.out.println("contains(-15): " + list.contains(-15));

    System.out.println("get(5): " + list.get(5));

    System.out.println("indexOf(13): " + list.indexOf(13));
    System.out.println("indexOf(78): " + list.indexOf(78));
    System.out.println("indexOf(302): " + list.indexOf(302));

    list.add(600);
    System.out.println("after add(600): " + list);
    System.out.println("indexOf(600): " + list.indexOf(600));
    System.out.println("lastIndexOf(600): " + list.lastIndexOf(600));

    System.out.println("set(7, 500): " + list.set(7, 500));
    System.out.println("after set(7, 500): " + list);

    System.out.println("size(): " + list.size());

    System.out.println("isEmpty(): " + list.isEmpty());

    Iterator<Integer> iter = list.iterator();
    System.out.println("test iter:");
    while (iter.hasNext()) {
      System.out.print(iter.next() + " ");
    }
    System.out.println();

    list.clear();
    System.out.println("clear(): " + list);

    System.out.println("isEmpty(): " + list.isEmpty());
  }
}
