/*
  Write a program that displays four images in a grid pane.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.geometry.Pos;

public class E14_01 extends Application {
  @Override
  public void start(Stage primaryStage) {
    GridPane pane = new GridPane();
    pane.setAlignment(Pos.CENTER);
    pane.setHgap(5);
    pane.setVgap(5);

    ImageView img1 = new ImageView(new Image("uk.gif"));
    ImageView img2 = new ImageView(new Image("ca.gif"));
    ImageView img3 = new ImageView(new Image("china.gif"));
    ImageView img4 = new ImageView(new Image("us.gif"));

    pane.addRow(0, img1, img2);
    pane.addRow(1, img3, img4);

    Scene scene = new Scene(pane);
    primaryStage.setTitle("E14_01");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    Application.launch(args);
  }
}
