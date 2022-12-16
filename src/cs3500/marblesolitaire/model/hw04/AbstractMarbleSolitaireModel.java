package cs3500.marblesolitaire.model.hw04;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

/**
 * This abstract class is implemented by the triangle, english, and european models. It
 * has the fields of gameBoard and score, and has the methods isValidMove, a twoDistanceChecker
 * that is used in the isValidMove method, move, gameOver, getSlotAt, and getScore, alongside a
 * getScoreHelper method used in the getScore method.
 */
public abstract class AbstractMarbleSolitaireModel implements MarbleSolitaireModel {

  protected SlotState[][] gameBoard;
  protected int score;

  /**
   * Returns a boolean that answers if the given coordinates render a valid move.
   *
   * @param fromRow row number of the from slot
   * @param fromCol column number of the from slot
   * @param toRow   row number of the to slot
   * @param toCol   column number of the to slot
   * @return boolean is the move valid or not? The move is not valid if the from slot is not a
   *          marble, the to slot is not empty, the distance between the two marbles is not
   *          equal to 2, or the middle row is not a marble
   */
  protected boolean isValidMove(int fromRow, int fromCol, int toRow, int toCol) {

    SlotState from = gameBoard[fromRow][fromCol];
    SlotState to = gameBoard[toRow][toCol];

    // checks if move is from a marble slot to an empty slot. would also check out of bound moves
    if (from.equals(SlotState.Marble) && (to.equals(SlotState.Empty))) {

      // checks if the move is 2 slots/ints away
      if (twoDistanceChecker(fromRow, fromCol, toRow, toCol)) {

        // math to make the middleRows more accessible
        int middleRow = (fromRow + toRow) / 2;
        int middleCol = (toCol + fromCol) / 2;
        SlotState middle = gameBoard[middleRow][middleCol];

        // checks if the middle of the given from & to is a marble
        if (middle.equals(SlotState.Marble)) {

          // if all are true you return true
          return true;
        }
      }
    }
    return false;
  }

  /**
   * Checks if the given fromRow, fromCol, toRow, and toCol are two away from each other with the
   * same column or row. Overridden in the triangle class as that one is allowed to make diagonal
   * moves.
   */
  protected boolean twoDistanceChecker(int fromRow, int fromCol, int toRow, int toCol) {
    return (Math.abs(fromRow - toRow) == 2 && fromCol == toCol
            || Math.abs(fromCol - toCol) == 2 && fromRow == toRow);
  }


  /**
   * Makes a move if all the conditions in the isValidMove are met, including if the from slot
   * is not a marble, the to slot is not empty, the distance between the two marbles is not equal
   * to 2, or the middle row is not a marble (all of these would render invalid moves).
   *
   * @param fromRow the row number of the position to be moved from
   *                (starts at 0)
   * @param fromCol the column number of the position to be moved from
   *                (starts at 0)
   * @param toRow   the row number of the position to be moved to
   *                (starts at 0)
   * @param toCol   the column number of the position to be moved to
   *                (starts at 0)
   * @throws IllegalArgumentException if move is invalid.
   */

  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    int boardSize = this.getBoardSize() - 1;

    if (fromRow < 0 || fromCol < 0 || toRow < 0 || toCol < 0 || fromRow > boardSize
            || fromCol > boardSize || toRow > boardSize || toCol > boardSize) {
      throw new IllegalArgumentException("Invalid position to move to");
    }

    if (this.isValidMove(fromRow, fromCol, toRow, toCol)) {

      // math to make middle more accessible
      int middleRow = (fromRow + toRow) / 2;
      int middleCol = (fromCol + toCol) / 2;

      // changes the states of the marbles and moves accordingly
      gameBoard[fromRow][fromCol] = SlotState.Empty;
      gameBoard[toRow][toCol] = SlotState.Marble;
      gameBoard[middleRow][middleCol] = SlotState.Empty;

      score--;

    } else {
      throw new IllegalArgumentException("Invalid move");
    }
  }

  @Override
  public boolean isGameOver() {
    int boardSize = this.getBoardSize() - 1;

    for (int i = 0; i <= boardSize; i++) {
      for (int j = 0; j <= boardSize; j++) {

        if (i >= 2 && this.isValidMove(i, j, i - 2, j)) {
          return false;
        }

        if (i + 2 <= boardSize && this.isValidMove(i, j, i + 2, j)) {
          return false;
        }

        // change back to 1?
        if (j >= 2 && this.isValidMove(i, j, i, j - 2)) {
          return false;
        }

        if (j + 2 <= boardSize && this.isValidMove(i, j, i, j + 2)) {
          return false;
        }
      }
    }
    return true;
  }

  @Override
  public SlotState getSlotAt(int row, int col) throws IllegalArgumentException {
    if (gameBoard[row][col].equals(SlotState.Empty)) {
      return SlotState.Empty;
    }
    if (gameBoard[row][col].equals(SlotState.Invalid)) {
      return SlotState.Invalid;
    } else {
      return SlotState.Marble;
    }
  }

  @Override
  public int getScore() {
    return score;
  }

  /**
   * Helper method for the getScore method.
   * @param i where each model will feed in its armThickness
   * @return the boardSize
   */
  protected int getBoardSizeHelper(int i) {
    return i * 3 - 2;
  }
}
