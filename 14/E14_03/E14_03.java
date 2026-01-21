/*
  Write a program that displays three cards randomly selected from a deck of
  52. All three cards are distinct and selected randomly.
*/

import java.util.ArrayList;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class E14_03 extends Application {
  @Override
  public void start(Stage primaryStage) {
    GridPane pane = new GridPane();
    pane.setPadding(new Insets(5));
    pane.setAlignment(Pos.CENTER);
    pane.setHgap(5);

    int[] cards = getRandomThree();

    for (int i = 0; i < 3; i++) {
      ImageView imgView = new ImageView(new Image("card/" + cards[i] + ".png"));
      pane.add(imgView, i, 0);
    }

    Scene scene = new Scene(pane);
    primaryStage.setTitle("E14_03");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  private static int[] getRandomThree() {
    ArrayList<Integer> deck = new ArrayList<>();
    for (int i = 1; i <= 52; i++) {
      deck.add(i);
    }

    shuffle(deck);

    return new int[]{deck.get(0), deck.get(1), deck.get(2)};
  }

  private static void shuffle(ArrayList<Integer> list) {
    for (int i = 0; i < list.size(); i++) {
      int randomIndex = (int)(Math.random() * list.size());
      Integer temp = list.get(i);
      list.set(i, list.get(randomIndex));
      list.set(randomIndex, temp);
    }
  }

  public static void main(String[] args) {
    Application.launch(args);
  }
}
