/*
  Write a program that displays a clock and sets the time with the input from
  three text fields.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

public class E16_07 extends Application {
  @Override
  public void start(Stage primaryStage) {
    ClockPane clockPane = new ClockPane();
    clockPane.setMaxWidth(clockPane.getW());
    clockPane.setMaxHeight(clockPane.getH());

    Label lbHour = new Label("Hour");
    Label lbMinute = new Label("Minute");
    Label lbSecond = new Label("Second");
    TextField tfHour = new TextField();
    TextField tfMinute = new TextField();
    TextField tfSecond = new TextField();

    tfHour.setPrefWidth(50);
    tfMinute.setPrefWidth(50);
    tfSecond.setPrefWidth(50);

    HBox controlPane = new HBox(10);
    controlPane.getChildren().addAll(lbHour, tfHour, lbMinute, tfMinute,
      lbSecond, tfSecond);
    controlPane.setAlignment(Pos.CENTER);

    BorderPane pane = new BorderPane();
    pane.setCenter(clockPane);
    pane.setBottom(controlPane);
    pane.setMargin(clockPane, new Insets(20));
    pane.setMargin(controlPane, new Insets(0, 20, 10, 20));

    EventHandler<KeyEvent> setTime = e -> {
      if (e.getCode().equals(KeyCode.ENTER)) {
        int hour = Integer.parseInt(tfHour.getText());
        int minute = Integer.parseInt(tfMinute.getText());
        int second = Integer.parseInt(tfSecond.getText());
        clockPane.setHour(hour);
        clockPane.setMinute(minute);
        clockPane.setSecond(second);
      }
    };

    tfHour.setOnKeyPressed(setTime);
    tfMinute.setOnKeyPressed(setTime);
    tfSecond.setOnKeyPressed(setTime);

    Scene scene = new Scene(pane);
    primaryStage.setTitle("E16_07");
    primaryStage.setScene(scene);
    primaryStage.setResizable(false);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
