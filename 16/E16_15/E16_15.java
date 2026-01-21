/*
  Write a program to let the user dynamically set the properties contentDisplay
  and graphicTextGap in a Label.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.input.KeyCode;
import javafx.geometry.Pos;

public class E16_15 extends Application {
  @Override
  public void start(Stage primaryStage) {
    Label lbContentDisplay = new Label("contentDisplay:");
    Label lbGraphicTextGap = new Label("graphicTextGap:");
    ComboBox<ContentDisplay> cbContentDisplay = new ComboBox<>();
    TextField tfGraphicTextGap = new TextField();
    ImageView ivGrapes = new ImageView("grapes.gif");
    Label lbContent = new Label("Grapes", ivGrapes);

    tfGraphicTextGap.setPrefWidth(80);

    // Add ContentDisplay values to combobox
    for (ContentDisplay cd: ContentDisplay.values()) {
      cbContentDisplay.getItems().add(cd);
    }

    cbContentDisplay.setOnAction(e -> {
      ContentDisplay cd = cbContentDisplay.getSelectionModel().getSelectedItem();
      lbContent.setContentDisplay(cd);
    });

    tfGraphicTextGap.setOnKeyPressed(e -> {
      if (e.getCode().equals(KeyCode.ENTER)) {
        double gap = Double.parseDouble(tfGraphicTextGap.getText());
        lbContent.setGraphicTextGap(gap);
      }
    });

    HBox controlBox = new HBox(10);
    controlBox.getChildren().addAll(lbContentDisplay, cbContentDisplay,
      lbGraphicTextGap, tfGraphicTextGap);
    controlBox.setAlignment(Pos.CENTER);

    StackPane contentPane = new StackPane();
    contentPane.getChildren().add(lbContent);

    BorderPane pane = new BorderPane();
    pane.setCenter(contentPane);
    pane.setTop(controlBox);

    Scene scene = new Scene(pane, 500, 200);
    primaryStage.setTitle("E16_15");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
