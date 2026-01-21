/*
  Write a program that lets the user click the Refresh button to display four
  cards from a deck of 52 cards.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import java.util.ArrayList;

public class E15_01 extends Application {
  @Override
  public void start(Stage primaryStage) {
    HBox hBox = new HBox(10);
    hBox.setPadding(new Insets(10));

    setCardsInPane(hBox);

    Button btRefresh = new Button("Refresh");
    btRefresh.setOnAction(e -> setCardsInPane(hBox));

    BorderPane pane = new BorderPane();
    pane.setCenter(hBox);
    pane.setBottom(btRefresh);
    BorderPane.setAlignment(btRefresh, Pos.CENTER);

    Scene scene = new Scene(pane);
    primaryStage.setTitle("E15_01");
    primaryStage.setScene(scene);
    primaryStage.setResizable(false);
    primaryStage.show();
  }

  public static void setCardsInPane(HBox hBox) {
    hBox.getChildren().clear();
    int[] fourCards = getFourRandomCards();
    for (int i = 0; i < 4; i++) {
      ImageView imageView = new ImageView("card/" + fourCards[i] + ".png");
      hBox.getChildren().add(imageView);
    }
  }

  public static int[] getFourRandomCards() {
    // create the list of 1-52
    ArrayList<Integer> cardNumbers = new ArrayList<>();
    for (int i = 1; i <= 52; i++) {
      cardNumbers.add(i);
    }

    // shuffle the list
    for (int i = 0; i < cardNumbers.size(); i++) {
      int ran = (int)(Math.random() * cardNumbers.size());
      int temp = cardNumbers.get(i);
      cardNumbers.set(i, cardNumbers.get(ran));
      cardNumbers.set(ran, temp);
    }

    // return array of first four values
    int[] firstFour = new int[4];
    for (int i = 0; i < firstFour.length; i++) {
      firstFour[i] = cardNumbers.get(i);
    }

    return firstFour;
  }

  public static void main(String[] args) {
    launch(args);
  }
}
