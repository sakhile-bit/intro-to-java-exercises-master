/*
  Write a program that demonstrates the properties of a text area. The program
  uses a check box to indicate whether the text is wrapped onto the next line
  and another to indicate whether the text is editable.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.CheckBox;
import javafx.geometry.Pos;

public class E16_12 extends Application {
  @Override
  public void start(Stage primaryStage) {
    TextArea taText = new TextArea();
    taText.setWrapText(true);
    ScrollPane spText = new ScrollPane(taText);

    CheckBox cbEditable = new CheckBox("Editable");
    CheckBox cbWrap = new CheckBox("Wrap");
    cbEditable.setSelected(true);
    cbWrap.setSelected(true);

    HBox controlBox = new HBox(20);
    controlBox.getChildren().addAll(cbEditable, cbWrap);
    controlBox.setAlignment(Pos.CENTER);

    cbEditable.setOnAction(e -> {
      taText.setEditable(cbEditable.isSelected() ? true : false);
    });

    cbWrap.setOnAction(e -> {
      taText.setWrapText(cbWrap.isSelected() ? true : false);
    });

    BorderPane pane = new BorderPane();
    pane.setCenter(spText);
    pane.setBottom(controlBox);

    Scene scene = new Scene(pane);
    primaryStage.setTitle("E16_12");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
