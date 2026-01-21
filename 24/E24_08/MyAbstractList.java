public abstract class MyAbstractList implements MyList {
  protected int size = 0;

  protected MyAbstractList() {
  }

  protected MyAbstractList(Integer[] objects) {
    for (int i = 0; i < objects.length; i++) {
      add(objects[i]);
    }
  }

  @Override
  public void add(Integer e) {
    add(size, e);
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean remove(Integer e) {
    if (indexOf(e) >= 0) {
      remove(indexOf(e));
      return true;
    }
    return false;
  }
}
