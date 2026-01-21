/*
  Write a program that displays five texts vertically. Set a random color and
  opacity for each text and set the font of each text to Times Roman, bold,
  italic, and 22 pixels.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.FontPosture;
import javafx.scene.paint.Color;

public class E14_04 extends Application {
  @Override
  public void start(Stage primaryStage) {
    GridPane pane = new GridPane();
    pane.setAlignment(Pos.CENTER);
    pane.setPadding(new Insets(20, 0, 20, 0));
    pane.setHgap(15);

    for (int i = 0; i < 5; i++) {
      Text text = new Text("Java");
      text.setFont(Font.font("Times New Roman", FontWeight.BOLD,
        FontPosture.ITALIC , 22));
      text.setFill(Color.color(Math.random(), Math.random(), Math.random()));
      text.setRotate(90);
      pane.add(text, i, 0);
    }

    Scene scene = new Scene(pane);
    primaryStage.setTitle("E14_04");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    Application.launch(args);
  }
}
