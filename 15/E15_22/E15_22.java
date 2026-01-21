/*
  Rewrite Programming Exercise 14.10 so that the cylinder's width and height
  are automatically resized when the window is resized.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.paint.Color;

public class E15_22 extends Application {
  @Override
  public void start(Stage primaryStage) {
    final double WIDTH = 500.0;
    final double HEIGHT = 500.0;
    final double X_RADIUS = WIDTH / 3;
    final double Y_RADIUS = HEIGHT / 10;
    Pane pane = new Pane();

    // top of cylinder
    Ellipse topEllipse = new Ellipse(WIDTH / 2, HEIGHT / 5, X_RADIUS, Y_RADIUS);
    topEllipse.centerXProperty().bind(pane.widthProperty().divide(2));
    topEllipse.radiusXProperty().bind(pane.widthProperty().divide(3));
    topEllipse.setFill(Color.TRANSPARENT);
    topEllipse.setStroke(Color.BLACK);

    // bottom of cylinder
    Arc bottomTopArc =
      new Arc(WIDTH / 2, HEIGHT / 5 * 4, X_RADIUS, Y_RADIUS, 0, 180);
    bottomTopArc.centerXProperty().bind(pane.widthProperty().divide(2));
    bottomTopArc.radiusXProperty().bind(pane.widthProperty().divide(3));
    bottomTopArc.centerYProperty()
      .bind(pane.heightProperty().divide(5).multiply(4));
    bottomTopArc.setFill(Color.TRANSPARENT);
    bottomTopArc.setStroke(Color.BLACK);
    bottomTopArc.setType(ArcType.OPEN);
    bottomTopArc.getStrokeDashArray().addAll(6.0, 21.0);

    Arc bottomBotArc =
      new Arc(WIDTH / 2, HEIGHT / 5 * 4, X_RADIUS, Y_RADIUS, 180, 180);
    bottomBotArc.centerXProperty().bind(pane.widthProperty().divide(2));
    bottomBotArc.radiusXProperty().bind(pane.widthProperty().divide(3));
    bottomBotArc.centerYProperty()
      .bind(pane.heightProperty().divide(5).multiply(4));
    bottomBotArc.setFill(Color.TRANSPARENT);
    bottomBotArc.setStroke(Color.BLACK);
    bottomBotArc.setType(ArcType.OPEN);

    // sides of cylinder
    Line leftSide = new Line();
    leftSide.startXProperty().bind
      (topEllipse.centerXProperty().subtract(topEllipse.radiusXProperty()));
    leftSide.startYProperty().bind(topEllipse.centerYProperty());
    leftSide.endXProperty().bind
      (bottomTopArc.centerXProperty().subtract(bottomTopArc.radiusXProperty()));
    leftSide.endYProperty().bind(bottomTopArc.centerYProperty());

    Line rightSide = new Line();
    rightSide.startXProperty().bind
      (topEllipse.centerXProperty().add(topEllipse.radiusXProperty()));
    rightSide.startYProperty().bind(topEllipse.centerYProperty());
    rightSide.endXProperty().bind
      (bottomTopArc.centerXProperty().add(bottomTopArc.radiusXProperty()));
    rightSide.endYProperty().bind(bottomTopArc.centerYProperty());

    pane.getChildren().addAll(topEllipse, bottomTopArc, bottomBotArc,
      leftSide, rightSide);

    Scene scene = new Scene(pane, WIDTH, HEIGHT);
    primaryStage.setTitle("E15_22");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
