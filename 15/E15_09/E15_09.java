/*
  Write a program that draws line segments using the arrow keys. The line
  starts from the center of the pane and draws toward east, north, west, or
  south when the right-arrow key, up-arrow key, left-arrow key, or
  down-arrow key is pressed.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Polyline;
import javafx.scene.paint.Color;

public class E15_09 extends Application {
  @Override
  public void start(Stage primaryStage) {
    final double WIDTH = 500.0;
    final double HEIGHT = 500.0;
    double[] position = {WIDTH / 2, HEIGHT / 2};


    Polyline polyline = new Polyline();
    polyline.getPoints().addAll(position[0], position[1]);
    polyline.setStroke(Color.BLACK);

    polyline.setOnKeyPressed(e -> {
      switch (e.getCode()) {
        case UP:    polyline.getPoints().addAll(position[0], position[1] -= 10);
                    break;
        case DOWN:  polyline.getPoints().addAll(position[0], position[1] += 10);
                    break;
        case LEFT:  polyline.getPoints().addAll(position[0] -= 10, position[1]);
                    break;
        case RIGHT: polyline.getPoints().addAll(position[0] += 10, position[1]);
      }
    });

    Pane pane = new Pane();
    pane.getChildren().add(polyline);

    Scene scene = new Scene(pane, WIDTH, HEIGHT);
    primaryStage.setTitle("E15_09");
    primaryStage.setScene(scene);
    primaryStage.show();

    polyline.requestFocus();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
