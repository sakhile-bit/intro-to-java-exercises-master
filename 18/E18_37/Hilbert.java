/*
  The following code is based on Andrew Cumming's pseudocode solution for
  generating the points of a Hilbert curve for a given order. This
  information proved invaluable for handling the point transformations, which
  had been my biggest source of difficulty when coming up with a solution,
  since I'm no linear algebra expert.

  http://www.soc.napier.ac.uk/~andrew/hilbert.html

  The purpose of this class is essentially just to generate the points for the
  graphical layer to consume and display to the user.
*/

import java.util.ArrayList;

public class Hilbert {
  private double startX;
  private double startY;
  private int order;
  private ArrayList<Double> points;

  public Hilbert(double startX, double startY, int order) {
    this.startX = startX;
    this.startY = startY;
    this.order = order;
    points = new ArrayList<>();
  }

  public void generate() {
    generate(startX, startY, startX, 0, 0, startY, order);
  }

  /*
    x0 = Hilbert order 0's X
    y0 = Hilbert order 0's Y
    xi = x0's vector X
    xj = x0's vector Y
    yi = y0's vector X
    yj = y0's vector Y
    order = the desired order of the Hilbert curve
  */
  private void generate(double x0, double y0, double xi, double xj, double yi,
    double yj, int order) {
    if (order <= 0) {
      double x = x0 + (xi + yi) / 2;
      double y = y0 + (xj + yj) / 2;
      points.add(x);
      points.add(y);
    } else {
      generate(x0, y0, yi / 2, yj / 2, xi / 2, xj / 2, order - 1);
      generate(x0 + xi / 2, y0 + xj / 2, xi / 2, xj / 2, yi / 2,
        yj / 2, order - 1);
      generate(x0 + xi / 2 + yi / 2, y0 + xj / 2 + yj / 2, xi / 2, xj / 2,
        yi / 2, yj / 2, order - 1);
      generate(x0 + xi / 2 + yi, y0 + xj / 2 + yj, -yi / 2, -yj / 2, -xi / 2,
        -xj / 2, order - 1);
    }
  }

  public ArrayList<Double> getPoints() {
    return points;
  }
}
