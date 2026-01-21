import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class E18_37 extends Application {
  @Override
  public void start(Stage primaryStage) {
    HilbertGUI hg = new HilbertGUI();

    Scene scene = new Scene(hg);
    primaryStage.setTitle("HilbertGUI");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
