import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

public class EightQueensGUI extends GridPane {
  private EightQueens eq;

  public EightQueensGUI() {
    eq = new EightQueens();
    drawGUI();
  }

  private void drawGUI() {
    boolean[][] board = eq.getBoard();
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        Rectangle r = new Rectangle(50, 50);
        r.setStroke(Color.BLACK);
        r.setFill(board[i][j] ? Color.RED : Color.WHITE);
        add(r, j, i);
      }
    }
  }
}
