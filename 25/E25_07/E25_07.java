/*
  Add a method in the BST class to return the number of nonleaves as follows:

  public int getNumberOfNonLeaves()
*/

public class E25_07 {
  public static void main(String[] args) {
    String[] list = {"George", "Ben", "Adam"};
    BST<String> tree = new BST<>(list);
    System.out.println(tree.getNumberOfNonLeaves());
  }
}
