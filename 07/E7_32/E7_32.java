/*
  Write the following method that partitions the list using the first element,
  called a pivot.

  public static int partition(int[] list)

  After the partition, the elements in the list are rearranged so that all the
  elements before the pivot are less than or equal to the pivot and the elements
  after the pivot are greater than the pivot. The method returns the index where
  the pivot is located in the new list. For example, suppose the list is
  {5, 2, 9, 3, 6, 8}. After the partition, the list becomes {3, 2, 5, 9, 6, 8}.
  Implement the method in a way that takes at most list.length comparisons.
  Write a test program that prompts the user to enter a list and displays
  the list after the partition. Note that the first number in the input
  indicates the number of the elements in the list. This number is not part of
  the list.
*/

import java.util.Scanner;

public class E7_32 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    int[] list = getList(input);

    partition(list);
  }

  public static int partition(int[] list) {
    int[] partitionedList = new int[list.length];
    int pivot = list[0];
    int pivotIndex = 0;

    int leftMarker = 0;
    int rightMarker = list.length - 1;
    int listMarker = 1;

    while (leftMarker <= rightMarker) {
      if (leftMarker == rightMarker) {
        partitionedList[leftMarker] = pivot;
        leftMarker++;
        rightMarker--;
      } else if (list[listMarker] <= pivot) {
        partitionedList[leftMarker] = list[listMarker];
        leftMarker++;
      } else {
        partitionedList[rightMarker] = list[listMarker];
        rightMarker--;
      }
      listMarker++;
    }

    displayList(partitionedList);
    return pivotIndex;
  }

  public static int[] getList(Scanner input) {
    System.out.print("Enter list: ");
    int[] list = new int[input.nextInt()];
    for (int i = 0; i < list.length; i++) {
      list[i] = input.nextInt();
    }
    return list;
  }

  public static void displayList(int[] list) {
    System.out.print("After the partition, the list is ");
    for (int n: list) {
      System.out.print(n + " ");
    }
    System.out.println();
  }
}
