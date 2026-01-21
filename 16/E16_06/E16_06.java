/*
  Write a program that sets the horizontal alignment and column-size properties
  of a text field dynamically.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.input.KeyCode;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class E16_06 extends Application {
  @Override
  public void start(Stage primaryStage) {
    Label lbTextField = new Label("Text Field");
    Label lbColumnSize = new Label("Column Size");
    TextField tfTextField = new TextField();
    TextField tfColumnSize = new TextField();
    RadioButton rbLeft = new RadioButton("Left");
    RadioButton rbCenter = new RadioButton("Center");
    RadioButton rbRight = new RadioButton("Right");

    tfTextField.setText("JavaFX");
    tfTextField.setEditable(false);

    ToggleGroup tg = new ToggleGroup();
    rbLeft.setToggleGroup(tg);
    rbCenter.setToggleGroup(tg);
    rbRight.setToggleGroup(tg);

    rbLeft.setSelected(true);

    rbLeft.setOnAction(e -> tfTextField.setAlignment(Pos.CENTER_LEFT));
    rbCenter.setOnAction(e -> tfTextField.setAlignment(Pos.CENTER));
    rbRight.setOnAction(e -> tfTextField.setAlignment(Pos.CENTER_RIGHT));

    HBox textFieldBox = new HBox(10);
    HBox controlBox = new HBox(10);
    textFieldBox.setPadding(new Insets(10, 10, 0, 10));
    textFieldBox.setAlignment(Pos.CENTER);
    controlBox.setPadding(new Insets(10));
    controlBox.setAlignment(Pos.CENTER);

    textFieldBox.getChildren().addAll(lbTextField, tfTextField);
    controlBox.getChildren().addAll(rbLeft, rbCenter, rbRight,
      lbColumnSize, tfColumnSize);

    BorderPane pane = new BorderPane();
    pane.setCenter(textFieldBox);
    pane.setBottom(controlBox);

    tfColumnSize.setOnKeyPressed(e -> {
      if (e.getCode().equals(KeyCode.ENTER)) {
        tfTextField.setPrefWidth(Integer.parseInt(tfColumnSize.getText()));
      }
    });

    Scene scene = new Scene(pane);
    primaryStage.setTitle("E16_06");
    primaryStage.setScene(scene);
    primaryStage.show();

    tfColumnSize.requestFocus();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
