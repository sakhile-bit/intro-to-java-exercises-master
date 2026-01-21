import java.util.Comparator;
import java.util.ArrayList;

public class Heap<E extends Comparable<E>> {
  private ArrayList<E> list = new ArrayList<>();
  private Comparator<? super E> comparator;

  public Heap() {
  }

  public Heap(Comparator<? super E> comparator) {
    this.comparator = comparator;
  }

  public void add(E newObject) {
    list.add(newObject);
    int currentIndex = list.size() - 1;

    while (currentIndex > 0) {
      int parentIndex = (currentIndex - 1) / 2;
      if (comparator != null &&
        comparator.compare(list.get(currentIndex), list.get(parentIndex)) > 0) {
        swap(currentIndex, parentIndex);
      } else if (comparator == null &&
        list.get(currentIndex).compareTo(list.get(parentIndex)) > 0) {
        swap(currentIndex, parentIndex);
      } else {
        break;
      }

      currentIndex = parentIndex;
    }
  }

  public E remove() {
    if (list.size() == 0) { return null; }

    E removedObject = list.get(0);
    list.set(0, list.get(list.size() - 1));
    list.remove(list.size() - 1);

    int currentIndex = 0;
    while (currentIndex < list.size()) {
      int leftChildIndex = 2 * currentIndex + 1;
      int rightChildIndex = 2 * currentIndex + 2;

      if (leftChildIndex >= list.size()) { break; }
      int maxIndex = leftChildIndex;
      if (rightChildIndex < list.size()) {
        if (comparator != null &&
          comparator.compare(list.get(maxIndex),
            list.get(rightChildIndex)) < 0) {
          maxIndex = rightChildIndex;
        } else if (comparator == null &&
          list.get(maxIndex).compareTo(list.get(rightChildIndex)) < 0) {
          maxIndex = rightChildIndex;
        }
      }

      if (comparator != null &&
        comparator.compare(list.get(currentIndex), list.get(maxIndex)) < 0) {
        swap(maxIndex, currentIndex);
        currentIndex = maxIndex;
      } else if (comparator == null &&
        list.get(currentIndex).compareTo(list.get(maxIndex)) < 0) {
        swap(maxIndex, currentIndex);
        currentIndex = maxIndex;
      } else {
        break;
      }
    }
    return removedObject;
  }

  public int getSize() {
    return list.size();
  }

  private void swap(int firstIndex, int secondIndex) {
    E temp = list.get(firstIndex);
    list.set(firstIndex, list.get(secondIndex));
    list.set(secondIndex, temp);
  }

  private void displayHeap() {
    for (E object: list) {
      System.out.print(object + " ");
    }
    System.out.println();
  }
}
