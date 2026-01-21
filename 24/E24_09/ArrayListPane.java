import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import javafx.scene.Node;
import javafx.animation.TranslateTransition;
import javafx.util.Duration;
import java.util.ArrayList;

public class ArrayListPane extends Pane {
  private MyArrayList list;
  private ArrayList<RectInfo> rects;
  private static final double WIDTH = 600.0;
  private static final double HEIGHT = 200.0;
  private static final double SLOT_WIDTH = 25.0;
  private static final double SLOT_HEIGHT = 15.0;
  private Text tMessage;

  public ArrayListPane() {
    setUp();
  }

  private void setUp() {
    list = new MyArrayList();
    syncRects();
    updatePane();
  }

  private void updatePane() {
    getChildren().clear();
    setPrefSize(WIDTH, HEIGHT);
    Text tEmpty = new Text("empty: " + (list.isEmpty() ? "true" : "false"));
    Text tSize = new Text("size: " + list.size());
    Text tCapacity = new Text("capacity: " + list.getCapacity());
    tMessage = new Text();

    tEmpty.setX(10.0);
    tEmpty.setY(15.0);
    tSize.setX(100.0);
    tSize.setY(15.0);
    tCapacity.setX(175.0);
    tCapacity.setY(15.0);
    tMessage.setX(300.0);
    tMessage.setY(15.0);

    getChildren().addAll(tEmpty, tSize, tCapacity, tMessage);

    for (int i = 0; i < rects.size(); i++) {
      RectInfo r = rects.get(i);
      getChildren().add(r.getRect());
      getChildren().add(r.getText() == null ? r.getLine() : r.getText());
    }
  }

  public void search(int value) {
    int index = list.indexOf(value);
    if (index == -1) {
      tMessage.setText(value + " was not found");
    } else {
      tMessage.setText(value + " found at " + index);
    }
  }

  public void insert(int value, int index) {
    if (index < 0) {
      list.add(value);
    } else {
      list.add(index, value);
    }
    syncRects();
    animateInsert(index);
    updatePane();
  }

  private void animateInsert(int index) {
    if (index < 0) { index = list.size() - 1; }
    RectInfo info = rects.get(index);
    Rectangle rect = info.getRect();
    Text text = info.getText();

    double fromY = -SLOT_HEIGHT;
    double toY = 0.0;

    TranslateTransition rectTransition = getTransition(2000, rect, fromY, toY);
    TranslateTransition textTransition = getTransition(2000, text, fromY, toY);
    rectTransition.play();
    textTransition.play();
  }

  public boolean delete(int value) {
    int index = list.remove(new Integer(value));
    if (index < 0) {
      tMessage.setText(value + " not in list ");
      return false;
    }
    tMessage.setText("");
    animateDelete(index);
    return true;
  }

  private void animateDelete(int index) {
    RectInfo info = rects.get(index);
    Rectangle rect = info.getRect();
    Text text = info.getText();

    double fromY = 0.0;
    double toY = -SLOT_HEIGHT;

    TranslateTransition rectTransition = getTransition(1000, rect, fromY, toY);
    TranslateTransition textTransition = getTransition(1000, text, fromY, toY);
    textTransition.setOnFinished(e -> {
      syncRects();
      updatePane();
    });
    rectTransition.play();
    textTransition.play();
  }

  private TranslateTransition getTransition(double duration, Node node,
    double fromY, double toY) {
    TranslateTransition transition =
      new TranslateTransition(Duration.millis(duration), node);
    transition.setFromY(fromY);
    transition.setToY(toY);
    return transition;
  }

  private void syncRects() {
    rects = generateBlankRects();
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i) != null) {
        Rectangle rect = rects.get(i).getRect();
        Text t = new Text(rect.getX() + 2, rect.getY() + 12, list.get(i) + "");
        rects.get(i).setText(t);
      }
    }
  }

  private ArrayList<RectInfo> generateBlankRects() {
    ArrayList<RectInfo> info = new ArrayList<>();
    double xPos = 10.0;
    double yPos = 100.0;
    for (int i = 0; i < list.getCapacity(); i++) {
      Rectangle r = new Rectangle(xPos, yPos, SLOT_WIDTH, SLOT_HEIGHT);
      r.setFill(Color.WHITE);
      r.setStroke(Color.BLACK);
      Line line = new Line(r.getX(), r.getY() + r.getHeight(),
        r.getX() + r.getWidth(), r.getY());
      info.add(new RectInfo(r, null, line));
      xPos += SLOT_WIDTH;
    }
    return info;
  }
}
