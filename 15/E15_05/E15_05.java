/*
  Write a program that calculates the future value of an investment at a given
  interest rate for a specified number of years. The formula for the
  calculation is:

  futureValue = investmentAmount * (1 + monthlyInterestRate)^(years * 12)

  Use text fields for the investment amount, number of years, and annual
  interest rate. Display the future amount in a text field when the user clicks
  the Calculate button.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.geometry.Insets;
import javafx.geometry.HPos;
import javafx.geometry.Pos;

public class E15_05 extends Application {
  @Override
  public void start(Stage primaryStage) {
    Text tInvestmentAmount = new Text("Investment Amount:");
    Text tNumberOfYears = new Text("Number of Years:");
    Text tAnnualInterestRate = new Text("Annual Interest Rate:");
    Text tFutureValue = new Text("Future Value:");

    TextField tfInvestmentAmount = new TextField();
    TextField tfNumberOfYears = new TextField();
    TextField tfAnnualInterestRate = new TextField();
    TextField tfFutureValue = new TextField();
    tfFutureValue.setEditable(false);

    Button btCalculate = new Button("Calculate");
    btCalculate.setOnAction(e -> {
      double a = getDoubleFromTextField(tfInvestmentAmount);
      double b = getDoubleFromTextField(tfAnnualInterestRate) / 1200;
      double c = getDoubleFromTextField(tfNumberOfYears) * 12;
      tfFutureValue.setText(String.format("$%.2f", a * Math.pow(1 + b, c)));
    });

    GridPane pane = new GridPane();
    pane.addRow(0, tInvestmentAmount, tfInvestmentAmount);
    pane.addRow(1, tNumberOfYears, tfNumberOfYears);
    pane.addRow(2, tAnnualInterestRate, tfAnnualInterestRate);
    pane.addRow(3, tFutureValue, tfFutureValue);
    pane.add(btCalculate, 1, 4);
    pane.setVgap(5);
    pane.setHgap(5);
    pane.setPadding(new Insets(5));
    pane.setHalignment(btCalculate, HPos.RIGHT);
    pane.setAlignment(Pos.CENTER);

    Scene scene = new Scene(pane);
    primaryStage.setTitle("E15_05");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  private static double getDoubleFromTextField(TextField t) {
    return Double.parseDouble(t.getText());
  }

  public static void main(String[] args) {
    launch(args);
  }
}
