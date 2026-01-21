import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.geometry.Pos;

public class AVLVisualizer extends BorderPane {
  public AVLVisualizer() {
    drawGUI();
  }

  private void drawGUI() {
    AVLPane aPane = new AVLPane();
    aPane.setStyle("-fx-border-color: black");

    Text tEnter = new Text("Enter a key:");
    TextField tfEnter = new TextField();
    tfEnter.setPrefColumnCount(5);
    Button btSearch = new Button("Search");
    Button btInsert = new Button("Insert");
    Button btRemove = new Button("Remove");

    btSearch.setOnAction(e -> {
      if (tfEnter.getText().isEmpty()) { return; }
      aPane.search(Integer.parseInt(tfEnter.getText()));
    });

    btInsert.setOnAction(e -> {
      if (tfEnter.getText().isEmpty()) { return; }
      aPane.insert(Integer.parseInt(tfEnter.getText()));
    });

    btRemove.setOnAction(e -> {
      if (tfEnter.getText().isEmpty()) { return; }
      aPane.delete(Integer.parseInt(tfEnter.getText()));
    });

    HBox hbControl = new HBox(10);
    hbControl.getChildren().addAll(tEnter, tfEnter,
      btSearch, btInsert, btRemove);
    hbControl.setAlignment(Pos.CENTER);

    setCenter(aPane);
    setBottom(hbControl);
  }
}
