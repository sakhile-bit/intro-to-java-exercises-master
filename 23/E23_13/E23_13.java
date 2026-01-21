/*
  Write a program that obtains the execution time of selection sort, bubble
  sort, merge sort, quick sort, heap sort, and radix sort for input size
  50,000, 100,000, 150,000, 200,000, 250,000, and 300,000. Your program should
  create data randomly and print a table.
*/

import java.util.Arrays;

public class E23_13 {
  public static void main(String[] args) {
    System.out.println("SIZE      |  Selection  Bubble  Merge  Quick  Heap  Radix");
    System.out.println("----------|----------------------------------------------");

    for (int i = 50_000; i <= 300_000; i += 50_000) {
      int[] list = new int[i];
      for (int j = 0; j < list.length; j++) {
        list[j] = (int)(Math.random() * i);
      }

      int[] copy = Arrays.copyOf(list, list.length);

      System.out.printf("%6d    |", i);

      long start = System.currentTimeMillis();
      SelectionSort.sort(copy);
      long end = System.currentTimeMillis();
      System.out.printf("  %9d", end - start);

      copy = Arrays.copyOf(list, list.length);

      start = System.currentTimeMillis();
      BubbleSort.sort(copy);
      end = System.currentTimeMillis();
      System.out.printf("  %6d", end - start);

      copy = Arrays.copyOf(list, list.length);

      start = System.currentTimeMillis();
      MergeSort.mergeSort(copy);
      end = System.currentTimeMillis();
      System.out.printf("  %5d", end - start);

      copy = Arrays.copyOf(list, list.length);

      start = System.currentTimeMillis();
      QuickSort.quickSort(copy);
      end = System.currentTimeMillis();
      System.out.printf("  %5d", end - start);

      Integer[] heapCopy = new Integer[list.length];
      for (int j = 0; j < list.length; j++) {
        heapCopy[j] = list[j];
      }

      start = System.currentTimeMillis();
      HeapSort.heapSort(heapCopy);
      end = System.currentTimeMillis();
      System.out.printf("  %4d", end - start);

      copy = Arrays.copyOf(list, list.length);
      start = System.currentTimeMillis();
      RadixSort.sort(copy);
      end = System.currentTimeMillis();
      System.out.printf("  %5d\n", end - start);
    }
  }

  public static void displayList(int[] list) {
    for (int i = 0; i < list.length; i++) {
      System.out.print(list[i] + " ");
    }
    System.out.println();
  }
}
