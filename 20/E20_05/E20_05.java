/*
  The example in Section 20.7 displays multiple bouncing balls. Extend the
  example to detect collisions. Once two balls collide, remove the later ball
  that was added to the pane and add its radius to the other ball. Use the
  Suspend button to suspend the animation and the Resume button to resume the
  animation. Add a mouse pressed handler that removes a ball when the mouse is
  pressed on the ball.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class E20_05 extends Application {
  @Override
  public void start(Stage primaryStage) {
    BouncingBall bb = new BouncingBall();

    Scene scene = new Scene(bb);
    primaryStage.setTitle("E20_05");
    primaryStage.setScene(scene);
    primaryStage.setResizable(false);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
