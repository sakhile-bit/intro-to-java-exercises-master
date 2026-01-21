public class E22_22 {
  public static void main(String[] args) {
    int[][] grid = {
      {2, 0, 0, 0, 7, 0, 0, 0, 4},
      {0, 0, 0, 6, 0, 8, 0, 0, 0},
      {0, 0, 7, 0, 9, 0, 6, 0, 0},
      {0, 6, 0, 0, 0, 0, 0, 3, 0},
      {3, 0, 9, 0, 8, 0, 7, 0, 6},
      {0, 8, 0, 0, 0, 0, 0, 4, 0},
      {0, 0, 8, 0, 6, 0, 1, 0, 0},
      {0, 0, 0, 8, 0, 5, 0, 0, 0},
      {4, 0, 0, 0, 2, 0, 0, 0, 7}
    };

    if (!isValid(grid)) {
      System.out.println("Invalid grid");
    } else if (solve(grid)) {
      System.out.println("Solution:");
      printGrid(grid);
    } else {
      System.out.println("No solution");
    }
  }

  private static boolean solve(int[][] grid) {
    int[][] freeCells = getFreeCells(grid);
    int cell = 0;
    int row = freeCells[cell][0];
    int col = freeCells[cell][1];
    return solve(row, col, cell, grid, freeCells);
  }

  private static boolean solve(
    int row, int col, int cell, int[][] grid, int[][] freeCells) {
    for (int i = 1; i <= 9; i++) { // try each possible value in the free cell
      if (isValid(row, col, grid, i)) {
        grid[row][col] = i; // assign value to cell if it is valid
        cell++; // and increment the cell
        if (cell == freeCells.length) { // base case: no more cells need values
          return true;
        }
        // update row and col for the next cell
        row = freeCells[cell][0];
        col = freeCells[cell][1];
        if (solve(row, col, cell, grid, freeCells)) { // try to solve the cell
          return true;
        } else { // failure: reached 9 without finding a valid value for cell
          cell--; // backtrack and reset
          row = freeCells[cell][0];
          col = freeCells[cell][1];
          grid[row][col] = 0;
        }
      }
    }
    return false;
  }

  private static int[][] getFreeCells(int[][] grid) {
    int numOfFreeCells = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] == 0) { numOfFreeCells++; }
      }
    }

    int[][] freeCells = new int[numOfFreeCells][2];
    int count = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] == 0) {
          freeCells[count][0] = i;
          freeCells[count][1] = j;
          count++;
        }
      }
    }

    return freeCells;
  }

  private static boolean isValid(int i, int j, int[][] grid, int num) {
    for (int col = 0; col < grid[0].length; col++) {
      if (col != j && grid[i][col] == num) { return false; }
    }

    for (int row = 0; row < grid.length; row++) {
      if (row != i && grid[row][j] == num) { return false; }
    }

    for (int row = (i / 3) * 3; row < (i / 3) * 3 + 3; row++) {
      for (int col = (j / 3) * 3; col < (j / 3) * 3 + 3; col++) {
        if (row != i && col != j && grid[row][col] == num) { return false; }
      }
    }

    return true;
  }

  private static boolean isValid(int[][] grid) {
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] < 0 || grid[i][j] > 9 ||
           (grid[i][j] != 0 && !isValid(i, j, grid, grid[i][j]))) {
          return false;
        }
      }
    }
    return true;
  }

  private static void printGrid(int[][] grid) {
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        System.out.print(grid[i][j] + " ");
      }
      System.out.println();
    }
  }
}
