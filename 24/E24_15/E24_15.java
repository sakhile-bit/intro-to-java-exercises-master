/*
  Design and write a complete test program to test if the MyArrayList class in
  Listing 24.3 meets all requirements.
*/

import java.util.Iterator;

public class E24_15 {
  public static void main(String[] args) {
    // Test no-arg constructor
    MyArrayList<Integer> blankList = new MyArrayList<>();
    System.out.println("no-arg constructor: " + blankList);

    // Test array-arg constructor
    Integer[] numList = {5, 20, 0, -10, 52, 322};
    MyArrayList<Integer> list = new MyArrayList<>(numList);
    System.out.println("array-arg constructor: " + list);

    // Test list functionality
    list.add(0, 10);
    System.out.println("list.add(0, 10): " + list);
    list.add(2, -7);
    System.out.println("list.add(2, -7): " + list);
    // add(index, object) needs a bounds check
    list.add(15, 15);
    System.out.println("list.add(15, 15): " + list);

    list.clear();
    System.out.println("list.clear(): " + list);

    list = new MyArrayList<>(numList);
    System.out.println("recreate list: " + list);
    System.out.println("list.contains(20): " + list.contains(20));
    System.out.println("list.contains(-2): " + list.contains(-2));
    System.out.println("list.get(0): " + list.get(0));
    System.out.println("list.get(3): " + list.get(3));
    System.out.println("list.get(5): " + list.get(5));
    // Throws proper exception on out-of-bounds
    // System.out.println("list.get(6): " + list.get(6));

    System.out.println("indexOf(5): " + list.indexOf(5));
    System.out.println("indexOf(322): " + list.indexOf(322));
    System.out.println("indexOf(69): " + list.indexOf(69));
    list.add(5);
    System.out.println("add(5): " + list);
    System.out.println("lastIndexOf(5): " + list.lastIndexOf(5));
    list.add(5, 0);
    System.out.println("add(5, 0): " + list);
    System.out.println("lastIndexOf(0): " + list.lastIndexOf(0));

    System.out.println("remove(0): " + list.remove(0));
    System.out.println("after remove(0): " + list);
    System.out.println("remove(3): " + list.remove(3));
    System.out.println("after remove(3): " + list);
    System.out.println("remove(5): " + list.remove(5));
    System.out.println("after remove(5): " + list);
    // Throws proper exception on out-of-bounds
    // System.out.println("remove(7): " + list.remove(7));

    System.out.println("set(0, 30): " + list.set(0, 30));
    System.out.println("after set(0, 30): " + list);
    System.out.println("set(3, -2): " + list.set(3, -2));
    System.out.println("after set(3, -2): " + list);
    // Throws proper exception on out-of-bounds
    // System.out.println("set(7, 27): " + list.set(7, 27));

    System.out.println("trimToSize()");
    list.trimToSize();
    System.out.println(list);

    System.out.println("isEmpty(): " + list.isEmpty());
    System.out.println("size(): " + list.size());

    System.out.println("remove(new Integer(30)): " + list.remove(new Integer(30)));
    System.out.println("after remove(new Integer(30)): " + list);

    Iterator<Integer> iter = list.iterator();
    System.out.println("testing iterator()");
    while (iter.hasNext()) {
      System.out.print(iter.next() + " ");
    }
    System.out.println();
  }
}
