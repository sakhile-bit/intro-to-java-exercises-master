import javafx.scene.layout.Pane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.paint.Color;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

public class FanPane extends BorderPane {
  private double paneSize;
  private Arc[] blades;
  private boolean isReversed;
  private Timeline timeline;
  private Slider slider;

  public FanPane(double paneSize) {
    this.paneSize = paneSize;
    blades = drawFan();

    startFan();
  }

  private Arc[] drawFan() {
    Button btPause = new Button("Pause");
    Button btResume = new Button("Resume");
    Button btReverse = new Button("Reverse");

    btPause.setOnAction(e -> stopFan());
    btResume.setOnAction(e -> {
      timeline.stop();
      startFan();
    });
    btReverse.setOnAction(e -> {
      timeline.stop();
      setReversed(!isReversed);
      startFan();
    });

    HBox buttonPane = new HBox(10);
    buttonPane.getChildren().addAll(btPause, btResume, btReverse);
    buttonPane.setAlignment(Pos.CENTER);

    Circle c = new Circle(paneSize / 2, paneSize / 2, paneSize / 2);
    c.setFill(Color.WHITE);
    c.setStroke(Color.BLACK);

    Arc[] arcs = new Arc[4];
    double sa = 0;
    for (int i = 0; i < 4; i++, sa += 90) {
      double cx = c.getCenterX();
      double cy = c.getCenterY();
      double rx = c.getRadius() / 1.1;
      double ry = c.getRadius() / 1.1;
      Arc arc = new Arc(cx, cy, rx, ry, sa, 45);
      arc.setType(ArcType.ROUND);
      arcs[i] = arc;
    }

    Pane fan = new Pane();
    fan.getChildren().addAll(c, arcs[0], arcs[1], arcs[2], arcs[3]);

    slider = new Slider();
    slider.setMin(5);
    slider.setMax(20);
    slider.setValue(5);
    slider.valueProperty().addListener(ov -> {
      timeline.setRate(slider.getValue());
    });

    setTop(buttonPane);
    setCenter(fan);
    setBottom(slider);
    setMargin(buttonPane, new Insets(20));
    setMargin(fan, new Insets(0, 20, 20, 20));
    setMargin(slider, new Insets(0, 20, 20, 20));

    return arcs;
  }

  public void setReversed(boolean isReversed) {
    this.isReversed = isReversed;
  }

  public void startFan() {
    KeyFrame kf;
    if (!isReversed) {
      kf = new KeyFrame(Duration.millis(10), e -> {
        for (Arc a: blades) {
          a.setStartAngle(a.getStartAngle() + 1);
        }
      });
    } else {
      kf = new KeyFrame(Duration.millis(10), e -> {
        for (Arc a: blades) {
          a.setStartAngle(a.getStartAngle() - 1);
        }
      });
    }

    timeline = new Timeline(kf);
    timeline.setCycleCount(Timeline.INDEFINITE);
    timeline.setRate(slider.getValue());
    timeline.play();
  }

  public void stopFan() {
    timeline.pause();
  }
}
