/*
  The preceding exercise compresses a file. The compressed file contains the
  Huffman codes and the compressed contents. Write a program that decompresses
  a source file into a target file using the following command:

  java E25_19 sourcefile targetfile
*/

import java.io.File;
import java.io.PrintWriter;
import java.io.ObjectInputStream;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.EOFException;

public class E25_19 {
  public static void main(String[] args)
    throws IOException, ClassNotFoundException {
    if (args.length != 2) {
      System.out.println("Usage: E25_19 sourcefile targetfile");
      System.exit(0);
    }

    File sourcefile = new File(args[0]);

    if (!sourcefile.exists()) {
      System.out.println(sourcefile.getName() + " does not exist");
      System.exit(1);
    }

    File targetfile = new File(args[1]);

    if (targetfile.exists()) {
      System.out.println(targetfile.getName() + " already exists");
      System.exit(2);
    }

    String[] codes = new String[0];
    int length = -1;
    StringBuilder sbEncode = new StringBuilder();

    try (
      ObjectInputStream objInput = new ObjectInputStream(
        new BufferedInputStream(
        new FileInputStream(sourcefile)));
    ) {
      codes = (String[])objInput.readObject();
      length = objInput.readInt();
      while (true) {
        sbEncode.append(getBits(objInput.readByte()));
      }
    } catch (EOFException ex) {
      // do nothing
    }

    sbEncode.delete(length, sbEncode.length());

    StringBuilder sbText = new StringBuilder();
    StringBuilder sbCharCode = new StringBuilder();
    for (int i = 0; i < sbEncode.length(); i++) {
      sbCharCode.append(sbEncode.charAt(i) + "");
      for (int j = 0; j < codes.length; j++) {
        if (sbCharCode.toString().equals(codes[j])) {
          sbText.append((char)j);
          sbCharCode = new StringBuilder();
        }
      }
    }

    try (
      PrintWriter pwOutput = new PrintWriter(targetfile);
    ) {
      pwOutput.write(sbText.toString());
    }
  }

  public static String getBits(int value) {
    value = value % 256;
    String binaryInteger = "";
    int i = 0;
    int tmp = value >> i;
    for (int j = 0; j < 8; j++) {
      binaryInteger = (tmp & 1) + binaryInteger;
      i++;
      tmp = value >> i;
    }
    return binaryInteger;
  }
}
