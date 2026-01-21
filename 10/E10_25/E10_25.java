/*
  The split method in the String class returns an array of strings consisting
  of the substrings split by the delimiters. However, the delimiters are not
  returned. Implement the following new method that returns an array of strings
  consisting of the substrings split by the matching delimiters, including the
  matching delimiters.
*/

import java.util.ArrayList;

public class E10_25 {
  public static void main(String[] args) {
    String s = "ab?babc?#gfe";
    String reg = "[#?]";
    String[] split = split(s, reg);

    displaySplit(split);
  }

  public static String[] split(String s, String regex) {
    ArrayList<String> delimiters = splitRegex(regex);
    ArrayList<String> pieces = new ArrayList<>();

    // This handles the case where the user wants to split after each
    // character in the string.

    if (delimiters.get(0).equals("")) {
      for (int i = 0; i < s.length(); i++) {
        pieces.add(String.valueOf(s.charAt(i)));
      }
    } else {

      // The strategy is to use StringBuilder's indexOf and substring methods
      // to select and add chunks of the StringBuilder object to the pieces
      // array, which holds the parts of the original string, split by one or
      // more delimiters. With each transfer of chunks, we use StringBuilder's
      // replace method to erase the transferred characters. When the
      // StringBuilder object's length is 0, the loop ends.

      StringBuilder sb = new StringBuilder(s);

      while (sb.length() != 0) {
        int[] lowest = getLowestIndex(sb, delimiters);
        int lowIndex = lowest[0];
        int delimiterIndex = lowest[1];

        if (delimiterIndex != -1) { // enter here if we still have a delimiter
          if (lowIndex < 0) {
            // getLowestIndex might return a -1 for the lowest Index, which
            // means the corresponding delimiter is no longer present in the
            // StringBuilder, and should be removed from the array of
            // delimiters.
            delimiters.remove(delimiterIndex);
            continue;
          } else {
            String delimiter = delimiters.get(delimiterIndex);
            if (lowIndex == 0) {
              // Handle the case where the delimiter falls at the beginning of
              // the StringBuilder.
              pieces.add(delimiter);
              sb.replace(0, delimiter.length(), "");
            } else if (lowIndex > 0) {
              // Handle the case where the delimiter falls after one or more
              // characters in the StringBuilder.
              pieces.add(sb.substring(0, lowIndex));
              pieces.add(delimiter);
              sb.replace(0, lowIndex + delimiter.length(), "");
            }
          }
        } else if (sb.length() > 0) {
          // Handle non-delimiter characters at the end of the StringBuilder.
          pieces.add(sb.toString());
          sb.replace(0, sb.length(), "");
        }
      }
    }

    String[] result = new String[pieces.size()];
    return pieces.toArray(result);
  }

  // Returns the lowest index of a delimiter in the StringBuilder along with
  // the index of the appropriate delimiter. lowIndex will be >= 0 if the
  // applicable delimiter is still present in the StringBuilder, and -1 if not.
  // delimiter will return >= 0 if there remains any delimiter in the
  // StringBuilder, and -1 if not.
  public static int[] getLowestIndex(StringBuilder sb,
    ArrayList<String> delimiters) {
    int lowIndex = sb.length() - 1;
    int delimiter = -1;
    for (int i = 0; i < delimiters.size(); i++) {
      int index = sb.indexOf(delimiters.get(i));
      if (index >= 0 && index <= lowIndex) {
        lowIndex = index;
        delimiter = i;
      }
    }
    return new int[]{lowIndex, delimiter};
  }

  // Returns an array of delimiters
  public static ArrayList<String> splitRegex(String regex) {
    ArrayList<String> delimiters = new ArrayList<>();
    // This accounts for the case of an empty regex, which means the user
    // intends to split after every character.
    if (regex.equals("")) {
      delimiters.add("");
    } else {
      // Any non-zero number of regex values surrounded by square brackets
      // indicates one or more single-character regex values. Regex input not
      // surrounded by square brackets is treated as a single regex value.
      // Note that an empty string surrounded by square brackets ("[]") will
      // treat the square brackets as an individual delimiter.
      if (regex.startsWith("[") && regex.endsWith("]") && regex.length() > 2) {
        for (int i = 1; i < regex.length() - 1; i++) {
          delimiters.add(String.valueOf(regex.charAt(i)));
        }
      } else {
        delimiters.add(regex);
      }
    }

    return delimiters;
  }

  // A convenience method for displaying the resulting array
  public static void displaySplit(String[] arr) {
    System.out.print("[");
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i]);
      System.out.print(i == arr.length - 1 ? "": ", ");
    }
    System.out.println("]");
  }
}
