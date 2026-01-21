/*
  Section 22.10.1 introduced the gift-wrapping algorithm for finding a convex
  hull for a set of points. Assume that Java's coordinate system is used for
  the points. Implement the algorithm using the following method:

  public static ArrayList<Point2D> getConvexHull(double[][] s)

  Write a test program that prompts the user to enter the set size and the
  points and displays the points that for a convex hull.
*/

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Arrays;
import java.util.Scanner;
import javafx.geometry.Point2D;

public class E22_09 {
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

    List<Point2D> list = getConvexHull(s);
    System.out.println("The convex hull is");
    for (Point2D p: list) {
      System.out.print("(" + p.getX() + ", " + p.getY() + ") ");
    }
    System.out.println();
  }

  public static ArrayList<Point2D> getConvexHull(double[][] s) {
    List<Point2D> points = new ArrayList<>();
    for (double[] point: s) {
      points.add(new Point2D(point[0], point[1]));
    }

    sortByRightmostLowest(points); // first point will be rightmost lowest

    List<Point2D> convexHull = new ArrayList<>();
    Point2D startingPoint = points.get(0);
    convexHull.add(startingPoint);

    Point2D rayStart = startingPoint;
    Point2D rayEnd = points.get(1); // 2nd point is arbitrary choice

    // note: startingPoint remains in points so it can be a valid candidate
    // for rayEnd, triggering the completion of convexHull.

    while (true) {
      // select the rightmost point relative to line through t0 and t1
      for (Point2D p: points) {
        if (isRightOfLine(p, rayStart, rayEnd)) {
          rayEnd = p;
        }
      }
      // this will be true when rayEnd eventually equals startingPoint
      if (convexHull.contains(rayEnd)) { break; }
      // otherwise add our next point to convexHull and remove it from
      // candidacy in the list of points
      convexHull.add(rayEnd);
      points.remove(rayEnd);
      // our next ray will start with the previous rayEnd, and the next rayEnd
      // is the last element in points, arbitrarily
      rayStart = convexHull.get(convexHull.size() - 1);
      rayEnd = points.get(points.size() - 1);
    }

    return (ArrayList<Point2D>)convexHull;
  }

  private static boolean isRightOfLine(Point2D p, Point2D start, Point2D end) {
    return (p.getY() - start.getY()) * (end.getX() - start.getX()) >
           (p.getX() - start.getX()) * (end.getY() - start.getY());
  }

  private static void sortByRightmostLowest(List<Point2D> points) {
    points.sort(new Comparator<Point2D>() {
      @Override
      public int compare(Point2D o1, Point2D o2) {
        if (o1.getY() > o2.getY()) {
          return -1;
        } else if (o1.getY() < o2.getY()) {
          return 1;
        } else {
          if (o1.getX() > o2.getX()) {
            return -1;
          } else if (o1.getX() < o2.getX()) {
            return 1;
          }
        }
        return 0;
      }
    });
  }
}
