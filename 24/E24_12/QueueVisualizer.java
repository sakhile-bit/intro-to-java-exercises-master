import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.geometry.Pos;

public class QueueVisualizer extends BorderPane {
  public QueueVisualizer() {
    drawGUI();
  }

  private void drawGUI() {
    QueuePane qPane = new QueuePane();
    qPane.setStyle("-fx-border-color: black");

    Text tEnter = new Text("Enter a value:");
    TextField tfEnter = new TextField();
    tfEnter.setPrefColumnCount(3);
    Button btEnqueue = new Button("Enqueue");
    Button btDequeue = new Button("Dequeue");

    btEnqueue.setOnAction(e -> {
      if (tfEnter.getText().isEmpty()) { return; }
      qPane.enqueue(Integer.parseInt(tfEnter.getText()));
    });

    btDequeue.setOnAction(e -> qPane.dequeue());

    HBox hbControl = new HBox(10);
    hbControl.getChildren().addAll(tEnter, tfEnter, btEnqueue, btDequeue);
    hbControl.setAlignment(Pos.CENTER);

    setCenter(qPane);
    setBottom(hbControl);
  }
}
