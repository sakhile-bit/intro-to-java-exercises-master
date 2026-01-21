/*
  Rewrite Programming Exercise 5.21 to create a GUI. Your program should let
  the user enter the loan amount and loan period in the number of years from
  text fields, and it should display the monthly and total payments for each
  interest rate starting from 5 percent to 8 percent, with increments of
  one-eighth, in a text area.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;

public class E16_13 extends Application {
  @Override
  public void start(Stage primaryStage) {
    Label lbLoanAmount = new Label("Loan Amount");
    Label lbNumberOfYears = new Label("Number of Years");
    TextField tfLoanAmount = new TextField();
    TextField tfNumberOfYears = new TextField();
    Button btShowTable = new Button("Show Table");
    TextArea taTable = new TextArea();
    ScrollPane spTable = new ScrollPane(taTable);

    tfLoanAmount.setPrefWidth(100);
    tfNumberOfYears.setPrefWidth(50);
    taTable.setEditable(false);
    taTable.setFont(Font.font("Courier", 15));
    taTable.setPrefWidth(500);

    btShowTable.setOnAction(e -> {
      StringBuilder sb = new StringBuilder();
      sb.append("Interest Rate    Monthly Payment    Total Payment\n");
      double rate = 5.0;
      double amount = Double.parseDouble(tfLoanAmount.getText());
      int years = Integer.parseInt(tfNumberOfYears.getText());
      for (int i = 0; i <= 24; i++, rate += 0.125) {
        double monthlyPayment = getMonthlyPayment(amount, rate, years);
        double totalPayment = getTotalPayment(monthlyPayment, years);
        sb.append(String.format("%-13.3f    %-15.2f    %-13.2f\n",
          rate, monthlyPayment, totalPayment));
      }
      taTable.setText(sb.toString());
    });

    HBox controlBox = new HBox(10);
    controlBox.getChildren().addAll(lbLoanAmount, tfLoanAmount,
      lbNumberOfYears, tfNumberOfYears, btShowTable);

    BorderPane pane = new BorderPane();
    pane.setCenter(controlBox);
    pane.setBottom(spTable);

    Scene scene = new Scene(pane);
    primaryStage.setTitle("E16_13");
    primaryStage.setScene(scene);
    primaryStage.setResizable(false);
    primaryStage.show();
  }

  public static double getMonthlyPayment(double amount, double rate, int years) {
    double monthlyRate = rate / 1200;
    return amount * monthlyRate / (1 - 1 / Math.pow(1 + monthlyRate, years * 12));
  }

  public static double getTotalPayment(double monthlyPayment, int years) {
    return monthlyPayment * years * 12;
  }

  public static void main(String[] args) {
    launch(args);
  }
}
