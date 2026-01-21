/*
  Write a program that displays two clocks. The hour, minute, and second values
  are 4, 20, 45 for the first clock and 22, 46, 15 for the second clock.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

public class E14_26 extends Application {
  @Override
  public void start(Stage primaryStage) {
    ClockPane c1 = new ClockPane(4, 20, 45);
    ClockPane c2 = new ClockPane(22, 46, 15);

    GridPane pane = new GridPane();
    pane.setAlignment(Pos.CENTER);
    pane.setPadding(new Insets(15));
    pane.setHgap(15);
    pane.addRow(0, c1, c2);

    Scene scene = new Scene(pane);
    primaryStage.setTitle("E14_26");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    Application.launch(args);
  }
}
