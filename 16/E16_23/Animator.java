import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import javafx.geometry.Pos;

public class Animator extends BorderPane {
  private int currentSlide;
  private int numberOfImages;
  TextField tfSpeed;
  TextField tfPrefix;
  TextField tfNumber;
  TextField tfURL;
  Pane imagePane;
  Timeline timeline = new Timeline();

  public Animator() {
    currentSlide = 1;
    numberOfImages = 0;
    drawAnimator();
  }

  public void drawAnimator() {
    Button btStart = new Button("Start Animation");

    btStart.setOnAction(e -> startAnimation());

    Label lbEnterInfo = new Label("Enter information for animation");
    Label lbSpeed = new Label("Animation speed in milliseconds");
    Label lbPrefix = new Label("Image file prefix");
    Label lbNumber = new Label("Number of images");
    Label lbURL = new Label("Audio file URL");
    tfSpeed = new TextField();
    tfPrefix = new TextField();
    tfNumber = new TextField();
    tfURL = new TextField();
    imagePane = new Pane();
    imagePane.setMinWidth(485);
    imagePane.setMinHeight(475);

    GridPane gridPane = new GridPane();
    gridPane.addRow(0, lbEnterInfo);
    gridPane.addRow(1, lbSpeed, tfSpeed);
    gridPane.addRow(2, lbPrefix, tfPrefix);
    gridPane.addRow(3, lbNumber, tfNumber);
    gridPane.addRow(4, lbURL, tfURL);

    setTop(btStart);
    setCenter(imagePane);
    setBottom(gridPane);
    setAlignment(btStart, Pos.CENTER_RIGHT);
  }

  private void startAnimation() {
    int speed = Integer.parseInt(tfSpeed.getText());
    String prefix = tfPrefix.getText();
    numberOfImages = Integer.parseInt(tfNumber.getText());
    KeyFrame kf = new KeyFrame(Duration.millis(speed), e -> {
      ImageView iv = new ImageView("image/" + prefix + currentSlide + ".gif");
      imagePane.getChildren().clear();
      imagePane.getChildren().add(iv);
      if (currentSlide == numberOfImages) { currentSlide = 1; }
      else currentSlide++;
    });

    timeline = new Timeline(kf);
    timeline.setCycleCount(Timeline.INDEFINITE);
    timeline.play();

    AudioClip audio = new AudioClip(tfURL.getText());
    audio.setCycleCount(AudioClip.INDEFINITE);
    audio.play();
  }
}
