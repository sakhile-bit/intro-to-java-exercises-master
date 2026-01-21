import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Polyline;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import java.util.ArrayList;

public class HilbertGUI extends BorderPane {
  private static final double SIZE = 400.0;
  private int order;
  private StackPane curvePane;
  private Hilbert hilbert;

  public HilbertGUI() {
    drawGUI();
  }

  private void setOrder(int order) {
    this.order = order;
    hilbert = new Hilbert(SIZE, SIZE, order);
    hilbert.generate();
    ArrayList<Double> points = hilbert.getPoints();
    drawPoints(points);
  }

  private void drawPoints(ArrayList<Double> points) {
    curvePane.getChildren().clear();
    Polyline p = new Polyline();
    for (double point: points) {
      p.getPoints().add(point);
    }

    curvePane.getChildren().add(p);
  }

  private void drawGUI() {
    curvePane = new StackPane();
    curvePane.setPrefSize(SIZE, SIZE);

    Label lbOrder = new Label("Enter an order:");
    TextField tfOrder = new TextField("1");

    tfOrder.setOnKeyPressed(e -> {
      if (e.getCode().equals(KeyCode.ENTER)) {
        if (isInteger(tfOrder.getText())) {
          setOrder(Integer.parseInt(tfOrder.getText()));
        }
      }
    });

    HBox hbControl = new HBox(10);
    hbControl.getChildren().addAll(lbOrder, tfOrder);
    hbControl.setAlignment(Pos.CENTER);

    setCenter(curvePane);
    setBottom(hbControl);
    setMargin(curvePane, new Insets(20));

    setOrder(1);
  }

  private boolean isInteger(String s) {
    if (s.length() < 1) {
      return false;
    }
    for (int i = 0; i < s.length(); i++) {
      if (!Character.isDigit(s.charAt(i))) {
        return false;
      }
    }
    return true;
  }
}
