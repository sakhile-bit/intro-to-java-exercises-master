/*
  Write a program that draws a diagram for the function f(x) = x^2.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.collections.ObservableList;

public class E14_18 extends Application {
  @Override
  public void start(Stage primaryStage) {
    final double WINDOW = 400.0;

    Pane graphPane = new Pane();
    drawArrow(0, WINDOW / 5 * 4, WINDOW, WINDOW / 5 * 4, graphPane);
    drawArrow(WINDOW / 2, WINDOW, WINDOW / 2, 0, graphPane);

    Polyline polyline = new Polyline();
    ObservableList<Double> list = polyline.getPoints();
    double scaleFactor = 0.0125;
    for (int x = -150; x <= 150; x++) {
      double pX = x + (WINDOW / 2);
      double pY = (scaleFactor * x * x) + (WINDOW / 5 * 4);
      list.add(pX);
      list.add(pY - 2 * (pY - (WINDOW / 5 * 4)));
    }

    graphPane.getChildren().add(polyline);

    StackPane pane = new StackPane();
    pane.setPadding(new Insets(20));
    pane.setAlignment(Pos.CENTER);
    pane.getChildren().add(graphPane);

    Scene scene = new Scene(pane);
    primaryStage.setTitle("E14_18");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void drawArrow(double startX, double startY,
    double endX, double endY, Pane pane) {
    double slope = (startY - endY) / (startX - endX);
    double lineAngle = Math.atan(slope);
    double arrowAngle = endX <= startX ? Math.toRadians(45) : -Math.toRadians(225);

    Line line = new Line(startX, startY, endX, endY);

    double lineLength = Math.sqrt(Math.pow(startX - endX, 2) + Math.pow(startY - endY, 2));
    double arrowLength = lineLength / 12;
    Line arrow1 = new Line();
    arrow1.setStartX(line.getEndX());
    arrow1.setStartY(line.getEndY());
    arrow1.setEndX(line.getEndX() + arrowLength * Math.cos(lineAngle + arrowAngle));
    arrow1.setEndY(line.getEndY() + arrowLength * Math.sin(lineAngle + arrowAngle));
    Line arrow2 = new Line();
    arrow2.setStartX(line.getEndX());
    arrow2.setStartY(line.getEndY());
    arrow2.setEndX(line.getEndX() + arrowLength * Math.cos(lineAngle - arrowAngle));
    arrow2.setEndY(line.getEndY() + arrowLength * Math.sin(lineAngle - arrowAngle));

    pane.getChildren().addAll(line, arrow1, arrow2);
  }

  public static void main(String[] args) {
    Application.launch(args);
  }
}
