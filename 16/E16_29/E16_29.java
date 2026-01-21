/*
  Write a program that displays the calendar for the current month. You can use
  the Prior and Next buttons to show the calendar of the previous or next
  month. Display the dates in the current month in black and display the dates
  in the previous month and next month in gray.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import java.util.Calendar;

public class E16_29 extends Application {
  @Override
  public void start(Stage primaryStage) {
    GraphicalCalendar gc = new GraphicalCalendar();

    Scene scene = new Scene(gc);
    primaryStage.setTitle("E16_29");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
