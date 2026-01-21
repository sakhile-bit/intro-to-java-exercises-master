import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.geometry.Pos;

public class SudokuGUI extends BorderPane {
  private int numOfSolutions;

  public SudokuGUI() {
    drawGUI();
  }

  private void drawGUI() {
    Text tMessage = new Text();
    SudokuPane sPane = new SudokuPane();
    Button btSolve = new Button("Solve");
    Button btClear = new Button("Clear");
    Button btNext = new Button("Next");
    btNext.setVisible(false);

    btSolve.setOnAction(e -> solve(sPane, tMessage, btSolve, btNext));
    btClear.setOnAction(e -> clear(sPane, tMessage, btSolve, btNext));
    btNext.setOnAction(e -> next(sPane, tMessage, btClear, btNext));

    HBox hbControl = new HBox(10);
    hbControl.getChildren().addAll(btSolve, btClear, btNext);
    hbControl.setAlignment(Pos.CENTER);

    setTop(tMessage);
    setCenter(sPane);
    setBottom(hbControl);
    setAlignment(tMessage, Pos.CENTER);
  }

  private void solve(SudokuPane sPane, Text tMessage, Button btSolve, Button btNext) {
    try {
      int result = sPane.solve();
      btSolve.setDisable(true);
      if (result == -1) {
        tMessage.setText("Only 1-9 or empty spaces allowed");
      } else if (result > 1) {
        numOfSolutions = result;
        tMessage.setText("1/" + result + " solutions");
        btNext.setVisible(true);
      }
    } catch (IllegalArgumentException ex) {
      tMessage.setText("Invalid Sudoku Grid");
    }
  }

  private void clear(SudokuPane sPane, Text tMessage, Button btSolve, Button btNext) {
    sPane.clear();
    tMessage.setText("");
    btSolve.setDisable(false);
    btNext.setVisible(false);
    btNext.setDisable(false);
  }

  private void next(SudokuPane sPane, Text tMessage, Button btClear, Button btNext) {
    int count = sPane.next();
    tMessage.setText(count + "/" + numOfSolutions + " solutions");
    if (count == numOfSolutions) {
      btNext.setDisable(true);
      btClear.requestFocus();
    }
  }
}
