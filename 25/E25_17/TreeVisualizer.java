import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;

public class TreeVisualizer extends BorderPane {
  public TreeVisualizer() {
    drawGUI();
  }

  private void drawGUI() {
    TreePane tPane = new TreePane();
    Text tEnterText = new Text("Enter a text:");
    Text tEnterBitString = new Text("Enter a bit string:");
    TextField tfEnterText = new TextField();
    TextField tfEnterBitString = new TextField();
    Button btShow = new Button("Show Huffman Tree");
    Button btDecode = new Button("Decode to Text");

    HBox hbText = new HBox(10);
    hbText.getChildren().addAll(tEnterText, tfEnterText, btShow);
    hbText.setAlignment(Pos.CENTER);
    HBox hbBit = new HBox(10);
    hbBit.getChildren().addAll(tEnterBitString, tfEnterBitString, btDecode);
    hbBit.setAlignment(Pos.CENTER);
    VBox vbControl = new VBox(10);
    vbControl.getChildren().addAll(hbText, hbBit);
    vbControl.setAlignment(Pos.CENTER);

    btShow.setOnAction(e -> {
      if (!tfEnterText.getText().isEmpty()) {
        tPane.show(tfEnterText.getText());
      }
    });

    btDecode.setOnAction(e -> {
      if (tPane.hasTree() && !tfEnterBitString.getText().isEmpty()) {
        tPane.decode(tfEnterBitString.getText());
      }
    });

    setTop(vbControl);
    setCenter(tPane);
  }
}
