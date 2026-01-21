import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.geometry.Pos;

public class PartitionVisualizer extends BorderPane {

  public PartitionVisualizer() {
    drawGUI();
  }

  private void drawGUI() {
    Text tMessage = new Text();

    PartitionPane pPane = new PartitionPane();
    pPane.setStyle("-fx-border-color: black");

    Button btStep = new Button("Step");
    Button btReset = new Button("Reset");

    btStep.setOnAction(e -> {
      tMessage.setText(pPane.step() ? "FINISHED" : "");
    });
    btReset.setOnAction(e -> {
      tMessage.setText("");
      pPane.reset();
    });

    HBox hbControl  = new HBox(10);
    hbControl.getChildren().addAll(btStep, btReset);
    hbControl.setAlignment(Pos.CENTER);

    setTop(tMessage);
    setCenter(pPane);
    setBottom(hbControl);
    setAlignment(tMessage, Pos.CENTER);
  }
}
