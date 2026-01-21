import java.util.ArrayList;
import javafx.geometry.Point2D;

public class SelfAvoidingWalk {
  private int size;
  private boolean[][] grid;
  private int cRow; // current row on grid
  private int cCol; // current column on grid
  private ArrayList<Point2D> path;

  public SelfAvoidingWalk(int size) {
    this.size = size;
    setGrid();
  }

  public int walk() {
    setGrid(); // reset the grid in case it has already been walked before
    grid[cRow][cCol] = true;
    path.add(new Point2D(cCol, cRow));

    while (isDoneWalking() == 0) {
      ArrayList<Integer> directions = getValidDirections();
      int r = (int)(Math.random() * directions.size());
      int ranDir = directions.get(r);
      if (ranDir == 0) { cRow--; }
      else if (ranDir == 1) { cCol++; }
      else if (ranDir == 2) { cRow++; }
      else if (ranDir == 3) { cCol--; }
      grid[cRow][cCol] = true;
      path.add(new Point2D(cCol, cRow));
    }

    // -1 for dead-end path, 1 for non-dead-end path
    return isDoneWalking();
  }

  private void setGrid() {
    grid = generateGrid(size);
    cRow = (int)Math.floor(size / 2);
    cCol = (int)Math.floor(size / 2);
    path = new ArrayList<>();
  }

  private int isDoneWalking() {
    if (cRow == 0 || cRow == grid.length - 1 ||
        cCol == 0 || cCol == grid[0].length - 1) {
      // fix the off-by-one error when drawing right-side or bottom-side
      // exiting walks in JavaFX, by adding the final point to the path array
      if (cRow == grid.length - 1) { path.add(new Point2D(cCol, cRow + 1)); }
      if (cCol == grid[0].length - 1) { path.add(new Point2D(cCol + 1, cRow)); }

      // denotes non-dead-end path
      return 1;
    }

    if (grid[cRow - 1][cCol] && grid[cRow + 1][cCol] &&
        grid[cRow][cCol - 1] && grid[cRow][cCol + 1]) {
      // denotes dead-end path
      return -1;
    }

    // not done walking
    return 0;
  }

  private ArrayList<Integer> getValidDirections() {
    ArrayList<Integer> directions = new ArrayList<>();
    if (!grid[cRow - 1][cCol]) { directions.add(0); } // North
    if (!grid[cRow][cCol + 1]) { directions.add(1); } // East
    if (!grid[cRow + 1][cCol]) { directions.add(2); } // South
    if (!grid[cRow][cCol - 1]) { directions.add(3); } // West
    return directions;
  }

  public boolean[][] getGrid() {
    return grid;
  }

  public ArrayList<Point2D> getPath() {
    return path;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < grid.length; i++) {
      sb.append(String.format("%2d", i) + "{ ");
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j]) { sb.append("* "); }
        else { sb.append(". "); }
      }
      sb.append("}\n");
    }
    return sb.toString();
  }

  // Creates a "blank" (all false) boolean grid
  private static boolean[][] generateGrid(int n) {
    return new boolean[n][n];
  }
}
