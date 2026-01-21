public class LargestBlock {
  private int[][] sourceArray;
  private int[][] blockArray;
  private int startRow;
  private int startCol;
  private int endRow;
  private int endCol;
  private int length;

  public LargestBlock(int[][] sourceArray) {
    this.sourceArray = sourceArray;
    blockArray = findLargestBlock();
    findLargestBlockInfo();
  }

  public int getStartRow() {
    return startRow;
  }

  public int getStartCol() {
    return startCol;
  }

  public int getEndRow() {
    return endRow;
  }

  public int getEndCol() {
    return endCol;
  }

  public int getLength() {
    return length;
  }

  private int[][] findLargestBlock() {
    int[][] ba = new int[sourceArray.length][sourceArray[0].length];
    // copy the first row of data to auxiliary array
    for (int i = 0; i < sourceArray[0].length; i++) {
      ba[0][i] = sourceArray[0][i];
    }
    // copy the first column of data to auxiliary array
    for (int j = 1; j < sourceArray.length; j++) {
      ba[j][0] = sourceArray[j][0];
    }

    // For every cell aside from the top row and leftmost column, if sourceArray
    // contains 1, the value of that cell in the aux array will be the minimum
    // of the cell above it, to the left of it, or up-and-left diagonally,
    // plus 1. If the sourceArray contains 0 in that cell, the cell in the aux
    // array simply remains 0 (its default value). In this way, cells in aux
    // surrounded by increasingly large numbers indicate that they are part of
    // a block of 1s in the sourceArray. The largest number in aux array
    // represents the lower-right corner of a square block, the side length of
    // which is that number.
    for (int i = 1; i < sourceArray.length; i++) {
      for (int j = 1; j < sourceArray[i].length; j++) {
        if (sourceArray[i][j] == 1) {
          ba[i][j] = Math.min(ba[i - 1][j],
            Math.min(ba[i][j - 1], ba[i - 1][j - 1])) + 1;
        }
      }
    }

    return ba;
  }

  private void findLargestBlockInfo() {
    int length = blockArray[0][0];
    int endRow = 0;
    int endCol = 0;
    for (int i = 0; i < blockArray.length; i++) {
      for (int j = 0; j < blockArray[i].length; j++) {
        if (blockArray[i][j] > length) {
          length = blockArray[i][j];
          endRow = i;
          endCol = j;
        }
      }
    }
    this.startRow = (endRow - length) + 1;
    this.startCol = (endCol - length) + 1;
    this.endRow = endRow;
    this.endCol = endCol;
    this.length = length;
  }

  @Override
  public String toString() {
    return "length: " + length + "\n" +
           "startRow: " + startRow + "\n" +
           "startCol: " + startCol + "\n" +
           "endRow: " + endRow + "\n" +
           "endCol: " + endCol;
  }
}
