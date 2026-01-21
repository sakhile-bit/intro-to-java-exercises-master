/*
  Write a test program that randomly generates 500,000 numbers and inserts them
  into a BST, reshuffles the 500,000 numbers and performs a search, and
  reshuffles the numbers again before deleting them from the tree. Write another
  test program that does the same thing for an AVLTree. Compare the execution
  times of these two programs.
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class E26_02 {
  public static void main(String[] args) {
    // Generate numbers and set up BST
    ArrayList<Integer> numbers = getNumbers(500_000);
    BST<Integer> tree1 = new BST<>();

    // Test tree1 (BST)
    long start = System.currentTimeMillis();
    for (Integer num: numbers) {
      tree1.insert(num);
    }

    Collections.shuffle(numbers);
    for (Integer num: numbers) {
      tree1.search(num);
    }

    Collections.shuffle(numbers);
    for (Integer num: numbers) {
      tree1.delete(num);
    }
    long end = System.currentTimeMillis();

    // Report time for BST
    System.out.println("BST: " + (end - start) + "ms");

    // Reshuffle numbers and set up AVL Tree
    Collections.shuffle(numbers);
    AVLTree<Integer> tree2 = new AVLTree<>();

    // Test tree2 (AVL)
    start = System.currentTimeMillis();
    for (Integer num: numbers) {
      tree2.insert(num);
    }

    Collections.shuffle(numbers);
    for (Integer num: numbers) {
      tree2.search(num);
    }

    Collections.shuffle(numbers);
    for (Integer num: numbers) {
      tree2.delete(num);
    }
    end = System.currentTimeMillis();

    // Report time for AVL Tree
    System.out.println("AVL: " + (end - start) + "ms");
  }

  public static ArrayList<Integer> getNumbers(int n) {
    HashSet<Integer> numbers = new HashSet<>();
    while (numbers.size() < n) {
      numbers.add((int)(Math.random() * n * 8));
    }
    return new ArrayList<>(numbers);
  }
}
