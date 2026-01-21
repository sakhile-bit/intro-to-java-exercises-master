/*
  Write a program that prompts the user to enter a file name, then displays
  the frequency table of the characters in the file and displays the Huffman
  code for each character.
*/

import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class E25_16 {
  public static void main(String[] args) throws IOException {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a filename: ");
    File file = new File(input.nextLine());
    input.close();

    Scanner reader = new Scanner(file);
    StringBuilder sb = new StringBuilder();
    while (reader.hasNext()) {
      sb.append(reader.nextLine());
    }
    reader.close();

    String text = sb.toString();

    int[] counts = HuffmanCode.getCharacterFrequency(text);

    System.out.printf("%-15s%-15s%-15s%-15s\n",
      "ASCII Code", "Character", "Frequency", "Code");

    HuffmanCode.Tree tree = HuffmanCode.getHuffmanTree(counts);
    String[] codes = HuffmanCode.getCode(tree.root);

    for (int i = 0; i < codes.length; i++) {
      if (counts[i] != 0) {
        System.out.printf("%-15d%-15s%-15d%-15s\n",
          i, (char)i + "", counts[i], codes[i]);
      }
    }
  }
}
