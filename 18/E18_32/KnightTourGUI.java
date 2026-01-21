import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Polyline;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import javafx.scene.input.MouseEvent;
import javafx.scene.Node;
import javafx.geometry.Pos;
import javafx.collections.ObservableList;
import java.util.ArrayList;

public class KnightTourGUI extends BorderPane {
  private static double squareSize;
  private static int boardSize;
  private GridPane gpBoard;
  private Pane pathPane;
  private StackPane stackPane;
  private Button btSolve;
  private Text tMessage;
  private int selectedRow;
  private int selectedColumn;
  private KnightTour kt;

  public KnightTourGUI(int boardSize, double squareSize) {
    this.boardSize = boardSize;
    this.squareSize = squareSize;
    drawGUI();
  }

  private void drawGUI() {
    gpBoard = new GridPane();
    for (int i = 0; i < boardSize; i++) {
      for (int j = 0; j < boardSize; j++) {
        Rectangle r = new Rectangle(squareSize, squareSize);
        r.setFill(Color.WHITE);
        r.setStroke(Color.BLACK);
        r.setOnMouseClicked(e -> selectStartingSquare(e));
        gpBoard.add(r, j, i);
      }
    }

    pathPane = new Pane();
    pathPane.setMinSize(
      squareSize * boardSize + boardSize, squareSize * boardSize + boardSize);

    stackPane = new StackPane();
    stackPane.getChildren().add(gpBoard);

    tMessage = new Text("Select a Square");

    btSolve = new Button("Solve");
    btSolve.setDisable(true);
    btSolve.setOnAction(e -> {
      if (btSolve.getText().equals("Solve")) {
        solve();
        btSolve.setText("Clear");
      } else if (btSolve.getText().equals("Clear")) {
        clear();
        btSolve.setText("Solve");
      }
    });

    setTop(tMessage);
    setCenter(stackPane);
    setBottom(btSolve);
    setAlignment(btSolve, Pos.CENTER);
    setAlignment(tMessage, Pos.CENTER);
  }

  private void selectStartingSquare(MouseEvent e) {
    if (btSolve.getText().equals("Solve")) {
      Rectangle r = (Rectangle)e.getSource();
      if (r.getFill().equals(Color.RED)) {
        r.setFill(Color.WHITE);
        tMessage.setText("Select a square");
        btSolve.setDisable(true);
      } else {
        paintBoardWhite();
        r.setFill(Color.RED);
        selectedRow = gpBoard.getRowIndex(r);
        selectedColumn = gpBoard.getColumnIndex(r);
        tMessage.setText(
          "Starting space: [" + selectedRow + ", " + selectedColumn + "]");
        btSolve.setDisable(false);
      }
    }
  }

  private void solve() {
    kt = new KnightTour(boardSize);
    ArrayList<Integer[]> path = kt.start(selectedRow, selectedColumn);
    drawPath(path);
  }

  private void clear() {
    stackPane.getChildren().remove(pathPane);
    pathPane.getChildren().clear();
  }

  private void drawPath(ArrayList<Integer[]> path) {
    Polyline p = new Polyline();
    for (int i = 0; i < path.size(); i++) {
      int pathRow = path.get(i)[0];
      int pathCol = path.get(i)[1];
      Rectangle r = (Rectangle)getNodeInGridPane(pathRow, pathCol);
      double x = r.getLayoutX() + squareSize / 2;
      double y = r.getLayoutY() + squareSize / 2;
      p.getPoints().addAll(x, y);
    }
    pathPane.getChildren().add(p);
    stackPane.getChildren().add(pathPane);
  }

  private Node getNodeInGridPane(int row, int col) {
    ObservableList<Node> list = gpBoard.getChildren();
    for (Node node: list) {
      if (gpBoard.getRowIndex(node) == row && gpBoard.getColumnIndex(node) == col) {
        return node;
      }
    }
    return null;
  }

  private void paintBoardWhite() {
    ObservableList<Node> list = gpBoard.getChildren();
    for (int i = 0; i < list.size(); i++) {
      Rectangle r = (Rectangle)list.get(i);
      r.setFill(Color.WHITE);
    }
  }
}
