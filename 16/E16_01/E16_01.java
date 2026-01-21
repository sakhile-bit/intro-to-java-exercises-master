/*
  Write a GUI program where you can use buttons to move a message to the left
  and right and use radio buttons to change the color for the message
  displayed.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.paint.Color;
import javafx.geometry.Pos;

public class E16_01 extends Application {
  @Override
  public void start(Stage primaryStage) {
    RadioButton rbRed = new RadioButton("Red");
    RadioButton rbYellow = new RadioButton("Yellow");
    RadioButton rbBlack = new RadioButton("Black");
    RadioButton rbOrange = new RadioButton("Orange");
    RadioButton rbGreen = new RadioButton("Green");

    ToggleGroup tg = new ToggleGroup();
    rbRed.setToggleGroup(tg);
    rbYellow.setToggleGroup(tg);
    rbBlack.setToggleGroup(tg);
    rbOrange.setToggleGroup(tg);
    rbGreen.setToggleGroup(tg);

    HBox rbPane = new HBox(10);
    rbPane.getChildren().addAll(rbRed, rbYellow, rbBlack, rbOrange, rbGreen);

    Text message = new Text(50, 50, "Programming is fun");
    message.setFont(Font.font("SansSerif", FontWeight.BOLD, 20));

    Pane messagePane = new Pane();
    messagePane.getChildren().add(message);
    messagePane.setStyle("-fx-border-color: black");

    Button btLeft = new Button("<=");
    Button btRight = new Button("=>");

    HBox arrowPane = new HBox(10);
    arrowPane.getChildren().addAll(btLeft, btRight);

    BorderPane pane = new BorderPane();
    pane.setTop(rbPane);
    pane.setBottom(arrowPane);
    pane.setCenter(messagePane);
    rbPane.setAlignment(Pos.CENTER);
    arrowPane.setAlignment(Pos.CENTER);

    rbRed.setOnAction(e -> message.setFill(Color.RED));
    rbYellow.setOnAction(e -> message.setFill(Color.YELLOW));
    rbBlack.setOnAction(e -> message.setFill(Color.BLACK));
    rbOrange.setOnAction(e -> message.setFill(Color.ORANGE));
    rbGreen.setOnAction(e -> message.setFill(Color.GREEN));

    btLeft.setOnAction(e -> message.setX(message.getX() - 10));
    btRight.setOnAction(e -> message.setX(message.getX() + 10));

    Scene scene = new Scene(pane, 400, 150);
    primaryStage.setTitle("E16_01");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
