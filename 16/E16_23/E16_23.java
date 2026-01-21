/*
  Creation an animation to meet the following requirements:

  - Allow the user to specify the animation speed in a text field.
  - Get the number of images and the image filename prefix from the user. For
    example, if the user enters n for the number of images and L for the image
    prefix, then the files are L1.gif, L2.gif, and so on, to Ln.gif. Assume
    the images are stored in the image directory, a subdirectory of the
    program's class directory. The animation displays the images one after the
    other.
  - Allow the user to specify an audio file URL. The audio is played while the
    animation runs.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class E16_23 extends Application {
  @Override
  public void start(Stage primaryStage) {
    Animator animator = new Animator();

    Scene scene = new Scene(animator);
    primaryStage.setTitle("E16_23");
    primaryStage.setScene(scene);
    primaryStage.setResizable(false);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
