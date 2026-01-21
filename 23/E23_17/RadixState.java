import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class RadixState {
  private int[] list;
  private ArrayList<ArrayList<Integer>> buckets;
  private int index;

  public RadixState(int[] list, ArrayList<ArrayList<Integer>> buckets, int index) {
    this.list = list;
    this.buckets = buckets;
    this.index = index;
  }

  public int[] getList() {
    return list;
  }

  public ArrayList<ArrayList<Integer>> getBuckets() {
    return buckets;
  }

  public int getIndex() {
    return index;
  }

  public static ArrayList<RadixState> getStates(int[] list) {
    ArrayList<RadixState> states = new ArrayList<>();

    // find the largest integer in the list
    int largest = list[0];
    for (int i = 1; i < list.length; i++) {
      if (list[i] > largest) { largest = list[i]; }
    }

    // find number of significant digits in largest integer
    int digits = 0;
    do {
      largest /= 10;
      digits++;
    } while (largest != 0);

    // perform the sorting
    ArrayList<ArrayList<Integer>> buckets = generateBuckets();
    int m = 10; // mod value for isolating digits up to significant digit
    int n = 1;  // divisor for isolating the significant digit itself
    // for each significant digit
    for (int i = 0; i < digits; i++) {
      // sort each integer into the appropriate bucket
      for (int j = 0; j < list.length; j++) {
        buckets.get((list[j] % m) / n).add(list[j]);
        ArrayList<ArrayList<Integer>> bucketCopy = copyBuckets(buckets);
        states.add(new RadixState(Arrays.copyOf(list, list.length),
          bucketCopy, j));
      }
      // put each integer back into the list in its new bucket order
      int count = 0;
      for (int k = 0; k < buckets.size(); k++) {
        for (int p = 0; p < buckets.get(k).size(); p++) {
          list[count++] = buckets.get(k).get(p);
        }
      }
      // increase mod and divisor for the next iteration
      m *= 10;
      n *= 10;
      buckets = generateBuckets(); // get fresh buckets
      ArrayList<ArrayList<Integer>> bucketCopy = copyBuckets(buckets);
      states.add(new RadixState(Arrays.copyOf(list, list.length),
        bucketCopy, -1));
    }

    return states;
  }

  public static ArrayList<ArrayList<Integer>> generateBuckets() {
    ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      list.add(new ArrayList<Integer>());
    }
    return list;
  }

  private static ArrayList<ArrayList<Integer>> copyBuckets(ArrayList<ArrayList<Integer>> buckets) {
    ArrayList<ArrayList<Integer>> bucketCopy = new ArrayList<>();
    for (int i = 0; i < buckets.size(); i++) {
      bucketCopy.add(new ArrayList<Integer>());
      for (int j = 0; j < buckets.get(i).size(); j++) {
        bucketCopy.get(i).add(buckets.get(i).get(j));
      }
    }
    return bucketCopy;
  }

  @Override
  public String toString() {
    StringBuilder sbList = new StringBuilder("list: [");
    for (int i = 0; i < list.length; i++) {
      sbList.append(list[i] + " ");
    }
    sbList.append("]");
    StringBuilder sbBuckets = new StringBuilder("buckets:\n");
    for (int i = 0; i < buckets.size(); i++) {
      sbBuckets.append(i + " [");
      for (int j = 0; j < buckets.get(i).size(); j++) {
        sbBuckets.append(buckets.get(i).get(j) + " ");
      }
      sbBuckets.append("]\n");
    }
    return sbList.toString() + "\n" + sbBuckets.toString() + index;
  }
}
