import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.geometry.Pos;
import java.io.RandomAccessFile;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.EOFException;

public class AddressBook extends BorderPane {

  // FIELDS

  private TextField tfName;
  private TextField tfStreet;
  private TextField tfCity;
  private TextField tfState;
  private TextField tfZip;
  private static final String BOOK_FILE = "ab.dat";
  // each entry has 101 bytes: 32 name, 32 street, 20 city, 2 state, 5 zip
  // with an additional 2 bytes on each field for the length
  private static final int ENTRY_LENGTH = 101;
  private RandomAccessFile raf;

  // CONSTRUCTORS

  public AddressBook() {
    drawGUI();
    getBook();
    first();
  }

  // GUI METHODS

  private void drawGUI() {
    Label lbName = new Label("Name");
    Label lbStreet = new Label("Street");
    Label lbCity = new Label("City");
    Label lbState = new Label("State");
    Label lbZip = new Label("Zip");
    tfName = new TextField();
    tfStreet = new TextField();
    tfCity = new TextField();
    tfState = new TextField();
    tfZip = new TextField();

    HBox hbName = new HBox(5);
    hbName.getChildren().addAll(lbName, tfName);

    HBox hbStreet = new HBox(5);
    hbStreet.getChildren().addAll(lbStreet, tfStreet);

    HBox hbLocality = new HBox(5);
    hbLocality.getChildren().addAll(
      lbCity, tfCity, lbState, tfState, lbZip, tfZip);

    VBox vbEntry = new VBox(5);
    vbEntry.getChildren().addAll(hbName, hbStreet, hbLocality);

    Button btAdd = new Button("Add");
    Button btFirst = new Button("First");
    Button btNext = new Button("Next");
    Button btPrevious = new Button("Previous");
    Button btLast = new Button("Last");
    Button btUpdate = new Button("Update");

    btAdd.setOnAction(e -> add());
    btFirst.setOnAction(e -> first());
    btNext.setOnAction(e -> next());
    btPrevious.setOnAction(e -> previous());
    btLast.setOnAction(e -> last());
    btUpdate.setOnAction(e -> update());

    HBox hbControls = new HBox(5);
    hbControls.getChildren().addAll(
      btAdd, btFirst, btNext, btPrevious, btLast, btUpdate);
    hbControls.setAlignment(Pos.CENTER);

    setCenter(vbEntry);
    setBottom(hbControls);
  }

  // BUTTON ACTION METHODS
    // The general strategy is to perform a given action using the
    // RandomAccessFile, then back up to the start of the current entry in the
    // file and await the next action.

  private void add() {
    try {
      raf.seek(raf.length());
      save(raf);
      clear();
    } catch (IOException ex) {
      // do nothing
    }
  }

  private void first() {
    try {
      raf.seek(0);
      populate(raf);
      raf.seek(0);
    } catch (IOException ex) {
      // do nothing
    }
  }

  private void next() {
    try {
      raf.seek(raf.getFilePointer() + ENTRY_LENGTH);
      populate(raf);
      raf.seek(raf.getFilePointer() - ENTRY_LENGTH);
    } catch (IOException ex) {
      // do nothing
    }
  }

  private void previous() {
    try {
      if (raf.getFilePointer() > 0) {
        raf.seek(raf.getFilePointer() - ENTRY_LENGTH);
        populate(raf);
        raf.seek(raf.getFilePointer() - ENTRY_LENGTH);
      } else {
        raf.seek(0);
        populate(raf);
      }
    } catch (IOException ex) {
      // do nothing
    }
  }

  private void last() {
    try {
      raf.seek(raf.length() - ENTRY_LENGTH);
      populate(raf);
      raf.seek(raf.getFilePointer() - ENTRY_LENGTH);
    } catch (IOException ex) {
      // do nothing
    }
  }

  private void update() {
    save(raf);
  }

  // BUTTON ACTION CONVENIENCE METHODS

  private void populate(RandomAccessFile raf) {
    try {
      tfName.setText(raf.readUTF());
      tfStreet.setText(raf.readUTF());
      tfCity.setText(raf.readUTF());
      tfState.setText(raf.readUTF());
      tfZip.setText(raf.readUTF());
    } catch (IOException ex) {
      // do nothing
    }
  }

  private void save(RandomAccessFile raf) {
    try {
      raf.writeUTF(rightSize(tfName.getText(), 32));
      raf.writeUTF(rightSize(tfStreet.getText(), 32));
      raf.writeUTF(rightSize(tfCity.getText(), 20));
      raf.writeUTF(rightSize(tfState.getText(), 2));
      raf.writeUTF(rightSize(tfZip.getText(), 5));
    } catch (IOException ex) {
      // do nothing
    }
  }

  private void clear() {
    tfName.setText("");
    tfStreet.setText("");
    tfCity.setText("");
    tfState.setText("");
    tfZip.setText("");
  }

  // Ensures that an entry has a uniform length for its given field. This
  // will pad an entry with extra space or cut it short depending on whether
  // it is too short or too long.
  private String rightSize(String s, int n) {
    if (s.length() < n) {
      int fill = n - s.length();
      for (int i = 0; i < fill; i++) {
        s += " ";
      }
      return s;
    }
    if (s.length() > n) {
      return s.substring(0, n);
    }
    return s;
  }

  // Convenience method for opening the address file.
  private void getBook() {
    try {
      raf = new RandomAccessFile(BOOK_FILE, "rw");
    } catch (IOException ex) {
      // do nothing
    }
  }
}
