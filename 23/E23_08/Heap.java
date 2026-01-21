import java.util.ArrayList;

public class Heap<E extends Comparable<E>> {
  private ArrayList<E> list = new ArrayList<>();

  public Heap() {
  }

  public void add(E item) {
    list.add(item);
    int currentIndex = list.size() - 1;

    while (currentIndex > 0) {
      int parentIndex = (currentIndex - 1) / 2;
      if (list.get(currentIndex).compareTo(list.get(parentIndex)) > 0) {
        E temp = list.get(currentIndex);
        list.set(currentIndex, list.get(parentIndex));
        list.set(parentIndex, temp);
      } else {
        break;
      }
      currentIndex = parentIndex;
    }
  }

  public E remove() {
    E removedItem = list.get(0);
    list.set(0, list.get(list.size() - 1));
    list.remove(list.size() - 1);

    int currentIndex = 0;
    while (currentIndex < list.size()) {
      int leftChildIndex = currentIndex * 2 + 1;
      int rightChildIndex = currentIndex * 2 + 2;

      if (leftChildIndex >= list.size()) { break; } // index out of bounds

      int maxIndex = leftChildIndex; // assume left is max of children
      // if right child is larger, make its index the max index
      if (rightChildIndex < list.size()) {
        if (list.get(rightChildIndex).compareTo(list.get(leftChildIndex)) > 0) {
          maxIndex = rightChildIndex;
        }
      }

      // if max child is larger than parent, swap them
      if (list.get(maxIndex).compareTo(list.get(currentIndex)) > 0) {
        E temp = list.get(currentIndex);
        list.set(currentIndex, list.get(maxIndex));
        list.set(maxIndex, temp);
      } else {
        break;
      }
    }

    return removedItem;
  }
}
