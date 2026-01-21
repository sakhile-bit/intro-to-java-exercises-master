/*
  Write a program that simulates a traffic light. The program lets the user
  select one of three lights: red, yellow, or green. When a radio button is
  selected, the light is turned on. Only one light can be on at a time. No
  light is on when the program starts.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.geometry.Pos;

public class E16_03 extends Application {
  @Override
  public void start(Stage primaryStage) {
    Pane lightPane = new Pane();
    Rectangle tLight = new Rectangle(0, 0, 100 / 3.0, 100);
    Circle redLight = new Circle(100 / 3.0 / 2, 100 / 4.0, 10);
    Circle yellowLight = new Circle(100 / 3.0 / 2, 100 / 2.0, 10);
    Circle greenLight = new Circle(100 / 3.0 / 2, 100 / 4.0 * 3, 10);
    tLight.setFill(Color.WHITE);
    tLight.setStroke(Color.BLACK);
    tLight.xProperty().bind(lightPane.widthProperty().divide(2).subtract(tLight.getWidth() / 2));
    tLight.yProperty().bind(lightPane.heightProperty().divide(2).subtract(tLight.getHeight() / 2));
    redLight.setFill(Color.WHITE);
    redLight.setStroke(Color.BLACK);
    redLight.centerXProperty().bind(lightPane.widthProperty().divide(2));
    redLight.centerYProperty().bind(tLight.yProperty().add(20));
    yellowLight.setFill(Color.WHITE);
    yellowLight.setStroke(Color.BLACK);
    yellowLight.centerXProperty().bind(lightPane.widthProperty().divide(2));
    yellowLight.centerYProperty().bind(tLight.yProperty().add(50));
    greenLight.setFill(Color.WHITE);
    greenLight.setStroke(Color.BLACK);
    greenLight.centerXProperty().bind(lightPane.widthProperty().divide(2));
    greenLight.centerYProperty().bind(tLight.yProperty().add(80));

    lightPane.getChildren().addAll(tLight, redLight, yellowLight, greenLight);

    RadioButton rbRed = new RadioButton("Red");
    RadioButton rbYellow = new RadioButton("Yellow");
    RadioButton rbGreen = new RadioButton("Green");

    ToggleGroup tg = new ToggleGroup();
    rbRed.setToggleGroup(tg);
    rbYellow.setToggleGroup(tg);
    rbGreen.setToggleGroup(tg);

    HBox controlPane = new HBox(10);
    controlPane.getChildren().addAll(rbRed, rbYellow, rbGreen);
    controlPane.setAlignment(Pos.CENTER);

    BorderPane pane = new BorderPane();
    pane.setCenter(lightPane);
    pane.setBottom(controlPane);

    rbRed.setOnAction(e -> {
      redLight.setFill(Color.RED);
      yellowLight.setFill(Color.WHITE);
      greenLight.setFill(Color.WHITE);
    });

    rbYellow.setOnAction(e -> {
      redLight.setFill(Color.WHITE);
      yellowLight.setFill(Color.YELLOW);
      greenLight.setFill(Color.WHITE);
    });

    rbGreen.setOnAction(e -> {
      redLight.setFill(Color.WHITE);
      yellowLight.setFill(Color.WHITE);
      greenLight.setFill(Color.GREEN);
    });

    Scene scene = new Scene(pane, 300, 150);
    primaryStage.setTitle("E16_03");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
