/*
  Write a GUI application that lets the user enter a file name in the text
  field and press the Enter key to display its binary representation in a text
  area. The user can also modify the binary code and save it back to the file.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class E17_20 extends Application {
  @Override
  public void start(Stage primaryStage) {
    BinaryEditor be = new BinaryEditor();

    Scene scene = new Scene(be);
    primaryStage.setTitle("E17_20");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
