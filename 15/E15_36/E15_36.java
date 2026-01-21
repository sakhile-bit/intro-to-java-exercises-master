/*
  Write a simulation program to show that the chance of getting dead-end paths
  increases as the grid size increases. Your program should simulate lattices
  with size from 10 to 80. For each lattice size, simulate a self-avoiding
  random walk 10,000 times and display the probability of the dead-end paths.
*/

public class E15_36 {
  public static void main(String[] args) {
    int attempts = 10_000;
    for (int i = 10; i <= 80; i++) {
      int deadEnd = 0;
      for (int j = 0; j < attempts; j++) {
        SelfAvoidingWalk saw = new SelfAvoidingWalk(i);
        int result = saw.walk();
        if (result == -1) { deadEnd++; }
      }
      double percent = ((double)deadEnd / attempts) * 100;
      System.out.printf("For a lattice of size %d, the probability of " +
        "dead-end paths is %.1f%%\n", i, percent);
    }
  }
}
