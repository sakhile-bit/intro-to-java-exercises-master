/*
  You have just started a sales job in a department store. Your pay consists
  of a base salary and a commission. The base salary is $5,000. The scheme
  shown below is used to determine the commission rate.

      Sales Amount                    Commission Rate
      $0.01-$5,000                    8 percent
      $5,000.01-$10,000               10 percent
      $10,000.01 and above            12 percent

  Note that this is a graduated rate. The rate for the first $5,000 is at 8%,
  the next $5,000 is at 10%, and the rest is at 12%. If the sales amount is
  25,000, the commission is 5000 * 8% + 5000 * 10% + 15000 * 12% = 2700.

  Your goal is to earn $30000 a year. Write a program that finds the minimum
  sales you have to generate in order to make $30000.
*/

public class E5_39 {
  public static void main(String[] args) {
    // need to earn 25,000 in commission, since base salary is $5000.
    final int COMMISSION_SOUGHT = 25_000;
    double commission = 0.0;
    double salesAmount = 0.01;
    while (commission < COMMISSION_SOUGHT) {
      if (salesAmount <= 5_000) {
        commission = salesAmount * 0.8;
      } else if (salesAmount <= 10_000) {
        commission = 400 + (salesAmount - 5000) * 0.1;
      } else {
        commission = 900 + (salesAmount - 10000) * 0.12;
      }
      salesAmount += 0.01;
    }
    System.out.printf("Sales Needed: $%.2f\n", salesAmount);
  }
}
