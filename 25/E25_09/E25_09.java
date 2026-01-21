/*
  Implement the clone and equals methods in the BST class. Two BST trees are
  equal if they contain the same elements. The clone method returns an identical
  copy of a BST.
*/

import java.util.ArrayList;

public class E25_09 {
  public static void main(String[] args) {
    Integer[] list = {10, 2, 15, 1, 4, 13, 17, 5, 18, 20};
    BST<Integer> tree = new BST<>(list);
    BST<Integer> copy = (BST<Integer>)tree.clone();

    ArrayList<Integer> treeList = tree.inorderList();
    ArrayList<Integer> copyList = copy.inorderList();

    System.out.println("tree inorder: " + treeList);
    System.out.println("copy inorder: " + copyList);

    System.out.println("tree.equals(copy): " + tree.equals(copy));
    System.out.println("tree == copy: " + (tree == copy));
  }
}
