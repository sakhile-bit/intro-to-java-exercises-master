/*
  Rewrite the preceding program so that it uses a new greedy algorithm that
  places an object with the smallest weight into the first bin in which it
  would fit. Your program should prompt the user to enter the total number of
  objects and the weight of each object. The program displays the total number
  of containers needed to pack the objects and the contents of each container.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class E25_21 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter the number of objects: ");
    int numOfObjects = input.nextInt();
    System.out.print("Enter the weights of the objects: ");
    int[] objects = new int[numOfObjects];
    for (int i = 0; i < objects.length; i++) {
      objects[i] = input.nextInt();
    }

    Arrays.sort(objects);
    ArrayList<ArrayList<Integer>> containers = new ArrayList<>();

    for (int i = 0; i < objects.length; i++) {
      if (containers.isEmpty()) {
        containers.add(new ArrayList<>());
        containers.get(containers.size() - 1).add(objects[i]);
      } else {
        for (int j = 0; j < containers.size(); j++) {
          int sum = 0;
          for (int k = 0; k < containers.get(j).size(); k++) {
            sum += containers.get(j).get(k);
          }

          if (sum + objects[i] <= 10) {
            containers.get(j).add(objects[i]);
            break;
          } else if (j == containers.size() - 1) {
            containers.add(new ArrayList<>());
            containers.get(containers.size() - 1).add(objects[i]);
            break;
          }
        }
      }
    }

    for (int i = 0; i < containers.size(); i++) {
      System.out.print("Container " + (i + 1) +
        " contains objects with weight ");
      for (int j = 0; j < containers.get(i).size(); j++) {
        System.out.print(containers.get(i).get(j) + " ");
      }
      System.out.println();
    }
  }
}
