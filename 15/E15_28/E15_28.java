/*
  Write a program that displays a running fan. Use the Pause, Resume, Reverse
  buttons to pause, resume, and reverse fan running.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.paint.Color;
import javafx.scene.control.Button;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class E15_28 extends Application {
  boolean isSpinningLeft = true;

  @Override
  public void start(Stage primaryStage){
    final double WIDTH = 500.0;
    final double HEIGHT = 500.0;
    final double CENTER_X = WIDTH / 2;
    final double CENTER_Y = WIDTH / 2;
    final double RADIUS = 200.0;
    Pane fanPane = new Pane();
    HBox controlPane = new HBox();
    BorderPane pane = new BorderPane();
    Arc[] blades = new Arc[4];

    // Set up the BorderPane
    pane.setCenter(fanPane);
    pane.setBottom(controlPane);

    // Create the fan
    Circle fanCircle = new Circle(CENTER_X, CENTER_Y, RADIUS);
    fanCircle.setFill(Color.TRANSPARENT);
    fanCircle.setStroke(Color.BLACK);

    for (int i = 0, sa = 0; i < 4; i++, sa += 90) {
      Arc arc = new Arc(CENTER_X, CENTER_Y, RADIUS - 10, RADIUS - 10, sa, 45);
      arc.setType(ArcType.ROUND);
      blades[i] = arc;
      fanPane.getChildren().add(arc);
    }

    fanPane.getChildren().addAll(fanCircle);

    // Create the control menu
    Button btPause = new Button("Pause");
    Button btResume = new Button("Resume");
    Button btReverse = new Button("Reverse");

    controlPane.getChildren().addAll(btPause, btResume, btReverse);

    // Create the KeyFrame animation
    EventHandler<ActionEvent> spinFan = e -> {
      int increment = isSpinningLeft ? 1 : -1;
      for (int i = 0; i < blades.length; i++) {
        double prevStartAngle = blades[i].getStartAngle();
        blades[i].setStartAngle(prevStartAngle + increment);
      }
    };

    KeyFrame kf = new KeyFrame(Duration.millis(1), spinFan);

    Timeline tl = new Timeline(kf);
    tl.setCycleCount(Timeline.INDEFINITE);
    tl.play();

    // Set up the button handlers
    btPause.setOnAction(e -> tl.pause());
    btResume.setOnAction(e -> tl.play());
    btReverse.setOnAction(e -> isSpinningLeft = !isSpinningLeft);

    Scene scene = new Scene(pane, WIDTH, HEIGHT);
    primaryStage.setTitle("E15_28");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
