public class Rectangle {
  public double width;
  public double height;

  public Rectangle() {
    this(1.0, 1.0);
  }

  public Rectangle(double width, double height) {
    this.width = width;
    this.height = height;
  }

  public double getArea() {
    return width * height;
  }

  public double getPerimeter() {
    return 2 * (width + height);
  }

  @Override
  public String toString() {
    return "width: " + width + "\nheight: " + height + "\narea: " +
      getArea() + "\nperimeter: " + getPerimeter();
  }
}
