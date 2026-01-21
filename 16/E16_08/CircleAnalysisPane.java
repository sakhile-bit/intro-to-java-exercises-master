import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.shape.Circle;
import javafx.event.EventHandler;
import javafx.geometry.Pos;

public class CircleAnalysisPane extends VBox {
  private CirclePane circ;
  private CircleInfoPane circInfo1;
  private CircleInfoPane circInfo2;
  private Label lbIntersect;

  public CircleAnalysisPane() {
    // Set up the pane containing the circles
    circ = new CirclePane(500);
    circ.setMinWidth(circ.getPaneSize());
    circ.setMinHeight(circ.getPaneSize());

    EventHandler<MouseEvent> dragCircle = e -> {
      Circle c = (Circle)e.getSource();
      c.setCenterX(e.getX());
      c.setCenterY(e.getY());
      lbIntersect.setText(getIntersectText(circ));
    };

    circ.getC1().setOnMouseDragged(dragCircle);
    circ.getC2().setOnMouseDragged(dragCircle);

    // Set up the label that reports whether the two circles intersect
    lbIntersect = new Label();
    lbIntersect.setText(getIntersectText(circ));

    // Set up the info panes for each circle
    circInfo1 = new CircleInfoPane("circle 1");
    circInfo2 = new CircleInfoPane("circle 2");

    circInfo1.getTFX().setOnKeyPressed(
      getEnterInfoHandler(circ.getC1(), circInfo1));
    circInfo1.getTFY().setOnKeyPressed(
      getEnterInfoHandler(circ.getC1(), circInfo1));
    circInfo1.getTFRadius().setOnKeyPressed(
      getEnterInfoHandler(circ.getC1(), circInfo1));
    circInfo2.getTFX().setOnKeyPressed(
      getEnterInfoHandler(circ.getC2(), circInfo2));
    circInfo2.getTFY().setOnKeyPressed(
      getEnterInfoHandler(circ.getC2(), circInfo2));
    circInfo2.getTFRadius().setOnKeyPressed(
      getEnterInfoHandler(circ.getC2(), circInfo2));

    circInfo1.updateInfo(circ.getC1());
    circInfo2.updateInfo(circ.getC2());

    // Listen to changes in each circle's center X and center Y properties in
    // order to update their respective info pane fields
    circ.getC1().centerXProperty().addListener(
      ov -> circInfo1.updateInfo(circ.getC1()));
    circ.getC1().centerYProperty().addListener(
      ov -> circInfo1.updateInfo(circ.getC1()));
    circ.getC2().centerXProperty().addListener(
      ov -> circInfo2.updateInfo(circ.getC2()));
    circ.getC2().centerYProperty().addListener(
      ov -> circInfo2.updateInfo(circ.getC2()));

    HBox circInfoBox = new HBox(10);
    circInfoBox.getChildren().addAll(circInfo1, circInfo2);
    circInfoBox.setAlignment(Pos.CENTER);

    Button btRedraw = new Button("Redraw Circles");
    btRedraw.setOnAction(e -> circ.drawCircles());

    getChildren().addAll(lbIntersect, circ, circInfoBox, btRedraw);
    setAlignment(Pos.CENTER);
  }

  private static String getIntersectText(CirclePane c) {
    StringBuilder sb = new StringBuilder("Two rectangles intersect? ");
    sb.append(c.doIntersect() ? "Yes" : "No");
    return sb.toString();
  }

  private static EventHandler<KeyEvent> getEnterInfoHandler(Circle c,
    CircleInfoPane info) {
    return e -> {
      if (e.getCode().equals(KeyCode.ENTER)) {
        CirclePane.updateCircle(c, info);
      }
    };
  }
}
