/*
  Redefine TreeNode by adding a reference to a node's parent. Reimplement the
  insert and delete methods in the BST class to update the parent for each
  node in the tree. Add the following new methods in BST:

  private TreeNode<E> getNode(E element)
  private boolean isLeaf(E element)
  public ArrayList<E> getPath(E e)

  Write a test program that prompts the user to enter 10 integers, adds them
  to the tree, deletes the first integer from the tree, and displays the paths
  for all leaf nodes.
*/

import java.util.Scanner;

public class E25_15 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter 10 integers: ");
    Integer[] ints = new Integer[10];
    for (int i = 0; i < ints.length; i++) {
      ints[i] = input.nextInt();
    }

    BST<Integer> tree = new BST<>(ints);

    for (int i = 0; i < ints.length; i++) {
      if (tree.isLeaf(ints[i])) {
        System.out.println(tree.getPath(ints[i]));
      }
    }
  }
}
