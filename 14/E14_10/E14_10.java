/*
  Write a program that draws a cylinder.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Line;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

public class E14_10 extends Application {
  @Override
  public void start(Stage primaryStage) {
    CylinderPane pane = new CylinderPane(200, 200 / 2.5);
    pane.setPadding(new Insets(20));

    Scene scene = new Scene(pane);
    primaryStage.setTitle("E14_10");
    primaryStage.setScene(scene);
    primaryStage.setResizable(false);
    primaryStage.show();
  }

  class CylinderPane extends StackPane {
    CylinderPane(double xRadius, double yRadius) {
      // Container pane for all the shapes
      Pane pane = new Pane();

      // The top ellipse
      Arc topArc = new Arc(xRadius, yRadius, xRadius, yRadius, 0, 360);
      topArc.setFill(Color.WHITE);
      topArc.setStroke(Color.BLACK);

      // The top half of the bottom ellipse, which should be dashed in order
      // to denote that it is "unseen" behind the cylinder.
      Arc bottomDash =
        new Arc(xRadius, yRadius + yRadius * 5, xRadius, yRadius, 0, 180);
      bottomDash.setFill(Color.WHITE);
      bottomDash.setStroke(Color.BLACK);
      bottomDash.getStrokeDashArray().addAll(6.0, 21.0);

      // The bottom half of the bottom ellipse, drawn solid since it is on the
      // front of the cylinder.
      Arc bottomSolid =
        new Arc(xRadius, yRadius + yRadius * 5, xRadius, yRadius, 180, 180);
      bottomSolid.setFill(Color.WHITE);
      bottomSolid.setStroke(Color.BLACK);
      bottomSolid.setType(ArcType.OPEN);

      // The lines connecting the top and bottom ellipses.
      Line leftLine = new Line(0, yRadius, 0, yRadius + yRadius * 5);
      leftLine.setStroke(Color.BLACK);
      Line rightLine =
        new Line(xRadius * 2, yRadius, xRadius * 2, yRadius + yRadius * 5);

      // Shapes added to container
      pane.getChildren().addAll(
        topArc, bottomDash, bottomSolid, leftLine, rightLine);

      // Container added to StackPane for presentation
      getChildren().add(pane);
    }
  }

  public static void main(String[] args) {
    Application.launch(args);
  }
}
