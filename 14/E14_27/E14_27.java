/*
  Modify the ClockPane class in Section 14.12 to draw the clock with more
  details on the hours and minutes.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class E14_27 extends Application {
  @Override
  public void start(Stage primaryStage) {
    ClockPane c = new ClockPane();

    Scene scene = new Scene(c);
    primaryStage.setTitle("E14_27");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    Application.launch(args);
  }
}
