/*
  Write a program that displays a text file in a text area. The user enters a
  file name in a text field and clicks the View button; the file is then
  displayed in a text area.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.geometry.Pos;
import java.io.File;
import java.net.URI;
import java.util.Scanner;

public class E16_10 extends Application {
  @Override
  public void start(Stage primaryStage) {
    TextArea textArea = new TextArea();
    ScrollPane scrollPane = new ScrollPane(textArea);

    Label lbFileName = new Label("Filename:");
    TextField tfFileName = new TextField();
    Button btView = new Button("View");

    HBox controlPane = new HBox();
    controlPane.getChildren().addAll(lbFileName, tfFileName, btView);

    BorderPane pane = new BorderPane();
    pane.setCenter(scrollPane);
    pane.setBottom(controlPane);

    btView.setOnAction(e -> {
      try {
        URI uri = new URI(tfFileName.getText());
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
            sb.append(input.nextLine() + "\n");
          }
          textArea.setText(sb.toString());
        } catch (Exception ex) {
          textArea.setText(ex.toString());
        }
      } catch (Exception ex) {
        textArea.setText(ex.toString());
      }
    });

    Scene scene = new Scene(pane);
    primaryStage.setTitle("E16_10");
    primaryStage.setScene(scene);
    primaryStage.setResizable(false);
    primaryStage.show();

    tfFileName.requestFocus();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
