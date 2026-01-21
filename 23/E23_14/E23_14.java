/*
  Write a program that obtains the execution time of external sorts for integers
  of size 5,000,000, 10,000,000, 15,000,000, 20,000,000, 25,000,000, and
  30,000,000. Your program should print a table.
*/

import java.io.File;
import java.io.DataOutputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class E23_14 {
  public static void main(String[] args) throws IOException, Exception {
    // make files to sort
    for (int i = 5_000_000; i <= 30_000_000; i += 5_000_000) {
      File file = new File(i + ".dat");
      if (file.exists()) { continue; }
      try (
        DataOutputStream output = new DataOutputStream(
          new BufferedOutputStream(
          new FileOutputStream(file)));
      ) {
        for (int j = 0; j < i; j++) {
          output.writeInt((int)(Math.random() * i * 4));
        }
      }
    }

    // measure the time taken to sort each file
    System.out.println("SIZE |   5,000,000  10,000,000  15,000,000  20,000,000  25,000,000  30,000,000");
    System.out.println("-----|------------------------------------------------------------------------");
    System.out.print("TIME |");

    for (int i = 5_000_000; i <= 30_000_000; i += 5_000_000) {
      String source = i + ".dat";
      String target = i + "_sorted.dat";
      long start = System.currentTimeMillis();
      SortLargeFile.sort(source, target);
      long end = System.currentTimeMillis();
      System.out.printf("  %10d", end - start);
    }
    System.out.println();
  }
}
