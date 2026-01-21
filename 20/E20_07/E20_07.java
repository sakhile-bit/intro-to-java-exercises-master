/*
  Programming Exercise 7.35 presents a console version of the popular hangman
  game. Write a GUI program that lets a user play the game. The user guesses
  a word by entering one letter at a time. If the user misses seven times,
  a hanging man swings. Once a word is finished, the user can press the Enter
  key to continue to guess another word.
*/

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class E20_07 extends Application {
  @Override
  public void start(Stage primaryStage) {
    Hangman hm = new Hangman();

    Scene scene = new Scene(hm);
    primaryStage.setTitle("E20_07");
    primaryStage.setScene(scene);
    primaryStage.setResizable(false);
    primaryStage.show();

    hm.requestFocus();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
