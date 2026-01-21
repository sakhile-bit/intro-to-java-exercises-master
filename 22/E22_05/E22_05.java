/*
  Write an O(n) program that prompts the user to enter a sequence of integers
  ending with 0 and finds the longest subsequence with the same number.
*/

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class E22_05 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a series of numbers ending with 0: ");
    List<Integer> list = new ArrayList<>();
    while (true) {
      int num = input.nextInt();
      if (num == 0) { break; }
      list.add(num);
    }

    int index = 0;
    int value = list.get(index);
    int count = 1;
    int maxIndex = index;
    int maxValue = value;
    int maxCount = count;
    for (int i = 1; i < list.size(); i++) {
      if (list.get(i) == value) {
        count++;
        if (count > maxCount) {
          if (maxIndex != index) { maxIndex = index; }
          maxValue = list.get(i);
          maxCount = count;
        }
      } else {
        index = i;
        value = list.get(i);
        count = 1;
      }
    }

    System.out.println("The longest same number sequence starts at index " +
      maxIndex + " with " + maxCount + " values of " + maxValue);
  }
}
