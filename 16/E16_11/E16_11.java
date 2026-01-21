/*
  Write a program that reads a file and displays a histogram to show the
  occurrences of each letter in the file. The file name is entered from a text
  field. Pressing the Enter key on the text field causes the program to start
  to read and process the file and displays the histogram. The histogram is
  displayed in the center of the window. Define a class named Histogram that
  extends Pane. The class contains the property counts that is an array of 26
  elements. counts[0] stores the number of A, counts[1] the number of B, and so
  on. The class also contains a setter method for setting a new counts and
  displaying the histogram for the new counts.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Insets;
import java.io.File;
import java.net.URI;
import java.util.Scanner;

public class E16_11 extends Application {
  static int[] counts = new int[26];

  @Override
  public void start(Stage primaryStage) {
    Histogram hist = new Histogram();
    Label lbFilename = new Label("Filename");
    TextField tfFilename = new TextField();
    Button btView = new Button("View");

    btView.setOnAction(e -> {
      counts = new int[26];
      try {
        URI uri = new URI(tfFilename.getText());
        File file;
        if (uri.isAbsolute()) {
          file = new File(uri);
        } else {
          file = new File(uri.toString());
        }

        try (
          Scanner input = new Scanner(file);
        ) {
          StringBuilder sb = new StringBuilder();
          while (input.hasNext()) {
            sb.append(input.nextLine().toLowerCase() + "\n");
          }
          countLetters(sb.toString());
          hist.setCounts(counts);
        } catch (Exception ex) {
          System.out.println(ex);
        }
      } catch (Exception ex) {
        System.out.println(ex);
      }
    });

    HBox controlBox = new HBox(10);
    controlBox.getChildren().addAll(lbFilename, tfFilename, btView);

    BorderPane pane = new BorderPane();
    pane.setCenter(hist);
    pane.setBottom(controlBox);
    pane.setMargin(hist, new Insets(20));

    Scene scene = new Scene(pane);
    primaryStage.setTitle("E16_11");
    primaryStage.setScene(scene);
    primaryStage.setResizable(false);
    primaryStage.show();
  }

  public static void countLetters(String s) {
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (Character.isLetter(c)) {
        counts[(int)c - 97]++;
      }
    }
  }

  public static void main(String[] args) {
    launch(args);
  }
}
