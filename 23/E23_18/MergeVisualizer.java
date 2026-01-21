import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.geometry.Pos;

public class MergeVisualizer extends BorderPane {

  public MergeVisualizer() {
    drawGUI();
  }

  private void drawGUI() {
    Text tMessage = new Text();

    MergePane mPane = new MergePane();
    mPane.setStyle("-fx-border-color: black");

    Button btStep = new Button("Step");
    Button btReset = new Button("Reset");

    btStep.setOnAction(e -> {
      tMessage.setText(mPane.step() ? "FINISHED" : "");
    });
    btReset.setOnAction(e -> {
      tMessage.setText("");
      mPane.reset();
    });

    HBox hbControl  = new HBox(10);
    hbControl.getChildren().addAll(btStep, btReset);
    hbControl.setAlignment(Pos.CENTER);

    setTop(tMessage);
    setCenter(mPane);
    setBottom(hbControl);
    setAlignment(tMessage, Pos.CENTER);
  }
}
