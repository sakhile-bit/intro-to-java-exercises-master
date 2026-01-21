public class MazeSolver {
  private char[][] maze; // '.' = empty space
                         // 'X' = wall
                         // '@' = path marking

  public MazeSolver(char[][] maze) {
    this.maze = maze;
  }

  public char[][] start() {
    maze[0][0] = '@'; // upper left corner is the starting space
    int[][] possibleMoves = getPossibleMoves(0, 0);
    solve(possibleMoves);
    return maze;
  }

  private boolean solve(int[][] possibleMoves) {
    if (maze[maze.length - 1][maze[0].length - 1] == '@') {
      // base case is the lower-right corner being marked as part of the path
      return true;
    } else {
      for (int i = 0; i < possibleMoves.length; i++) {
        int row = possibleMoves[i][0];
        int col = possibleMoves[i][1];
        if (isValidSpace(row, col)) {
          // mark the valid space as part of the path
          maze[row][col] = '@';
          if (solve(getPossibleMoves(row, col))) {
            // try to solve for the valid moves at the current valid space
            return true;
          } else {
            // reset the spaces from failed path attempts to empty
            // and try the next possible move
            maze[row][col] = '.';
          }
        }
      }
    }
    return false;
  }

  public static char[][] getInitialMatrix(int rows, int cols) {
    // get a blank matrix with no walls or path markings
    char[][] chars = new char[rows][cols];
    for (int i = 0; i < chars.length; i++) {
      for (int j = 0; j < chars[i].length; j++) {
        chars[i][j] = '.';
      }
    }
    return chars;
  }

  private static int[][] getPossibleMoves(int row, int col) {
    // the possible moves are immediately left, right, above, and below
    // the current valid space
    int[][] m = new int[4][2];
    m[0][0] = row + 1;
    m[0][1] = col;
    m[1][0] = row;
    m[1][1] = col + 1;
    m[2][0] = row;
    m[2][1] = col - 1;
    m[3][0] = row - 1;
    m[3][1] = col;
    return m;
  }

  private boolean isValidSpace(int row, int col) {
    // illegal for a space to be out of bounds
    if (row < 0 || row >= maze.length) { return false; }
    if (col < 0 || col >= maze[0].length) { return false; }
    // illegal for a space to have a wall
    if (maze[row][col] == 'X') { return false; }
    // illegal for a space to already be marked as part of the path
    if (maze[row][col] == '@') { return false; }
    // illegal for a space to complete a square of four marked spaces
    if (row > 0 && col < maze[0].length - 1 &&
        maze[row - 1][col] == '@' &&
        maze[row - 1][col + 1] == '@' &&
        maze[row][col + 1] == '@') { return false; }
    if (row > 0 && col > 0 &&
        maze[row - 1][col] == '@' &&
        maze[row - 1][col - 1] == '@' &&
        maze[row][col - 1] == '@') { return false; }
    if (row < maze.length - 1 && col < maze[0].length - 1 &&
        maze[row][col + 1] == '@' &&
        maze[row + 1][col + 1] == '@' &&
        maze[row + 1][col] == '@') { return false ;}
    if (row < maze.length - 1 && col > 0 &&
        maze[row][col - 1] == '@' &&
        maze[row + 1][col - 1] == '@' &&
        maze[row + 1][col] == '@') { return false; }
    return true;
  }
}
