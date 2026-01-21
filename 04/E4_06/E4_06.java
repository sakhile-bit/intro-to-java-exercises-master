/*
  Write a program that generates three random points on a circle centered at
  (0, 0) with radius 40 and display three angles in a triangle formed by these
  three points.

  Note: This is kind of a hacky solution. I was getting values outside the
  [-1, 1] range for use with Math.acos, and some angles were returning NaN as a
  result. So I added a do-while loop to make the program keep trying until
  no angles return as NaN and the triangle is valid (the sum of any two angles
  is larger than the remaining angle). I also fudged the floating-point math
  a bit so angles would add up to exactly 180.
*/

import java.util.Random;

public class E4_06 {
  public static void main(String[] args) {
    Random r = new Random();
    
    double A, B, C;
    do {
      Point a = getPointOnCircle(40, getRandomAngle(r));
      Point b = getPointOnCircle(40, getRandomAngle(r));
      Point c = getPointOnCircle(40, getRandomAngle(r));

      double ab = distance(a, b);
      double bc = distance(b, c);
      double ca = distance(c, a);

      double cosA = ((ca * ca) + (ab * ab) - (bc * bc)) / (2 * bc * ab);
      double cosB = ((ab * ab) + (bc * bc) - (ca * ca)) / (2 * ab * bc);
      double cosC = ((bc * bc) + (ca * ca) - (ab * ab)) / (2 * bc * ca);
      A = (Math.acos(cosA) * (180 / Math.PI));
      B = (Math.acos(cosB) * (180 / Math.PI));

      A = Double.parseDouble(String.format("%.2f", A));
      B = Double.parseDouble(String.format("%.2f", B));
      C = 180 - A - B;
    } while ((Double.isNaN(A) || Double.isNaN(B) || Double.isNaN(C)) ||
              !triangleIsValid(A, B, C));

    System.out.printf("Angles are: %.2f %.2f %.2f\n", A, B, C);
  }

  private static double getRandomAngle(Random r) {
    return Math.toRadians(r.nextDouble() * 360);
  }

  private static Point getPointOnCircle(double radius, double angle) {
    return new Point(radius * Math.cos(angle), radius * Math.sin(angle));
  }

  private static double distance(Point a, Point b) {
    double x1 = a.getX();
    double y1 = a.getY();
    double x2 = b.getX();
    double y2 = b.getY();
    return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
  }

  private static boolean triangleIsValid(double a, double b, double c) {
    return (a + b > c) && (b + c > a) && (c + a > b);
  }

  private static class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
      this.x = x;
      this.y = y;
    }

    public double getX() {
      return x;
    }

    public double getY() {
      return y;
    }

    public String toString() {
      return String.format("(%f, %f)", x, y);
    }
  }
}
