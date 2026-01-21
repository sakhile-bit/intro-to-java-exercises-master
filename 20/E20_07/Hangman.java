import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Shape;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Line;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.util.Duration;
import java.util.ArrayList;

public class Hangman extends Pane {
  private static final double WIDTH = 600.0;
  private static final double HEIGHT = 500.0;

  // Hangman Graphics
  private Line hook;
  private Circle head;
  private Line leftArm;
  private Line rightArm;
  private Line body;
  private Line leftLeg;
  private Line rightLeg;
  private PathTransition path;
  private Shape[] bodyParts;

  // Game Components
  Label lbWord;
  Label lbStatus;
  String[] words = {"white", "flower", "jello"};
  String word;
  int misses = 0;
  ArrayList<Character> missedLetters = new ArrayList<>();
  ArrayList<Character> correctLetters = new ArrayList<>();
  boolean playing;

  public Hangman() {
    drawGUI();
  }

  private void startGame() {
    playing = true;

    // Choose a word
    word = words[(int)(Math.random() * words.length)];

    // Set labels for ongoing game
    setLabelsOngoing();
  }

  private void setLabelsOngoing() {
    lbWord.setText("Guess a word: " + getWord());
    lbStatus.setText("Missed letters: " + getMissed());
  }

  private void setLabelsFinal() {
      lbWord.setText("The word is: " + word);
      lbStatus.setText("To continue the game, press ENTER");
  }

  private String getWord() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < word.length(); i++) {
      if (!correctLetters.contains(word.charAt(i))) {
        sb.append("*");
      } else {
        sb.append(word.charAt(i));
      }
    }
    return sb.toString();
  }

  private String getMissed() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < missedLetters.size(); i++) {
      sb.append(missedLetters.get(i));
    }
    return sb.toString();
  }

  private void enterCommand(KeyCode key) {
    if (key.equals(KeyCode.ENTER) && !playing) {
      if (misses == 6) {
        path.stop();
      }
      misses = 0;
      missedLetters.clear();
      correctLetters.clear();
      for (Shape part: bodyParts) {
        getChildren().remove(part);
      }
      playing = true;
      startGame();
    } else if (key.isLetterKey() && playing) {
      makeGuess(Character.toLowerCase(key.getName().charAt(0)));
    }
  }

  private void makeGuess(char key) {
    if (correctLetters.contains(key) || missedLetters.contains(key)) {
      return;
    }
    if (word.contains(Character.toString(key))) {
      correctLetters.add(key);
      setLabelsOngoing();
      if (word.equals(getWord())) {
        playing = false;
        setLabelsFinal();
      }
    } else {
      getChildren().add(bodyParts[misses++]);
      missedLetters.add(key);
      setLabelsOngoing();
      if (misses == 6) {
        playing = false;
        setLabelsFinal();
        animate();
      }
    }
  }

  private void drawGUI() {
    setPrefSize(WIDTH, HEIGHT);
    drawPlatform();
    drawPerson();
    drawLabels();
    startGame();
    setOnKeyPressed(e -> enterCommand(e.getCode()));
  }

  private void drawPlatform() {
    Arc bottom =
      new Arc(WIDTH / 6, HEIGHT - 20, WIDTH / 10, HEIGHT / 15, 0, 180);
    bottom.setFill(Color.WHITE);
    bottom.setStroke(Color.BLACK);

    Line post =
      new Line(bottom.getCenterX(), bottom.getCenterY() - bottom.getRadiusY(),
      bottom.getCenterX(), HEIGHT / 15);

    Line top = new Line(post.getEndX(), post.getEndY(),
      post.getEndX() + WIDTH / 3.5, post.getEndY());

    hook = new Line(top.getEndX(), top.getEndY(),
      top.getEndX(), top.getEndY() + HEIGHT / 20);

    getChildren().addAll(bottom, post, top, hook);
  }

  private void drawPerson() {
    head = new Circle(
      hook.getEndX(), hook.getEndY() + HEIGHT / 15, HEIGHT / 15);
    head.setFill(Color.WHITE);
    head.setStroke(Color.BLACK);

    leftArm = new Line();
    leftArm.setStartX(head.getCenterX() +
      head.getRadius() * Math.cos(Math.toRadians(135)));
    leftArm.setStartY(head.getCenterY() +
      head.getRadius() * Math.sin(Math.toRadians(135)));
    leftArm.setEndX(leftArm.getStartX() +
      (WIDTH / 7) * Math.cos(Math.toRadians(135)));
    leftArm.setEndY(leftArm.getStartY() +
      (WIDTH / 7) * Math.sin(Math.toRadians(135)));

    rightArm = new Line();
    rightArm.setStartX(head.getCenterX() +
      head.getRadius() * Math.cos(Math.toRadians(45)));
    rightArm.setStartY(head.getCenterY() +
      head.getRadius() * Math.sin(Math.toRadians(45)));
    rightArm.setEndX(rightArm.getStartX() +
      (WIDTH / 7) * Math.cos(Math.toRadians(45)));
    rightArm.setEndY(rightArm.getStartY() +
      (WIDTH / 7) * Math.sin(Math.toRadians(45)));

    body = new Line();
    body.setStartX(head.getCenterX() +
      head.getRadius() * Math.cos(Math.toRadians(90)));
    body.setStartY(head.getCenterY() +
      head.getRadius() * Math.sin(Math.toRadians(90)));
    body.setEndX(body.getStartX());
    body.setEndY(body.getStartY() + HEIGHT / 4);

    leftLeg = new Line();
    leftLeg.setStartX(body.getEndX());
    leftLeg.setStartY(body.getEndY());
    leftLeg.setEndX(body.getEndX() +
      (WIDTH / 7) * Math.cos(Math.toRadians(135)));
    leftLeg.setEndY(body.getEndY() +
      (WIDTH / 7) * Math.sin(Math.toRadians(135)));

    rightLeg = new Line();
    rightLeg.setStartX(body.getEndX());
    rightLeg.setStartY(body.getEndY());
    rightLeg.setEndX(body.getEndX() +
      (WIDTH / 7) * Math.cos(Math.toRadians(45)));
    rightLeg.setEndY(body.getEndY() +
      (WIDTH / 7) * Math.sin(Math.toRadians(45)));

    bodyParts = new Shape[6];
    bodyParts[0] = head;
    bodyParts[1] = leftArm;
    bodyParts[2] = rightArm;
    bodyParts[3] = body;
    bodyParts[4] = leftLeg;
    bodyParts[5] = rightLeg;
  }

  private void animate() {
    head.translateXProperty().addListener((observable, oldValue, newValue) -> {
      body.setTranslateX(newValue.doubleValue());
      leftArm.setTranslateX(newValue.doubleValue());
      rightArm.setTranslateX(newValue.doubleValue());
      leftLeg.setTranslateX(newValue.doubleValue());
      rightLeg.setTranslateX(newValue.doubleValue());
    });

    head.translateYProperty().addListener((observable, oldValue, newValue) -> {
      body.setTranslateY(newValue.doubleValue());
      leftArm.setTranslateY(newValue.doubleValue());
      rightArm.setTranslateY(newValue.doubleValue());
      leftLeg.setTranslateY(newValue.doubleValue());
      rightLeg.setTranslateY(newValue.doubleValue());
    });

    Arc arc = new Arc(head.getCenterX(), head.getCenterY() - head.getRadius(), head.getRadius(), HEIGHT / 20, 240, 75);
    arc.setFill(Color.TRANSPARENT);
    path = new PathTransition(Duration.seconds(3), arc, head);
    path.setCycleCount(Timeline.INDEFINITE);
    path.setAutoReverse(true);
    path.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
    path.play();

    getChildren().add(arc);
  }

  private void drawLabels() {
    lbWord = new Label();
    lbStatus = new Label();

    VBox vbLabels = new VBox(10);
    vbLabels.getChildren().addAll(lbWord, lbStatus);
    vbLabels.setLayoutX(hook.getEndX() - WIDTH / 6);
    vbLabels.setLayoutY(HEIGHT - HEIGHT / 6);

    getChildren().add(vbLabels);
  }
}
