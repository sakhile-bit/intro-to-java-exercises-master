/*
  You can approximate e using the following series:

                      (series)

  Write a program that displays the e value for i = 10000, 20000, ..., and
  100000.
*/

import java.math.BigInteger;

public class E5_26 {
  public static void main(String[] args) {
    for (int i = 10_000; i <= 100_000; i += 10_000) {
      double e = 1.0;
      double item = 1.0;
      for (int n = 2; n <= i; n++) {
        e += item;
        item /= n;
      }
      System.out.println("i = " + i + ": " + e);
    }
  }
}
