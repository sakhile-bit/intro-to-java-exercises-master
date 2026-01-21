/*
  Define the following methods in MyList and implement them in MyAbstractList:

  public boolean addAll(MyList<E> otherList);
  public boolean removeAll(MyList<E> otherList);
  public boolean retainAll(MyList<E> otherList);

  Write a test program that creates two MyArrayLists, list1 and list2, with
  the initial values {"Tom", "George", "Peter", "Jean", "Jane"} and
  {"Tom", "George", "Michael", "Michelle", "Daniel"}, then perform the following
  operations:

  - Invokes list1.addAll(list2), and displays list1 and list2.
  - Recreates list1 and list2 with the same initial values, invokes
    list1.removeAll(list2), and displays list1 and list2;
  - Recreates list1 and list2 with the same initial values, invokes
    list1.retainAll(list2), and displays list1 and list2.
*/

public class E24_01 {
  public static void main(String[] args) {
    String[] permList1 = {"Tom", "George", "Peter", "Jean", "Jane"};
    String[] permList2 = {"Tom", "George", "Michael", "Michelle", "Daniel"};

    MyList<String> list1 = new MyArrayList<>(permList1);
    MyList<String> list2 = new MyArrayList<>(permList2);

    list1.addAll(list2);
    System.out.println(list1);
    System.out.println(list2);

    list1 = new MyArrayList<>(permList1);

    list1.removeAll(list2);
    System.out.println(list1);
    System.out.println(list2);

    list1 = new MyArrayList<>(permList1);

    list1.retainAll(list2);
    System.out.println(list1);
    System.out.println(list2);
  }
}
