/*
  Write a method that returns a new array by eliminating the duplicate values
  in the array using the following method header:

  public static int[] eliminateDuplicates(int[] list)

  Write a test program that reads in ten integers, invokes the method, and
  displays the result.
*/

import java.util.Scanner;
import java.util.Arrays;

public class E7_15 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter ten numbers: ");

    int[] nums = new int[10];
    for (int i = 0; i < nums.length; i++) {
      nums[i] = input.nextInt();
    }

    int[] uniques = eliminateDuplicates(nums);

    for (int n: uniques) {
      System.out.print(n + " ");
    }
    System.out.println();
  }

  public static int[] eliminateDuplicates(int[] list) {
    int[] uniques = new int[list.length];
    int currentIndex = 0;
    for (int i = 0; i < list.length; i++) {
      boolean unique = true;
      for (int j = 0; j <= currentIndex; j++) {
        if (list[i] == uniques[j]) {
          unique = false;
          break;
        }
      }
      if (unique) {
        uniques[currentIndex] = list[i];
        currentIndex++;
      }
    }
    return Arrays.copyOf(uniques, currentIndex);
  }
}
