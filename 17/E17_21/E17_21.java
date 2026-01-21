/*
  Write a GUI application that lets the user enter a file name in the text
  field and press the Enter key to display its hex representation in a text
  area. The user can also modify the hex code and save it back to the file.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class E17_21 extends Application {
  @Override
  public void start(Stage primaryStage) {
    HexEditor he = new HexEditor();

    Scene scene = new Scene(he);
    primaryStage.setTitle("E17_21");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
