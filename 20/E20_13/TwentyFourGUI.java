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
  Label lbMessage;
  TextField tfEnter;
  HBox hbCards;

  public TwentyFourGUI() {
    twentyFour = new TwentyFour();
    drawGUI();
  }

  private void drawGUI() {
    lbMessage = new Label();
    lbMessage.setPrefSize(300, 50);
    lbMessage.setWrapText(true);
    Button btShuffle = new Button("Shuffle");

    btShuffle.setOnAction(e -> shuffle());

    HBox hbTop = new HBox(10);
    hbTop.getChildren().addAll(lbMessage, btShuffle);

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

  private void shuffle() {
    lbMessage.setText("");
    tfEnter.setText("");
    twentyFour.newValues();
    displayCards();
  }

  private void verify() {
    String expression = tfEnter.getText();

    if (!twentyFour.numbersAreValid(expression)) {
      lbMessage.setText("Invalid use of numbers");
      return;
    }

    if (twentyFour.expressionIsValid(expression)) {
      if (twentyFour.evaluateInfix(expression) == 24.0) {
        lbMessage.setText("Correct");
      } else {
        lbMessage.setText("Incorrect");
      }
    } else {
      lbMessage.setText("Invalid Expression");
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
