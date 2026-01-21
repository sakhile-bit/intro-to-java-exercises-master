/*
  Write a program that randomly generates 1,000,000 integers and sorts them
  using radix sort.
*/

import java.util.ArrayList;

public class E23_12 {
  public static void main(String[] args) {
    int n = 1_000_000;
    int[] list = new int[n];
    for (int i = 0; i < n; i++) {
      list[i] = (int)(Math.random() * n);
    }

    radixSort(list);
  }

  public static void radixSort(int[] list) {
    // find the largest integer in the list
    int largest = list[0];
    for (int i = 1; i < list.length; i++) {
      if (list[i] > largest) { largest = list[i]; }
    }

    // find number of significant digits in largest integer
    int digits = 0;
    do {
      largest /= 10;
      digits++;
    } while (largest != 0);

    // perform the sorting
    ArrayList<ArrayList<Integer>> buckets = getBuckets();
    int m = 10; // mod value for isolating digits up to significant digit
    int n = 1;  // divisor for isolating the significant digit itself
    // for each significant digit
    for (int i = 0; i < digits; i++) {
      // sort each integer into the appropriate bucket
      for (int j = 0; j < list.length; j++) {
        buckets.get((list[j] % m) / n).add(list[j]);
      }
      // put each integer back into the list in its new bucket order
      int count = 0;
      for (int k = 0; k < buckets.size(); k++) {
        for (int p = 0; p < buckets.get(k).size(); p++) {
          list[count++] = buckets.get(k).get(p);
        }
      }
      // increase mod and divisor for the next iteration
      m *= 10;
      n *= 10;
      buckets = getBuckets(); // get fresh buckets
    }
  }

  public static ArrayList<ArrayList<Integer>> getBuckets() {
    ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      list.add(new ArrayList<Integer>());
    }
    return list;
  }

  public static void displayList(int[] list) {
    for (int i = 0; i < list.length; i++) {
      System.out.print(list[i] + " ");
    }
    System.out.println();
  }
}
