/*
  Write a program that prompts the user to enter the coordinates of five points
  from the command line. The first four points form a polygon, and the program
  displays the polygon and a text that indicates whether the fifth point is
  inside the polygon.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.paint.Color;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.collections.ObservableList;
import java.util.List;

public class E14_24 extends Application {
  @Override
  public void start(Stage primaryStage) {
    final double WINDOW = 400.0;
    // get the parameter list
    List<String> params = getParameters().getRaw();

    // this scales the input values so small numbers can be passed in for
    // convenience
    double scaleFactor = 10.0;

    // create the polygon using the first 8 values in the input
    Polygon polygon = new Polygon();
    polygon.setFill(Color.WHITE);
    polygon.setStroke(Color.BLACK);
    ObservableList<Double> points = polygon.getPoints();
    for (int i = 0; i < 8; i++) {
      double p = Double.parseDouble(params.get(i)) * scaleFactor;
      points.add(p);
    }

    // create the circle using the last 2 values in the input
    double centerX = Double.parseDouble(params.get(8)) * scaleFactor;
    double centerY = Double.parseDouble(params.get(9)) * scaleFactor;
    Circle circle = new Circle(centerX, centerY, 10);

    // create the text label
    Text text = new Text();
    text.setX(0);
    text.setY(WINDOW - 50);
    if (polygon.contains(circle.getCenterX(), circle.getCenterY())) {
      text.setText("The point is inside the polygon");
    } else {
      text.setText("The point is not inside the polygon");
    }

    Pane container = new Pane();
    container.getChildren().addAll(polygon, circle, text);

    StackPane pane = new StackPane();
    pane.setAlignment(Pos.CENTER);
    pane.setPadding(new Insets(20));
    pane.getChildren().add(container);

    Scene scene = new Scene(pane);
    primaryStage.setTitle("E14_24");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    if (args.length != 10) {
      System.out.println("Usage: enter 5 points");
      System.exit(1);
    }
    Application.launch(args);
  }
}
