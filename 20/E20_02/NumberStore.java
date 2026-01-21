import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.geometry.Pos;
import java.util.LinkedList;
import java.util.Collections;

public class NumberStore extends BorderPane {
  private LinkedList<Integer> list;
  private TextArea taDisplay;

  public NumberStore() {
    list = new LinkedList<>();
    drawGUI();
  }

  private void drawGUI() {
    Label lbEnterNumber = new Label("Enter a number:");
    TextField tfEnterNumber = new TextField();

    tfEnterNumber.setOnKeyPressed(e -> enterNumber(e));

    HBox hbTop = new HBox(10);
    hbTop.getChildren().addAll(lbEnterNumber, tfEnterNumber);
    hbTop.setAlignment(Pos.CENTER);

    taDisplay = new TextArea();

    Button btSort = new Button("Sort");
    Button btShuffle = new Button("Shuffle");
    Button btReverse = new Button("Reverse");

    btSort.setOnAction(e -> sort());
    btShuffle.setOnAction(e -> shuffle());
    btReverse.setOnAction(e -> reverse());

    HBox hbBottom = new HBox(10);
    hbBottom.getChildren().addAll(btSort, btShuffle, btReverse);
    hbBottom.setAlignment(Pos.CENTER);

    setTop(hbTop);
    setCenter(taDisplay);
    setBottom(hbBottom);
  }

  private void enterNumber(KeyEvent e) {
    if (e.getCode().equals(KeyCode.ENTER)) {
      TextField tf = (TextField)e.getSource();
      if (tf.getText().length() == 0) { return; }
      for (int i = 0; i < tf.getText().length(); i++) {
        if (!Character.isDigit(tf.getText().charAt(i))) { return; }
      }
      Integer num = Integer.parseInt(tf.getText());
      if (!list.contains(num)) { list.add(num); }
      tf.setText("");
      updateDisplay();
    }
  }

  private void sort() {
    Collections.sort(list);
    updateDisplay();
  }

  private void shuffle() {
    Collections.shuffle(list);
    updateDisplay();
  }

  private void reverse() {
    Collections.reverse(list);
    updateDisplay();
  }

  private void updateDisplay() {
    StringBuilder sb = new StringBuilder();
    for (Integer i: list) {
      sb.append(i + " ");
    }
    taDisplay.setText(sb.toString());
  }
}
