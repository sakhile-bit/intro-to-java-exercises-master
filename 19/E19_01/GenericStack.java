public class GenericStack<E> {
  private E[] list;
  private int size;

  public GenericStack() {
    list = (E[])new Object[8];
    size = 0;
  }

  public int getSize() {
    return size;
  }

  public E peek() {
    return list[size - 1];
  }

  public void push(E o) {
    if (size == list.length) {
      E[] expandedList = (E[])new Object[list.length * 2];
      System.arraycopy(list, 0, expandedList, 0, list.length);
      list = expandedList;
    }
    list[size] = o;
    size++;
  }

  public E pop() {
    E o = list[size - 1];
    size--;
    return o;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("stack: ");
    for (int i = size - 1; i >= 0; i--) {
      sb.append(list[i] + " ");
    }
    return sb.toString();
  }
}
