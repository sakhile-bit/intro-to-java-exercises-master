/*
  Write a program that uses a pie chart to display the percentages of the
  overall grade represented by projects, quizzes, midterm exams, and the final
  exam. Suppose that projects take 20 percent and are displayed in red, quizzes
  take 10 percent and are displayed in blue, midterm exams take 30 percent and
  are displayed in green, and the final exam takes 40 percent and is displayed
  in orange. Use the Arc class to display the pies.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class E14_13 extends Application {
  @Override
  public void start(Stage primaryStage) {
    // Constants
    final double SIZE = 400.0;
    final double RADIUS = SIZE / 2.0;
    final int PROJECT = 20;
    final int QUIZ = 10;
    final int MIDTERM = 30;
    final int FINAL_EXAM = 40;

    // Create the pie slices
    double startAngle = 0;
    Arc project = new Arc(RADIUS, RADIUS, RADIUS, RADIUS,
      startAngle, 360 * (PROJECT / 100.0));
    project.setFill(Color.RED);
    project.setType(ArcType.ROUND);
    startAngle += 360 * (PROJECT / 100.0);
    Arc quiz = new Arc(RADIUS, RADIUS, RADIUS, RADIUS,
      startAngle, 360 * (QUIZ / 100.0));
    quiz.setFill(Color.BLUE);
    quiz.setType(ArcType.ROUND);
    startAngle += 360 * (QUIZ / 100.0);
    Arc midterm = new Arc(RADIUS, RADIUS, RADIUS, RADIUS,
      startAngle, 360 * (MIDTERM / 100.0));
    midterm.setFill(Color.GREEN);
    midterm.setType(ArcType.ROUND);
    startAngle += 360 * (MIDTERM / 100.0);
    Arc finalExam = new Arc(RADIUS, RADIUS, RADIUS, RADIUS,
      startAngle, 360 * (FINAL_EXAM / 100.0));
    finalExam.setFill(Color.ORANGE);
    finalExam.setType(ArcType.ROUND);

    // Create the text labels
    Text tProject = new Text("Project -- " + PROJECT + "%");
    tProject.setX(RADIUS + RADIUS / 8);
    tProject.setY(RADIUS - RADIUS / 4);
    Text tQuiz = new Text("Quiz -- " + QUIZ + "%");
    tQuiz.setX(RADIUS);
    Text tMidterm = new Text("Midterm -- " + MIDTERM + "%");
    tMidterm.setY(RADIUS);
    Text tFinalExam = new Text("Final -- " + FINAL_EXAM + "%");
    tFinalExam.setX(RADIUS);
    tFinalExam.setY(RADIUS + RADIUS);

    Pane pie = new Pane();
    pie.getChildren().addAll(project, quiz, midterm, finalExam, tProject,
      tQuiz, tMidterm, tFinalExam);

    StackPane pane = new StackPane();
    pane.setAlignment(Pos.CENTER);
    pane.setPadding(new Insets(20));
    pane.getChildren().add(pie);

    Scene scene = new Scene(pane);
    primaryStage.setTitle("E14_13");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    Application.launch(args);
  }
}
