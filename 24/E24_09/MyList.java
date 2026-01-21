public interface MyList extends java.lang.Iterable {
  public void add(Integer e);
  public void add(int index, Integer e);
  public void clear();
  public boolean contains(Integer e);
  public Integer get(int index);
  public int indexOf(Integer e);
  public boolean isEmpty();
  public int lastIndexOf(Integer e);
  public int remove(Integer e);
  public Integer remove(int index);
  public Object set(int index, Integer e);
  public int size();
}
