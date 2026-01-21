import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;

public class ConnectFour extends BorderPane {
  private static final double WIDTH = 700;
  private static final double HEIGHT = 600;
  private int whoseTurn;
  private Text tMessage; //
  private Circle[][] cMatrix; // array of references to Circle objects
  private int[][] matrix = new int[6][7]; // backing array for cMatrix
  private GridPane gpBoard; // GridPane containing the Circle objects
  private StackPane spBoard; // StackPane containing the backdrop and gpBoard

  // CONSTRUCTORS

  public ConnectFour() {
    play();
  }

  // CONTROL METHODS

  private void play() {
    drawGUI();

    // Randomly choose first player
    whoseTurn = (int)(Math.random() * 2);
    tMessage.setText(whoseTurn == 0 ? "BLUE's turn" : "RED's turn");
  }

  private void reset() {
    getChildren().clear();
    play();
  }

  // DRAWING / GUI METHODS

  private void drawGUI() {
    drawTop();
    drawCenter();
    drawBottom();
  }

  private void drawTop() {
    tMessage = new Text("MESSAGE");
    tMessage.setFont(Font.font("SansSerif", 30));
    setTop(tMessage);
    setAlignment(tMessage, Pos.CENTER);
  }

  private void drawCenter() {
    Rectangle backdrop = new Rectangle(0, 0, WIDTH, HEIGHT);
    backdrop.setFill(Color.BLACK);

    cMatrix = getGameBoard();
    gpBoard = new GridPane();
    for (int i = 0; i < cMatrix.length; i++) {
      for (int j = 0; j < cMatrix[i].length; j++) {
        gpBoard.add(cMatrix[i][j], j, i);
      }
    }

    spBoard = new StackPane();
    spBoard.getChildren().addAll(backdrop, gpBoard);

    setCenter(spBoard);
  }

  private void drawBottom() {
    Button btReset = new Button("Reset");
    btReset.setOnAction(e -> reset());
    setBottom(btReset);
    setAlignment(btReset, Pos.CENTER);
  }

  private void markConsecutiveFour(int row, int col, int type) {
    if (type == 1) { // represents horizontal search
      for (int i = col; i > col - 4; i--) {
        cMatrix[row][i].setFill(Color.YELLOW);
      }
    } else if (type == 2) { // represents vertical search
      for (int i = row; i > row - 4; i--) {
        cMatrix[i][col].setFill(Color.YELLOW);
      }
    } else if (type == 3) { // represents right-rising diagonal search
      for (int i = row, j = col; i < row + 4; i++, j--) {
        cMatrix[i][j].setFill(Color.YELLOW);
      }
    } else if (type == 4) { // represents left-rising diagonal search
      for (int i = row, j = col; i < row + 4; i++, j++) {
        cMatrix[i][j].setFill(Color.YELLOW);
      }
    }
  }

  private void coverBoard() {
    Rectangle rect = new Rectangle(0, 0, WIDTH, HEIGHT);
    rect.setFill(Color.TRANSPARENT);
    spBoard.getChildren().add(rect);
  }

  // GAMEPLAY METHODS

  private void placeTile(int row, int col, Circle c) {
    if (isValidSpace(row, col)) {
      c.setFill(whoseTurn == 0 ? Color.BLUE : Color.RED);

      if (isDraw()) {
        tMessage.setText("DRAW GAME");
        coverBoard(); // game over, prevent user interaction with circles
      } else if (isWinner()) {
        StringBuilder sb = new StringBuilder(" is the winner");
        sb.insert(0, (whoseTurn == 0 ? "BLUE" : "RED"));
        tMessage.setText(sb.toString());
        coverBoard(); // game over, prevent user interaction with circles
      } else {
        whoseTurn = whoseTurn == 0 ? 1 : 0;
        StringBuilder sb = new StringBuilder("'s turn");
        sb.insert(0, (whoseTurn == 0 ? "BLUE" : "RED"));
        tMessage.setText(sb.toString());
      }
    }
  }

  private boolean isValidSpace(int row, int col) {
    if (cMatrix[row][col].getFill().equals(Color.WHITE) &&
        (row == 5 || !cMatrix[row + 1][col].getFill().equals(Color.WHITE))) {
      return true;
    }
    return false;
  }

  private boolean isDraw() {
    for (int i = 0; i < cMatrix.length; i++) {
      for (int j = 0; j < cMatrix[i].length; j++) {
        if (cMatrix[i][j].getFill().equals(Color.WHITE)) {
          return false;
        }
      }
    }
    return true;
  }

  private boolean isWinner() {
    // for convenience, this method analyzes the backing int[] array, so first
    // step is to sync backing array with the cMatrix array of Circle objects
    updateBackingMatrix();

    // Search the rows
    for (int i = 0; i < matrix.length; i++) {
      int guess = matrix[i][0];
      int count = 1;
      int[] info = {0, 0, guess, count, 1};
      for (int j = 1; j < matrix[i].length; j++) {
        info[0] = i;
        info[1] = j;
        if (foundConsecutiveFour(info)) {
          return true;
        }
      }
    }

    // Search the columns
    for (int j = 0; j < matrix[0].length; j++) {
      int guess = matrix[0][j];
      int count = 1;
      int[] info = {0, 0, guess, count, 2};
      for (int i = 1; i < matrix.length; i++) {
        info[0] = i;
        info[1] = j;
        if (foundConsecutiveFour(info)) {
          return true;
        }
      }
    }

    // Search right-rising diagonals (starting left side)
    for (int i = 3; i < matrix.length; i++) {
      int guess = matrix[i][0];
      int count = 1;
      int[] info = {0, 0, guess, count, 3};
      for (int j = i - 1, k = 1; j >= 0 && k <= i; j--, k++) {
        info[0] = j;
        info[1] = k;
        if (foundConsecutiveFour(info)) {
          return true;
        }
      }
    }

    // Search right-rising diagonals (starting bottom)
    for (int i = 1; i <= 3; i++) {
      int guess = matrix[matrix.length - 1][i];
      int count = 1;
      int[] info = {0, 0, guess, count, 3};
      for (int j = matrix.length - 2, k = i + 1;
        j >= 0 && k < matrix[0].length; j--, k++) {
        info[0] = j;
        info[1] = k;
        if (foundConsecutiveFour(info)) {
          return true;
        }
      }
    }

    // Search left-rising diagonals (starting right side)
    for (int i = 3; i < matrix.length; i++) {
      int guess = matrix[i][matrix[0].length - 1];
      int count = 1;
      int[] info = {0, 0, guess, count, 4};
      for (int j = i - 1, k = matrix[0].length - 2;
        j >= 0 && k >= 0; j--, k--) {
        info[0] = j;
        info[1] = k;
        if (foundConsecutiveFour(info)) {
          return true;
        }
      }
    }

    // Search left-rising diagonals (starting bottom)
    for (int i = matrix[0].length - 2; i >= 3; i--) {
      int guess = matrix[matrix.length - 1][i];
      int count = 1;
      int[] info = {0, 0, guess, count, 4};
      for (int j = matrix.length - 2, k = i - 1; j >= 0 && k >= 0; j--, k--) {
        info[0] = j;
        info[1] = k;
        if (foundConsecutiveFour(info)) {
          return true;
        }
      }
    }

    return false;
  }

  private boolean foundConsecutiveFour(int[] info) {
    int i = info[0];
    int j = info[1];

    if (matrix[i][j] == info[2] && info[2] != -1) {
      info[3]++;
      if (info[3] == 4) {
        markConsecutiveFour(i, j, info[4]);
        return true;
      }
    } else {
      info[2] = matrix[i][j];
      info[3] = 1;
    }
    return false;
  }

  // DATA STRUCTURE MANAGEMENT METHODS

  private Circle[][] getGameBoard() {
    EventHandler<MouseEvent> clickCircle = e -> {
      Circle circle = (Circle)e.getSource();
      int row = gpBoard.getRowIndex(circle);
      int col = gpBoard.getColumnIndex(circle);
      placeTile(row, col, circle);
    };

    Circle[][] circ = new Circle[6][7];
    for (int i = 0; i < circ.length; i++) {
      for (int j = 0; j < circ[i].length; j++) {
        Circle c = new Circle(WIDTH / 7 / 2);
        c.setFill(Color.WHITE);
        c.setOnMouseClicked(clickCircle);
        circ[i][j] = c;
      }
    }
    return circ;
  }

  private void updateBackingMatrix() {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        if (cMatrix[i][j].getFill().equals(Color.WHITE)) {
          matrix[i][j] = -1; // empty space
        } else if (cMatrix[i][j].getFill().equals(Color.BLUE)) {
          matrix[i][j] = 0; // blue space
        } else if (cMatrix[i][j].getFill().equals(Color.RED)) {
          matrix[i][j] = 1; // red space
        }
      }
    }
  }
}
