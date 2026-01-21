/*
  Listing 16.4, ComboBoxDemo.java, gives a program that lets the user view a
  country's flag image and description by selecting the country from a combo
  box. The description is a string coded in the program. Rewrite the program
  to read the text description from a file. Suppose that the descriptions are
  stored in the files description0.txt, ..., and description8.txt under the
  text directory for the nine countries Canada, China, Denmark, France, Germany,
  India, Norway, United Kingdom, and United States, in this order.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import java.io.File;
import java.util.Scanner;

public class E16_27 extends Application {
  private String[] flagTitles = {"Canada", "China", "Denmark", "France",
    "Germany", "India", "Norway", "United Kingdom",
    "United States of America"};

  private ImageView[] flagImage = {
    new ImageView("image/ca.gif"),
    new ImageView("image/china.gif"),
    new ImageView("image/denmark.gif"),
    new ImageView("image/fr.gif"),
    new ImageView("image/germany.gif"),
    new ImageView("image/india.gif"),
    new ImageView("image/norway.gif"),
    new ImageView("image/uk.gif"),
    new ImageView("image/us.gif")
  };

  private DescriptionPane descriptionPane = new DescriptionPane();

  private ComboBox<String> cbo = new ComboBox<>();

  @Override
  public void start(Stage primaryStage) {
    setDisplay(0);

    BorderPane pane = new BorderPane();

    BorderPane paneForComboBox = new BorderPane();
    paneForComboBox.setLeft(new Label("Select a country: "));
    paneForComboBox.setCenter(cbo);
    pane.setTop(paneForComboBox);
    cbo.setPrefWidth(400);
    cbo.setValue("Canada");

    ObservableList<String> items =
      FXCollections.observableArrayList(flagTitles);
    cbo.getItems().addAll(items);
    pane.setCenter(descriptionPane);

    cbo.setOnAction(e -> setDisplay(items.indexOf(cbo.getValue())));

    Scene scene = new Scene(pane, 450, 170);
    primaryStage.setTitle("ComboBoxDemo");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public void setDisplay(int index) {
    descriptionPane.setTitle(flagTitles[index]);
    descriptionPane.setImageView(flagImage[index]);

    File descriptionFile = new File("text/description" + index + ".txt");
    try (
      Scanner input = new Scanner(descriptionFile);
    ) {
      StringBuilder sb = new StringBuilder();
      while (input.hasNext()) {
        sb.append(input.nextLine() + "\n");
      }
      descriptionPane.setDescription(sb.toString());
    } catch (Exception ex) {
      System.out.println(ex);
    }
  }
}
