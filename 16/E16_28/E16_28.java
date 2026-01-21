/*
  Programming Exercise 15.30 developed a slide show using images. Rewrite that
  program to develop a slide show using text files. Suppose ten text files
  named slide0.txt, slide1.txt, ..., and slide9.txt are stored in a directory.
  Each slide displays the text from one file. Each slide is shown for one
  second, and the slides are displayed in order. When the last slide finishes,
  the first slide is redisplayed, and so on. Use a text area to display the
  slide.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import javafx.geometry.Pos;
import java.util.Scanner;
import java.io.File;

public class E16_28 extends Application {
  private int currentSlide = 0;

  @Override
  public void start(Stage primaryStage) {
    TextArea taSlide = new TextArea();
    Button btStart = new Button("Start");

    btStart.setOnAction(e -> {
      KeyFrame kf = new KeyFrame(Duration.millis(1000), f -> {
        File file = new File("slide" + currentSlide + ".txt");
        try (
          Scanner input = new Scanner(file);
        ) {
          StringBuilder sb = new StringBuilder();
          if (input.hasNext()) {
            sb.append(input.nextLine() + "\n");
          }
          taSlide.setText(sb.toString());
        } catch (Exception ex) {
          System.out.println(ex);
        }
        if (currentSlide == 9) { currentSlide = 0; }
        else { currentSlide++; }
      });

      Timeline timeline = new Timeline(kf);
      timeline.setCycleCount(Timeline.INDEFINITE);
      timeline.play();
      btStart.setDisable(true);
    });

    BorderPane pane = new BorderPane();
    pane.setCenter(taSlide);
    pane.setBottom(btStart);
    pane.setAlignment(btStart, Pos.CENTER);

    Scene scene = new Scene(pane);
    primaryStage.setTitle("E16_28");
    primaryStage.setScene(scene);
    primaryStage.setResizable(false);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
