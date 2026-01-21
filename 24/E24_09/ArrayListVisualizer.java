import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.geometry.Pos;

public class ArrayListVisualizer extends BorderPane {
  public ArrayListVisualizer() {
    drawGUI();
  }

  private void drawGUI() {
    ArrayListPane aPane = new ArrayListPane();
    aPane.setStyle("-fx-border-color: black");

    Text tEnter = new Text("Enter a value:");
    Text tIndex = new Text("Enter an index:");
    TextField tfEnter = new TextField();
    TextField tfIndex = new TextField();
    tfEnter.setPrefColumnCount(5);
    tfEnter.setPrefColumnCount(3);
    Button btInsert = new Button("Insert");
    Button btDelete = new Button("Delete");
    Button btSearch = new Button("Search");

    btInsert.setOnAction(e -> {
      if (tfIndex.getText().isEmpty()) {
        aPane.insert(Integer.parseInt(tfEnter.getText()), -1);
      } else {
        aPane.insert(Integer.parseInt(tfEnter.getText()),
        Integer.parseInt(tfIndex.getText()));
      }
    });

    btDelete.setOnAction(e -> {
      if (tfEnter.getText().isEmpty()) {
        return;
      } else {
        aPane.delete(Integer.parseInt(tfEnter.getText()));
      }
    });

    btSearch.setOnAction(e -> {
      if (tfEnter.getText().isEmpty()) {
        return;
      } else {
        aPane.search(Integer.parseInt(tfEnter.getText()));
      }
    });

    HBox hbControl = new HBox(10);
    hbControl.getChildren().addAll(tEnter, tfEnter, tIndex, tfIndex,
      btSearch, btInsert, btDelete);
    hbControl.setAlignment(Pos.CENTER);

    setCenter(aPane);
    setBottom(hbControl);
  }
}
