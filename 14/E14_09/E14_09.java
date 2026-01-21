/*
  Write a program that places four fans in a GridPane with two rows and two
  columns.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class E14_09 extends Application {
  @Override
  public void start(Stage primaryStage) {
    FanGrid pane = new FanGrid(2, 75);
    pane.setAlignment(Pos.CENTER);
    pane.setPadding(new Insets(5));
    pane.setVgap(5);
    pane.setHgap(5);

    Scene scene = new Scene(pane);
    primaryStage.setTitle("E14_09");
    primaryStage.setScene(scene);
    primaryStage.setResizable(false);
    primaryStage.show();
  }

  class FanGrid extends GridPane {
    FanGrid(int n, double radius) {
      for (int col = 0; col < n; col++) {
        for (int row = 0; row < n; row++) {
          FanPane fanPane = new FanPane(radius);
          add(fanPane, col, row);
        }
      }
    }
  }

  class FanPane extends StackPane {
    FanPane(double radius) {
      Circle circle = new Circle(radius);
      circle.setStroke(Color.BLACK);
      circle.setFill(Color.WHITE);
      getChildren().add(circle);

      Pane pane = new Pane();
      for (int i = 0, j = 25; i < 4; i++, j += 90) {
        Arc arc = new Arc(radius, radius, radius * 0.9, radius * 0.9, j, 40);
        arc.setFill(Color.BLACK);
        arc.setType(ArcType.ROUND);
        pane.getChildren().add(arc);
      }
      getChildren().add(pane);
    }
  }

  public static void main(String[] args) {
    Application.launch(args);
  }
}
