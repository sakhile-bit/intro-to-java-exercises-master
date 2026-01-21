/*
  Section 22.8 introduced an algorithm for finding the closest pair of points
  using a divide-and-conquer approach. Implement the algorithm to meet the
  following requirements:

  [long list of requirements]
*/

public class E22_07 {
  public static void main(String[] args) {
    double[][] s = new double[100][2];
    for (int i = 0; i < s.length; i++) {
      s[i][0] = Math.random() * 1000;
      s[i][1] = Math.random() * 1000;
    }

    System.out.println(Pair.getClosestPair(s));
  }
}
