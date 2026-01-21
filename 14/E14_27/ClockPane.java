import java.util.Calendar;
import java.util.GregorianCalendar;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class ClockPane extends Pane {
  private int hour;
  private int minute;
  private int second;

  private double w = 250, h = 250;

  public ClockPane() {
    setCurrentTime();
  }

  public ClockPane(int hour, int minute, int second) {
    this.hour = hour;
    this.minute = minute;
    this.second = second;
    paintClock();
  }

  public int getHour() {
    return hour;
  }

  public void setHour(int hour) {
    this.hour = hour;
    paintClock();
  }

  public int getMinute() {
    return minute;
  }

  public void setMinute(int minute) {
    this.minute = minute;
    paintClock();
  }

  public int getSecond() {
    return second;
  }

  public void setSecond(int second) {
    this.second = second;
    paintClock();
  }

  public double getW() {
    return w;
  }

  public void setW(double w) {
    this.w = w;
    paintClock();
  }

  public double getH() {
    return h;
  }

  public void setH(double h) {
    this.h = h;
    paintClock();
  }

  public void setCurrentTime() {
    Calendar calendar = new GregorianCalendar();

    this.hour = calendar.get(Calendar.HOUR_OF_DAY);
    this.minute = calendar.get(Calendar.MINUTE);
    this.second = calendar.get(Calendar.SECOND);

    paintClock();
  }

  protected void paintClock() {
    double clockRadius = Math.min(w, h) * 0.5;
    double centerX = w / 2;
    double centerY = h / 2;

    Circle circle = new Circle(centerX, centerY, clockRadius);
    circle.setFill(Color.WHITE);
    circle.setStroke(Color.BLACK);
    // Text t1 = new Text(centerX - 5, centerY - clockRadius + 12, "12");
    // Text t2 = new Text(centerX - clockRadius + 3, centerY + 5, "9");
    // Text t3 = new Text(centerX + clockRadius - 10, centerY + 3, "3");
    // Text t4 = new Text(centerX - 3, centerY + clockRadius - 3, "6");

    double sLength = clockRadius * 0.8;
    double secondX = centerX + sLength * Math.sin(second * (2 * Math.PI / 60));
    double secondY = centerY - sLength * Math.cos(second * (2 * Math.PI / 60));
    Line sLine = new Line(centerX, centerY, secondX, secondY);
    sLine.setStroke(Color.RED);

    double mLength = clockRadius * 0.65;
    double xMinute = centerX + mLength * Math.sin(minute * (2 * Math.PI / 60));
    double minuteY = centerY - mLength * Math.cos(minute * (2 * Math.PI / 60));
    Line mLine = new Line(centerX, centerY, xMinute, minuteY);
    mLine.setStroke(Color.BLUE);

    double hLength = clockRadius * 0.5;
    double hourX = centerX + hLength *
      Math.sin((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
    double hourY = centerY - hLength *
      Math.cos((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
    Line hLine = new Line(centerX, centerY, hourX, hourY);
    hLine.setStroke(Color.GREEN);

    getChildren().clear();
    getChildren().addAll(circle, sLine, mLine, hLine);

    // Draw minute lines
    for (int i = 0; i < 60; i++) {
      double startX = centerX + clockRadius * Math.cos(2 * i * Math.PI / 60);
      double startY = centerY + clockRadius * Math.sin(2 * i * Math.PI / 60);
      double endX = startX - (clockRadius / 30) * Math.cos(2 * i * Math.PI / 60);
      double endY = startY - (clockRadius / 30) * Math.sin(2 * i * Math.PI / 60);
      getChildren().add(new Line(startX, startY, endX, endY));
    }

    // Draw hour lines and labels
    for (int i = 0, j = 3; i < 12; i++, j++) {
      double startX = centerX + clockRadius * Math.cos(2 * i * Math.PI / 12);
      double startY = centerY + clockRadius * Math.sin(2 * i * Math.PI / 12);
      double endX = startX - (clockRadius / 12) * Math.cos(2 * i * Math.PI / 12);
      double endY = startY - (clockRadius / 12) * Math.sin(2 * i * Math.PI / 12);
      if (j == 13) { j = 1; }
      double textX = centerX + (clockRadius / 1.25) * Math.cos(2 * i * Math.PI / 12);
      double textY = centerY + (clockRadius / 1.25) * Math.sin(2 * i * Math.PI / 12);
      Text text = new Text(textX, textY, String.valueOf(j));
      getChildren().add(new Line(startX, startY, endX, endY));
      getChildren().add(text);
    }
  }
}
