/*
  Connect four is a two-player board game in which the players alternately drop
  colored disks into a seven-column, six-row vertically suspended grid.

  The objective of the game is to connect four same-colored disks in a row, a
  column, or a diagonal before your opponent can do likewise. The program
  prompts two players to drop a red or yellow disk alternately. Whenever a disk
  is dropped, the program redisplays the board on the console and determines
  the status of the game (win, draw, or continue).
*/

import java.util.Scanner;

public class E8_20 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    startGame(input);
  }

  public static int startGame(Scanner input) {
    int[][] board = getNewBoard();
    int gameStatus; // 1 = winner, 0 = continue, -1 = tie
    boolean redTurn = true;

    do {
      gameStatus = 0;
      String token = redTurn ? "red" : "yellow";
      int col;

      displayBoard(board);

      do {
        System.out.print("Drop a " + token + " disk at column (0-6): ");
        col = input.nextInt();
      } while (col < 0 || col > 6 || isFull(col, board));

      dropDisk(col, board, redTurn ? 1 : 0);

      if (isConsecutiveFour(redTurn ? 1 : 0, board)) {
        displayBoard(board);
        System.out.println("The " + token + " player won");
        gameStatus = 1;
      } else if (isDrawGame(board)) {
        displayBoard(board);
        System.out.println("Draw game");
        gameStatus = -1;
      } else {
        redTurn = !redTurn;
      }

    } while (gameStatus == 0);

    return gameStatus;
  }

  public static boolean isDrawGame(int[][] board) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (board[i][j] == -1) { return false; }
      }
    }
    return true;
  }

  public static void dropDisk(int col, int[][] board, int player) {
    for (int i = col, j = board.length - 1; j >= 0; j--) {
      if (board[j][i] == -1) {
        if (player == 1) { board[j][i] = 1; break; }
        if (player == 0) { board[j][i] = 0; break; }
      }
    }
  }

  public static boolean isFull(int col, int[][] board) {
    for (int i = 0; i < board[0].length; i++) {
      for (int j = 0; j < board.length; j++) {
        if (board[j][i] == -1) { return false; }
      }
    }
    return true;
  }

  public static int[][] getNewBoard() {
    int[][] board = new int[6][7];
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        board[i][j] = -1;
      }
    }
    return board;
  }

  public static void displayBoard(int[][] board) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (board[i][j] == 1) { System.out.print("|R"); }
        else if (board[i][j] == 0) { System.out.print("|Y"); }
        else { System.out.print("| "); }
      }
      System.out.println("|");
    }
    System.out.println("---------------");
  }

  public static boolean isConsecutiveFour(int player, int[][] board) {
    int count;

    // check rows
    for (int i = 0; i < board.length; i++) {
      count = 0;
      for (int j = 1; j < board[i].length; j++) {
        if (board[i][j] != player) { count = 0; }
        else { count++; }
        if (count == 4) { return true; }
      }
    }

    // check columns
    for (int i = 0; i < board[0].length; i++) {
      count = 0;
      for (int j = 1; j < board.length; j++) {
        if (board[j][i] != player) { count = 0; }
        else { count++; }
        if (count == 4) { return true; }
      }
    }

    // check left-rising diagonals
    for (int i = 0; i < board.length; i++) {
      count = 0;
      for (int j = i + 1, k = 1; j < board.length && k < board[j].length;
        j++, k++) {
          if (board[j][k] != player) { count = 0; }
          else { count++; }
          if (count == 4) { return true; }
      }
    }

    for (int i = 1; i < board[0].length; i++) {
      count = 0;
      for (int j = 1, k = i + 1; j < board.length && k < board[j].length;
        j++, k++) {
          if (board[j][k] != player) { count = 0; }
          else { count++; }
          if (count == 4) { return true; }
      }
    }

    // check right-rising diagonals
    for (int i = 0; i < board.length; i++) {
      count = 0;
      for (int j = i + 1, k = board[i].length - 2; j < board.length &&
        k >= 0; j++, k--) {
          if (board[j][k] != player) { count = 0; }
          else { count++; }
          if (count == 4) { return true; }
      }
    }

    for (int i = board[0].length - 2; i >= 0; i--) {
      count = 0;
      for (int j = 1, k = i - 1; j < board.length && k >= 0; j++, k--) {
        if (board[j][k] != player) { count = 0; }
        else { count++; }
        if (count == 4) { return true; }
      }
    }

    return false;
  }
}
