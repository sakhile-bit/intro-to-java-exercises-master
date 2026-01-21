/*
  Write a program that enables the user to enter text and displays the Huffman
  coding tree based on the text. Display the weight of the subtree inside the
  subtree's root circle. Display each leaf node's character. Display the
  encoded bits for the text in a label. When the user clicks the Decode Text
  button, a bit string is decoded into text and displayed in the label.
*/

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class E25_17 extends Application {
  @Override
  public void start(Stage primaryStage) {
    TreeVisualizer tv = new TreeVisualizer();

    Scene scene = new Scene(tv, 800, 600);
    primaryStage.setTitle("E25_17");
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
