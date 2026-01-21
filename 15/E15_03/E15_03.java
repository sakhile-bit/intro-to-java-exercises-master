/*
  Write a program that moves the ball in a pane. You should define a pane class
  for displaying the ball and provide the methods for moving the ball left,
  right, up, and down. Check the boundary to prevent the ball from moving out
  of sight completely.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class E15_03 extends Application {
  @Override
  public void start(Stage primaryStage) {
    BallPane ballPane = new BallPane();

    HBox buttonPane = new HBox(5);
    Button btLeft = new Button("Left");
    Button btRight = new Button("Right");
    Button btUp = new Button("Up");
    Button btDown = new Button("Down");
    buttonPane.getChildren().addAll(btLeft, btRight, btUp, btDown);

    btLeft.setOnAction(e -> ballPane.moveLeft());
    btRight.setOnAction(e -> ballPane.moveRight());
    btUp.setOnAction(e -> ballPane.moveUp());
    btDown.setOnAction(e -> ballPane.moveDown());

    BorderPane pane = new BorderPane();
    pane.setCenter(ballPane);
    pane.setBottom(buttonPane);
    pane.setPadding(new Insets(0, 20, 0, 20));
    BorderPane.setAlignment(buttonPane, Pos.CENTER);

    Scene scene = new Scene(pane, 250, 250);
    primaryStage.setTitle("E15_03");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  class BallPane extends Pane {
    private double radius = 15;
    private double width = 200;
    private double height = 200;
    Circle ball = new Circle(width / 2, height / 2, radius);

    BallPane() {
      ball.setFill(Color.WHITE);
      ball.setStroke(Color.BLACK);
      getChildren().add(ball);
    }

    public void moveLeft() {
      if (ball.getRadius() < ball.getCenterX()) {
        ball.setCenterX(ball.getCenterX() - 10);
      }
    }

    public void moveRight() {
      if (ball.getCenterX() < width - ball.getRadius()) {
        ball.setCenterX(ball.getCenterX() + 10);
      }
    }

    public void moveUp() {
      if (ball.getRadius() < ball.getCenterY()) {
        ball.setCenterY(ball.getCenterY() - 10);
      }
    }

    public void moveDown() {
      if (ball.getCenterY() < height - ball.getRadius()) {
        ball.setCenterY(ball.getCenterY() + 10);
      }
    }
  }

  public static void main(String[] args) {
    launch(args);
  }
}
