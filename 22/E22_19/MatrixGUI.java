import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.geometry.Pos;
import javafx.event.ActionEvent;

public class MatrixGUI extends BorderPane {
  private int rows;
  private int columns;

  public MatrixGUI(int rows, int columns) {
    this.rows = rows;
    this.columns = columns;
    drawGUI();
  }

  private void drawGUI() {
    Text tMessage = new Text();
    MatrixPane mPane = new MatrixPane(rows, columns);
    Button btRefresh = new Button("Refresh");
    Button btFindLargestBlock = new Button("Find Largest Block");

    btRefresh.setOnAction(e -> refresh(btFindLargestBlock, mPane, tMessage));
    btFindLargestBlock.setOnAction(e ->
      findLargestBlock(e, btRefresh, mPane, tMessage));

    HBox hbControl = new HBox(10);
    hbControl.getChildren().addAll(btRefresh, btFindLargestBlock);
    hbControl.setAlignment(Pos.CENTER);

    setTop(tMessage);
    setCenter(mPane);
    setBottom(hbControl);
    setAlignment(tMessage, Pos.CENTER);
  }

  private void findLargestBlock(
    ActionEvent event, Button button, MatrixPane mPane, Text text) {
    if (mPane.markLargestBlock()) {
      Button btSource = (Button)event.getSource();
      btSource.setDisable(true); // disable the Find Largest Block button
      button.requestFocus(); // give focus to the Refresh button
      text.setText("");
    } else {
      text.setText("Matrix must contain only 0s and 1s");
    }
  }

  private void refresh(Button button, MatrixPane mPane, Text text) {
    mPane.reset();
    button.setDisable(false); // reenable the Find Largest Block button
    text.setText("");
  }
}
