/*
  Add a method in the BST class to return the number of leaves as follows:

  public int getNumberOfLeaves()
*/

public class E25_06 {
  public static void main(String[] args) {
    String[] list = {"George", "Ben", "Mark", "Carl", "Mack"};
    BST<String> tree = new BST<>(list);

    System.out.println(tree.getNumberOfLeaves());
  }
}
