/*
  Write a program that prompts the user to enter a string and displays the
  maximum consecutive increasingly ordered substring.
*/

import java.util.Scanner;

public class E22_01 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a string: ");
    String str = input.nextLine();

    int index = 0;
    int value = str.charAt(index);
    int count = 1;
    int maxIndex = index;
    int maxCount = count;
    for (int i = 1; i < str.length(); i++) {
      char ch = str.charAt(i);
      if (value <= ch) {
        count++;
        if (count > maxCount) {
          maxCount = count;
          if (maxIndex != index) {
            maxIndex = index;
          }
        }
      } else {
        count = 1;
        index = i;
      }
      value = ch;
    }

    System.out.println(str.substring(maxIndex, maxIndex + maxCount));
  }
}
