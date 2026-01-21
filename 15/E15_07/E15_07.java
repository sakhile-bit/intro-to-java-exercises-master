/*
  Write a program that displays the color of a circle as black when the mouse
  button is pressed and as white when the mouse button is released.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;

public class E15_07 extends Application {
  @Override
  public void start(Stage primaryStage) {
    Circle circle = new Circle(50);
    circle.setFill(Color.WHITE);
    circle.setStroke(Color.BLACK);

    circle.setOnMousePressed(e -> circle.setFill(Color.BLACK));
    circle.setOnMouseReleased(e -> circle.setFill(Color.WHITE));

    StackPane pane = new StackPane();
    pane.getChildren().add(circle);
    pane.setPadding(new Insets(50));

    Scene scene = new Scene(pane);
    primaryStage.setTitle("E15_07");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
