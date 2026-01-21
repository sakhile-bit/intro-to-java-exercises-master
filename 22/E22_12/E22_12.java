/*
  Programming Exercise 22.8 stores the prime numbers in a file named
  PrimeNumbers.dat. Write an efficient program that reads the last 100 numbers
  in the file.
*/

import java.io.File;
import java.io.RandomAccessFile;
import java.io.EOFException;
import java.io.IOException;

public class E22_12 {
  public static void main(String[] args) throws IOException {
    final String filename = "../E22_08/PrimeNumbers.dat";
    final int PRIMES_TO_READ = 100;
    final int LENGTH_OF_PRIME = 8; // bytes

    File file = new File(filename);

    if (!file.exists()) {
      System.out.println(file.getName() + " does not exist");
      System.exit(1);
    }

    try(
      RandomAccessFile raf = new RandomAccessFile(file, "r");
    ) {
      long length = file.length();
      raf.seek(length - (PRIMES_TO_READ * LENGTH_OF_PRIME));
      while (true) {
        System.out.println(raf.readLong());
      }
    } catch (EOFException ex) {
      System.out.println("EOF");
    }
  }
}
