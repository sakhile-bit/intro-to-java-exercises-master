/*
  Write a program that obtains the execution time for finding all the prime
  numbers less than 8,000,000, 10,000,000, 12,000,000, 14,000,000, 16,000,000,
  and 18,000,000 using the algorithms in Listings 22.5-22.7.
*/

import java.util.List;
import java.util.ArrayList;

public class E22_14 {
  public static void main(String[] args) {
    System.out.println("            |   8,000,000  10,000,000  12,000,000  14,000,000  16,000,000  18,000,000");
    System.out.println("------------|------------------------------------------------------------------------");

    System.out.print("Listing 22.5|");
    for (int i = 8_000_000; i <= 18_000_000; i += 2_000_000) {
      long start = System.currentTimeMillis();
      prime22_5(i);
      long end = System.currentTimeMillis();
      System.out.printf("  %-10d", end - start);
    }
    System.out.println();

    System.out.print("Listing 22.6|");
    for (int i = 8_000_000; i <= 18_000_000; i += 2_000_000) {
      long start = System.currentTimeMillis();
      prime22_6(i);
      long end = System.currentTimeMillis();
      System.out.printf("  %-10d", end - start);
    }
    System.out.println();

    System.out.print("Listing 22.7|");
    for (int i = 8_000_000; i <= 18_000_000; i += 2_000_000) {
      long start = System.currentTimeMillis();
      prime22_7(i);
      long end = System.currentTimeMillis();
      System.out.printf("  %-10d", end - start);
    }
    System.out.println();
  }

  public static void prime22_5(int n) {
    int number = 2;
    while (number <= n) {
      for (int divisor = 2; divisor <= (int)(Math.sqrt(number)); divisor++) {
        if (number % divisor == 0) {
          break;
        }
      }
      number++;
    }
  }

  public static void prime22_6(int n) {
    int number = 2;
    int squareRoot = 1;
    List<Integer> list = new ArrayList<>();
    while (number <= n) {
      boolean isPrime = true;
      if (squareRoot * squareRoot < number) { squareRoot++; }
      for (int k = 0; k < list.size() && list.get(k) <= squareRoot; k++) {
        if (number % list.get(k) == 0) {
          isPrime = false;
          break;
        }
      }
      if (isPrime) { list.add(number); }
      number++;
    }
  }

  public static void prime22_7(int n) {
    boolean[] primes = new boolean[n + 1];
    for (int i = 0; i < primes.length; i++) {
      primes[i] = true;
    }
    for (int k = 2; k <= n / k; k++) {
      if (primes[k]) {
        for (int i = k; i <= n / k; i++) {
          primes[k * i] = false;
        }
      }
    }
  }
}
