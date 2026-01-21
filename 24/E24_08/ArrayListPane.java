import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;

public class ArrayListPane extends Pane {
  private MyArrayList list;
  private Text tMessage;

  public ArrayListPane() {
    set();
  }

  private void set() {
    reset();
  }

  private void reset() {
    list = new MyArrayList();
    drawPane();
  }

  private void drawPane() {
    getChildren().clear();
    final double WIDTH = 600.0;
    final double HEIGHT = 200.0;
    setPrefSize(WIDTH, HEIGHT);

    Text tEmpty = new Text("empty: " + (list.isEmpty() ? "true" : "false"));
    Text tSize = new Text("size: " + list.size());
    Text tCapacity = new Text("capacity: " + list.getCapacity());
    tMessage = new Text();

    tEmpty.setX(10.0);
    tEmpty.setY(15.0);
    tSize.setX(100.0);
    tSize.setY(15.0);
    tCapacity.setX(150.0);
    tCapacity.setY(15.0);
    tMessage.setX(250.0);
    tMessage.setY(15.0);

    getChildren().addAll(tEmpty, tSize, tCapacity, tMessage);

    final double SLOT_WIDTH = 25.0;
    final double SLOT_HEIGHT = 15.0;
    double xPos = 10.0;
    double yPos = 100.0;
    for (int i = 0; i < list.getCapacity(); i++) {
      Rectangle r = new Rectangle(xPos, yPos, SLOT_WIDTH, SLOT_HEIGHT);
      r.setFill(Color.TRANSPARENT);
      r.setStroke(Color.BLACK);
      if (list.getData()[i] == null) {
        Line line = new Line(r.getX(), r.getY() + r.getHeight(),
          r.getX() + r.getWidth(), r.getY());
        getChildren().add(line);
      } else {
        Text t = new Text(xPos, yPos + 10, list.getData()[i] + "");
        getChildren().add(t);
      }
      getChildren().add(r);
      xPos += SLOT_WIDTH;
    }
  }

  public void search(int value) {
    int index = list.indexOf(value);
    if (index == -1) {
      tMessage.setText(value + " is not in the list");
    } else {
      tMessage.setText(value + " is at index " + index);
    }
  }

  public void insert(int value, int index) {
    if (index < 0) {
      list.add(new Integer(value));
    } else {
      list.add(index, value);
    }
    drawPane();
  }

  public void delete(int value) {
    String text = "";
    if (list.remove(new Integer(value))) {
      text = value + " was removed";
    } else {
      text = value + " not in list";
    }
    drawPane();
    tMessage.setText(text);
  }

  public void trimToSize() {
    list.trimToSize();
    drawPane();
  }
}
