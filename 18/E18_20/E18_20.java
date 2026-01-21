/*
  Write a Java program that displays circles. The circles are centered in the
  pane. The gap between two adjacent circles is 10 pixels, and the gap between
  the border of the pane and the largest circle is also 10.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;

public class E18_20 extends Application {
  @Override
  public void start(Stage primaryStage) {
    CirclePane c = new CirclePane(10, 10);

    Scene scene = new Scene(c);
    primaryStage.setTitle("E18_20");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public class CirclePane extends StackPane {
    private double startingRadius;

    public CirclePane(int numberOfCircles, double startingRadius) {
      this.startingRadius = startingRadius;
      drawCircles(numberOfCircles, startingRadius);
      setPadding(new Insets(startingRadius));
    }

    private void drawCircles(int n, double radius) {
      if (n == 0) { return; }
      Circle circle = new Circle(radius);
      circle.setFill(Color.TRANSPARENT);
      circle.setStroke(Color.BLACK);
      getChildren().add(circle);
      drawCircles(n - 1, radius + startingRadius);
    }
  }

  public static void main(String[] args) {
    launch(args);
  }
}
