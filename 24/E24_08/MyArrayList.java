public class MyArrayList extends MyAbstractList {
  public static final int INITIAL_CAPACITY = 16;
  private Integer[] data = new Integer[INITIAL_CAPACITY];

  public MyArrayList() {
  }

  public MyArrayList(Integer[] objects) {
    for (int i = 0; i < objects.length; i++) {
      add(objects[i]);
    }
  }

  public int getCapacity() {
    return data.length;
  }

  public Integer[] getData() {
    return data;
  }

  @Override
  public void add(int index, Integer e) {
    ensureCapacity();

    for (int i = size - 1; i >= index; i--) {
      data[i + 1] = data[i];
    }

    data[index] = e;
    size++;
  }

  private void ensureCapacity() {
    if (size >= data.length) {
      Integer[] newData = new Integer[size * 2 + 1];
      System.arraycopy(data, 0, newData, 0, size);
      data = newData;
    }
  }

  @Override
  public void clear() {
    data = new Integer[INITIAL_CAPACITY];
    size = 0;
  }

  @Override
  public boolean contains(Integer e) {
    for (int i = 0; i < size; i++) {
      if (e.equals(data[i])) { return true; }
    }
    return false;
  }

  @Override
  public Integer get(int index) {
    checkIndex(index);
    return data[index];
  }

  private void checkIndex(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("index " + index + " out of bounds");
    }
  }

  @Override
  public int indexOf(Integer e) {
    for (int i = 0; i < size; i++) {
      if (e.equals(data[i])) { return i; }
    }
    return -1;
  }

  @Override
  public int lastIndexOf(Integer e) {
    for (int i = size - 1; i >= 0; i--) {
      if (e.equals(data[i])) { return i; }
    }
    return -1;
  }

  @Override
  public Integer remove(int index) {
    checkIndex(index);

    Integer e = data[index];

    for (int j = index; j < size - 1; j++) {
      data[j] = data[j + 1];
    }

    data[size - 1] = null;
    size--;
    return e;
  }

  @Override
  public Integer set(int index, Integer e) {
    checkIndex(index);
    Integer old = data[index];
    data[index] = e;
    return old;
  }

  @Override
  public String toString() {
    StringBuilder result = new StringBuilder("[");

    for (int i = 0; i < size; i++) {
      result.append(data[i]);
      if (i < size - 1) { result.append(", "); }
    }

    return result.toString() + "]";
  }

  public void trimToSize() {
    if (size != data.length) {
      Integer[] newData = new Integer[size];
      System.arraycopy(data, 0, newData, 0, size);
      data = newData;
    }
  }

  @Override
  public java.util.Iterator<Integer> iterator() {
    return new ArrayListIterator();
  }

  private class ArrayListIterator implements java.util.Iterator<Integer> {
    private int current = 0;

    @Override
    public boolean hasNext() {
      return (current < size);
    }

    @Override
    public Integer next() {
      return data[current++];
    }

    @Override
    public void remove() {
      MyArrayList.this.remove(current);
    }
  }
}
