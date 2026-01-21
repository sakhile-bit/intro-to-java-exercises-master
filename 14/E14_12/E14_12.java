/*
  Write a program that uses a bar chart to display the percentages of the
  overall grade represented by projects, quizzes, midterm exams, and the final
  exam. Suppose that projects take 20 percent and are displayed in red,
  quizzes take 10 percent and are displayed in blue, midterm exams take 30
  percent and are displayed in green, and the final exam takes 40 percent and
  is displayed in orange. Use the Rectangle class to display the bars.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;
import javafx.geometry.VPos;

public class E14_12 extends Application {
  @Override
  public void start(Stage primaryStage) {
    // Represents the height of a 100% bar
    final int HEIGHT = 800;
    final int WIDTH = (int)Math.round(HEIGHT / 8);

    // The percent of each graded portion (should add up to 100)
    final int PROJECT = 20;
    final int QUIZ = 10;
    final int MIDTERM = 30;
    final int FINAL_EXAM = 40;

    GridPane pane = new GridPane();

    // Create Labels
    Label projectLabel = getLabel("Project", PROJECT);
    Label quizLabel = getLabel("Quiz", QUIZ);
    Label midtermLabel = getLabel("Midterm", MIDTERM);
    Label finalExamLabel = getLabel("Final", FINAL_EXAM);

    // Create Bars
    Rectangle project = getBar(PROJECT, HEIGHT, WIDTH, Color.RED);
    Rectangle quiz = getBar(QUIZ, HEIGHT, WIDTH, Color.BLUE);
    Rectangle midterm = getBar(MIDTERM, HEIGHT, WIDTH, Color.GREEN);
    Rectangle finalExam = getBar(FINAL_EXAM, HEIGHT, WIDTH, Color.ORANGE);

    // Set constraints and options for the GridPane
    RowConstraints rc = new RowConstraints();
    rc.setValignment(VPos.BOTTOM);
    pane.getRowConstraints().add(rc);
    pane.setHgap(20);
    pane.setPadding(new Insets(20));

    // Add bars and labels to
    pane.addRow(0, project, quiz, midterm, finalExam);
    pane.addRow(1, projectLabel, quizLabel, midtermLabel, finalExamLabel);

    Scene scene = new Scene(pane);
    primaryStage.setTitle("E14_12");
    primaryStage.setScene(scene);
    primaryStage.setResizable(false);
    primaryStage.show();
  }

  private static Rectangle getBar(
    int percentage, int height, int width, Color color) {
    Rectangle bar = new Rectangle(width, height * (percentage / 100.0));
    bar.setFill(color);
    return bar;
  }

  private static Label getLabel(String title, int percentage) {
    return new Label(title + " -- " + percentage + "%");
  }

  public static void main(String[] args) {
    Application.launch(args);
  }
}
