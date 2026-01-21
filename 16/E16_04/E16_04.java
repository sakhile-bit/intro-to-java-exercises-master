/*
  Write a program that converts miles and kilometers. If you enter a value in
  the Mile text field and press the Enter key, the corresponding kilometer
  measurement is displayed in the Kilometer text field. Likewise, if you enter
  a value in the Kilometer text field and press the Enter key, the
  corresponding miles is displayed in the Mile text field.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.input.KeyCode;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

public class E16_04 extends Application {
  @Override
  public void start(Stage primaryStage) {
    Label lbMile = new Label("Mile");
    Label lbKilometer = new Label("Kilometer");
    TextField tfMile = new TextField();
    TextField tfKilometer = new TextField();

    tfMile.setAlignment(Pos.CENTER_RIGHT);
    tfKilometer.setAlignment(Pos.CENTER_RIGHT);

    GridPane pane = new GridPane();
    pane.addColumn(0, lbMile, lbKilometer);
    pane.addColumn(1, tfMile, tfKilometer);
    pane.setAlignment(Pos.CENTER);
    pane.setPadding(new Insets(10, 20, 10, 20));

    tfMile.setOnKeyPressed(e -> {
      if (e.getCode().equals(KeyCode.ENTER)) {
        tfKilometer.setText
          (String.valueOf(mToK(Double.parseDouble(tfMile.getText()))));
      }
    });

    tfKilometer.setOnKeyPressed(e -> {
      if (e.getCode().equals(KeyCode.ENTER)) {
        tfMile.setText
          (String.valueOf(kToM(Double.parseDouble(tfKilometer.getText()))));
      }
    });

    Scene scene = new Scene(pane, 300, 100);
    primaryStage.setTitle("E16_04");
    primaryStage.setScene(scene);
    primaryStage.setResizable(false);
    primaryStage.show();
  }

  public static double mToK(double m) {
    return m * 1.60934;
  }

  public static double kToM(double k) {
    return k / 1.60934;
  }

  public static void main(String[] args) {
    launch(args);
  }
}
