import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class BTView extends Pane {
  private BST<Integer> tree = new BST<>();
  private double radius = 15;
  private double vGap = 50;

  BTView(BST<Integer> tree) {
    this.tree = tree;
    setStatus("Tree is empty");
  }

  public void setStatus(String msg) {
    getChildren().add(new Text(20, 40, msg));
  }

  public void displayTree() {
    this.getChildren().clear();
    if (tree.getRoot() != null) {
      displayTree(tree.getRoot(), getWidth() / 2, vGap, getWidth() / 4);
    }
  }

  public void displayTree(BST.TreeNode<Integer> root, double x, double y,
    double hGap) {
    if (root.left != null) {
      getChildren().add(new Line(x - hGap, y + vGap, x, y));
      displayTree(root.left, x - hGap, y + vGap, hGap / 2);
    }

    if (root.right != null) {
      getChildren().add(new Line(x + hGap, y + vGap, x, y));
      displayTree(root.right, x + hGap, y + vGap, hGap / 2);
    }

    Circle circle = new Circle(x, y, radius);
    circle.setFill(Color.WHITE);
    circle.setStroke(Color.BLACK);
    getChildren().addAll(circle, new Text(x - 4, y + 4, root.element + ""));
  }

  public void displayOrder(Order order) {
    StringBuilder sb = new StringBuilder();
    if (order.equals(Order.INORDER)) {
      sb.append("Inorder: [");
      for (Integer num: tree.inorderList()) {
        sb.append(num + " ");
      }
      sb.append("]");
    } else if (order.equals(Order.PREORDER)) {
      sb.append("Preorder: [");
      for (Integer num: tree.preorderList()) {
        sb.append(num + " ");
      }
      sb.append("]");
    } else if (order.equals(Order.POSTORDER)) {
      sb.append("Postorder: [");
      for (Integer num: tree.postorderList()) {
        sb.append(num + " ");
      }
      sb.append("]");
    }
    getChildren().add(new Text(getWidth() / 2 - 50, 20, sb.toString()));
  }

  enum Order {
    INORDER, PREORDER, POSTORDER;
  }
}
