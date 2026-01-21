/*
  Suppose you have a lot of files in a directory that contain words
  Exercisei_j, where i and j are digits. Write a program that pads a 0 before
  i if i is a single digit and 0 before j if j is a single digit. For example,
  the word Exercise2_1 in a file will be replaced by Exercise02_01. Use the
  following command to run our program. Use the following command to run your
  program.

  java E12_27 *
*/

import java.io.File;

public class E12_27 {
  public static void main(String[] args) {
    for (String s: args) {
      File file = new File(s);
      StringBuilder sb = new StringBuilder(s);
      if (s.matches("Exercise\\d_\\d")) {
        sb.insert(8, "0");
        sb.insert(11, "0");
      } else if (s.matches("Exercise\\d_\\d+")) {
        sb.insert(8, "0");
      } else if (s.matches("Exercise\\d+_\\d")) {
        sb.insert(11, "0");
      }
      File newName = new File(sb.toString());
      file.renameTo(newName);
    }
  }
}
