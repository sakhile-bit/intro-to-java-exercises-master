/*
  Write a program that lets the user enter numbers from a graphical user
  interface and displays them in a text area. Use a linked list to store the
  numbers. Do not store duplicate numbers. Add the buttons Sort, Shuffle, and
  Reverse to sort, shuffle, and reverse the list.
*/

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class E20_02 extends Application {
  @Override
  public void start(Stage primaryStage) {
    NumberStore ns = new NumberStore();

    Scene scene = new Scene(ns);
    primaryStage.setTitle("E20_02");
    primaryStage.setScene(scene);
    primaryStage.setResizable(false);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
