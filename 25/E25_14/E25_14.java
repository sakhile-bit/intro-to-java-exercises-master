/*
  Revise BST in Listing 25.5, using a generic parameter and a Comparator for
  comparing objects. Define a new constructor with a Comparator as its
  argument as follows:

  BST(Comparator<? super E> comparator)
*/

public class E25_14 {
  public static void main(String[] args) {
    BST<String> tree1 = new BST<>(new DescendingComparator<String>());
    tree1.insert("George");
    tree1.insert("Ben");
    tree1.insert("Mark");

    tree1.breadthFirst();
    System.out.println();
    System.out.println(tree1.search("Mark"));
    System.out.println(tree1.search("Nick"));

    tree1.insert("Adam");
    tree1.insert("Carl");
    tree1.insert("Mack");
    tree1.insert("Nick");

    tree1.breadthFirst();
    System.out.println();

    tree1.delete("George");
    tree1.breadthFirst();
    System.out.println();

    tree1.inorder();
    System.out.println();

    System.out.println();

    BST<String> tree2 = new BST<>();
    tree2.insert("George");
    tree2.insert("Ben");
    tree2.insert("Mark");

    tree2.breadthFirst();
    System.out.println();
    System.out.println(tree2.search("Ben"));
    System.out.println(tree2.search("Carl"));

    tree2.insert("Adam");
    tree2.insert("Carl");
    tree2.insert("Mack");
    tree2.insert("Nick");

    tree2.breadthFirst();
    System.out.println();

    tree2.delete("Mark");
    tree2.breadthFirst();
    System.out.println();

    tree2.inorder();
    System.out.println();
  }
}
