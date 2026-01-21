/*
  Expand Exercise 14.3 to display all 54 cards (including two jokers), nine
  per row.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class E14_08 extends Application {
  @Override
  public void start(Stage primaryStage) {
    CardsPane pane = new CardsPane();

    Scene scene = new Scene(pane);
    primaryStage.setTitle("E14_08");
    primaryStage.setScene(scene);
    primaryStage.setResizable(false);
    primaryStage.show();
  }

  class CardsPane extends GridPane {
    CardsPane() {
      int cardCount = 0;
      for (int col = 0; col < 9; col++) {
        for (int row = 0; row < 6; row++) {
          cardCount++;
          ImageView img =
            new ImageView(new Image("card/" + cardCount + ".png"));
          add(img, col, row);
        }
      }
    }
  }

  public static void main(String[] args) {
    Application.launch(args);
  }
}
