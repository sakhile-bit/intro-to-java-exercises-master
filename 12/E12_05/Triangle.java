public class Triangle extends GeometricObject {
  // fields
  private double side1, side2, side3;

  // constructors
  public Triangle(double side1, double side2, double side3)
    throws IllegalTriangleException {
    if (side1 + side2 <= side3 ||
        side2 + side3 <= side1 ||
        side3 + side1 <= side2) {
      throw new IllegalTriangleException("The sum of any two sides must be " +
        "greater than the remaining side");
    }
    this.side1 = side1;
    this.side2 = side2;
    this.side3 = side3;
  }

  // instance methods
  public double getArea() {
    double s = (side1 + side2 + side3) / 2.0;
    return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
  }

  public double getPerimeter() {
    return side1 + side2 + side3;
  }

  // getters
  public double getSide1() {
    return side1;
  }

  public double getSide2() {
    return side2;
  }

  public double getSide3() {
    return side3;
  }

  // overrides
  @Override
  public String toString() {
    return "Triangle: side1 = " + side1 + " side2 = " + side2 +
      " side3 = " + side3;
  }
}
