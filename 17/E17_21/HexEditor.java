import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.geometry.Pos;
import java.io.File;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.EOFException;

public class HexEditor extends BorderPane {
  TextField tfFileName;
  TextArea taFile;

  public HexEditor() {
    drawGUI();
  }

  private void drawGUI() {
    Label lbFileName = new Label("Enter a file:");
    tfFileName = new TextField();
    taFile = new TextArea();
    Button btSave = new Button("Save the change");

    tfFileName.setOnKeyPressed(e -> {
      if (e.getCode().equals(KeyCode.ENTER)) {
        loadFile();
      }
    });

    btSave.setOnAction(e -> saveChanges());

    taFile.setWrapText(true);

    HBox hbFileEntry = new HBox(10);
    hbFileEntry.getChildren().addAll(lbFileName, tfFileName);

    setTop(hbFileEntry);
    setCenter(taFile);
    setBottom(btSave);
    setAlignment(btSave, Pos.CENTER);
  }

  private void loadFile() {
    StringBuilder bin = new StringBuilder();
    StringBuilder hex = new StringBuilder();
    try (
      DataInputStream input = new DataInputStream(
        new FileInputStream(tfFileName.getText()));
    ) {
      while (true) {
        int value = input.readByte();
        hex.append(getHexVal(value));
      }
    } catch (EOFException ex) {
      taFile.setText(hex.toString());
    } catch (IOException ex) {
      // do nothing
    }
  }

  private void saveChanges() {
    try (
      BitOutputStream bos = new BitOutputStream(new File(tfFileName.getText()));
    ) {
      StringBuilder sb = new StringBuilder();
      String text = taFile.getText();
      for (int i = 0; i < text.length() - 1; i += 2) {
        int a = hexToDec(text.charAt(i));
        int b = hexToDec(text.charAt(i + 1));
        int value = (a * 16) + b;
        sb.append(getBits(value));
      }
      bos.writeBit(sb.toString());
    } catch (IOException ex) {
      // do nothing
    }
  }

  private static String getBits(int value) {
    StringBuilder sb = new StringBuilder();
    sb.append(value % 2 == 0 ? "0" : "1");
    for (int i = 1; i < 8; i++) {
      value = value >> 1;
      sb.insert(0, (value % 2 == 0) ? "0" : "1");
    }
    return sb.toString();
  }

  private static String getHexVal(int value) {
    String h = Integer.toHexString(value);
    if (h.length() == 1) {
      h = "0" + h;
    }
    return h;
  }

  private static int hexToDec(char hex) {
    if (Character.isDigit(hex)) {
      return Integer.parseInt(Character.toString(hex));
    }

    int num = 0;
    switch (Character.toLowerCase(hex)) {
      case 'a': num = 10; break;
      case 'b': num = 11; break;
      case 'c': num = 12; break;
      case 'd': num = 13; break;
      case 'e': num = 14; break;
      case 'f': num = 15;
    }
    return num;
  }
}
