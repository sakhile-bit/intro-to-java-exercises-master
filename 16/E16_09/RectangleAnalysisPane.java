import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.shape.Rectangle;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.beans.value.ChangeListener;

public class RectangleAnalysisPane extends VBox {
  private RectanglePane rect;
  private RectangleInfoPane rectInfo1;
  private RectangleInfoPane rectInfo2;
  private Label lbIntersect;

  public RectangleAnalysisPane() {
    // Set up the pane containing the rectangles
    rect = new RectanglePane(500);
    rect.setMinWidth(rect.getPaneSize());
    rect.setMinHeight(rect.getPaneSize());

    EventHandler<MouseEvent> dragRectangle = e -> {
      Rectangle r = (Rectangle)e.getSource();
      r.setX(e.getX() - r.getWidth() / 2);
      r.setY(e.getY() - r.getHeight() / 2);
      lbIntersect.setText(getIntersectText(rect));
    };

    rect.getR1().setOnMouseDragged(dragRectangle);
    rect.getR2().setOnMouseDragged(dragRectangle);

    // Set up the label that reports whether the two rectangles intersect
    lbIntersect = new Label();
    lbIntersect.setText(getIntersectText(rect));

    // Set up the info panes for each rectangle
    rectInfo1 = new RectangleInfoPane("rectangle 1");
    rectInfo2 = new RectangleInfoPane("rectangle 2");

    rectInfo1.getTFX().setOnKeyPressed(
      getEnterInfoHandler(rect.getR1(), rectInfo1));
    rectInfo1.getTFY().setOnKeyPressed(
      getEnterInfoHandler(rect.getR1(), rectInfo1));
    rectInfo1.getTFWidth().setOnKeyPressed(
      getEnterInfoHandler(rect.getR1(), rectInfo1));
    rectInfo1.getTFHeight().setOnKeyPressed(
      getEnterInfoHandler(rect.getR1(), rectInfo1));
    rectInfo2.getTFX().setOnKeyPressed(
      getEnterInfoHandler(rect.getR2(), rectInfo2));
    rectInfo2.getTFY().setOnKeyPressed(
      getEnterInfoHandler(rect.getR2(), rectInfo2));
    rectInfo2.getTFWidth().setOnKeyPressed(
      getEnterInfoHandler(rect.getR2(), rectInfo2));
    rectInfo2.getTFHeight().setOnKeyPressed(
      getEnterInfoHandler(rect.getR2(), rectInfo2));

    rectInfo1.updateInfo(rect.getR1());
    rectInfo2.updateInfo(rect.getR2());

    // Listen to changes in each rectangle's X and Y properties in order to
    // update their respective info pane fields
    rect.getR1().xProperty().addListener(
      ov -> rectInfo1.updateInfo(rect.getR1()));
    rect.getR1().yProperty().addListener(
      ov -> rectInfo1.updateInfo(rect.getR1()));
    rect.getR2().xProperty().addListener(
      ov -> rectInfo2.updateInfo(rect.getR2()));
    rect.getR2().yProperty().addListener(
      ov -> rectInfo2.updateInfo(rect.getR2()));

    HBox rectInfoBox = new HBox(10);
    rectInfoBox.getChildren().addAll(rectInfo1, rectInfo2);
    rectInfoBox.setAlignment(Pos.CENTER);

    Button btRedraw = new Button("Redraw Rectangles");
    btRedraw.setOnAction(e -> rect.drawRectangles());

    getChildren().addAll(lbIntersect, rect, rectInfoBox, btRedraw);
    setAlignment(Pos.CENTER);
  }

  private static String getIntersectText(RectanglePane r) {
    StringBuilder sb = new StringBuilder("Two rectangles intersect? ");
    sb.append(r.doIntersect() ? "Yes" : "No");
    return sb.toString();
  }
  
  private static EventHandler<KeyEvent> getEnterInfoHandler(Rectangle r,
    RectangleInfoPane info) {
    return e -> {
      if (e.getCode().equals(KeyCode.ENTER)) {
        RectanglePane.updateRectangle(r, info);
      }
    };
  }
}
