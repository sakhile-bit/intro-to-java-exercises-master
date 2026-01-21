import java.util.ArrayList;
import java.util.Arrays;

public class Queens {
  private static final int SIZE = 8;
  private static Integer[] board = {-1, -1, -1, -1, -1, -1, -1, -1};
  private ArrayList<Integer[]> boards;

  public Queens() {
    boards = search();
  }

  public ArrayList<Integer[]> getBoards() {
    return boards;
  }

  private static ArrayList<Integer[]> search() {
    ArrayList<Integer[]> boards = new ArrayList<>();
    int row = 0;

    while (true) {
      // try column 0 at a row that currently has no queen placed
      if (board[row] == -1) { board[row] = 0; }

      // shouldReturn generally shadows its neighboring isValid check, with the
      // exception of when a solution is found, in which case we don't proceed
      // with a return, but rather pretend as though the solution wasn't found
      // and continue backtracking to find more solutions
      boolean shouldReturn = false;

      if (isValid(row, board[row])) {
        shouldReturn = true;
        if (row + 1 == SIZE) {
          // when all 8 rows have correctly placed queens, it's a solution
          boards.add(Arrays.copyOf(board, board.length));
          // pretend solution wasn't found, try to find more
          shouldReturn = false;
        } else {
          row++; // otherwise, move to next row
        }
      }

      // the generic case for an invalid queen placement
      if (!shouldReturn) {
        if (board[row] < SIZE) { // if the column is on the board
          board[row]++; // try the next column
        } else { // column is out of bounds, need to backtrack
          // for as long as each row has an invalid placement
          while (!isValid(row, board[row])) {
            board[row] = -1; // reset to unassigned row value
            row--; // backtrack
            if (row == -1) { // row of -1 signals that all solutions are found
              // because the algorithm has backtracked off the board entirely
              return boards; // so return the solutions
            }
          }
          // otherwise try next column on row we've backtracked to
          board[row]++;
        }
      }
    }
  }

  private static boolean isValid(int row, int col) {
    if (col >= SIZE) { return false; }
    for (int i = 1; i <= row; i++) {
      if (board[row - i] == col ||
          board[row - i] == col - i ||
          board[row - i] == col + i) {
        return false;
      }
    }
    return true;
  }
}
