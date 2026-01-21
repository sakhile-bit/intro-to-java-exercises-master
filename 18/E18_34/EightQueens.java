public class EightQueens {
  private boolean[][] board;
  private int queensPlaced;

  public EightQueens() {
    board = new boolean[8][8];
    queensPlaced = 0;
    solve();
  }

  private boolean solve() {
    // if we have 8 queens placed successfully, break recursion
    if (queensPlaced == 8) {
      return true;
    } else {
      // iterate through the rows and columns of the board
      for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[i].length; j++) {
          if (isValidMove(i, j, board)) {
            // put a queen on the first valid space
            board[i][j] = true;
            queensPlaced++;
            // then try to solve the next row recursively
            if (solve()) {
              return true;
            } else {
              // if the next row can't be solved, remove the queen from this
              // space and loop to the next valid space in the current row
              board[i][j] = false;
              queensPlaced--;
            }
          }
        }
      }
    }
    return false;
  }

  private boolean isValidMove(int row, int col, boolean[][] board) {
    // check row
    for (int i = 0; i < board[row].length; i++) {
      if (board[row][i]) { return false; }
    }

    // check column
    for (int i = 0; i < board.length; i++) {
      if (board[i][col]) { return false; }
    }

    // check left-rising diagonal
    for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
      if (board[i][j]) { return false; }
    }

    for (int i = row + 1, j = col + 1; i < board.length && j < board[i].length;
      i++, j++) {
      if (board[i][j]) { return false; }
    }

    // check right-rising diagonal
    for (int i = row, j = col; i >= 0 && j < board[i].length; i--, j++) {
      if (board[i][j]) { return false; }
    }

    for (int i = row + 1, j = col - 1; i < board.length && j >= 0; i++, j--) {
      if (board[i][j]) { return false; }
    }

    return true;
  }

  public boolean[][] getBoard() {
    return board;
  }
}
