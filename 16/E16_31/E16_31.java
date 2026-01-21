/*
  Programming Exercise 8.20 enables two players to play the connect-four game
  on the console. Rewrite a GUI version for the program. The program enables
  two players to place red and yellow discs in turn. To place a disk, the
  player needs to click an available cell. An available cell is unoccupied and
  its downward neighbor is occupied. The program flashes the four winning cells
  if a player wins and reports no winners if all cells are occupied with no
  winners.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class E16_31 extends Application {
  @Override
  public void start(Stage primaryStage) {
    ConnectFour c = new ConnectFour();

    Scene scene = new Scene(c);
    primaryStage.setTitle("E16_31");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
