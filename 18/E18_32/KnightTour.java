import java.util.ArrayList;

public class KnightTour {
  private boolean[][] chessboard;
  private ArrayList<Integer[]> path;

  public KnightTour(int size) {
    chessboard = new boolean[size][size];
  }

  public ArrayList<Integer[]> start(int row, int col) {
    chessboard[row][col] = true;
    path = new ArrayList<>();
    path.add(new Integer[]{row, col});
    ArrayList<Integer[]> possibleMoves = getPossibleMoves(row, col);
    solve(possibleMoves);
    return path;
  }

  private boolean solve(ArrayList<Integer[]> possibleMoves) {
    if (!spacesLeft()) {
      // base case: recursion ends when every space on the chessboard has
      // been visited
      return true;
    } else {
      getAndSortNumberOfMoves(possibleMoves); // for Warnsdorf's heuristic
      for (int i = 0; i < possibleMoves.size(); i++) {
        Integer[] move = possibleMoves.get(i);
        int row = move[0];
        int col = move[1];
        if (isValidSpace(row, col)) {
          // set the space as visited and add that space to the path
          chessboard[row][col] = true;
          Integer[] point = {row, col};
          path.add(point);
          // then try to the next move via a recursive call
          if (solve(getPossibleMoves(row, col))) {
            return true;
          } else {
            // if this fails, mark the space not visited and remove it from
            // the path
            chessboard[row][col] = false;
            path.remove(point);
          }
        }
      }
    }
    return false;
  }

  public ArrayList<Integer[]> getPossibleMoves(int row, int col) {
    // Creates a list of int arrays where
    // index 0 = row
    // index 1 = column
    // index 2 = number of valid moves from (row, column) on the chessboard
    //           (0 is placeholder value)
    ArrayList<Integer[]> moves = new ArrayList<>();
    if (isValidSpace(row - 2, col - 1))
      moves.add(new Integer[]{row - 2, col - 1, 0});
    if (isValidSpace(row - 2, col + 1))
      moves.add(new Integer[]{row - 2, col + 1, 0});
    if (isValidSpace(row - 1, col + 2))
      moves.add(new Integer[]{row - 1, col + 2, 0});
    if (isValidSpace(row + 1, col + 2))
      moves.add(new Integer[]{row + 1, col + 2, 0});
    if (isValidSpace(row + 2, col + 1))
      moves.add(new Integer[]{row + 2, col + 1, 0});
    if (isValidSpace(row + 2, col - 1))
      moves.add(new Integer[]{row + 2, col - 1, 0});
    if (isValidSpace(row + 1, col - 2))
      moves.add(new Integer[]{row + 1, col - 2, 0});
    if (isValidSpace(row - 1, col - 2))
      moves.add(new Integer[]{row - 1, col - 2, 0});
    return moves;
  }

  public void getAndSortNumberOfMoves(ArrayList<Integer[]> possibleMoves) {
    // get the number of moves at each space in the list of possible moves
    for (int i = 0; i < possibleMoves.size(); i++) {
      Integer[] space = possibleMoves.get(i);
      space[2] = getNumberOfMovesForSpace(space);
    }
    sortByNumberOfMoves(possibleMoves);
  }

  public void sortByNumberOfMoves(ArrayList<Integer[]> possibleMoves) {
    // bubble sort the list of possible moves by the number of valid moves
    // from each space in the list (the lower the number the better, in
    // accordance with Warnsdorf's heuristic)
    boolean changed;
    do {
      changed = false;
      for (int i = 0; i < possibleMoves.size() - 1; i++) {
        Integer[] a = possibleMoves.get(i);
        Integer[] b = possibleMoves.get(i + 1);
        if (b[2] < a[2]) {
          Integer[] temp = possibleMoves.get(i);
          possibleMoves.set(i, possibleMoves.get(i + 1));
          possibleMoves.set(i + 1, temp);
          changed = true;
        }
      }
    } while (changed);
  }

  private int getNumberOfMovesForSpace(Integer[] space) {
    return getPossibleMoves(space[0], space[1]).size();
  }

  private boolean isValidSpace(int row, int col) {
    if (row < 0 || row >= chessboard.length) { return false; }
    if (col < 0 || col >= chessboard[0].length) { return false; }
    if (chessboard[row][col]) { return false; }
    return true;
  }

  private boolean spacesLeft() {
    for (int i = 0; i < chessboard.length; i++) {
      for (int j = 0; j < chessboard[i].length; j++) {
        if (!chessboard[i][j]) { return true; }
      }
    }
    return false;
  }
}
