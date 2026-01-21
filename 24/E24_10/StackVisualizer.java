import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.geometry.Pos;

public class StackVisualizer extends BorderPane {
  public StackVisualizer() {
    drawGUI();
  }

  private void drawGUI() {
    StackPane sPane = new StackPane();
    sPane.setStyle("-fx-border-color: black");

    Text tEnter = new Text("Enter a value:");
    TextField tfEnter = new TextField();
    tfEnter.setPrefColumnCount(3);
    Button btPush = new Button("Push");
    Button btPop = new Button("Pop");

    btPush.setOnAction(e -> {
      if (tfEnter.getText().isEmpty()) { return; }
      sPane.push(Integer.parseInt(tfEnter.getText()));
    });

    btPop.setOnAction(e -> sPane.pop());

    HBox hbControl = new HBox(10);
    hbControl.getChildren().addAll(tEnter, tfEnter, btPush, btPop);
    hbControl.setAlignment(Pos.CENTER);

    setCenter(sPane);
    setBottom(hbControl);
  }
}
