import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import java.util.ArrayList;

public class TwentyFourGUI extends BorderPane {
  TwentyFour twentyFour;
  TextField tfMessage;
  TextField tfEnter;
  HBox hbCards;

  public TwentyFourGUI() {
    twentyFour = new TwentyFour();
    drawGUI();
  }

  private void drawGUI() {
    tfMessage = new TextField();
    Button btFindSolution = new Button("Find Solution");
    Button btShuffle = new Button("Shuffle");

    btFindSolution.setOnAction(e -> findSolution());
    btShuffle.setOnAction(e -> shuffle());

    HBox hbTop = new HBox(10);
    hbTop.getChildren().addAll(btFindSolution, tfMessage, btShuffle);
    hbTop.setAlignment(Pos.CENTER);

    hbCards = new HBox(10);
    hbCards.setAlignment(Pos.CENTER);
    displayCards();

    Label lbEnter = new Label("Enter an expression:");
    tfEnter = new TextField();
    Button btVerify = new Button("Verify");

    btVerify.setOnAction(e -> verify());

    HBox hbBottom = new HBox(10);
    hbBottom.getChildren().addAll(lbEnter, tfEnter, btVerify);
    hbBottom.setAlignment(Pos.CENTER);

    setTop(hbTop);
    setCenter(hbCards);
    setBottom(hbBottom);
    setMargin(hbBottom, new Insets(20));
  }

  private void findSolution() {
    tfMessage.setText(twentyFour.solve());
  }

  private void shuffle() {
    tfMessage.setText("");
    tfEnter.setText("");
    twentyFour.newValues();
    displayCards();
  }

  private void verify() {
    String expression = tfEnter.getText();

    if (!twentyFour.numbersAreValid(expression)) {
      tfMessage.setText("Invalid use of numbers");
      return;
    }

    if (twentyFour.expressionIsValid(expression)) {
      if (twentyFour.evaluateInfix(expression) == 24.0) {
        tfMessage.setText("Correct");
      } else {
        tfMessage.setText("Incorrect");
      }
    } else {
      tfMessage.setText("Invalid Expression");
    }
  }

  private void displayCards() {
    hbCards.getChildren().clear();
    ArrayList<Integer> cards = twentyFour.getCardNumbers();
    for (int i = 0; i < cards.size(); i++) {
      ImageView iv = new ImageView("card/" + cards.get(i) + ".png");
      hbCards.getChildren().add(iv);
    }
  }
}
