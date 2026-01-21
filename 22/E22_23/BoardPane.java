import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;
import javafx.geometry.Pos;

public class BoardPane extends BorderPane {
  private Integer[] board;
  private Label[][] labels;
  private int solutionNumber;

  public BoardPane(Integer[] board, int solutionNumber) {
    this.board = board;
    labels = new Label[board.length][board.length];
    this.solutionNumber = solutionNumber;
    drawGUI();
  }

  public Label[][] getLabels() {
    return labels;
  }

  private void drawGUI() {
    Text tSolution = new Text("Solution " + solutionNumber);

    GridPane boardGrid = new GridPane();
    boardGrid.setAlignment(Pos.CENTER);
    for (int row = 0; row < board.length; row++) {
      for (int col = 0; col < board.length; col++) {
        Label label = new Label();
        label.setPrefSize(55, 55);
        label.setStyle("-fx-border-color: black");
        labels[row][col] = label;
        boardGrid.add(label, col, row);
      }
    }

    Image queen = new Image("queen.jpg");
    for (int row = 0; row < board.length; row++) {
      labels[row][board[row]].setGraphic(new ImageView(queen));
    }

    setTop(tSolution);
    setCenter(boardGrid);
    setAlignment(tSolution, Pos.CENTER);
  }
}
