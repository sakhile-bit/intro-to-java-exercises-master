/*
  Design and write a complete test program to test if the BST class in
  Listing 25.5 meets all requirements.
*/

import java.util.ArrayList;
import java.util.Iterator;

public class E25_12 {
  public static void main(String[] args) {
    BST<String> tree1 = new BST<>();
    System.out.println("no-arg constructor:");
    tree1.inorder();
    System.out.println();

    String[] list = {"George", "Ben", "Mark", "Adam", "Carl", "Mack", "Nick"};
    BST<String> tree2 = new BST<>(list);
    System.out.println("array-arg constructor:");
    tree2.inorder();
    System.out.println();

    System.out.println("search(\"Mack\"): " + tree2.search("Mack"));
    System.out.println("search(\"Jason\"): " + tree2.search("Jason"));

    tree2.insert("Bruce");
    System.out.println("insert(\"Bruce\"):");
    tree2.inorder();
    System.out.println();

    tree2.postorder();
    System.out.println();
    tree2.preorder();
    System.out.println();

    System.out.println("getSize(): " + tree2.getSize());

    BST.TreeNode<String> root = tree2.getRoot();
    System.out.println(root.element);

    ArrayList<BST.TreeNode<String>> path = tree2.path("Nick");

    for (BST.TreeNode<String> node: path) {
      System.out.print(node.element + " ");
    }
    System.out.println();

    System.out.println("delete(\"Bruce\"): " + tree2.delete("Bruce"));
    tree2.inorder();
    System.out.println();

    System.out.println("delete(\"Joseph\"): " + tree2.delete("Joseph"));
    tree2.inorder();
    System.out.println();

    Iterator<String> iter = tree2.iterator();
    while (iter.hasNext()) {
      System.out.print(iter.next() + " ");
    }
    System.out.println();

    System.out.println("isEmpty(): " + tree2.isEmpty());

    tree2.clear();
    tree2.inorder();
    System.out.println("isEmpty(): " + tree2.isEmpty());
  }
}
