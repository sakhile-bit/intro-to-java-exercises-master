/*
  Write a program that displays a flag rising up. As the national flag rises,
  play the national anthem.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.animation.PathTransition;
import javafx.util.Duration;
import java.io.File;

public class E16_26 extends Application {
  @Override
  public void start(Stage primaryStage) {
    Pane pane = new Pane();
    Line line = new Line(80, 500, 80, 42);
    line.setStroke(Color.TRANSPARENT);
    ImageView iv = new ImageView("us.gif");
    File file = new File("anthem6.mp3");
    Media anthem = new Media(file.toURI().toString());
    MediaPlayer player = new MediaPlayer(anthem);
    PathTransition pt = new PathTransition(
      Duration.millis(30000), line, iv);
    pane.getChildren().addAll(line, iv);
    pt.play();
    player.play();

    Scene scene = new Scene(pane);
    primaryStage.setTitle("E16_26");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
