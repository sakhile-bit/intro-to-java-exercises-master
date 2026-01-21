/*
  Write a method that uses the divide-and-conquer approach to find the smallest
  number in a list.
*/

public class E22_24 {
  public static void main(String[] args) {
    int n = 100;
    int[] list = new int[n];
    for (int i = 0; i < list.length; i++) {
      list[i] = (int)(Math.random() * n * 10);
    }

    printList(list);
    System.out.println("smallest: " + findSmallestNumber(list));
  }

  private static int findSmallestNumber(int[] list) {
    return findSmallestNumber(0, list.length - 1, list);
  }

  private static int findSmallestNumber(int low, int high, int[] list) {
    if (low == high) { return list[low]; }
    if (high - low == 1) { return Math.min(list[low], list[high]); }

    int mid = low + (high - low) / 2;

    int s1 = findSmallestNumber(low, mid, list);
    int s2 = findSmallestNumber(mid + 1, high, list);

    return Math.min(s1, s2);
  }

  private static void printList(int[] list) {
    for (int i = 0; i < list.length; i++) {
      if (i % 10 == 0) { System.out.println(); }
      System.out.printf("%3d ", list[i]);
    }
    System.out.println();
  }
}
