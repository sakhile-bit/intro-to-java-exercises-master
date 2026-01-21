import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

public class Consecutives extends BorderPane {
  private int rows;
  private int columns;
  private int[][] matrix;
  private TextField[][] tfMatrix;
  private Text tHeader;
  private static final String SUCCESS = "A consecutive four found";
  private static final String FAILURE = "No consecutive four found";
  private static final String HIGHLIGHT = "-fx-border-color: red";

  public Consecutives() {
    rows = 6;
    columns = 7;
    matrix = initializeMatrix(); // create backing matrix with random values
    tfMatrix = getTFMatrix(); // create TextField matrix to match it

    drawInterface();
  }

  public void drawInterface() {
    drawHeader();
    drawBody();
    drawFooter();
  }

  public void drawHeader() {
    tHeader = new Text();

    setTop(tHeader);
    setAlignment(tHeader, Pos.CENTER);
    setMargin(tHeader, new Insets(15, 15, 0, 15));
  }

  public void drawBody() {
    GridPane gpBody = new GridPane();
    gpBody.setAlignment(Pos.CENTER);
    gpBody.setHgap(5);
    gpBody.setVgap(5);
    for (int i = 0; i < tfMatrix.length; i++) {
      for (int j = 0; j < tfMatrix[i].length; j++) {
        gpBody.add(tfMatrix[i][j], j, i);
      }
    }

    setCenter(gpBody);
    setMargin(gpBody, new Insets(15));
  }

  public void drawFooter() {
    Button btSolve = new Button("Solve");

    btSolve.setOnAction(e -> findConsecutives());

    setBottom(btSolve);
    setAlignment(btSolve, Pos.CENTER);
    setMargin(btSolve, new Insets(0, 15, 15, 15));
  }

  private void findConsecutives() {
    // Remove any highlights from previous consecutive matches
    resetTFStyle();

    // Check that TextField values are valid
    if (!isValid()) {
      tHeader.setText("Single-digit entry only");
      return;
    }

    // Update the backing int[] matrix to match the TextField matrix
    matrix = getMatrix();

    // Search the rows
    for (int i = 0; i < matrix.length; i++) {
      int guess = matrix[i][0];
      int count = 1;
      int[] info = {0, 0, guess, count, 1};
      for (int j = 1; j < matrix[i].length; j++) {
        info[0] = i;
        info[1] = j;
        if (foundConsecutiveFour(info)) {
          return;
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
          return;
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
          return;
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
          return;
        }
      }
    }

    // Search left-rising diagonals (starting right side)
    for (int i = 3; i < matrix.length; i++) {
      int guess = matrix[i][matrix[0].length - 1];
      int count = 1;
      int[] info = {0, 0, guess, count, 4};
      for (int j = i - 1, k = matrix[0].length - 2; j >= 0 && k >= 0; j--, k--) {
        info[0] = j;
        info[1] = k;
        if (foundConsecutiveFour(info)) {
          return;
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
          return;
        }
      }
    }

    tHeader.setText(FAILURE);
  }

  private boolean foundConsecutiveFour(int[] info) {
    int i = info[0];
    int j = info[1];

    if (matrix[i][j] == info[2]) {
      info[3]++;
      if (info[3] == 4) {
        tHeader.setText(SUCCESS);
        markConsecutiveFour(i, j, info[4]);
        return true;
      }
    } else {
      info[2] = matrix[i][j];
      info[3] = 1;
    }
    return false;
  }

  private void markConsecutiveFour(int row, int col, int type) {
    if (type == 1) { // represents horizontal search
      for (int i = col; i > col - 4; i--) {
        tfMatrix[row][i].setStyle(HIGHLIGHT);
      }
    } else if (type == 2) { // represents vertical search
      for (int i = row; i > row - 4; i--) {
        tfMatrix[i][col].setStyle(HIGHLIGHT);
      }
    } else if (type == 3) { // represents right-rising diagonal search
      for (int i = row, j = col; i < row + 4; i++, j--) {
        tfMatrix[i][j].setStyle(HIGHLIGHT);
      }
    } else if (type == 4) { // represents left-rising diagonal search
      for (int i = row, j = col; i < row + 4; i++, j++) {
        tfMatrix[i][j].setStyle(HIGHLIGHT);
      }
    }
  }

  private void resetTFStyle() {
    for (int i = 0; i < tfMatrix.length; i++) {
      for (int j = 0; j < tfMatrix[i].length; j++) {
        tfMatrix[i][j].setStyle("-fx-border-color: black");
      }
    }
  }

  // Check that TextFields only contain single digits
  private boolean isValid() {
    for (int i = 0; i < tfMatrix.length; i++) {
      for (int j = 0; j < tfMatrix[i].length; j++) {
        String text = tfMatrix[i][j].getText();
        if (text.length() != 1) { return false; }
        if (!Character.isDigit(text.charAt(0))) { return false; }
      }
    }
    return true;
  }

  // Updates the backing int[] matrix to match current TextField matrix values
  private int[][] getMatrix() {
    int[][] m = new int[rows][columns];
    for (int i = 0; i < m.length; i++) {
      for (int j = 0; j < m[i].length; j++) {
        int num = Integer.parseInt(tfMatrix[i][j].getText());
        m[i][j] = num;
      }
    }
    return m;
  }

  // Creates the initial TextField matrix based on backing int[] matrix
  private TextField[][] getTFMatrix() {
    TextField[][] tf = new TextField[rows][columns];
    for (int i = 0; i < tf.length; i++) {
      for (int j = 0; j < tf[i].length; j++) {
        TextField t = new TextField();
        t.setPrefColumnCount(1);
        t.setAlignment(Pos.CENTER);
        t.setStyle("-fx-border-color: black");
        t.setText(String.valueOf(matrix[i][j]));
        tf[i][j] = t;
      }
    }
    return tf;
  }

  // Creates the initial backing int[] matrix with random values
  private int[][] initializeMatrix() {
    int[][] m = new int[rows][columns];
    for (int i = 0; i < m.length; i++) {
      for (int j = 0; j < m[i].length; j++) {
        m[i][j] = (int)(Math.random() * 10);
      }
    }
    return m;
  }
}
