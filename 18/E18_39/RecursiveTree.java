import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

public class RecursiveTree extends BorderPane {
  private double startX;
  private double startY;

  public RecursiveTree() {
    drawGUI();
  }

  private void drawGUI() {
    RecursiveTreePane rtp = new RecursiveTreePane();
    Label lbOrder = new Label("Enter an order:");
    TextField tfOrder = new TextField();

    tfOrder.setText("0");
    tfOrder.setPrefColumnCount(5);
    tfOrder.setAlignment(Pos.CENTER_RIGHT);

    tfOrder.setOnKeyPressed(e -> {
      if (e.getCode().equals(KeyCode.ENTER)) {
        rtp.setOrder(Integer.parseInt(tfOrder.getText()));
      }
    });

    rtp.setOnMousePressed(e -> {
      startX = e.getX();
      startY = e.getY();
    });

    rtp.setOnMouseDragged(e -> {
      rtp.setTranslateX(rtp.getTranslateX() + e.getX() - startX);
      rtp.setTranslateY(rtp.getTranslateY() + e.getY() - startY);
    });

    HBox hbControl = new HBox(10);
    hbControl.getChildren().addAll(lbOrder, tfOrder);
    hbControl.setAlignment(Pos.CENTER);

    setCenter(rtp);
    setBottom(hbControl);
    setAlignment(rtp, Pos.CENTER);
    setMargin(hbControl, new Insets(10));
  }
}
