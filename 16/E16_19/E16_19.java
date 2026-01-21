/*
  Write a program that displays three fans in a group, with control buttons to
  start and stop all of them.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.geometry.Pos;

public class E16_19 extends Application {
  @Override
  public void start(Stage primaryStage) {
    FanPane f1 = new FanPane(300);
    FanPane f2 = new FanPane(300);
    FanPane f3 = new FanPane(300);
    String style = "-fx-border-color: black";
    f1.setStyle(style);
    f2.setStyle(style);
    f3.setStyle(style);

    HBox fanBox = new HBox(10);
    fanBox.getChildren().addAll(f1, f2, f3);

    Button btStartAll = new Button("Start All");
    Button btStopAll = new Button("Stop All");

    btStartAll.setOnAction(e -> {
      f1.startFan();
      f2.startFan();
      f3.startFan();
    });

    btStopAll.setOnAction(e -> {
      f1.stopFan();
      f2.stopFan();
      f3.stopFan();
    });

    HBox buttonBox = new HBox(10);
    buttonBox.getChildren().addAll(btStartAll, btStopAll);
    buttonBox.setAlignment(Pos.CENTER);

    BorderPane pane = new BorderPane();
    pane.setCenter(fanBox);
    pane.setBottom(buttonBox);

    Scene scene = new Scene(pane);
    primaryStage.setTitle("E16_19");
    primaryStage.setScene(scene);
    primaryStage.setResizable(false);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
