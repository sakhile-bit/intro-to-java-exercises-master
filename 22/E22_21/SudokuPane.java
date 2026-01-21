import javafx.scene.layout.GridPane;
import javafx.scene.control.TextField;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

public class SudokuPane extends GridPane {
  private TextField[][] allTextFields;

  public SudokuPane() {
    drawGUI();
  }

  private void drawGUI() {
    allTextFields = new TextField[9][9];
    for (int i = 0; i < allTextFields.length; i++) {
      for (int j = 0; j < allTextFields[i].length; j++) {
        TextField tf = new TextField();
        tf.setPrefColumnCount(1);
        tf.setAlignment(Pos.CENTER);
        allTextFields[i][j] = tf;
        add(tf, j, i);
      }
    }

    setHgap(5);
    setVgap(5);
    setPadding(new Insets(5));
  }

  public boolean solve() throws IllegalArgumentException {
    if (!inputValid()) { return false; }
    try {
      TextField[] inputTextFields = getInputTextFields();
      Integer[][] sudokuInputArray = getSudokuInputArray();
      SudokuSolver solver = new SudokuSolver(sudokuInputArray);
      Integer[][] solutionArray = solver.getSolutions().get(0);
      fillSolutions(solutionArray);
      changeColorOfUserInput(inputTextFields);
    } catch (IllegalArgumentException ex) {
      throw ex;
    }
    return true;
  }

  public void clear() {
    for (int i = 0; i < allTextFields.length; i++) {
      for (int j = 0; j < allTextFields[i].length; j++) {
        TextField tf = allTextFields[i][j];
        tf.setText("");
        tf.setStyle("-fx-text-inner-color: black");
      }
    }
  }

  private void fillSolutions(Integer[][] solutionArray) {
    for (int i = 0; i < allTextFields.length; i++) {
      for (int j = 0; j < allTextFields[i].length; j++) {
        allTextFields[i][j].setText(solutionArray[i][j] + "");
      }
    }
  }

  private void changeColorOfUserInput(TextField[] inputTextFields) {
    for (int i = 0; i < inputTextFields.length; i++) {
      TextField tf = inputTextFields[i];
      tf.setStyle("-fx-text-inner-color: #C8C8C8");
    }
  }

  private TextField[] getInputTextFields() {
    int numOfUserInputs = 0;
    for (int i = 0; i < allTextFields.length; i++) {
      for (int j = 0; j < allTextFields[i].length; j++) {
        if (allTextFields[i][j].getText().length() > 0) {
          numOfUserInputs++;
        }
      }
    }

    TextField[] inputTextFields = new TextField[numOfUserInputs];
    int count = 0;
    for (int i = 0; i < allTextFields.length; i++) {
      for (int j = 0; j < allTextFields[i].length; j++) {
        TextField tf = allTextFields[i][j];
        if (tf.getText().length() > 0) {
          inputTextFields[count] = tf;
          count++;
        }
      }
    }

    return inputTextFields;
  }

  private boolean inputValid() {
    for (int i = 0; i < allTextFields.length; i++) {
      for (int j = 0; j < allTextFields[i].length; j++) {
        String text = allTextFields[i][j].getText();
        if (!textValid(text)) { return false; }
      }
    }
    return true;
  }

  private boolean textValid(String text) {
    if (text.length() > 1) { return false; }
    if (text.length() == 1 && (text.charAt(0) < '1' || text.charAt(0) > '9')) {
      return false;
    }
    return true;
  }

  private Integer[][] getSudokuInputArray() {
    Integer[][] inputArray = new Integer[9][9];
    for (int i = 0; i < allTextFields.length; i++) {
      for (int j = 0; j < allTextFields[i].length; j++) {
        String text = allTextFields[i][j].getText();
        inputArray[i][j] = text.length() > 0 ? Integer.parseInt(text) : 0;
      }
    }
    return inputArray;
  }
}
