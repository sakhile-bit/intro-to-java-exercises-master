/*
  Twin primes are a pair of prime numbers that differ by 2. For example,
  3 and 5 are twin primes, 5 and 7 are twin primes, and 11 and 13 are twin
  primes. Write a program to find all twin primes less than 1000.
*/

public class E6_29 {
  public static void main(String[] args) {
    // loop i to 998, because last possible pair would be (998, 1000) in order
    // to keep the results to < 1000
    for (int i = 2; i <= 998; i++) {
      if (isPrime(i) && isPrime(i + 2)) {
        System.out.printf("(%d, %d)\n", i, i + 2);
      }
    }
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
