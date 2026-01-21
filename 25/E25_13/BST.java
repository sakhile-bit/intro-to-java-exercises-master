import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class BST<E extends Comparable<E>> extends AbstractTree<E> {
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

  public List<E> inorderList() {
    List<E> list = new ArrayList<>();
    inorderList(root, list);
    return list;
  }

  private void inorderList(TreeNode<E> node, List<E> list) {
    if (node == null) { return; }
    inorderList(node.left, list);
    list.add(node.element);
    inorderList(node.right, list);
  }

  public List<E> preorderList() {
    List<E> list = new ArrayList<>();
    preorderList(root, list);
    return list;
  }

  private void preorderList(TreeNode<E> node, List<E> list) {
    if (node == null) { return; }
    list.add(node.element);
    preorderList(node.left, list);
    preorderList(node.right, list);
  }

  public List<E> postorderList() {
    List<E> list = new ArrayList<>();
    postorderList(root, list);
    return list;
  }

  private void postorderList(TreeNode<E> node, List<E> list) {
    if (node == null) { return; }
    postorderList(node.left, list);
    postorderList(node.right, list);
    list.add(node.element);
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

  public void clear() {
    root = null;
    size = 0;
  }
}
