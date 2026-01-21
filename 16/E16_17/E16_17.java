/*
  Write a program that uses scrollbars to select the color for a text. Four
  horizontal scrollbars are used for selecting the colors: red, green, blue,
  and opacity percentages.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.beans.value.ChangeListener;

public class E16_17 extends Application {
  @Override
  public void start(Stage primaryStage) {
    Text tShowColors = new Text("Show Colors");
    Label lbRed = new Label("Red");
    Label lbGreen = new Label("Green");
    Label lbBlue = new Label("Blue");
    Label lbOpacity = new Label("Opacity");
    ScrollBar sbRed = new ScrollBar();
    ScrollBar sbGreen = new ScrollBar();
    ScrollBar sbBlue = new ScrollBar();
    ScrollBar sbOpacity = new ScrollBar();
    sbRed.setMin(0);
    sbRed.setMax(1);
    sbGreen.setMin(0);
    sbGreen.setMax(1);
    sbBlue.setMin(0);
    sbBlue.setMax(1);
    sbOpacity.setMin(0);
    sbOpacity.setMax(1);
    sbOpacity.setValue(1);

    ChangeListener<Number> changeColor = (observedValue, oldValue, newValue) -> {
      double red = sbRed.getValue();
      double green = sbGreen.getValue();
      double blue = sbBlue.getValue();
      double opacity = sbOpacity.getValue();
      tShowColors.setFill(new Color(red, green, blue, opacity));
    };

    sbRed.valueProperty().addListener(changeColor);
    sbGreen.valueProperty().addListener(changeColor);
    sbBlue.valueProperty().addListener(changeColor);
    sbOpacity.valueProperty().addListener(changeColor);

    GridPane gridPane = new GridPane();
    gridPane.addColumn(0, lbRed, lbGreen, lbBlue, lbOpacity);
    gridPane.addColumn(1, sbRed, sbGreen, sbBlue, sbOpacity);
    gridPane.setHgap(10);
    gridPane.setVgap(5);

    BorderPane pane = new BorderPane();
    pane.setTop(tShowColors);
    pane.setCenter(gridPane);
    pane.setAlignment(tShowColors, Pos.CENTER);
    pane.setMargin(tShowColors, new Insets(20));
    pane.setMargin(gridPane, new Insets(0, 20, 20, 20));

    Scene scene = new Scene(pane);
    primaryStage.setTitle("E16_17");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
