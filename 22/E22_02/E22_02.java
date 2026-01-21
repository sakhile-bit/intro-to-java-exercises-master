/*
  Write a program that prompts the user to enter a string and displays the
  maximum increasingly ordered subsequence of characters.
*/

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class E22_02 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a string: ");
    String str = input.nextLine();

    List<Character> max = new ArrayList<>();

    for (int i = 0; i < str.length(); i++) {
      char a = str.charAt(i);
      List<Character> current = new ArrayList<>();
      current.add(a);
      for (int j = i + 1; j < str.length(); j++) {
        char b = str.charAt(j);
        if (a <= b) {
          current.add(str.charAt(j));
          a = b;
        }
      }
      if (current.size() > max.size()) { max = current; }
    }

    for (Character ch: max) {
      System.out.print(ch);
    }
    System.out.println();
  }
}
