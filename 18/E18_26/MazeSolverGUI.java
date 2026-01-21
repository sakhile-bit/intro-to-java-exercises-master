import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.input.MouseEvent;
import javafx.geometry.Pos;

public class MazeSolverGUI extends BorderPane {
  private int rows;
  private int cols;
  private GridPane gpMaze;
  private char[][] backingMaze;
  private MazeSolver mazeSolver;

  public MazeSolverGUI(int rows, int cols) {
    this.rows = rows;
    this.cols = cols;
    initialize(rows, cols);
  }

  private void initialize(int rows, int cols) {
    backingMaze = MazeSolver.getInitialMatrix(rows, cols);
    drawMaze();
  }

  private void drawMaze() {
    gpMaze = new GridPane();
    for (int i = 0; i < backingMaze.length; i++) {
      for (int j = 0; j < backingMaze[i].length; j++) {
        Rectangle r = new Rectangle(50, 50);
        if (backingMaze[i][j] == '.') {
          r.setFill(Color.WHITE);
        } else if (backingMaze[i][j] == 'X') {
          r.setFill(Color.RED);
        } else if (backingMaze[i][j] == '@') {
          r.setFill(Color.GREEN);
        }
        r.setStroke(Color.BLACK);
        r.setOnMouseClicked(e -> placeWall(e));
        gpMaze.add(r, j, i);
      }
    }

    Button btFindPath = new Button("Find Path");
    Button btClearPath = new Button("Clear Path");

    btFindPath.setOnAction(e -> findPath());
    btClearPath.setOnAction(e -> clearPath());

    HBox hbButtons = new HBox(5);
    hbButtons.getChildren().addAll(btFindPath, btClearPath);
    hbButtons.setAlignment(Pos.CENTER);

    setCenter(gpMaze);
    setBottom(hbButtons);
  }

  private void placeWall(MouseEvent e) {
    Rectangle r = (Rectangle)e.getSource();
    int row = gpMaze.getRowIndex(r);
    int col = gpMaze.getColumnIndex(r);
    if (r.getFill().equals(Color.GREEN)) {
      return;
    }
    if (r.getFill().equals(Color.WHITE)) {
      r.setFill(Color.RED);
      backingMaze[row][col] = 'X';
    } else {
      r.setFill(Color.WHITE);
      backingMaze[row][col] = '.';
    }
  }

  private void findPath() {
    gpMaze.getChildren().clear();
    mazeSolver = new MazeSolver(backingMaze);
    backingMaze = mazeSolver.start();
    drawMaze();
  }

  private void clearPath() {
    gpMaze.getChildren().clear();
    initialize(rows, cols);
  }
}
