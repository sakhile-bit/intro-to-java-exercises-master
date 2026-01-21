/*
  Implement the postorder method in BST using a stack instead of recursion.
  Write a test program that prompts the user to enter 10 integers, stores them
  in a BST, and invokes the postorder method to display the elements.
*/

import java.util.Scanner;

public class E25_05 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter 10 integers: ");
    Integer[] list = new Integer[10];
    for (int i = 0; i < list.length; i++) {
      list[i] = input.nextInt();
    }

    BST<Integer> tree = new BST<>(list);

    tree.postorder();
    System.out.println();
  }
}
