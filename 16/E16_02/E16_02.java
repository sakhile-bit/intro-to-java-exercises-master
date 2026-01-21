/*
  Write a program that draws various figures. The user selects a figure from a
  radio button and uses a check box to specify whether it is filled.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.RadioButton;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ToggleGroup;
import javafx.scene.shape.Shape;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Ellipse;
import javafx.scene.paint.Color;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

public class E16_02 extends Application {
  private static Shape figure = new Circle(400 / 2, 150 / 2, 20);

  @Override
  public void start(Stage primaryStage) {
    Pane figurePane = new Pane();
    figurePane.setStyle("-fx-border-color: black");

    RadioButton rbCircle = new RadioButton("Circle");
    RadioButton rbRectangle = new RadioButton("Rectangle");
    RadioButton rbEllipse = new RadioButton("Ellipse");
    CheckBox cbFill = new CheckBox("Fill");

    ToggleGroup tg = new ToggleGroup();
    rbCircle.setToggleGroup(tg);
    rbRectangle.setToggleGroup(tg);
    rbEllipse.setToggleGroup(tg);

    HBox controlPane = new HBox(10);
    controlPane.getChildren().addAll(rbCircle, rbRectangle, rbEllipse, cbFill);

    BorderPane pane = new BorderPane();
    pane.setCenter(figurePane);
    pane.setBottom(controlPane);
    controlPane.setAlignment(Pos.CENTER);
    controlPane.setPadding(new Insets(10));

    rbCircle.setSelected(true);

    figure.setFill(Color.TRANSPARENT);
    figure.setStroke(Color.BLACK);
    figurePane.getChildren().add(figure);

    cbFill.setOnAction(e -> {
      if (cbFill.isSelected()) {
        figure.setFill(Color.BLACK);
      } else {
        figure.setFill(Color.TRANSPARENT);
      }
    });

    rbCircle.setOnAction(e -> {
      figurePane.getChildren().clear();
      figure = new Circle(400 / 2, 150 / 2, 20);
      figure.setStroke(Color.BLACK);
      figure.setFill(cbFill.isSelected() ? Color.BLACK : Color.TRANSPARENT);
      figurePane.getChildren().add(figure);
    });

    rbRectangle.setOnAction(e -> {
      figurePane.getChildren().clear();
      figure = new Rectangle(400 / 2 - 20, 150 / 2 - 10, 40, 20);
      figure.setStroke(Color.BLACK);
      figure.setFill(cbFill.isSelected() ? Color.BLACK : Color.TRANSPARENT);
      figurePane.getChildren().add(figure);
    });

    rbEllipse.setOnAction(e -> {
      figurePane.getChildren().clear();
      figure = new Ellipse(400 / 2, 150 / 2, 20, 10);
      figure.setStroke(Color.BLACK);
      figure.setFill(cbFill.isSelected() ? Color.BLACK : Color.TRANSPARENT);
      figurePane.getChildren().add(figure);
    });

    Scene scene = new Scene(pane, 400, 150);
    primaryStage.setTitle("E16_02");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
