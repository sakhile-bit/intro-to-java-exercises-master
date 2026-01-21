import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.shape.Rectangle;

public class RectangleInfoPane extends VBox {
  private TextField tfX;
  private TextField tfY;
  private TextField tfWidth;
  private TextField tfHeight;

  public RectangleInfoPane(String name) {
    Label lbInfo = new Label("Enter " + name + " info:");
    Label lbX = new Label("X:");
    Label lbY = new Label("Y:");
    Label lbWidth = new Label("Width:");
    Label lbHeight = new Label("Height:");
    tfX = new TextField();
    tfY = new TextField();
    tfWidth = new TextField();
    tfHeight = new TextField();

    tfX.setPrefWidth(80);
    tfY.setPrefWidth(80);
    tfWidth.setPrefWidth(80);
    tfHeight.setPrefWidth(80);

    GridPane gridPane = new GridPane();
    gridPane.addColumn(0, lbX, lbY, lbWidth, lbHeight);
    gridPane.addColumn(1, tfX, tfY, tfWidth, tfHeight);

    getChildren().addAll(lbInfo, gridPane);
    setStyle("-fx-border-color: black");
  }

  public TextField getTFX() {
    return tfX;
  }

  public TextField getTFY() {
    return tfY;
  }

  public TextField getTFWidth() {
    return tfWidth;
  }

  public TextField getTFHeight() {
    return tfHeight;
  }

  public void updateInfo(Rectangle r) {
    tfX.setText(String.format("%.2f", RectanglePane.getCenterX(r)));
    tfY.setText(String.format("%.2f", RectanglePane.getCenterY(r)));
    tfWidth.setText(String.format("%.2f", r.getWidth()));
    tfHeight.setText(String.format("%.2f", r.getHeight()));
  }
}
