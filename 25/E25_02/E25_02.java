/*
  A full binary tree is a binary tree with the leaves on the same level. Add
  a method in the BST class to return true if the tree is a full binary tree.
*/

public class E25_02 {
  public static void main(String[] args) {
    BST<String> full = new BST<>();
    full.insert("George");
    full.insert("Ben");
    full.insert("Adam");
    full.insert("Carl");
    full.insert("Mark");
    full.insert("Mack");
    full.insert("Nick");

    System.out.println(full.isFullBST());

    BST<String> notFull = new BST<>();
    notFull.insert("George");
    notFull.insert("Michael");
    notFull.insert("Tom");
    notFull.insert("Adam");
    notFull.insert("Jones");
    notFull.insert("Peter");
    notFull.insert("Daniel");

    System.out.println(notFull.isFullBST());
  }
}
