import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import java.io.File;
import java.io.RandomAccessFile;
import java.io.FileOutputStream;
import java.io.IOException;

public class Combiner extends BorderPane {
  private TextField tfFileName;
  private TextField tfNumber;

  public Combiner() {
    drawGUI();
  }

  private void drawGUI() {
    Text tDescription = new Text("If the base file is named temp.txt " +
      "with three pieces,\ntemp.txt.1, temp.txt.2, and temp.txt.3 " +
      "are combined into temp.txt");

    Label lbFileName = new Label("Enter a file:");
    Label lbNumber = new Label("Specify the number of smaller files:");
    tfFileName = new TextField();
    tfNumber = new TextField();

    GridPane gpEntry = new GridPane();
    gpEntry.addColumn(0, lbFileName, lbNumber);
    gpEntry.addColumn(1, tfFileName, tfNumber);
    gpEntry.setAlignment(Pos.CENTER);
    gpEntry.setHgap(10);

    Button btStart = new Button("Start");
    btStart.setOnAction(e -> start());

    setTop(tDescription);
    setCenter(gpEntry);
    setBottom(btStart);
    setAlignment(tDescription, Pos.CENTER);
    setMargin(tDescription, new Insets(20, 20, 0, 20));
    setAlignment(btStart, Pos.CENTER);
    setMargin(btStart, new Insets(0, 20, 20, 20));
    setMargin(gpEntry, new Insets(20));
  }

  private void start() {
    if (!numberIsInteger()) {
      return;
    }

    if (!sourceFilesValid()) {
      return;
    }

    String baseFilePath = tfFileName.getText();
    long numberOfPieces = Long.parseLong(tfNumber.getText());

    for (int i = 1; i <= numberOfPieces; i++) {
      try (
        RandomAccessFile raf =
          new RandomAccessFile(baseFilePath + "." + i, "r");
        FileOutputStream output = new FileOutputStream(baseFilePath, true);
      ) {
        byte[] bytes = new byte[(int)raf.length()];
        raf.read(bytes);
        output.write(bytes);
      } catch (IOException ex) {
        // do nothing
      }
    }
  }

  private boolean numberIsInteger() {
    String s = tfNumber.getText();
    for (int i = 0; i < s.length(); i++) {
      if (!Character.isDigit(s.charAt(i))) {
        return false;
      }
    }
    return true;
  }

  private boolean sourceFilesValid() {
    for (int i = 1; i <= Long.parseLong(tfNumber.getText()); i++) {
      File file = new File(tfFileName.getText() + "." + i);
      if (!file.exists()) { return false; }
    }
    return true;
  }
}
