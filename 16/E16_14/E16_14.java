/*
  Write a program that can dynamically change the font of a text in a label
  displayed on a stack pane. The text can be displayed in bold and italic at
  the same time. You can select the font name or font size from combo boxes.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ComboBox;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.FontPosture;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;

public class E16_14 extends Application {
  static Label lbText = new Label("Programming is fun");
  static ComboBox<String> cbFontName = new ComboBox<>();
  static ComboBox<Integer> cbFontSize = new ComboBox<>();
  static CheckBox cbBold = new CheckBox("Bold");
  static CheckBox cbItalic = new CheckBox("Italic");

  @Override
  public void start(Stage primaryStage) {
    Label lbFontName = new Label("Font Name");
    Label lbFontSize = new Label("Font Size");

    // Add font names to combobox
    for (String font: Font.getFamilies()) {
      cbFontName.getItems().add(font);
    }

    // Add font sizes to combobox
    for (int i = 1; i <= 100; i++) {
      cbFontSize.getItems().add(i);
    }

    EventHandler<ActionEvent> changeFont = e -> {
      updateFont();
    };

    cbFontName.setOnAction(changeFont);
    cbFontSize.setOnAction(changeFont);
    cbBold.setOnAction(changeFont);
    cbItalic.setOnAction(changeFont);

    cbFontName.getSelectionModel().select(4);
    cbFontSize.getSelectionModel().select(12);

    updateFont();

    HBox controlTop = new HBox(10);
    controlTop.getChildren().addAll(lbFontName, cbFontName,
      lbFontSize, cbFontSize);
    HBox controlBottom = new HBox(10);
    controlBottom.getChildren().addAll(cbBold, cbItalic);
    controlTop.setAlignment(Pos.CENTER);
    controlBottom.setAlignment(Pos.CENTER);

    StackPane textPane = new StackPane();
    textPane.getChildren().add(lbText);

    BorderPane pane = new BorderPane();
    pane.setTop(controlTop);
    pane.setCenter(textPane);
    pane.setBottom(controlBottom);

    Scene scene = new Scene(pane, 500, 200);
    primaryStage.setTitle("E16_14");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void updateFont() {
    String fn = cbFontName.getSelectionModel().getSelectedItem();
    int fs = cbFontSize.getSelectionModel().getSelectedItem();
    FontWeight w = cbBold.isSelected() ? FontWeight.BOLD : FontWeight.NORMAL;
    FontPosture p = cbItalic.isSelected() ? FontPosture.ITALIC : FontPosture.REGULAR;
    lbText.setFont(Font.font(fn, w, p, fs));
  }

  public static void main(String[] args) {
    launch(args);
  }
}
