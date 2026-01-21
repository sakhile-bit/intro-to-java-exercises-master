import java.util.LinkedList;
import java.util.Collection;

public class GenericQueue<E> extends LinkedList<E> {
  private static final long serialVersionUID = 7586471125622736147L;

  public GenericQueue() {
  }

  public GenericQueue(Collection<? extends E> c) {
    super(c);
  }

  public void enqueue(E e) {
    addLast(e);
  }

  public E dequeue() {
    return removeFirst();
  }

  public int getSize() {
    return size();
  }
}
