/*
  Write a program that draws two circles with radius 15 pixels, centered at
  random locations, with a line connecting the two circles. The line should not
  cross inside the circles.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class E14_22 extends Application {
  @Override
  public void start(Stage primaryStage) {
    final double WINDOW = 500.0;

    Pane container = new Pane();

    Circle c1 = new Circle(getRand(WINDOW), getRand(WINDOW), 15);
    Circle c2 = new Circle(getRand(WINDOW), getRand(WINDOW), 15);
    c1.setFill(Color.WHITE);
    c1.setStroke(Color.BLACK);
    c2.setFill(Color.WHITE);
    c2.setStroke(Color.BLACK);

    Text t1 = new Text(c1.getCenterX(), c1.getCenterY(), "1");
    Text t2 = new Text(c2.getCenterX(), c2.getCenterY(), "2");

    Line line = new Line(c1.getCenterX(), c1.getCenterY(),
      c2.getCenterX(), c2.getCenterY());

    container.getChildren().addAll(line, c1, c2, t1, t2);

    StackPane pane = new StackPane();
    pane.setPadding(new Insets(20));
    pane.setAlignment(Pos.CENTER);
    pane.getChildren().add(container);

    Scene scene = new Scene(pane);
    primaryStage.setTitle("E14_22");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static double getRand(double max) {
    return Math.random() * max;
  }

  public static void main(String[] args) {
    Application.launch(args);
  }
}
