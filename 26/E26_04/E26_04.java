/*
  Suppose that the TreeNode class defined in BST contains a reference to the
  node's parent. Implement the AVLTree class to support this change. Write a
  test program that adds numbers 1, 2, ..., 100 to the tree and displays the
  paths for all leaf nodes.
*/

import java.util.ArrayList;

public class E26_04 {
  public static void main(String[] args) {
    AVLTree<Integer> tree = new AVLTree<>();
    for (int i = 1; i <= 100; i++) {
      tree.insert(i);
    }

    for (Integer i: tree) {
      if (tree.isLeaf(i)) {
        System.out.print(i + ": ");
        printPath(tree.getPath(i));
      }
    }
  }

  public static void printPath(ArrayList<Integer> list) {
    for (Integer i: list) {
      System.out.print(i + " ");
    }
    System.out.println();
  }
}
