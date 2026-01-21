/*
  Listing 5.15 determines whether a number n is prime by checking whether
  2, 3, 4, 5, 6, ..., n/2 is a divisor. If a divisor is found, n is not prime.
  A more efficient approach is to check whether any of the prime numbers less
  than or equal to sqrt(n) can divide n evenly. If not, n is prime. Rewrite
  Listing 5.15 to display the first 50 prime numbers using this approach. You
  need to use an array to store the prime numbers and later use them to check
  whether they are possible divisor for n.
*/

import java.util.ArrayList;

public class E7_06 {
  public static void main(String[] args) {
    final int NUMBER_OF_PRIMES = 50;
    final int NUMBER_OF_PRIMES_PER_LINE = 10;
    int count = 0;
    int number = 2;
    ArrayList<Integer> primes = new ArrayList<>();
    primes.add(number);

    System.out.println("The first 50 prime numbers are \n");

    while (count < NUMBER_OF_PRIMES) {
      boolean isPrime = true;

      for (int i = 0; primes.get(i) <= Math.sqrt(number); i++) {
        if (number % primes.get(i) == 0) {
          isPrime = false;
          break;
        }
      }

      if (isPrime) {
        count++;
        primes.add(number);

        if (count % NUMBER_OF_PRIMES_PER_LINE == 0) {
          System.out.println(number);
        } else {
          System.out.print(number + " ");
        }
      }

      number++;
    }
  }
}
