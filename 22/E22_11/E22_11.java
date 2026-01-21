/*
  Section 22.10.2 introduced Graham's algorithm for finding a convex hull for a
  set of points. Assume that Java's coordinate system is used for the points.
  Implement the algorithm using the following method:

  public static ArrayList<MyPoint> getConvexHull(double[][] s)

  (MyPoint inner class template here)
*/

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Comparator;
import java.util.Scanner;

public class E22_11 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("How many points are in the set? ");
    int numOfPoints = input.nextInt();
    System.out.print("Enter " + numOfPoints + " points: ");
    double[][] s = new double[numOfPoints][2];
    for (int i = 0; i < s.length; i++) {
      s[i][0] = input.nextDouble();
      s[i][1] = input.nextDouble();
    }

    List<MyPoint> list = getConvexHull(s);
    System.out.println("The convex hull is");
    for (MyPoint p: list) {
      System.out.print(p + " ");
    }
    System.out.println();
  }

  public static ArrayList<MyPoint> getConvexHull(double[][] s) {
    List<MyPoint> points = new ArrayList<>();
    for (double[] point: s) {
      points.add(new MyPoint(point[0], point[1]));
    }

    // Get the rightmost-lowest point and remove it from the array
    MyPoint rightmostLowest = getRightmostLowestPoint(points);
    points.remove(rightmostLowest);

    // Set the rightmost-lowest point for all remaining points in the array
    for (MyPoint p: points) {
      p.setRightmostLowestPoint(rightmostLowest);
    }

    // Sort the points by their angles
    Collections.sort(points);

    // Remove points marked for deletion
    List<MyPoint> copy = new ArrayList<>(points);
    for (MyPoint p: copy) {
      if (p.deletion == -1) {
        points.remove(p);
      }
    }

    // Add rightmost-lowest point back in at the front
    points.add(0, rightmostLowest);

    // Push definite points onto convexHull
    Stack<MyPoint> convexHull = new Stack<>();
    convexHull.push(points.get(0));
    convexHull.push(points.get(1));

    for (int i = 2; i < points.size(); i++) {
      MyPoint top = convexHull.pop();
      while (!isLeftOfLine(points.get(i), convexHull.peek(), top)) {
        top = convexHull.pop();
      }
      convexHull.push(top);
      convexHull.push(points.get(i));
    }

    return new ArrayList<>(convexHull);
  }

  private static boolean isLeftOfLine(MyPoint p, MyPoint start, MyPoint end) {
    return (p.y - start.y) * (end.x - start.x) <
           (p.x - start.x) * (end.y - start.y);
  }

  private static class MyPoint implements Comparable<MyPoint> {
    double x, y;
    int deletion; // -1: delete, 1: retain
    MyPoint rightmostLowestPoint;

    MyPoint(double x, double y) {
      this.x = x;
      this.y = y;
      deletion = 1;
    }

    public void setRightmostLowestPoint(MyPoint p) {
      rightmostLowestPoint = p;
    }

    public double getAngle() {
      double dy = rightmostLowestPoint.y - y;
      double dx = x - rightmostLowestPoint.x;
      double theta = Math.atan2(dy, dx);
      theta *= 180 / Math.PI;
      return theta;
    }

    public double getDistance() {
      double x2 = rightmostLowestPoint.x;
      double y2 = rightmostLowestPoint.y;
      return Math.sqrt(Math.pow(x2 - x, 2) + Math.pow(y2 - y, 2));
    }

    @Override
    public int compareTo(MyPoint o) {
      if (getAngle() < o.getAngle()) {
        return -1;
      } else if (getAngle() > o.getAngle()) {
        return 1;
      }
      // if two points have the same angle, the one closer to the
      // rightmost-lowest point will be marked for removal from candidacy
      // in the Graham scan
      MyPoint closer = getDistance() < o.getDistance() ? this : o;
      closer.deletion = -1;
      return 0;
    }

    @Override
    public String toString() {
      return "(" + x + ", " + y + ")";
    }
  }

  private static MyPoint getRightmostLowestPoint(List<MyPoint> points) {
    points.sort(new Comparator<MyPoint>() {
      @Override
      public int compare(MyPoint o1, MyPoint o2) {
        if (o1.y > o2.y) {
          return -1;
        } else if (o1.y < o2.y) {
          return 1;
        } else {
          if (o1.x > o2.x) {
            return -1;
          } else if (o1.x < o2.x) {
            return 1;
          }
        }
        return 0;
      }
    });
    return points.get(0);
  }
}
