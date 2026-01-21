/*
  Write a program that stores, retrieves, adds, and updates addresses. Use a
  fixed-length string for storing each attribute in the address. Use random
  access file for reading and writing an address. Assume that the size of name,
  street, city, state, and zip is 32, 32, 20, 2, 5 bytes, respectively.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import java.io.IOException;

public class E17_09 extends Application {
  @Override
  public void start(Stage primaryStage) throws IOException {
    AddressBook a = new AddressBook();

    Scene scene = new Scene(a);
    primaryStage.setTitle("E17_09");
    primaryStage.setScene(scene);
    primaryStage.setResizable(false);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
