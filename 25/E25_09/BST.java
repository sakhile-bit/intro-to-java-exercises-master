import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;
import java.util.LinkedList;

public class BST<E extends Comparable<E>> extends AbstractTree<E> implements Cloneable {
  protected TreeNode<E> root;
  protected int size = 0;

  public BST() {
  }

  public BST(E[] objects) {
    for (int i = 0; i < objects.length; i++) {
      insert(objects[i]);
    }
  }

  @Override
  public boolean search(E e) {
    TreeNode<E> current = root;

    while (current != null) {
      if (e.compareTo(current.element) < 0) {
        current = current.left;
      } else if (e.compareTo(current.element) > 0) {
        current = current.right;
      } else {
        return true;
      }
    }

    return false;
  }

  @Override
  public boolean insert(E e) {
    if (root == null) {
      root = createNewNode(e);
    } else {
      TreeNode<E> parent = null;
      TreeNode<E> current = root;
      while (current != null) {
        if (e.compareTo(current.element) < 0){
          parent = current;
          current = current.left;
        } else if (e.compareTo(current.element) > 0) {
          parent = current;
          current = current.right;
        } else {
          return false;
        }
      }

      if (e.compareTo(parent.element) < 0) {
        parent.left = createNewNode(e);
      } else {
        parent.right = createNewNode(e);
      }
    }

    size++;
    return true;
  }

  protected TreeNode<E> createNewNode(E e) {
    return new TreeNode<>(e);
  }

  @Override
  public void inorder() {
    inorder(root);
  }

  protected void inorder(TreeNode<E> root) {
    if (root == null) { return; }
    inorder(root.left);
    System.out.print(root.element + " ");
    inorder(root.right);
  }

  public ArrayList<E> inorderList() {
    ArrayList<E> list = new ArrayList<>();
    inorderList(list, root);
    return list;
  }

  private void inorderList(ArrayList<E> list, TreeNode<E> node) {
    if (node == null) { return; }
    inorderList(list, node.left);
    list.add(node.element);
    inorderList(list, node.right);
  }

  @Override
  public void postorder() {
    postorder(root);
  }

  protected void postorder(TreeNode<E> root) {
    if (root == null) { return; }
    postorder(root.left);
    postorder(root.right);
    System.out.print(root.element + " ");
  }

  @Override
  public void preorder() {
    preorder(root);
  }

  protected void preorder(TreeNode<E> root) {
    if (root == null) { return; }
    System.out.print(root.element + " ");
    preorder(root.left);
    preorder(root.right);
  }

  public static class TreeNode<E extends Comparable<E>> {
    protected E element;
    protected TreeNode<E> left;
    protected TreeNode<E> right;

    public TreeNode(E e) {
      element = e;
    }
  }

  @Override
  public int getSize() {
    return size;
  }

  public TreeNode<E> getRoot() {
    return root;
  }

  public ArrayList<TreeNode<E>> path(E e) {
    ArrayList<TreeNode<E>> list = new ArrayList<>();
    TreeNode<E> current = root;

    while (current != null) {
      list.add(current);
      if (e.compareTo(current.element) < 0) {
        current = current.left;
      } else if (e.compareTo(current.element) > 0) {
        current = current.right;
      } else {
        break;
      }
    }

    return list;
  }

  @Override
  public boolean delete(E e) {
    TreeNode<E> parent = null;
    TreeNode<E> current = root;
    while (current != null) {
      if (e.compareTo(current.element) < 0) {
        parent = current;
        current = current.left;
      } else if (e.compareTo(current.element) > 0) {
        parent = current;
        current = current.right;
      } else {
        break;
      }
    }

    if (current == null) {
      return false;
    }

    if (current.left == null) {
      if (parent == null) {
        root = current.right;
      } else {
        if (e.compareTo(parent.element) < 0) {
          parent.left = current.right;
        } else {
          parent.right = current.right;
        }
      }
    } else {
      TreeNode<E> parentOfRightmost = current;
      TreeNode<E> rightmost = current.left;

      while (rightmost.right != null) {
        parentOfRightmost = rightmost;
        rightmost = rightmost.right;
      }

      current.element = rightmost.element;

      if (parentOfRightmost.right == rightmost) {
        parentOfRightmost.right = rightmost.left;
      } else {
        parentOfRightmost.left = rightmost.left;
      }
    }

    size--;
    return true;
  }

  @Override
  protected Object clone() {
    BST<E> copy = new BST<>();
    Iterator<E> iter = new BreadthFirstIterator();
    while (iter.hasNext()) {
      copy.insert(iter.next());
    }
    return copy;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) { return true; }
    if (!(obj instanceof BST)) { return false; }
    BST<E> c = (BST<E>)obj;
    ArrayList<E> list1 = inorderList();
    ArrayList<E> list2 = c.inorderList();
    return list1.equals(list2);
  }

  @Override
  public Iterator<E> iterator() {
    return new InorderIterator();
  }

  private class InorderIterator implements Iterator<E> {
    private ArrayList<E> list = new ArrayList<>();
    private int current = 0;

    public InorderIterator() {
      inorder();
    }

    private void inorder() {
      inorder(root);
    }

    private void inorder(TreeNode<E> root) {
      if (root == null) { return; }
      inorder(root.left);
      list.add(root.element);
      inorder(root.right);
    }

    @Override
    public boolean hasNext() {
      if (current < list.size()) {
        return true;
      }
      return false;
    }

    @Override
    public E next() {
      return list.get(current++);
    }

    @Override
    public void remove() {
      delete(list.get(current));
      list.clear();
      inorder();
    }
  }

  private class BreadthFirstIterator implements Iterator<E> {
    private ArrayList<E> list = new ArrayList<>();
    private int current = 0;

    public BreadthFirstIterator() {
      breadthFirst();
    }

    private void breadthFirst() {
      if (root == null) { return; }
      Queue<TreeNode<E>> queue = new LinkedList<>();
      queue.offer(root);
      while (!queue.isEmpty()) {
        TreeNode<E> node = queue.poll();
        list.add(node.element);
        if (node.left != null) { queue.offer(node.left); }
        if (node.right != null) { queue.offer(node.right); }
      }
    }

    @Override
    public boolean hasNext() {
      if (current < list.size()) {
        return true;
      }
      return false;
    }

    @Override
    public E next() {
      return list.get(current++);
    }
  }

  public void clear() {
    root = null;
    size = 0;
  }
}
