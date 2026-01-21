import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Line;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import java.util.ArrayList;

public class HTree extends BorderPane {
  private int order;
  private Pane treePane;

  public HTree() {
    drawGUI();
  }

  private void setOrder(int order) {
    this.order = order;
    treePane.getChildren().clear();
    drawH();
  }

  private void drawH() {
    double length = 200;
    Line line1 = new Line(100, 200, 300, 200);
    Line line2 = new Line(100, 100, 100, 300);
    Line line3 = new Line(300, 100, 300, 300);
    treePane.getChildren().addAll(line1, line2, line3);
    ArrayList<Line> lines = new ArrayList<>();
    lines.add(line2);
    lines.add(line3);
    drawH(length / 2, lines, order);
  }

  private void drawH(double length, ArrayList<Line> lines, int order) {
    if (order == 0) { return; }

    ArrayList<Line> nextLines = new ArrayList<>();

    for (Line line: lines) {
      Line top1 = new Line(line.getStartX() - length / 2, line.getStartY(),
        line.getStartX() + length / 2, line.getStartY());
      Line top2 = new Line(top1.getStartX(), top1.getStartY() - length / 2,
        top1.getStartX(), top1.getStartY() + length / 2);
      Line top3 = new Line(top1.getEndX(), top1.getEndY() - length / 2,
        top1.getEndX(), top1.getEndY() + length / 2);
      Line bot1 = new Line(line.getEndX() - length / 2, line.getEndY(),
        line.getEndX() + length / 2, line.getEndY());
      Line bot2 = new Line(bot1.getStartX(), bot1.getStartY() - length / 2,
        bot1.getStartX(), bot1.getStartY() + length / 2);
      Line bot3 = new Line(bot1.getEndX(), bot1.getEndY() - length / 2,
        bot1.getEndX(), bot1.getEndY() + length / 2);
      nextLines.add(top2);
      nextLines.add(top3);
      nextLines.add(bot2);
      nextLines.add(bot3);
      treePane.getChildren().addAll(top1, top2, top3, bot1, bot2, bot3);
    }

    drawH(length / 2, nextLines, order - 1);
  }

  private void drawGUI() {
    treePane = new Pane();
    treePane.setPrefSize(400, 400);

    Label lbOrder = new Label("Enter an order:");
    TextField tfOrder = new TextField("0");

    tfOrder.setOnKeyPressed(e -> {
      if (e.getCode().equals(KeyCode.ENTER)) {
        setOrder(Integer.parseInt(tfOrder.getText()));
      }
    });

    HBox hbControl = new HBox(10);
    hbControl.getChildren().addAll(lbOrder, tfOrder);
    hbControl.setAlignment(Pos.CENTER);

    setCenter(treePane);
    setBottom(hbControl);
    setMargin(treePane, new Insets(50));

    setOrder(0);
  }

  private Point2D getMidpoint(double x1, double y1, double x2, double y2) {
    return (new Point2D(x1, y1)).midpoint(new Point2D(x2, y2));
  }
}
