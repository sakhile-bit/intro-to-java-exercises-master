/*
  Rewrite the preceding program so that it finds an optimal solution that packs
  all objects using the smallest number of containers.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class E25_23 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter the number of objects: ");
    Integer[] list = new Integer[input.nextInt()];
    System.out.print("Enter the weights of the objects: ");
    for (int i = 0; i < list.length; i++) {
      list[i] = input.nextInt();
    }
    ArrayList<Integer> objects = new ArrayList<>(Arrays.asList(list));
    objects.sort(new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        if (o1.compareTo(o2) < 0) {
          return 1;
        } else if (o1.compareTo(o2) > 0) {
          return -1;
        }
        return 0;
      }
    });

    ArrayList<ArrayList<Integer>> containers = new ArrayList<>();

    while (!objects.isEmpty()) {
      if (containers.isEmpty()) {
        // create first container, add first object, and remove it from objects
        // list
        containers.add(new ArrayList<>());
        containers.get(containers.size() - 1).add(objects.remove(0));
      } else {
        for (int i = 0; i < containers.size(); i++) { // iterate over containers
          int sum = 0;
          for (int j = 0; j < containers.get(i).size(); j++) {
            // select a container and find sum of its objects' weights
            sum += containers.get(i).get(j);
          }
          int spaceRemaining = 10 - sum; // calculate remaining space
          for (int k = 0; k < objects.size(); k++) {
            // iterate over objects, add those that fit into container's space,
            // and remove them from objects list
            if (objects.get(k) <= spaceRemaining) {
              containers.get(i).add(objects.get(k));
              spaceRemaining -= objects.get(k);
              objects.remove(k);
              k--;
            }
          }
          if (i == containers.size() - 1 && !objects.isEmpty()) {
            // if we reach the last container and there are still objects left
            // add a new container
            containers.add(new ArrayList<>());
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
    System.out.println("The optimal number of bins is " + containers.size());
  }
}
