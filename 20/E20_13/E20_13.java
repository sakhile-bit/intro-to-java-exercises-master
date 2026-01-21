/*
  The 24-point game is to pick any 4 cards from 52 cards. Note that the Jokers
  are excluded. Each card represents a number. An Ace, King, Queen, and Jack
  represent 1, 13, 12, and 11, respectively. You can click the Shuffle button
  to get four new cards. Enter an expression that uses the four numbers from
  the four selected cards. Each number must be used once and only once. You
  can use the operators (addition, subtraction, multiplication, division) and
  parentheses in the expression. The expression must evaluate to 24. After
  entering the expression, click the Verify button to check whether the
  numbers in the expression are currently selected and whether the result of
  the expression is correct. Display the verification in a label before the
  Shuffle button. Assume that images are stored in files named 1.png, 2.png,
  ..., 52.png, in the order of spades, hearts, diamonds, and clubs. So, the
  first 13 images are for spades 1, 2, 3, ..., and 13.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class E20_13 extends Application {
  @Override
  public void start(Stage primaryStage) {
    TwentyFourGUI tf = new TwentyFourGUI();

    Scene scene = new Scene(tf);
    primaryStage.setTitle("E20_13");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
