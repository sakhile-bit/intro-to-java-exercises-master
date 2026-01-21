import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

public class E16_24 extends Application {
  private static final String MEDIA_URL =
    "http://cs.armstrong.edu/liang/common/sample.mp4";

  @Override
  public void start(Stage primaryStage) {
    Media media = new Media(MEDIA_URL);
    MediaPlayer mediaPlayer = new MediaPlayer(media);
    MediaView mediaView = new MediaView(mediaPlayer);

    Button playButton = new Button(">");
    playButton.setOnAction(e -> {
      if (playButton.getText().equals(">")) {
        mediaPlayer.play();
        playButton.setText("||");
      } else {
        mediaPlayer.pause();
        playButton.setText(">");
      }
    });

    Slider slVolume = new Slider();
    slVolume.setPrefWidth(150);
    slVolume.setMaxWidth(Region.USE_PREF_SIZE);
    slVolume.setMinWidth(30);
    slVolume.setValue(50);
    mediaPlayer.volumeProperty().bind(slVolume.valueProperty().divide(100));

    Slider slTime = new Slider();
    slTime.setPrefWidth(150);
    slTime.setMaxWidth(Region.USE_PREF_SIZE);
    slTime.setMinWidth(30);
    slTime.setMin(0);

    Label lbTime = new Label();

    mediaPlayer.currentTimeProperty().addListener(ov -> {
      if (!slTime.isValueChanging()) {
        // need to set max value of slider multiple times, because a video
        // loaded from the web doesn't give an accurate total duration
        // immediately
        double total = mediaPlayer.getTotalDuration().toMillis();
        double current = mediaPlayer.getCurrentTime().toMillis();
        slTime.setMax(total);
        slTime.setValue(current);
        lbTime.setText(getTimeString(current) + "/" + getTimeString(total));
      }
    });

    slTime.valueProperty().addListener(ov -> {
      if (slTime.isValueChanging()) {
        mediaPlayer.seek(new Duration(slTime.getValue()));
      }
    });

    HBox hBox = new HBox(10);
    hBox.setAlignment(Pos.CENTER);
    hBox.setPadding(new Insets(20));
    hBox.getChildren().addAll(playButton, new Label("Time"), slTime, lbTime,
      new Label("Volume"), slVolume);

    BorderPane pane = new BorderPane();
    pane.setCenter(mediaView);
    pane.setBottom(hBox);

    Scene scene = new Scene(pane, 720, 550);
    primaryStage.setTitle("MediaDemo");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static String getTimeString(double millis) {
    millis /= 1000;
    String s = formatTime(millis % 60);
    millis /= 60;
    String m = formatTime(millis % 60);
    millis /= 60;
    String h = formatTime(millis % 24);
    return h + ":" + m + ":" + s;
  }

  public static String formatTime(double time) {
    int t = (int)time;
    if (t > 9) { return String.valueOf(t); }
    return "0" + t;
  }
}
