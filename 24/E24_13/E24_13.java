/*
  Define an iterator class named FibonacciIterator for iterating Fibonacci
  numbers. The constructor takes an argument that specifies the limit on the
  maximum Fibonacci number. For example, new FibonacciIterator(23302) creates
  an iterator that iterates Fibonacci numbers less than or equal to 23302.
  Write a test program that uses this iterator to display all Fibonacci numbers
  less than or equal to 100000.
*/

public class E24_13 {
  public static void main(String[] args) {
    FibonacciIterator fibIterator = new FibonacciIterator(100000);
    while (fibIterator.hasNext()) {
      System.out.println(fibIterator.next());
    }
  }
}
