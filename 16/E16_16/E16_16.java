/*
  Write a program that demonstrates selecting items in a list. The program
  uses a combo box to specify a selection mode. When you select items, they are
  displayed in a label below the list.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;

public class E16_16 extends Application {
  @Override
  public void start(Stage primaryStage) {
    Label lbChoose = new Label("Choose Selection Mode:");
    Label lbDisplay = new Label("Selected: ");
    ComboBox<SelectionMode> cbChoose = new ComboBox<>();
    ListView<String> lvCountry = new ListView<>();

    for (SelectionMode s: SelectionMode.values()) {
      cbChoose.getItems().add(s);
    }

    String[] countries = {"China", "Japan", "Korea", "India", "Malaysia",
      "Vietnam"};

    for (String c: countries) {
      lvCountry.getItems().add(c);
    }

    cbChoose.getSelectionModel().select(SelectionMode.SINGLE);
    cbChoose.setOnAction(e -> {
      SelectionMode s = cbChoose.getSelectionModel().getSelectedItem();
      lvCountry.getSelectionModel().setSelectionMode(s);
    });

    lvCountry.setOnMouseClicked(e -> {
      lbDisplay.setText("Selected: ");
      String s = "";
      for (String country: lvCountry.getSelectionModel().getSelectedItems()) {
        s += country + " ";
      }
      lbDisplay.setText(lbDisplay.getText() + s);
    });

    HBox topControl = new HBox(10);
    topControl.getChildren().addAll(lbChoose, cbChoose);

    BorderPane pane = new BorderPane();
    pane.setTop(topControl);
    pane.setCenter(lvCountry);
    pane.setBottom(lbDisplay);

    Scene scene = new Scene(pane);
    primaryStage.setTitle("E16_16");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
