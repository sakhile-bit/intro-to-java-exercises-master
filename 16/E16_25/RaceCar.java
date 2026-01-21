import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class RaceCar extends Pane {
  private static final double WIDTH = 600.0;
  private static final double HEIGHT = 100.0;
  private double currentXCoord = 0.0;
  private Timeline timeline = new Timeline();

  public RaceCar() {
    setMinWidth(WIDTH);
    setMaxWidth(WIDTH);
    setMinHeight(HEIGHT);
    setStyle("-fx-border-color: black");
  }

  public void start(double rate) {
    stop();
    KeyFrame kf = new KeyFrame(Duration.millis(20), e -> drawCar(currentXCoord, HEIGHT));
    timeline = new Timeline(kf);
    timeline.setCycleCount(Timeline.INDEFINITE);
    timeline.setRate(rate);
    timeline.play();
  }

  public void stop() {
    timeline.stop();
    getChildren().clear();
    currentXCoord = 0;
  }

  private void drawCar(double x, double y) {
    getChildren().clear();
    if (currentXCoord > getMinWidth() - 50) { currentXCoord = 0; }
    Rectangle body = new Rectangle(x, y - 20, 50, 10);
    Circle leftTire = new Circle(x + 15, y - 5, 5);
    Circle rightTire = new Circle(x + 35, y - 5, 5);
    Polygon top = new Polygon(x + 10, y - 20, x + 20, y - 30,
      x + 30, y - 30, x + 40, y - 20);
    getChildren().addAll(body, leftTire, rightTire, top);
    currentXCoord++;
  }
}
