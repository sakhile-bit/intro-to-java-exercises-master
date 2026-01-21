import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import java.util.ArrayList;

public class TwentyFourGUI extends BorderPane {
  TwentyFour twentyFour;
  TextField tfSolve;
  TextField[] tfNums;

  public TwentyFourGUI() {
    tfNums = new TextField[4];
    drawGUI();
  }

  private void drawGUI() {
    tfSolve = new TextField();
    Button btSolve = new Button("Solve");

    btSolve.setOnAction(e -> solve());

    HBox hbTop = new HBox(10);
    hbTop.getChildren().addAll(tfSolve, btSolve);
    hbTop.setAlignment(Pos.CENTER);

    for (int i = 0; i < tfNums.length; i++) {
      TextField textField = new TextField();
      textField.setPrefColumnCount(2);
      textField.setAlignment(Pos.CENTER);
      tfNums[i] = textField;
    }

    HBox hbNums = new HBox(10);
    hbNums.setAlignment(Pos.CENTER);

    for (TextField textField: tfNums) {
      hbNums.getChildren().add(textField);
    }

    setTop(hbTop);
    setCenter(hbNums);
  }

  private void solve() {
    ArrayList<Integer> nums = new ArrayList<>();
    for (TextField textField: tfNums) {
      nums.add(Integer.parseInt(textField.getText()));
    }
    twentyFour = new TwentyFour(nums);
    tfSolve.setText(twentyFour.solve());
  }
}
