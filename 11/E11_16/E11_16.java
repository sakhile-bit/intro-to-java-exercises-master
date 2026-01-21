/*
  Rewrite Listing 5.1 RepeatAdditionQuiz.java to alert the user if an answer
  is entered again.
*/

import java.util.Scanner;
import java.util.ArrayList;

public class E11_16 {
  public static void main(String[] args) {
    int number1 = (int)(Math.random() * 10);
    int number2 = (int)(Math.random() * 10);

    Scanner input = new Scanner(System.in);

    System.out.print("What is " + number1 + " + " + number2 + "? ");
    int answer = input.nextInt();

    ArrayList<Integer> answers = new ArrayList<>();
    while (number1 + number2 != answer) {
      if (answers.contains(answer)) {
        System.out.println("You already entered " + answer);
      }
      System.out.print("Wrong answer. Try again. What is " +
        number1 + " + " + number2 + "? ");
      answers.add(answer);
      answer = input.nextInt();
    }

    System.out.println("You got it!");
  }
}
