/*
  Write a program that displays a STOP sign. The octogon is in red and the
  sign is in white.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;
import javafx.collections.ObservableList;

public class E14_15 extends Application {
  @Override
  public void start(Stage primaryStage) {
    StopSign pane = new StopSign(300);

    Scene scene = new Scene(pane);
    primaryStage.setTitle("E14_15");
    primaryStage.setScene(scene);
    primaryStage.setResizable(false);
    primaryStage.show();
  }

  class StopSign extends StackPane {
    StopSign(double canvasSize) {
      // Create the octagon
      Polygon oct = new Polygon();
      oct.setFill(Color.RED);
      ObservableList<Double> list = oct.getPoints();

      double centerX = canvasSize / 2;
      double radius = canvasSize;

      for (int i = 0; i <= 8; i++) {
        list.add(centerX + radius * Math.cos(2 * i * Math.PI / 8));
        list.add(centerX - radius * Math.sin(2 * i * Math.PI / 8));
      }

      // Rotate so the octagon is sitting on a side
      oct.setRotate(45 / 2.0);

      // Create the sign text
      Text stop = new Text("STOP");
      stop.setFont(Font.font("Times New Roman", radius / 2));
      stop.setFill(Color.WHITE);

      getChildren().addAll(oct, stop);
    }
  }

  public static void main(String[] args) {
    Application.launch(args);
  }
}
