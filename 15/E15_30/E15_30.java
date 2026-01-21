/*
  Write a program that automatically displays slides repeatedly. Each slide
  is shown for two seconds. The slides are displayed in order. When the last
  slide finishes, the first slide is redisplayed, and so on. Click to pause if
  the animation is currently playing. Click to resume if the animation is
  currently paused.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.Animation;
import javafx.util.Duration;

public class E15_30 extends Application {
  static int currentIndex = 0;
  static ImageView[] images = getImages();
  static StackPane pane = new StackPane();

  @Override
  public void start(Stage primaryStage) {
    final double WIDTH = 500.0;
    final double HEIGHT = 500.0;

    KeyFrame keyFrame = new KeyFrame(Duration.millis(50), e -> next());
    Timeline timeline = new Timeline(keyFrame);
    timeline.setCycleCount(Timeline.INDEFINITE);
    timeline.play();

    pane.setOnMouseClicked(e -> {
      if (timeline.getStatus().equals(Animation.Status.RUNNING)) {
        timeline.pause();
      } else {
        timeline.play();
      }
    });

    Scene scene = new Scene(pane, WIDTH, HEIGHT);
    primaryStage.setTitle("E15_30");
    primaryStage.setScene(scene);
    primaryStage.show();

    pane.requestFocus();
  }

  public static void next() {
    if (currentIndex >= images.length) { currentIndex = 0; }
    pane.getChildren().clear();
    pane.getChildren().add(images[currentIndex]);
    currentIndex++;
  }

  public static ImageView[] getImages() {
    ImageView[] images = new ImageView[52];
    for (int i = 0; i < images.length; i++) {
      images[i] = new ImageView("image/L" + (i + 1) + ".gif");
    }
    return images;
  }

  public static void main(String[] args) {
    launch(args);
  }
}
