/*
  A palindromic prime is a prime number and also palindromic. For example,
  131 is a prime and also a palindromic prime, as are 313 and 757. Write a
  program that displays the first 100 palindromic prime numbers. Display 10
  numbers per line, separated by exactly one space.
*/

public class E6_26 {
  public static void main(String[] args) {
    final int PRIMES_PER_LINE = 10;
    int count = 0;
    for (int i = 2; count < 100; i++) {
      if (isPrime(i) && isPalindrome(i)) {
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
