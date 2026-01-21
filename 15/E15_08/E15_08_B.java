/*
  Write two programs, such that one displays the mouse position when the
  mouse button is clicked and the other displays the mouse position when the
  mouse button is pressed and ceases to display it when the mouse button is
  released.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class E15_08_B extends Application {
  @Override
  public void start(Stage primaryStage) {
    Pane pane = new Pane();

    pane.setOnMousePressed(e -> {
      double x = e.getX();
      double y = e.getY();
      Text position = new Text("(" + x + ", " + y + ")");
      position.setX(x);
      position.setY(y);
      pane.getChildren().add(position);
    });

    pane.setOnMouseDragged(e -> {
      pane.getChildren().clear();
      double x = e.getX();
      double y = e.getY();
      Text position = new Text("(" + x + ", " + y + ")");
      position.setX(x);
      position.setY(y);
      pane.getChildren().add(position);
    });

    pane.setOnMouseReleased(e -> {
      pane.getChildren().clear();
    });

    Scene scene = new Scene(pane, 500, 500);
    primaryStage.setTitle("E15_08_A");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
