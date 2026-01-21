/*
  Write a program that displays a bean machine introduced in Programming
  Exercise 7.21.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Circle;
import javafx.geometry.Insets;

public class E14_29 extends Application {
  @Override
  public void start(Stage primaryStage) {
    final double WIDTH = 300.0;
    final double HEIGHT = 400.0;

    Pane container = new Pane();

    // draw bottom of the bean machine
    Line bottomEdge = new Line(0, HEIGHT, WIDTH, HEIGHT);

    // draw lines for slots
    double xSpot = 0;
    for (int i = 0; i < 9; i++) {
      container.getChildren().add(
        new Line(xSpot, HEIGHT, xSpot, HEIGHT / 5 * 4));
      xSpot += WIDTH / 8;
    }

    // draw entry lines
    Line leftEntry = new Line();
    leftEntry.setStartX(WIDTH / 2 - WIDTH / 16);
    leftEntry.setStartY(0);
    leftEntry.setEndX(WIDTH / 2 - WIDTH / 16);
    leftEntry.setEndY(HEIGHT / 9);

    Line rightEntry = new Line();
    rightEntry.setStartX(WIDTH / 2 + WIDTH / 16);
    rightEntry.setStartY(0);
    rightEntry.setEndX(WIDTH / 2 + WIDTH / 16);
    rightEntry.setEndY(HEIGHT / 9);

    // draw slanted side lines
    Line leftSlant = new Line(0, HEIGHT / 5 * 4,
      leftEntry.getEndX(), leftEntry.getEndY());
    Line rightSlant = new Line(WIDTH, HEIGHT / 5 * 4,
      rightEntry.getEndX(), rightEntry.getEndY());

    // draw pins
    for (int row = 7, mod = 0; row >= 1; row--, mod++) {
      xSpot = (WIDTH / 8) + (WIDTH / 16 * mod);
      double ySpot = (HEIGHT / 5 * 4) - (HEIGHT / 9 * mod);
      for (int col = row; col >= 1; col--) {
        Circle c = new Circle(xSpot, ySpot, HEIGHT / 75);
        xSpot += WIDTH / 8;
        container.getChildren().add(c);
      }
    }

    container.getChildren().addAll(bottomEdge, leftEntry, rightEntry,
      leftSlant, rightSlant);


    StackPane pane = new StackPane();
    pane.setPadding(new Insets(20));
    pane.getChildren().add(container);

    Scene scene = new Scene(pane);
    primaryStage.setTitle("E14_29");
    primaryStage.setScene(scene);
    primaryStage.setResizable(false);
    primaryStage.show();
  }

  public static void main(String[] args) {
    Application.launch(args);
  }
}
