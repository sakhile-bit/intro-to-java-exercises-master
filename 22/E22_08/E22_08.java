/*
  Write a program that finds all prime numbers up to 10,000,000,000. There are
  approximately 455,052,511 such prime numbers. Your program should meet the
  following requirements:

  - Your program should store the prime numbers in a binary data file, named
    PrimeNumbers.dat. When a new prime number is found, the number is
    appended to the file.
  - To find whether a new number is prime, your program should load the prime
    numbers from the file to an array of the long type of size 10,000. If no
    number in the array is a divisor for the new number, continue to read the
    next 10,000 prime numbers from the data file, until a divisor is found or
    all numbers in the file are read. If no divisor is found, the new number is
    prime.
  - Since this program takes a long time to finish, you should run it as a
    batch job from a UNIX matchine. If the machine is shut down and rebooted,
    your program should resume by using the prime numbers stored in the binary
    data file rather than start over from scratch.
*/

import java.io.File;
import java.io.IOException;
import java.io.EOFException;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.DataInputStream;
import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class E22_08 {
  public static void main(String[] args) throws IOException {
    String filename = "PrimeNumbers.dat";
    File file = new File(filename);

    // Write 2 to PrimeNumbers.dat to begin with
    if (!file.exists()) {
      try (
        DataOutputStream output =
          new DataOutputStream(
          new FileOutputStream(file));
      ) {
        output.writeLong(2);
      }
    }

    // Obtain the current value to check for primeness (i.e. the last value
    // in PrimeNumbers.dat + 1)
    long value = -1;
    try (
      DataInputStream input =
        new DataInputStream(
        new BufferedInputStream(
        new FileInputStream(file)));
    ) {
      while (true) {
        value = input.readLong() + 1;
        if (value % 2 == 0) { value++; }
      }
    } catch (EOFException ex) {
      // Do nothing
    }

    outer:
    for (long i = value; i <= 10_000_000_000L; i += 2) {
      long[] arr = new long[0];
      boolean prime = true;
      try (
        DataInputStream input =
          new DataInputStream(
          new BufferedInputStream(
          new FileInputStream(file)));
      ) {
        while (true) {
          // get up to 10,000 primes from the file
          arr = new long[10_000];
          for (int j = 0; j < arr.length; j++) {
            arr[j] = input.readLong();
          }
          // if number of primes to test >= 10_000, process a full chunk here
          if (!isPrime(i, arr)) {
            prime = false;
            continue outer;
          }
        }
      } catch (EOFException ex) {
        // if EOF has been reached, process number of primes < 10_000 here
        if (!isPrime(i, arr)) {
          prime = false;
          continue outer;
        }
      }
      if (prime) {
        writePrime(i, file);
      }
    }
  }

  private static boolean isPrime(long n, long[] arr) {
    double sqrt = Math.sqrt(n);
    for (int i = 0; i < arr.length && arr[i] != 0 && arr[i] <= sqrt; i++) {
      if (n % arr[i] == 0) { return false; }
    }
    return true;
  }

  private static void writePrime(long prime, File file) throws IOException {
    try (
      DataOutputStream output =
        new DataOutputStream(
        new FileOutputStream(file, true));
    ) {
      output.writeLong(prime);
    }
  }
}
