/*
  An emirp (prime spelled backward) is a nonpalindromic prime number whose
  reversal is also a prime. For example, 17 is a prime and 71 is a prime, so
  17 and 71 are emirps. Write a program that displays the first 100 emirps.
  Display 10 numbers per line, separated by exactly one space.
*/

public class E6_27 {
  public static void main(String[] args) {
    final int PRIMES_PER_LINE = 10;
    int count = 0;
    for (int i = 2; count < 100; i++) {
      if (!isPalindrome(i) && isPrime(i) && isPrime(reverse(i))) {
        System.out.printf("%5d ", i);
        count++;
        if (count % PRIMES_PER_LINE == 0) {
          System.out.println();
        }
      }
    }
  }

  public static boolean isPalindrome(int number) {
    return number == reverse(number);
  }

  public static int reverse(int number) {
    StringBuilder s = new StringBuilder(number + "");
    s = s.reverse();
    return Integer.parseInt(s.toString());
  }

  public static boolean isPrime(int number) {
    for (int divisor = 2; divisor <= number / 2; divisor++) {
      if (number % divisor == 0) {
        return false;
      }
    }
    return true;
  }
}
