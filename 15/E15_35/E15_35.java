/*
  Revise the preceding exercise to display the walk step by step in an
  animation.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import java.util.ArrayList;

public class E15_35 extends Application {
  static int currentIndex = 0;
  static ArrayList<Point2D> points = new ArrayList<>();

  @Override
  public void start(Stage primaryStage) {
    int size = 16;
    SelfAvoidingWalk walk = new SelfAvoidingWalk(size);
    LatticePane latticePane = new LatticePane(size, 20);

    Button btStart = new Button("Start");
    btStart.setOnAction(e -> startPathAnimation(latticePane, walk));

    HBox controlPane = new HBox();
    controlPane.getChildren().add(btStart);
    controlPane.setAlignment(Pos.CENTER);

    BorderPane pane = new BorderPane();
    pane.setCenter(latticePane);
    pane.setBottom(controlPane);
    pane.setMargin(latticePane, new Insets(20));
    pane.setMargin(controlPane, new Insets(0, 0, 20, 0));

    startPathAnimation(latticePane, walk);

    Scene scene = new Scene(pane);
    primaryStage.setTitle("E15_35");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void startPathAnimation(LatticePane latticePane, SelfAvoidingWalk walk) {
    currentIndex = 0;
    walk.walk();
    points = walk.getPath();

    KeyFrame keyFrame = new KeyFrame(Duration.millis(500), e -> {
      if (currentIndex == points.size()) { currentIndex = 0; }
      latticePane.nextStep(currentIndex, points);
      currentIndex++;
    });

    Timeline timeline = new Timeline(keyFrame);
    timeline.setCycleCount(Timeline.INDEFINITE);
    timeline.play();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
