/*
  Write a program that simulates four cars racing. You can set the speed of
  each car, with maximum 100.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Insets;

public class E16_25 extends Application {
  @Override
  public void start(Stage primaryStage) {
    Label lbR1 = new Label("Car 1:");
    Label lbR2 = new Label("Car 2:");
    Label lbR3 = new Label("Car 3:");
    Label lbR4 = new Label("Car 4:");
    TextField tfR1 = new TextField("1");
    TextField tfR2 = new TextField("1");
    TextField tfR3 = new TextField("1");
    TextField tfR4 = new TextField("1");
    Button btStart = new Button("Start");
    RaceCar r1 = new RaceCar();
    RaceCar r2 = new RaceCar();
    RaceCar r3 = new RaceCar();
    RaceCar r4 = new RaceCar();

    btStart.setOnAction(e -> {
      String text = btStart.getText();
      if (text.equals("Start")) {
        btStart.setText("Stop");
        r1.start(Double.parseDouble(tfR1.getText()));
        r2.start(Double.parseDouble(tfR2.getText()));
        r3.start(Double.parseDouble(tfR3.getText()));
        r4.start(Double.parseDouble(tfR4.getText()));
      } else {
        btStart.setText("Start");
        r1.stop();
        r2.stop();
        r3.stop();
        r4.stop();
      }
    });

    HBox controlBox = new HBox(10);
    controlBox.getChildren().addAll(lbR1, tfR1, lbR2, tfR2, lbR3, tfR3,
      lbR4, tfR4, btStart);

    VBox carBox = new VBox(10);
    carBox.getChildren().addAll(r1, r2, r3, r4);

    BorderPane pane = new BorderPane();
    pane.setTop(controlBox);
    pane.setCenter(carBox);
    pane.setMargin(carBox, new Insets(20));

    Scene scene = new Scene(pane);
    primaryStage.setTitle("E16_25");
    primaryStage.setScene(scene);
    primaryStage.setResizable(false);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
