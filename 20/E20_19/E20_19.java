/*
  When you pick four cards from a deck of 52 cards for the 24-point game
  introduced in Programming Exercise 20.13, the four cards may not have a
  24-point solution. What is the number of all possible picks of four cards
  from 52 cards? Among all possible picks, how many of them have 24-point
  solutions? What is the success ratio--that is, the number of picks with
  solutions divided by the number of all possible picks of four cards?
  Write a program to find these answers.
*/

import java.util.Collections;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;
import java.util.function.Predicate;

public class E20_19 {
  static ArrayList<String> operatorPermutations = new ArrayList<>();
  static ArrayList<String> expressionForms = new ArrayList<>();
  static ArrayList<ArrayList<Integer>> operandPermutations = new ArrayList<>();
  static ArrayList<ArrayList<Integer>> solutions = new ArrayList<>();

  static ArrayList<ArrayList<Integer>> subPermutations = new ArrayList<>();

  public static void main(String[] args) {
    // get all permutations of operators (pick 3)
    char[] operators = {'+', '-', '*', '/'};
    permuteOperators(operators, 3, i -> i[0] == 4 && i[1] == 4 && i[2] == 4);

    // get all of the postfix notation forms for expressions
    generateExpressionForms();

    // get all permutations of four cards from a deck of 52 playing cards
    int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
    permuteOperands(nums, 4, i -> i[0] == 13 && i[1] == 13 && i[2] == 13);
    // weed out duplicates by sorting the subarrays, then convert to HashSet
    for (ArrayList<Integer> list: operandPermutations) {
      Collections.sort(list);
    }
    HashSet<ArrayList<Integer>> set = new HashSet<>(operandPermutations);
    // convert HashSet back to ArrayList
    operandPermutations = new ArrayList<>(set);

    // find all of the permutations that have solutions
    solve();

    int numberOfUniquePicks = operandPermutations.size();
    int numberOfSolvablePicks = solutions.size();
    double successRatio =
      (double)numberOfSolvablePicks / numberOfUniquePicks * 100.0;

    System.out.println("Number of unique picks: " + numberOfUniquePicks);
    System.out.println(
      "Number of picks that are solvable: " + numberOfSolvablePicks);
    System.out.println(
      "Success ratio: " + String.format("%.2f%%", successRatio));
  }

  private static void operandPermute(
    ArrayList<Integer> nums1, ArrayList<Integer> nums2) {
    if (nums2.isEmpty()) {
      subPermutations.add(nums1);
    } else {
      for (int i = 0; i < nums2.size(); i++) {
        ArrayList<Integer> temp1 = (ArrayList<Integer>)nums1.clone();
        ArrayList<Integer> temp2 = (ArrayList<Integer>)nums2.clone();
        // if the card is a king (num % 13 == 0) then change the number
        // within the permutation to a 13, so it can be used for arithmetic
        int nextNum = (nums2.get(i) % 13 == 0) ? 13 : (nums2.get(i) % 13);
        temp1.add(nextNum);
        temp2.remove(nums2.get(i));
        operandPermute(temp1, temp2);
      }
    }
  }

  public static void solve() {
    for (int i = 0; i < operandPermutations.size(); i++) {
      ArrayList<Integer> nums = operandPermutations.get(i);
      subPermutations.clear();
      operandPermute(new ArrayList<Integer>(), nums);
      outer:
      for (int j = 0; j < subPermutations.size(); j++) {
        ArrayList<Integer> sub = subPermutations.get(j);
        for (int k = 0; k < operatorPermutations.size(); k++) {
          String ops = operatorPermutations.get(k);
          for (int m = 0; m < expressionForms.size(); m++) {
            String form = expressionForms.get(m);
            if (equalsTwentyFour(sub, ops, form)) {
              solutions.add(nums);
              break outer;
            }
          }
        }
      }
    }
  }

  public static String getPostfixExpression(
    ArrayList<Integer> nums, String ops, String form) {
    int numsIndex = 0;
    int opsIndex = 0;
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < form.length(); i++) {
      char c = form.charAt(i);
      if (c == 'A') { sb.append(ops.charAt(opsIndex++) + " "); }
      else if (c == 'D') { sb.append(nums.get(numsIndex++) + " "); }
    }
    return sb.toString();
  }

  public static String postfixToInfix(String s) {
    String[] tokens = s.split(" ");
    Stack<String> stack = new Stack<>();
    for (int i = 0; i < tokens.length; i++) {
      String t = tokens[i];
      if (t.equals("+") || t.equals("-") || t.equals("*") || t.equals("/")) {
        String op2 = stack.pop();
        String op1 = stack.pop();
        stack.push("(" + op1 + " " + t + " " + op2 + ")");
      } else {
        stack.push(t);
      }
    }
    return stack.pop();
  }

  public static double evaluate(String s) {
    String[] tokens = s.split(" ");
    Stack<Double> operands = new Stack<>();

    for (int i = 0; i < tokens.length; i++) {
      String t = tokens[i];
      if (t.equals("+") || t.equals("-") || t.equals("*") || t.equals("/")) {
        double y = operands.pop();
        double x = operands.pop();
        operands.push(calculate(x, y, t.charAt(0)));
      } else {
        operands.push(Double.parseDouble(t));
      }
    }

    // Of all possible solutions, the permutation (3, 3, 8, 8) requires an
    // approximation because of floating-point inaccuracy due to division
    double num = operands.pop();
    double epsilon = 0.0000001;
    if (num < 24 + epsilon && num > 24 - epsilon) {
      return 24;
    } else {
      return num;
    }
  }

  public static boolean equalsTwentyFour(
    ArrayList<Integer> nums, String ops, String form) {
    String expression = getPostfixExpression(nums, ops, form);
    return evaluate(expression) == 24.0;
  }

  public static double calculate(double x, double y, char operator) {
    double result = 0;
    switch (operator) {
      case '+': result = x + y; break;
      case '-': result = x - y; break;
      case '*': result = x * y; break;
      case '/': result = x / y; break;
    }
    return result;
  }

  public static void permuteOperators(
    char[] a, int k, Predicate<int[]> decider) {
    int n = a.length;
    if (k < 1 || k > n)
    throw new IllegalArgumentException("Illegal number of positions.");

    int[] indexes = new int[n];
    int total = (int) Math.pow(n, k);

    while (total-- > 0) {
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < n - (n - k); i++)
        sb.append(a[indexes[i]]);
      operatorPermutations.add(sb.toString());

      if (decider.test(indexes))
      break;

      for (int i = 0; i < n; i++) {
        if (indexes[i] >= n - 1) {
          indexes[i] = 0;
        } else {
          indexes[i]++;
          break;
        }
      }
    }
  }

  public static void permuteOperands(
    int[] a, int k, Predicate<int[]> decider) {
    int n = a.length;
    if (k < 1 || k > n)
    throw new IllegalArgumentException("Illegal number of positions.");

    int[] indexes = new int[n];
    int total = (int) Math.pow(n, k);

    while (total-- > 0) {
      ArrayList<Integer> nums = new ArrayList<>();
      for (int i = 0; i < n - (n - k); i++)
        nums.add(a[indexes[i]]);
      operandPermutations.add(nums);

      if (decider.test(indexes))
      break;

      for (int i = 0; i < n; i++) {
        if (indexes[i] >= n - 1) {
          indexes[i] = 0;
        } else {
          indexes[i]++;
          break;
        }
      }
    }
  }

  public static void generateExpressionForms() {
    // there are five possible postfix expression forms for 4 numbers
    // D = number
    // A = operator
    expressionForms.add("DDDDAAA");
    expressionForms.add("DDDADAA");
    expressionForms.add("DDADDAA");
    expressionForms.add("DDDAADA");
    expressionForms.add("DDADADA");
  }
}
