/*
  The implementations of the methods contains(E e), get(int index),
  indexOf(E e), lastIndexOf(E e), and set(int index, E e) are omitted in the
  text. Implement these methods.
*/

public class E24_02 {
  public static void main(String[] args) {
    String[] permList = {"Joe", "Jim", "June", "Jordan", "Jamaica", "Jill"};
    MyList<String> list = new MyLinkedList<>(permList);

    System.out.println("contains(\"Joe\"): " + list.contains("Joe"));
    System.out.println("contains(\"Jeff\"): " + list.contains("Jeff"));
    System.out.println("get(\"0\"): " + list.get(0));
    System.out.println("get(\"5\"): " + list.get(5));
    //System.out.println("get(\"7\"): " + list.get(7));
    System.out.println("indexOf(\"June\"): " + list.indexOf("June"));
    System.out.println("indexOf(\"Jeff\"): " + list.indexOf("Jeff"));
    System.out.println("indexOf(\"Jill\"): " + list.indexOf("Jill"));
    System.out.println("indexOf(\"Joe\"): " + list.indexOf("Joe"));
    System.out.println("lastIndexOf(\"Joe\"): " + list.lastIndexOf("Joe"));
    System.out.println("Add another Joe");
    list.add("Joe");
    System.out.println("lastIndexOf(\"Joe\"): " + list.lastIndexOf("Joe"));
    System.out.println("set(6, \"Jennifer\"): " + list.set(6, "Jennifer"));
    System.out.println("set(1, \"Josh\"): " + list.set(1, "Josh"));
    //System.out.println("set(7, \"Jamal\"): " + list.set(7, "Jamal"));
  }
}
