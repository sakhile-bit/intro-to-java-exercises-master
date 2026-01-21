import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.Button;
import javafx.geometry.Pos;

public class BouncingBall extends BorderPane {
  public BouncingBall() {
    drawGUI();
  }

  private void drawGUI() {
    ScrollBar sbSpeed = new ScrollBar();
    sbSpeed.setMax(20);
    sbSpeed.setValue(10);

    BallPane ballPane = new BallPane();

    ballPane.rateProperty().bind(sbSpeed.valueProperty());

    Button btSuspend = new Button("Suspend");
    Button btResume = new Button("Resume");
    Button btAdd = new Button("+");
    Button btRemove = new Button("-");

    btSuspend.setOnAction(e -> ballPane.suspend());
    btResume.setOnAction(e -> ballPane.resume());
    btAdd.setOnAction(e -> ballPane.add());
    btRemove.setOnAction(e -> ballPane.remove());

    HBox hbButtons = new HBox(10);
    hbButtons.getChildren().addAll(btSuspend, btResume, btAdd, btRemove);
    hbButtons.setAlignment(Pos.CENTER);

    setTop(sbSpeed);
    setCenter(ballPane);
    setBottom(hbButtons);
  }
}
