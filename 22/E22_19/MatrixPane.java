import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.control.TextField;
import javafx.geometry.Pos;

public class MatrixPane extends GridPane {
  private int rows;
  private int columns;

  public MatrixPane(int rows, int columns) {
    this.rows = rows;
    this.columns = columns;
    drawEntryMatrix();
  }

  public void reset() {
    getChildren().clear();
    drawEntryMatrix();
  }

  public boolean markLargestBlock() {
    // check if the textfields all contain either 1 or 0
    if (!isEntryValid()) { return false; }
    int[][] matrix = getMatrix(); // get a backing int array for textfield vals
    drawResultMatrix(matrix); // find the largest block and color it in
    return true;
  }

  private void drawEntryMatrix() {
    for (int col = 0; col < columns; col++) {
      for (int row = 0; row < rows; row++) {
        int random = (int)(Math.random() * 2);
        TextField tf = new TextField(random + "");
        tf.setAlignment(Pos.CENTER);
        tf.setPrefColumnCount(1);
        add(tf, col, row);
      }
    }
  }

  private void drawResultMatrix(int[][] matrix) {
    // get the textfields and set all to non-editable
    TextField[][] textFields = getTextFields();
    for (int i = 0; i < textFields.length; i++) {
      for (int j = 0; j < textFields[i].length; j++) {
        textFields[i][j].setEditable(false);
      }
    }
    colorLargestBlock(matrix, textFields);
  }

  private void colorLargestBlock(int[][] matrix, TextField[][] textFields) {
    // find the largest block of textfields and color it red
    LargestBlock block = new LargestBlock(matrix);
    for (int i = block.getStartRow(); i <= block.getEndRow(); i++) {
      for (int j = block.getStartCol(); j <= block.getEndCol(); j++) {
        textFields[i][j].setStyle("-fx-control-inner-background: red");
      }
    }
  }

  private int[][] getMatrix() {
    int[][] matrix = new int[rows][columns];
    for (Node child: getChildren()) {
      TextField tf = (TextField)child;
      int column = getColumnIndex(child);
      int row = getRowIndex(child);
      matrix[row][column] = Integer.parseInt(tf.getText());
    }
    return matrix;
  }

  private TextField[][] getTextFields() {
    TextField[][] textFields = new TextField[rows][columns];
    for (Node child: getChildren()) {
      TextField tf = (TextField)child;
      int column = getColumnIndex(child);
      int row = getRowIndex(child);
      textFields[row][column] = tf;
    }
    return textFields;
  }

  private boolean isEntryValid() {
    for (Node child: getChildren()) {
      TextField tf = (TextField)child;
      String text = tf.getText();
      if (!text.equals("1") && !text.equals("0")) { return false; }
    }
    return true;
  }
}
