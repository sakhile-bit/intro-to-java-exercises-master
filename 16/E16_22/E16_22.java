/*
  Write a program that meets the following requirements:

  - Get an audio file from the class directory using AudioClip.
  - Place three buttons labeled Play, Loop, and Stop.
  - If you click the Play button, the audio file is played once. If you click
    the Loop button, the audio file keeps playing repeatedly. If you click the
    Stop button, the playing stops.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.media.AudioClip;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import java.io.File;

public class E16_22 extends Application {
  @Override
  public void start(Stage primaryStage) {
    Button btPlay = new Button("Play");
    Button btLoop = new Button("Loop");
    Button btStop = new Button("Stop");

    File file = new File("dog_bark6.wav");
    AudioClip audio = new AudioClip(file.toURI().toString());

    btPlay.setOnAction(e -> {
      audio.stop();
      audio.setCycleCount(1);
      audio.play();
    });

    btLoop.setOnAction(e -> {
      audio.stop();
      audio.setCycleCount(AudioClip.INDEFINITE);
      audio.play();
    });

    btStop.setOnAction(e -> audio.stop());

    HBox pane = new HBox(10);
    pane.getChildren().addAll(btPlay, btLoop, btStop);
    pane.setPadding(new Insets(20));
    pane.setAlignment(Pos.CENTER);

    Scene scene = new Scene(pane);
    primaryStage.setTitle("E16_22");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
