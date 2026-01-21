/*
  Write a static method that draws an arrow line from a starting point to an
  ending point in a pane using the following method header:

  public static void drawArrowLine(double startX, double startY,
    double endX, double endY, Pane pane)

  Write a test program that randomly draws an arrow line.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Line;
import javafx.geometry.Insets;

public class E14_20 extends Application {
  @Override
  public void start(Stage primaryStage) {
    final double WINDOW = 200.0;

    double startX = Math.random() * WINDOW;
    double startY = Math.random() * WINDOW;
    double endX = Math.random() * WINDOW;
    double endY = Math.random() * WINDOW;
    Pane arrowPane = new Pane();
    drawArrowLine(startX, startY, endX, endY, arrowPane);

    StackPane pane = new StackPane();
    pane.setPadding(new Insets(20));
    pane.getChildren().add(arrowPane);

    Scene scene = new Scene(pane);
    primaryStage.setTitle("E14_20");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void drawArrowLine(double startX, double startY,
    double endX, double endY, Pane pane) {
    // get the slope of the line and find its angle
    double slope = (startY - endY) / (startX - endX);
    double lineAngle = Math.atan(slope);

    // choose an arrow angle, making sure that the arrow legs point back away
    // from the endpoint of the line
    double arrowAngle =
      startX > endX ? Math.toRadians(45) : -Math.toRadians(225);

    // create the line itself
    Line line = new Line(startX, startY, endX, endY);

    // find the length of the line and use that to determine the length of the
    // arrow legs
    double lineLength =
      Math.sqrt(Math.pow(startX - endX, 2) + Math.pow(startY - endY, 2));
    double arrowLength = lineLength / 10;

    // create the arrow legs
    Line arrow1 = new Line();
    arrow1.setStartX(line.getEndX());
    arrow1.setStartY(line.getEndY());
    arrow1.setEndX(line.getEndX() + arrowLength *
      Math.cos(lineAngle - arrowAngle));
    arrow1.setEndY(line.getEndY() + arrowLength *
      Math.sin(lineAngle - arrowAngle));

    Line arrow2 = new Line();
    arrow2.setStartX(line.getEndX());
    arrow2.setStartY(line.getEndY());
    arrow2.setEndX(line.getEndX() + arrowLength *
      Math.cos(lineAngle + arrowAngle));
    arrow2.setEndY(line.getEndY() + arrowLength *
      Math.sin(lineAngle + arrowAngle));

    pane.getChildren().addAll(line, arrow1, arrow2);
  }

  public static void main(String[] args) {
    Application.launch(args);
  }
}
