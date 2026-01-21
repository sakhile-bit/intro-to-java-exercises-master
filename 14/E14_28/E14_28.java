/*
  Modify the ClockPane class with three new Boolean properties--hourHandVisible,
  minuteHandVisible, and secondHandVisibls--and their associated accessor and
  mutator methods. You can use the set methods to make a hand visible or
  invisible. Write a test program that displays only the hour and minute hands.
  The hour and minute values are randomly generated. The hour is between 0 and
  11, and the minute is either 0 or 30.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class E14_28 extends Application {
  @Override
  public void start(Stage primaryStage) {
    ClockPane c = new ClockPane();
    c.setSecondHandVisible(false);
    c.setHour((int)(Math.random() * 12));
    c.setMinute((int)(Math.random() * 2) == 1 ? 30 : 0);

    Scene scene = new Scene(c);
    primaryStage.setTitle("E14_28");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    Application.launch(args);
  }
}
