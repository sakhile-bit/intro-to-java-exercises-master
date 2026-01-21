/*
  Programming Exercise 22.8 stores the prime numbers in a file named
  PrimeNumbers.dat. Write a program that finds the number of prime numbers that
  are less than or equal to 10, 100, 1000, 10000, 100000, 1000000, 10000000,
  100000000, 1000000000, and 10000000000. Your program should read the data
  from PrimeNumbers.dat.
*/

import java.io.File;
import java.io.DataInputStream;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.EOFException;
import java.io.IOException;

public class E22_10 {
  public static void main(String[] args) throws IOException {
    String filename = "../E22_08/PrimeNumbers.dat";
    File file = new File(filename);

    if (!file.exists()) {
      System.out.println(file.getName() + " does not exist");
      System.exit(1);
    }

    int[] counts = new int[10];

    try (
      DataInputStream input =
        new DataInputStream(
        new BufferedInputStream(
        new FileInputStream(file)));
    ) {
      while (true) {
        long prime = input.readLong();
        for (long i = 0, denom = 10;
          i < counts.length && denom <= 10_000_000_000L; i++, denom *= 10) {
          if (prime <= denom) { counts[(int)i]++; }
        }
      }
    } catch (EOFException ex) {
      for (long i = 0, denom = 10;
        i < counts.length && denom <= 10_000_000_000L; i++, denom *= 10) {
        System.out.println("<= " + i + ": " + counts[(int)i]);
      }
    }
  }
}
