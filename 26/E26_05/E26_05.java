/*
  You can find the kth smallest element in a BST in O(n) time from an inorder
  iterator. For an AVL tree, you can find it in O(log n) time. To achieve this,
  add a new data field named size in AVLTreeNode to store the number of nodes
  in the subtree rooted at this node. Note that the size of a node v is one more
  than the sum of the sizes of its two children.

  In the AVLTree class, add the following method to return the kth smallest
  element in the tree.

  public E find(int k)
*/

import java.util.Scanner;

public class E26_05 {
  public static void main(String[] args) {
    AVLTree<Double> tree = new AVLTree<>();
    Scanner input = new Scanner(System.in);
    System.out.print("Enter 15 numbers: ");
    for (int i = 0; i < 15; i++) {
      tree.insert(input.nextDouble());
    }

    System.out.print("Enter k: ");
    int k = input.nextInt();
    System.out.println("The " + k + "th smallest number is " +
      tree.find(k));
  }
}
