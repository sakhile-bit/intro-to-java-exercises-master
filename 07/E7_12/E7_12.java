/*
  The reverse method in Section 7.7 reverses an array by copying it to a new
  array. Rewrite the method that reverses the array passed in the argument
  and returns this array. Write a test program that prompts the user to enter
  ten numbers, invokes the method to reverse the numbers, and displays the
  numbers.
*/

import java.util.Scanner;

public class E7_12 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter ten numbers: ");

    double[] nums = new double[10];
    for (int i = 0; i < nums.length; i++) {
      nums[i] = input.nextDouble();
    }

    double[] reversed = reverse(nums);

    for (double n: reversed) {
      System.out.print(n + " ");
    }
    System.out.println();
  }

  public static double[] reverse(double[] array) {
    for (int i = 0, j = array.length - 1; i <= j; i++, j--) {
      double temp = array[i];
      array[i] = array[j];
      array[j] = temp;
    }
    return array;
  }
}
