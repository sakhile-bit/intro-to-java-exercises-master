/*
  In Section 24.5, Stacks and Queues, GenericQueue is implemented using
  composition. Define a new queue class that extends java.util.LinkedList.
*/

import java.util.ArrayList;

public class E24_05 {
  public static void main(String[] args) {
    ArrayList<Integer> startingList = new ArrayList<>();
    startingList.add(5);
    startingList.add(10);
    startingList.add(-2);
    startingList.add(0);
    startingList.add(51);

    System.out.println(startingList);

    GenericQueue<Integer> queue = new GenericQueue<>(startingList);

    System.out.println(queue);

    queue.enqueue(56);

    System.out.println(queue);
    System.out.println(queue.dequeue());
    System.out.println(queue.dequeue());
    System.out.println(queue);

    System.out.println(queue.getSize());
  }
}
