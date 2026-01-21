/*
  Modify Listing 25.9, BSTAnimation.java, to add three new buttons--
  Show Inorder, Show Preorder, and Show Postorder--to display the result in a
  label. You also need to modify BST.java to implement the inorderList(),
  preorderList(), and postorderList() methods so that each of these methods
  returns a List of the node elements in inorder, preorder, and postorder, as
  follows:

  public List<E> inorderList();
  public List<E> preorderList();
  public List<E> postorderList();
*/

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class E25_13 extends Application {
  @Override
  public void start(Stage primaryStage) {
    BST<Integer> tree = new BST<>();

    BorderPane pane = new BorderPane();
    BTView view = new BTView(tree);
    pane.setCenter(view);

    TextField tfKey = new TextField();
    tfKey.setPrefColumnCount(3);
    tfKey.setAlignment(Pos.BASELINE_RIGHT);
    Button btInsert = new Button("Insert");
    Button btDelete = new Button("Delete");
    Button btInorder = new Button("Show Inorder");
    Button btPreorder = new Button("Show Preorder");
    Button btPostorder = new Button("Show Postorder");
    HBox hBox = new HBox(5);
    hBox.getChildren().addAll(new Label("Enter a key: "),
      tfKey, btInsert, btDelete, btInorder, btPreorder, btPostorder);
    hBox.setAlignment(Pos.CENTER);
    pane.setBottom(hBox);

    btInsert.setOnAction(e -> {
      int key = Integer.parseInt(tfKey.getText());
      if (tree.search(key)) {
        view.displayTree();
        view.setStatus(key + " is already in the tree");
      } else {
        tree.insert(key);
        view.displayTree();
        view.setStatus(key + " is inserted in the tree");
      }
    });

    btDelete.setOnAction(e -> {
      int key = Integer.parseInt(tfKey.getText());
      if (!tree.search(key)) {
        view.displayTree();
        view.setStatus(key + " is not in the tree");
      } else {
        tree.delete(key);
        view.displayTree();
        view.setStatus(key + " is deleted from the tree");
      }
    });

    btInorder.setOnAction(e -> view.displayOrder(BTView.Order.INORDER));
    btPreorder.setOnAction(e -> view.displayOrder(BTView.Order.PREORDER));
    btPostorder.setOnAction(e -> view.displayOrder(BTView.Order.POSTORDER));

    Scene scene = new Scene(pane, 600, 400);
    primaryStage.setTitle("E25_13");
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
