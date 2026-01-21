/*
  Write a program that displays the first 50 prime numbers in descending order.
  Use a stack to store the prime numbers.
*/

public class E24_04 {
  public static void main(String[] args) {
    GenericStack<Integer> primes = getPrimes(50);
    while (!primes.isEmpty()) {
      System.out.print(primes.pop() + " ");
    }
    System.out.println();
  }

  public static GenericStack<Integer> getPrimes(int n) {
    GenericStack<Integer> stack = new GenericStack<>();

    int count = 0;
    int i = 2;
    while (count < n) {
      if (isPrime(i)) {
        stack.push(i);
        count++;
      }
      i++;
    }

    return stack;
  }

  public static boolean isPrime(int n) {
    if (n < 2) { return false; }
    if (n == 2) { return true; }
    for (int i = 2; i <= Math.sqrt(n); i++) {
      if (n % i == 0) { return false; }
    }
    return true;
  }
}
