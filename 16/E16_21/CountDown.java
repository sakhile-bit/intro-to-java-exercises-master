import javafx.scene.layout.StackPane;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.input.KeyCode;
import javafx.scene.media.AudioClip;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import javafx.geometry.Pos;
import javafx.beans.property.SimpleIntegerProperty;
import java.io.File;

public class CountDown extends StackPane {
  private SimpleIntegerProperty seconds;
  private TextField tfTime;

  public CountDown() {
    tfTime = new TextField();
    tfTime.setAlignment(Pos.CENTER);
    tfTime.setFont(Font.font("SansSerif", 50));
    tfTime.setPrefWidth(400);

    seconds = new SimpleIntegerProperty();

    // when enter is pressed and input is valid, the countdown starts
    tfTime.setOnKeyPressed(e -> {
      if (!e.getCode().equals(KeyCode.ENTER) || !inputIsValid()) {
        return;
      }
      seconds.setValue(Integer.parseInt(tfTime.getText()));
      start();
    });

    // listen to the seconds property, when it's 0 play an audio clip
    seconds.addListener(ov -> {
      if (seconds.getValue() == 0) {
        playAudio();
      }
    });

    getChildren().add(tfTime);
  }

  private void start() {
    KeyFrame countDown = new KeyFrame(Duration.millis(1000), e -> {
      seconds.setValue(seconds.getValue() - 1);
      tfTime.setText(String.valueOf(seconds.getValue()));
    });

    Timeline timeline = new Timeline(countDown);
    timeline.setCycleCount(seconds.getValue());
    timeline.play();
  }

  private void playAudio() {
    File file = new File("dog_bark6.wav");
    AudioClip dog = new AudioClip(file.toURI().toString());
    dog.setCycleCount(AudioClip.INDEFINITE);
    dog.play();
  }

  // ensure that entry is only digits, so it can be converted into an integer
  private boolean inputIsValid() {
    String input = tfTime.getText();
    if (input.length() == 0) { return false; }
    for (int i = 0; i < input.length(); i++) {
      char c = input.charAt(i);
      if (!Character.isDigit(c)) { return false; }
    }
    return true;
  }
}
