/*
  The bean machine, also known as a quincunx or the Galton box, is a device
  for statistics experiments named after English scientist Sir Francis Galton.
  It consists of an upright board with evenly spaced nails (or pegs) in a
  triangular form. Balls are dropped from the opening of the board. Every time
  a ball hits a nail, it has a 50% chance of falling to the left or to the
  right. The piles of balls are accumulated in the slots at the bottom of the
  board.

  Write a progrom that simulates the bean machine. Your program should prompt
  the user to enter the number of the balls and the number of the slots in the
  machine. Simulate the falling of each ball by printing its path. Display the
  final buildup of the balls in the slots in histogram.
*/

import java.util.Scanner;

public class E7_21 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter the number of balls to drop: ");
    int numberOfBalls = input.nextInt();
    System.out.print("Enter the number of slots in the bean machine: ");
    int numberOfSlots = input.nextInt();

    runSimulation(numberOfBalls, numberOfSlots);
  }

  public static void runSimulation(int b, int s) {
    String[] ballpaths = ballpaths(b, s);
    int[] slots = readBallPaths(ballpaths, s);

    // display paths
    for (String path: ballpaths) {
      System.out.println(path);
    }

    System.out.println();

    // display slots histogram
    String emptySlotsString = "";
    for (int i = 0; i < slots.length; i++) {
      emptySlotsString += "*";
    }
    for (int i = slots.length - 1; i > 0; i--) {
      String output = "";
      for (int j = 0; j < slots.length; j++) {
        if (slots[j] == i) {
          output += "O";
          slots[j]--;
        } else {
          output += "*";
        }
      }
      if (!output.equals(emptySlotsString)) {
        System.out.println(output);
      }
    }
  }

  public static int[] readBallPaths(String[] ballpaths, int s) {
    int[] slots = slots(s);
    for (int i = 0; i < ballpaths.length; i++) {
      int rightCount = 0;
      for (int j = 0; j < ballpaths[i].length(); j++) {
        if (ballpaths[i].charAt(j) == 'R') { rightCount++; }
      }
      slots[rightCount]++;
    }
    return slots;
  }

  public static int[] slots(int s) {
    return new int[s];
  }

  public static String[] ballpaths(int b, int s) {
    String[] ballpaths = new String[b];

    for (int ball = 0; ball < b; ball++) {
      StringBuilder path = new StringBuilder();

      for (int way = 1; way < s; way++) {
        int random = (int)(Math.random() * 2);
        if (random == 0) { path.append("L"); }
        else { path.append("R"); }
      }

      ballpaths[ball] = path.toString();
    }

    return ballpaths;
  }
}
