import javafx.scene.control.Label;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Pos;
import java.io.IOException;

public class NameRankingGUI extends BorderPane {
  private BabyNames bn;
  private ComboBox<Integer> cbYear;
  private ComboBox<String> cbGender;
  private TextField tfName;
  private Label lbResult;

  public NameRankingGUI() throws IOException {
    bn = new BabyNames();
    drawGUI();
  }

  private void drawGUI() {
    setPrefWidth(350);

    // Set up the controls for top portion of UI
    Label lbYear = new Label("Select a year:");
    Label lbGender = new Label("Boy or girl?");
    Label lbName = new Label("Enter a name:");
    cbYear = new ComboBox<>();
    cbGender = new ComboBox<>();
    tfName = new TextField();
    Button btFind = new Button("Find Ranking");

    // Add items to and configure the combo boxes
    for (int i = 2001; i <= 2010; i++) {
      cbYear.getItems().add(i);
    }
    cbGender.getItems().addAll("Male", "Female");
    cbYear.getSelectionModel().selectFirst();
    cbGender.getSelectionModel().selectFirst();

    // Set up the result label
    lbResult = new Label("Boy name Michael is ranked #2 in year 2004");

    btFind.setOnAction(e -> findRanking());

    // Populate the grid pane for the control portion of UI
    GridPane gpControls = new GridPane();
    gpControls.setVgap(5);
    gpControls.setHgap(10);
    gpControls.addColumn(0, lbYear, lbGender, lbName);
    gpControls.addColumn(1, cbYear, cbGender, tfName, btFind);
    gpControls.setAlignment(Pos.CENTER);

    // Populate the containing border pane
    setCenter(gpControls);
    setBottom(lbResult);
    setAlignment(lbResult, Pos.CENTER);
  }

  private void findRanking() {
    int year = cbYear.getSelectionModel().getSelectedItem();
    int index = getIndexForYear(year);
    String gender = cbGender.getSelectionModel().getSelectedItem();
    String name = tfName.getText();
    if (gender.equals("Male")) {
      if (bn.getBoyData().get(index).get(name) != null) {
        String rank = bn.getBoyData().get(index).get(name);
        lbResult.setText("Boy name " + name + " is ranked #" + rank +
          " in year " + year);
      } else {
        lbResult.setText("Name not found");
      }
    } else if (gender.equals("Female")) {
      if (bn.getGirlData().get(index).get(name) != null) {
        String rank = bn.getGirlData().get(index).get(name);
        lbResult.setText("Girl name " + name + " is ranked #" + rank +
          " in year " + year);
      } else {
        lbResult.setText("Name not found");
      }
    }
  }

  private static int getIndexForYear(int year) {
    for (int i = 0, j = 2001; i < 10; i++, j++) {
      if (j == year) { return i; }
    }
    return -1; // shouldn't happen
  }
}
