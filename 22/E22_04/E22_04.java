/*
  Write a program that prompts the user to enter two strings and tests whether
  the second string is a substring of the first string. (Don't use the indexOf
  method in the String class.)
*/

import java.util.Scanner;

public class E22_04 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a string s1: ");
    String s1 = input.nextLine();
    System.out.print("Enter a string s2: ");
    String s2 = input.nextLine();

    int index = getSubstringIndex(s1, s2);

    if (index == -1) {
      System.out.println("no match");
    } else {
      System.out.println("matched at index " + index);
    }
  }

  public static int getSubstringIndex(String s1, String s2) {
    if (s2.length() > s1.length()) { return -1; }
    for (int i = 0; i <= s1.length() - s2.length(); i++) {
      for (int j = 0; j < s2.length(); j++) {
        char c1 = s1.charAt(i + j);
        char c2 = s2.charAt(j);
        if (c1 != c2) { break; }
        if (c1 == c2 && j == s2.length() - 1) {
          return i;
        }
      }
    }
    return -1;
  }
}
