/*
  Write a program that converts between decimal, hex, and binary numbers. When
  you enter a decimal value in the decimal value text field and press the
  Enter key, its corresponding hex and binary numbers are displayed in the
  other two text fields. Likewise, you can enter values in other fields and
  convert them accordingly.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.input.KeyCode;

public class E16_05 extends Application {
  @Override
  public void start(Stage primaryStage) {
    Label lbDecimal = new Label("Decimal");
    Label lbHex = new Label("Hex");
    Label lbBinary = new Label("Binary");
    TextField tfDecimal = new TextField();
    TextField tfHex = new TextField();
    TextField tfBinary = new TextField();

    tfDecimal.setAlignment(Pos.CENTER_RIGHT);
    tfHex.setAlignment(Pos.CENTER_RIGHT);
    tfBinary.setAlignment(Pos.CENTER_RIGHT);

    GridPane pane = new GridPane();
    pane.addColumn(0, lbDecimal, lbHex, lbBinary);
    pane.addColumn(1, tfDecimal, tfHex, tfBinary);
    pane.setAlignment(Pos.CENTER);
    pane.setPadding(new Insets(10, 20, 10, 20));

    tfDecimal.setOnKeyPressed(e -> {
      if (e.getCode().equals(KeyCode.ENTER)) {
        int decimal = Integer.parseInt(tfDecimal.getText(), 10);
        tfHex.setText(Integer.toHexString(decimal));
        tfBinary.setText(Integer.toBinaryString(decimal));
      }
    });

    tfHex.setOnKeyPressed(e -> {
      if (e.getCode().equals(KeyCode.ENTER)) {
        int decimal = Integer.parseInt(tfHex.getText(), 16);
        tfDecimal.setText(String.valueOf(decimal));
        tfBinary.setText(Integer.toBinaryString(decimal));
      }
    });

    tfBinary.setOnKeyPressed(e -> {
      if (e.getCode().equals(KeyCode.ENTER)) {
        int decimal = Integer.parseInt(tfBinary.getText(), 2);
        tfDecimal.setText(String.valueOf(decimal));
        tfHex.setText(Integer.toHexString(decimal));
      }
    });

    Scene scene = new Scene(pane);
    primaryStage.setTitle("E16_05");
    primaryStage.setScene(scene);
    primaryStage.setResizable(false);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
