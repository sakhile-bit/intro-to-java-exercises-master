/*
  Write a program that displays a rectanguloid. The cube should grow and shrink
  as the window grows or shrinks.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Line;
import javafx.scene.paint.Color;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

public class E14_14 extends Application {
  @Override
  public void start(Stage primaryStage) {
    final double SIDE = 200.0;

    Pane rectanguloid = new Pane();

    // Create the back and front facing rectangles
    Rectangle r1 = new Rectangle(SIDE / 10, 0, SIDE, SIDE);
    r1.widthProperty().bind(rectanguloid.widthProperty().subtract(SIDE / 10));
    r1.heightProperty().bind(rectanguloid.heightProperty().subtract(SIDE / 2));
    r1.setFill(Color.TRANSPARENT);
    r1.setStroke(Color.BLACK);

    Rectangle r2 = new Rectangle(0, SIDE / 3, SIDE, SIDE);
    r2.widthProperty().bind(rectanguloid.widthProperty().subtract(SIDE / 10));
    r2.heightProperty().bind(rectanguloid.heightProperty().subtract(SIDE / 2));
    r2.setFill(Color.TRANSPARENT);
    r2.setStroke(Color.BLACK);

    // Create the lines connecting the two rectangles
    Line line1 = new Line(r2.getX(), r2.getY(), r1.getX(), r1.getY());

    Line line2 = new Line();
    line2.setStartX(r2.getX());
    line2.setEndX(r1.getX());
    line2.startYProperty().bind(r2.yProperty().add(r2.heightProperty()));
    line2.endYProperty().bind(r1.yProperty().add(r1.heightProperty()));

    Line line3 = new Line();
    line3.setStartY(r2.getY());
    line3.setEndY(r1.getY());
    line3.startXProperty().bind(r2.xProperty().add(r2.widthProperty()));
    line3.endXProperty().bind(r1.xProperty().add(r1.widthProperty()));

    Line line4 = new Line();
    line4.startXProperty().bind(r2.xProperty().add(r2.widthProperty()));
    line4.startYProperty().bind(r2.yProperty().add(r2.heightProperty()));
    line4.endXProperty().bind(r1.xProperty().add(r1.widthProperty()));
    line4.endYProperty().bind(r1.yProperty().add(r1.heightProperty()));

    rectanguloid.getChildren().addAll(r1, r2, line1, line2, line3, line4);

    StackPane pane = new StackPane();
    pane.setAlignment(Pos.CENTER);
    pane.setPadding(new Insets(20));
    pane.getChildren().add(rectanguloid);

    Scene scene = new Scene(pane, SIDE * 2, SIDE * 3);
    primaryStage.setTitle("E14_14");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    Application.launch(args);
  }
}
