/*
  Modify Listing 14.21, ClockPane.java, to add the animation into this class
  and add two methods start() and stop() to start and stop the clock. Write a
  program that lets the user control the clock with the Start and Stop buttons.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

public class E15_32 extends Application {
  @Override
  public void start(Stage primaryStage) {
    ClockPane clockPane = new ClockPane();
    HBox controlPane = new HBox();

    Button btStop = new Button("Stop");
    Button btStart = new Button("Start");

    controlPane.getChildren().addAll(btStop, btStart);
    controlPane.setAlignment(Pos.CENTER);

    btStop.setOnAction(e -> clockPane.stop());
    btStart.setOnAction(e -> clockPane.start());

    BorderPane pane = new BorderPane();
    pane.setCenter(clockPane);
    pane.setBottom(controlPane);
    pane.setPadding(new Insets(20));

    Scene scene = new Scene(pane);
    primaryStage.setTitle("E15_32");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
