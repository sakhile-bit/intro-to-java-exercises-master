/*
  Write a program that obtains the execution time for finding the GCD of every
  two consecutive Fibonacci numbers from the index 40 to index 45 using the
  algorithms in Listings 22.3 and 22.4.
*/

import java.util.List;
import java.util.ArrayList;

public class E22_06 {
  public static void main(String[] args) {
    // Generate the Fibonacci numbers for indices 40-45
    List<Integer> fibs = new ArrayList<>();
    for (int i = 40; i <= 46; i++) {
      fibs.add((int)ImprovedFibonacci.fib(i));
    }

    System.out.println("             |  40          41          42          43          44          45");
    System.out.println("-------------|----------------------------------------------------------------");
    System.out.print("GCD          |");

    for (int i = 0; i < fibs.size() - 1; i++) {
      long startTime = System.currentTimeMillis();
      GCD.gcd(fibs.get(i), fibs.get(i + 1));
      long endTime = System.currentTimeMillis();
      System.out.printf("  %-10d", endTime - startTime);
    }

    System.out.print("\nGCDEuclid    |");

    for (int i = 0; i < fibs.size() - 1; i++) {
      long startTime = System.currentTimeMillis();
      GCDEuclid.gcd(fibs.get(i), fibs.get(i + 1));
      long endTime = System.currentTimeMillis();
      System.out.printf("  %-10d", endTime - startTime);
    }

    System.out.println();
  }
}
