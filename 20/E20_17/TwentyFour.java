// Modified from standard version in E20_13. The main difference is that this
// class takes numbers from the user and solves based on those, whereas the
// standard version generates numbers and allows the user to solve from that
// point.

import java.util.Collections;
import java.util.ArrayList;
import java.util.Stack;
import java.util.function.Predicate;

public class TwentyFour {
  private ArrayList<Integer> cardNumbers;
  private ArrayList<ArrayList<Integer>> operandPermutations;
  private ArrayList<String> operatorPermutations;
  private ArrayList<String> expressionForms;

  public TwentyFour(ArrayList<Integer> numbers) {
    cardNumbers = numbers;
    operandPermutations = new ArrayList<>();
    operatorPermutations = new ArrayList<>();
    expressionForms = new ArrayList<>();
    operandPermute();
    operatorPermute(new char[]{'+', '-', '*', '/'},
      3, i -> i[0] == 4 && i[1] == 4 && i[2] == 4);
    generateExpressionForms();
  }

  public void newValues() {
    dealNumbers();
    operandPermute();
  }

  private void dealNumbers() {
    cardNumbers.clear();
    ArrayList<Integer> deck = getDeck();
    for (int i = 0; i < 4; i++) {
      cardNumbers.add(deck.get(i));
    }
    operandPermute();
  }

  private ArrayList<Integer> getDeck() {
    ArrayList<Integer> deck = new ArrayList<>();
    for (int i = 1; i <= 52; i++) {
      deck.add(i);
    }
    Collections.shuffle(deck);
    return deck;
  }

  public ArrayList<Integer> getCardNumbers() {
    return cardNumbers;
  }

  private void operandPermute() {
    operandPermutations.clear();
    operandPermute(new ArrayList<Integer>(), cardNumbers);
  }

  private void operandPermute(
    ArrayList<Integer> nums1, ArrayList<Integer> nums2) {
    if (nums2.isEmpty()) {
      operandPermutations.add(nums1);
    } else {
      for (int i = 0; i < nums2.size(); i++) {
        ArrayList<Integer> temp1 = (ArrayList<Integer>)nums1.clone();
        ArrayList<Integer> temp2 = (ArrayList<Integer>)nums2.clone();
        temp1.add(nums2.get(i));
        temp2.remove(nums2.get(i));
        operandPermute(temp1, temp2);
      }
    }
  }

  // Adapted from code at
  // https://rosettacode.org/wiki/Permutations_with_repetitions#Java
  private void operatorPermute(char[] a, int k, Predicate<int[]> decider) {
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

  private void generateExpressionForms() {
    // there are five possible postfix expression forms for 4 numbers
    // D = number
    // A = operator
    expressionForms.add("DDDDAAA");
    expressionForms.add("DDDADAA");
    expressionForms.add("DDADDAA");
    expressionForms.add("DDDAADA");
    expressionForms.add("DDADADA");
  }

  public String solve() {
    for (int i = 0; i < operandPermutations.size(); i++) {
      ArrayList<Integer> nums = operandPermutations.get(i);
      for (int j = 0; j < operatorPermutations.size(); j++) {
        String ops = operatorPermutations.get(j);
        for (int k = 0; k < expressionForms.size(); k++) {
          String form = expressionForms.get(k);
          if (equalsTwentyFour(nums, ops, form)) {
            return postfixToInfix(getPostfixExpression(nums, ops, form));
          }
        }
      }
    }
    return "No solution";
  }

  private String getPostfixExpression(
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

  private String postfixToInfix(String s) {
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

  private boolean equalsTwentyFour(
    ArrayList<Integer> nums, String ops, String form) {
    String expression = getPostfixExpression(nums, ops, form);
    return evaluate(expression) == 24.0;
  }

  private double evaluate(String s) {
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

  public String addSpaces(String s) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == '+' || c == '-' || c == '*' ||
          c == '/' || c == '(' || c == ')') {
        sb.append(" " + c + " ");
      } else {
        sb.append(c);
      }
    }
    return sb.toString();
  }

  public boolean numbersAreValid(String s) {
    String[] tokens = addSpaces(s).split(" ");
    ArrayList<Integer> userNums = new ArrayList<>();
    for (String t: tokens) {
      if (t.isEmpty()) { continue; }
      char c = t.charAt(0);
      if (c == '+' || c == '-' || c == '*' ||
          c == '/' || c == '(' || c == ')') {
        continue;
      } else {
        userNums.add(new Integer(t));
      }
    }

    if (userNums.size() != 4) { return false; }

    ArrayList<Integer> currentNums = new ArrayList<>();
    for (Integer i: cardNumbers) {
      currentNums.add(i % 13 == 0 ? 13 : i % 13);
    }

    Collections.sort(userNums);
    Collections.sort(currentNums);

    for (int i = 0; i < userNums.size(); i++) {
      if (!userNums.get(i).equals(currentNums.get(i))) { return false; }
    }

    return true;
  }

  public boolean expressionIsValid(String s) {
    try {
      evaluateInfix(s);
    } catch (Exception ex) {
      return false;
    }
    return true;
  }

  public double evaluateInfix(String s) {
    String[] tokens = addSpaces(s).split(" ");
    Stack<Double> operands = new Stack<>();
    Stack<Character> operators = new Stack<>();

    for (String token: tokens) {
      if (!(token.length() == 0)) {
        char c = token.charAt(0);
        if (c == '+' || c == '-') {
          while (!operators.isEmpty() &&
                 (operators.peek() == '+' ||
                  operators.peek() == '-' ||
                  operators.peek() == '*' ||
                  operators.peek() == '/')) {
            processAnOperator(operands, operators);
          }
          operators.push(c);
        } else if (c == '*' || c == '/') {
          while (!operators.isEmpty() &&
                 (operators.peek() == '*' ||
                  operators.peek() == '/')) {
            processAnOperator(operands, operators);
          }
          operators.push(c);
        } else if (c == '(') {
          operators.push(c);
        } else if (c == ')') {
          while (operators.peek() != '(') {
            processAnOperator(operands, operators);
          }
          operators.pop();
        } else {
          operands.push(new Double(token));
        }
      }
    }

    while (!operators.isEmpty()) {
      processAnOperator(operands, operators);
    }

    return operands.pop();
  }

  private void processAnOperator(Stack<Double> operands, Stack<Character> operators) {
    char op = operators.pop();
    double op1 = operands.pop();
    double op2 = operands.pop();
    if (op == '+') {
      operands.push(op2 + op1);
    } else if (op == '-') {
      operands.push(op2 - op1);
    } else if (op == '*') {
      operands.push(op2 * op1);
    } else if (op == '/') {
      operands.push(op2 / op1);
    }
  }

  private double calculate(double x, double y, char operator) {
    double result = 0;
    switch (operator) {
      case '+': result = x + y; break;
      case '-': result = x - y; break;
      case '*': result = x * y; break;
      case '/': result = x / y; break;
    }
    return result;
  }
}
