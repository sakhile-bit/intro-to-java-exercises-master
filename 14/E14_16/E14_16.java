/*
  Write a program that displays a 3x3 grid. Use red color for vertical lines
  and blue for horizontals. The lines are automatically resized when the
  window is resized.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.paint.Color;

public class E14_16 extends Application {
  @Override
  public void start(Stage primaryStage) {
    final int WIDTH = 200;
    final int HEIGHT = 200;

    Pane pane = new Pane();
    Line h1 = new Line(0, HEIGHT / 3, WIDTH, HEIGHT / 3);
    h1.endXProperty().bind(pane.widthProperty());
    h1.startYProperty().bind(pane.heightProperty().divide(3));
    h1.endYProperty().bind(pane.heightProperty().divide(3));

    Line h2 = new Line(0, HEIGHT - HEIGHT / 3, WIDTH, HEIGHT - HEIGHT / 3);
    h2.endXProperty().bind(pane.widthProperty());
    h2.startYProperty().bind(pane.heightProperty().divide(3)
      .add(pane.heightProperty().divide(3)));
    h2.endYProperty().bind(pane.heightProperty().divide(3)
      .add(pane.heightProperty().divide(3)));

    Line v1 = new Line(WIDTH / 3, 0, WIDTH / 3, HEIGHT);
    v1.endYProperty().bind(pane.heightProperty());
    v1.startXProperty().bind(pane.widthProperty().divide(3));
    v1.endXProperty().bind(pane.widthProperty().divide(3));

    Line v2 = new Line(WIDTH - WIDTH / 3, 0, WIDTH - WIDTH / 3, HEIGHT);
    v2.endYProperty().bind(pane.heightProperty());
    v2.startXProperty().bind(pane.widthProperty().divide(3)
      .add(pane.widthProperty().divide(3)));
    v2.endXProperty().bind(pane.widthProperty().divide(3)
      .add(pane.widthProperty().divide(3)));

    h1.setStroke(Color.BLUE);
    h2.setStroke(Color.BLUE);
    v1.setStroke(Color.RED);
    v2.setStroke(Color.RED);
    
    pane.getChildren().addAll(h1, h2, v1, v2);

    Scene scene = new Scene(pane, WIDTH, HEIGHT);
    primaryStage.setTitle("E14_16");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    Application.launch(args);
  }
}
