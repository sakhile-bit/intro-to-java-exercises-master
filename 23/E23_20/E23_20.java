/*
  Rewrite the mergeSort method to recursively sort the first half of the array
  and the second half of the array without create new temporary arrays, and
  then merge the two into a temporary array and copy its contents to the
  original array.
*/

public class E23_20 {
  public static void main(String[] args) {
    int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
    MergeSort.mergeSort(list);
    for (int i = 0; i < list.length; i++) {
      System.out.print(list[i] + " ");
    }
    System.out.println();
  }
}
