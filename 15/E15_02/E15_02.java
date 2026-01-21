/*
  Write a program that rotates a rectangle 15 degrees right when the rotate
  button is clicked.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

public class E15_02 extends Application {
  @Override
  public void start(Stage primaryStage) {
    final double WIDTH = 200.0;
    final double HEIGHT = 150.0;

    BorderPane pane = new BorderPane();
    StackPane sp = new StackPane();
    sp.setPadding(new Insets(50));

    Rectangle rect = new Rectangle(100, 50);
    rect.setFill(Color.WHITE);
    rect.setStroke(Color.BLACK);
    sp.getChildren().add(rect);

    Button btRotate = new Button("Rotate");
    btRotate.setOnAction(e -> rect.setRotate(rect.getRotate() + 15));

    pane.setCenter(sp);
    pane.setBottom(btRotate);
    BorderPane.setAlignment(btRotate, Pos.CENTER);

    Scene scene = new Scene(pane);
    primaryStage.setTitle("E15_02");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
