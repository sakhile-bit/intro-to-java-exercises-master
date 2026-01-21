/*
  Revise MyPriorityQueue in Listing 24.9, using a generic parameter for
  comparing objects. Define a new constructor with a Comparator as its
  argument as follows:

  PriorityQueue(Comparator<? super E> comparator)
*/

public class E24_06 {
  public static void main(String[] args) {
    Patient patient1 = new Patient("John", 2);
    Patient patient2 = new Patient("Jim", 1);
    Patient patient3 = new Patient("Tim", 5);
    Patient patient4 = new Patient("Cindy", 7);

    MyPriorityQueue<Patient> priorityQueue = new MyPriorityQueue<>();
    priorityQueue.enqueue(patient1);
    priorityQueue.enqueue(patient2);
    priorityQueue.enqueue(patient3);
    priorityQueue.enqueue(patient4);

    while (priorityQueue.getSize() > 0) {
      System.out.print(priorityQueue.dequeue() + " ");
    }
    System.out.println();

    MyPriorityQueue<Patient> pq2 =
      new MyPriorityQueue<>(new DescendingComparator<Patient>());
    pq2.enqueue(patient1);
    pq2.enqueue(patient2);
    pq2.enqueue(patient3);
    pq2.enqueue(patient4);

    while (pq2.getSize() > 0) {
      System.out.print(pq2.dequeue() + " ");
    }
    System.out.println();
  }

  static class Patient implements Comparable<Patient> {
    private String name;
    private int priority;

    public Patient(String name, int priority) {
      this.name = name;
      this.priority = priority;
    }

    @Override
    public String toString() {
      return name + "(priority:" + priority + ")";
    }

    @Override
    public int compareTo(Patient patient) {
      if (priority > patient.priority) {
        return 1;
      } else if (priority < patient.priority) {
        return -1;
      }
      return 0;
    }
  }
}
