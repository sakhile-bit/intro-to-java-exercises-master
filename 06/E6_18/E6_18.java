/*
  Some websites impose certain rules for passwords. Write a method that checks
  whether a string is a valid password. Suppose the password rules are as
  follows:

  - A password must have at least eight characters.
  - A password consists of only letters and digits.
  - A password must contain at least two digits.

  Write a program that prompts the user to enter a password and displays
  Valid Password if the rules are followed or Invalid Password otherwise.
*/

import java.util.Scanner;

public class E6_18 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a password: ");
    String password = input.nextLine();

    StringBuilder result = new StringBuilder(" Password");
    result.insert(0, isValidPassword(password) ? "Valid" : "Invalid");

    System.out.println(result);
  }

  public static boolean isValidPassword(String password) {
    int letterCount = 0;
    int digitCount = 0;
    boolean isValid = true;
    for (int i = 0; i < password.length(); i++) {
      char c = password.charAt(i);
      if (!Character.isLetterOrDigit(c)) { isValid = false; break; }
      if (Character.isLetter(c)) { letterCount++; }
      else { digitCount++; }
    }
    if (letterCount < 8 || digitCount < 2) { isValid = false; }
    return isValid;
  }
}
