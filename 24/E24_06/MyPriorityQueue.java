import java.util.Comparator;

public class MyPriorityQueue<E extends Comparable<E>> {
  private Heap<E> heap = new Heap<>();

  public MyPriorityQueue() {
    heap = new Heap<>();
  }

  public MyPriorityQueue(Comparator<? super E> comparator) {
    heap = new Heap<>(comparator);
  }

  public void enqueue(E newObject) {
    heap.add(newObject);
  }

  public E dequeue() {
    return heap.remove();
  }

  public int getSize() {
    return heap.getSize();
  }
}
