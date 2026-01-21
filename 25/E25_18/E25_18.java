/*
  Write a program that compresses a source file into a target file using the
  Huffman coding method. First use ObjectOutputStream to output the Huffman
  codes into the target file, and then use BitOutputStream in Programming
  Exercise 17.17 to output the encoded binary contents to the target file.
  Pass the files from the command line using the following command:

  java E25_18 sourcefile targetfile
*/

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class E25_18 {
  public static void main(String[] args) throws IOException {
    if (args.length != 2)  {
      System.out.println("Usage: java E25_18 sourcefile targetfile");
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

    // get text from the sourcefile
    Scanner sourceReader = new Scanner(sourcefile);
    StringBuilder sbText = new StringBuilder();
    while (sourceReader.hasNext()) {
      sbText.append(sourceReader.nextLine());
    }

    // generate Huffman codes for characters in the text
    int[] counts = HuffmanCode.getCharacterFrequency(sbText.toString());
    HuffmanCode.Tree tree = HuffmanCode.getHuffmanTree(counts);
    String[] codes = HuffmanCode.getCode(tree.root);

    // encode the text using the Huffman codes
    StringBuilder sbEncoded = new StringBuilder();
    for (int i = 0; i < sbText.length(); i++) {
      char c = sbText.charAt(i);
      sbEncoded.append(codes[(int)c]);
    }

    // write the codes, the encoded length in bits, and the bits themselves
    // to targetfile
    try (
      BitOutputStream bitOutput = new BitOutputStream(targetfile);
    ) {
      bitOutput.writeObject(codes);
      bitOutput.writeInt(sbEncoded.length());
      bitOutput.writeBit(sbEncoded.toString());
    }
  }
}
