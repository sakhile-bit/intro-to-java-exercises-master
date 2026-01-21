import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;

public class CircleInfoPane extends VBox {
  private TextField tfX;
  private TextField tfY;
  private TextField tfRadius;

  public CircleInfoPane(String name) {
    Label lbInfo = new Label("Enter " + name + " info:");
    Label lbX = new Label("Center x:");
    Label lbY = new Label("Center y:");
    Label lbRadius = new Label("Radius:");
    tfX = new TextField();
    tfY = new TextField();
    tfRadius = new TextField();

    tfX.setPrefWidth(80);
    tfY.setPrefWidth(80);
    tfRadius.setPrefWidth(80);

    GridPane gridPane = new GridPane();
    gridPane.addColumn(0, lbX, lbY, lbRadius);
    gridPane.addColumn(1, tfX, tfY, tfRadius);

    getChildren().addAll(lbInfo, gridPane);
    setStyle("-fx-border-color: black");
  }

  public TextField getTFX() {
    return tfX;
  }

  public TextField getTFY() {
    return tfY;
  }

  public TextField getTFRadius() {
    return tfRadius;
  }

  public void updateInfo(Circle c) {
    tfX.setText(String.format("%.2f", c.getCenterX()));
    tfY.setText(String.format("%.2f", c.getCenterY()));
    tfRadius.setText(String.format("%.2f", c.getRadius()));
  }
}
