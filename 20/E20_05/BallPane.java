import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.Node;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.util.Duration;
import javafx.beans.property.DoubleProperty;

public class BallPane extends Pane {
  private Timeline animation;

  public BallPane() {
    setPrefSize(700, 300);
    setStyle("-fx-border-color: gray");
    animation = new Timeline(
      new KeyFrame(Duration.millis(50), e -> moveBall()));
    animation.setCycleCount(Timeline.INDEFINITE);
    animation.play();
  }

  public DoubleProperty rateProperty() {
    return animation.rateProperty();
  }

  public void suspend() {
    animation.pause();
  }

  public void resume() {
    animation.play();
  }

  public void add() {
    Color color = new Color(Math.random(), Math.random(), Math.random(), 0.5);
    getChildren().add(new Ball(30, 30, 20, color));
  }

  public void remove() {
    if (getChildren().size() > 0) {
      getChildren().remove(getChildren().size() - 1);
    }
  }

  public void moveBall() {
    for (int i = 0; i < getChildren().size(); i++) {
      Ball ball = (Ball)getChildren().get(i);

      if (ball.getCenterX() < ball.getRadius() ||
          ball.getCenterX() > getWidth() - ball.getRadius()) {
        ball.setDX(ball.getDX() * -1);
      }

      if (ball.getCenterY() < ball.getRadius() ||
          ball.getCenterY() > getHeight() - ball.getRadius()) {
        ball.setDY(ball.getDY() * - 1);
      }

      for (int j = i; j < getChildren().size(); j++) {
        Ball thisBall = (Ball)getChildren().get(j);

        // make sure that ball and thisBall aren't the same, otherwise any ball
        // will simply remove itself from the pane
        if (ball != thisBall && ball.intersects(thisBall.getBoundsInLocal())) {
          // find the indices of each ball
          int ballIndex = -1;
          int thisBallIndex = -1;
          for (int k = 0; k < getChildren().size(); k++) {
            if (getChildren().get(k) == ball) { ballIndex = k; }
            if (getChildren().get(k) == thisBall) { thisBallIndex = k; }
          }

          // the ball with the smaller index will "eat" the ball with the larger
          // index
          Ball earlier =
            (Ball)(getChildren().get(Math.min(ballIndex, thisBallIndex)));
          Ball later =
            (Ball)(getChildren().get(Math.max(ballIndex, thisBallIndex)));
          getChildren().remove(later);
          earlier.setRadius(earlier.getRadius() + later.getRadius());
        }
      }

      ball.setCenterX(ball.getCenterX() + ball.getDX());
      ball.setCenterY(ball.getCenterY() + ball.getDY());
    }
  }
}
