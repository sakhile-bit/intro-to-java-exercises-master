/*
  Add the following new methods in BST.

  public void breadthFirstTraversal()
  public int height()
*/

public class E25_01 {
  public static void main(String[] args) {
    BST<String> tree = new BST<>();
    tree.insert("George");
    tree.insert("Michael");
    tree.insert("Tom");
    tree.insert("Adam");
    tree.insert("Jones");
    tree.insert("Peter");
    tree.insert("Daniel");

    tree.breadthFirstTraversal();
    System.out.println(tree.height());
  }
}
