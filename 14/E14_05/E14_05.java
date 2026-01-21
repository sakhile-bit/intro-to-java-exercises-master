/*
  Write a program that displays a string "Welcome to Java" around a circle.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class E14_05 extends Application {
  @Override
  public void start(Stage primaryStage) {
    final double SIZE = 400.0;
    final double RADIUS = SIZE / 2;
    String[] s = "WELCOME TO JAVA ".split("");

    Pane letters = new Pane();

    for (int i = 0; i < s.length; i++) {
      double angle = (2 * i * Math.PI) / s.length;
      double x = RADIUS + RADIUS * Math.cos(angle);
      double y = RADIUS + RADIUS * Math.sin(angle);
      Text t = new Text(x, y, s[i]);
      t.setFont(Font.font("Times New Roman", RADIUS / 8));
      t.setRotate(90 + Math.toDegrees(angle));
      letters.getChildren().add(t);
    }

    StackPane pane = new StackPane();
    pane.getChildren().add(letters);
    pane.setPadding(new Insets(20));
    pane.setAlignment(Pos.CENTER);

    Scene scene = new Scene(pane);
    primaryStage.setTitle("E14_05");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    Application.launch(args);
  }
}
