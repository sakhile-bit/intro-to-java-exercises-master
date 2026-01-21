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
    Button btSearch = new Button("Search");
    Button btInsert = new Button("Insert");
    Button btDelete = new Button("Delete");
    Button btTrim = new Button("Trim to Size");

    tfEnter.setPrefColumnCount(5);
    tfIndex.setPrefColumnCount(3);

    btSearch.setOnAction(e -> {
      if (isValidEntry(tfEnter.getText())) {
        aPane.search(Integer.parseInt(tfEnter.getText()));
      }
    });

    btInsert.setOnAction(e -> {
      if (!isValidEntry(tfEnter.getText())) { return; }
      if (!isValidEntry(tfIndex.getText())) {
        aPane.insert(Integer.parseInt(tfEnter.getText()), -1);
      } else {
        aPane.insert(Integer.parseInt(tfEnter.getText()),
        Integer.parseInt(tfIndex.getText()));
      }
    });

    btDelete.setOnAction(e -> {
      if (isValidEntry(tfEnter.getText())) {
        aPane.delete(Integer.parseInt(tfEnter.getText()));
      }
    });

    btTrim.setOnAction(e -> aPane.trimToSize());

    HBox hbControl = new HBox(10);
    hbControl.getChildren().addAll(tEnter, tfEnter, tIndex, tfIndex,
      btSearch, btInsert, btDelete, btTrim);
    hbControl.setAlignment(Pos.CENTER);

    setCenter(aPane);
    setBottom(hbControl);
  }

  private boolean isValidEntry(String text) {
    if (text.isEmpty()) { return false; }
    for (int i = 0; i < text.length(); i++) {
      char c = text.charAt(i);
      if (i == 0 && c == '-') { continue; }
      if (!Character.isDigit(c)) { return false; }
    }
    return true;
  }
}
