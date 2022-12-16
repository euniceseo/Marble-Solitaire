package cs3500.marblesolitaire.model.hw02;

import cs3500.marblesolitaire.model.hw04.AbstractMarbleSolitaireModel;

/**
 * Public class EnglishSolitaireModel is an implementaiton of the English Solitiare Model, which
 * produces a board that looks like a T shape. An extensio of the abstract marble solitaire model,
 * with no methods from there being overridden.
 */
public class EnglishSolitaireModel extends AbstractMarbleSolitaireModel {

  private final int armThickness;
  private final int sRow;
  private final int sCol;

  /**
   * Constructor #1. Generates board.
   * Takes no parameters, and initialize the game board as shown
   * above (arm thickness 3 with the empty slot at the center).
   */

  public EnglishSolitaireModel() {
    this.armThickness = 3;
    this.sRow = 3;
    this.sCol = 3;
    this.generateBoard();
  }

  /**
   * Constructor #2. Generates board.
   * Should initialize the game board so arm thickness is 3 and empty slot is at
   * the position (sRow, sCol).
   *
   * @param sRow row at which the empty slot will be
   * @param sCol column at which the empty slot will be
   * @throws IllegalArgumentException with a message "Invalid empty cell position (r,c)" with and
   *                                  replaced with the row and column passed to it.
   */
  public EnglishSolitaireModel(int sRow, int sCol) throws IllegalArgumentException {
    if (sRow < 0 || sCol < 0 || sRow > 6 || sCol > 6) {
      throw new IllegalArgumentException("Invalid position at (" + sRow + ", " + sCol + ")");
    }

    if ((sRow >= 0 && sRow <= 1 && sCol >= 0 && sCol <= 1)
            || (sRow >= 5 && sRow <= 6 && sCol >= 0 && sCol <= 1)
            || (sRow >= 0 && sRow <= 1 && sCol >= 5 && sCol <= 6)
            || (sRow >= 5 && sRow <= 5 && sCol >= 5 && sCol <= 6)) {
      throw new IllegalArgumentException("Invalid position at (" + sRow + ", " + sCol + ")");
    }

    this.armThickness = 3;
    this.sRow = sRow;
    this.sCol = sCol;
    this.generateBoard();
  }

  /**
   * Constructor #3. Generates board.
   * Should only take in armThickness, initialize a game board with the empty slot at the center.
   *
   * @param armThickness thickness of each square on board
   * @throws IllegalArgumentException if the arm thickness is not a positive odd number.
   */
  public EnglishSolitaireModel(int armThickness) throws IllegalArgumentException {
    if (armThickness <= 0 || (armThickness % 2 == 0)) {
      throw new IllegalArgumentException("Arm thickness is not a positive, odd number!");
    }

    this.armThickness = armThickness;
    this.sRow = (armThickness * 3 - 3) / 2;
    this.sCol = (armThickness * 3 - 3) / 2;
    this.generateBoard();
  }

  /**
   * Constructor #4. Generates board.
   * Should take the arm thickness, row and column of the empty slot in that order.
   *
   * @param armThickness thickness of each square on board
   * @param sRow         row at which the empty slot will be
   * @param sCol         column at which the empty slot will be
   * @throws IllegalArgumentException if
   *                                  - The arm thickness is not a positive odd number.
   *                                  - The empty cell position is invalid.
   *                                  - If both are invalid, the first if case will throw the
   *                                  exception
   */
  public EnglishSolitaireModel(int armThickness, int sRow, int sCol)
          throws IllegalArgumentException {

    if (armThickness <= 0 || (armThickness % 2 == 0)) {
      throw new IllegalArgumentException("Arm thickness is not a positive, odd number!");
    }

    if (sRow < 0 && sCol < 0 || sRow > armThickness * 3 - 3 && sCol > armThickness * 3 - 3) {
      throw new IllegalArgumentException("Invalid position at (" + sRow + ", " + sCol + ")");
    }

    if ((sRow >= 0 && sRow <= armThickness - 2 && sCol >= 0 && sCol <= armThickness - 2)
            || (sRow >= armThickness * 2 - 1 && sRow <= armThickness * 3 - 3
            && sCol >= 0 && sCol <= armThickness - 2)
            || (sRow >= 0 && sRow <= armThickness - 2
            && sCol >= armThickness * 2 - 1 && sCol <= armThickness * 3 - 3)
            || (sRow >= armThickness * 2 - 1 && sRow <= armThickness * 3 - 3
            && sCol >= armThickness * 2 - 1 && sCol <= armThickness * 3 - 3)) {
      throw new IllegalArgumentException("Invalid position at (" + sRow + ", " + sCol + ")");
    }

    this.armThickness = armThickness;
    this.sRow = sRow;
    this.sCol = sCol;
    this.generateBoard();
  }

  @Override
  public int getBoardSize() {
    return getBoardSizeHelper(armThickness);
  }

  /**
   * Generates the initial board at the beginning of the game state, assigns a slot state to every
   * possible place on the board through a nested for loop.
   */
  protected void generateBoard() {

    // 0 indexing
    int boardSize = this.getBoardSize() - 1;

    // this creates a new gameboard everytime + will cause bugs?
    this.gameBoard = new SlotState[boardSize + 1][boardSize + 1];

    // row
    for (int i = 0; i <= boardSize; i++) {

      // column
      for (int j = 0; j <= boardSize; j++) {

        gameBoard[i][j] = SlotState.Marble;
        score++;

        // initialize the empty slot in the middle first
        if (sRow == i && sCol == j) {
          gameBoard[i][j] = SlotState.Empty;
          score--;
        }

        // checking top left
        if (i >= 0 && i <= armThickness - 2 && j >= 0 && j <= armThickness - 2) {
          gameBoard[i][j] = SlotState.Invalid;
          score--;
        }

        // checking bottom left
        if (i >= armThickness * 2 - 1 && i <= boardSize && j >= 0 && j <= armThickness - 2) {
          gameBoard[i][j] = SlotState.Invalid;
          score--;
        }

        // checking top right
        if (i >= 0 && i <= armThickness - 2 && j >= armThickness * 2 - 1 && j <= boardSize) {
          gameBoard[i][j] = SlotState.Invalid;
          score--;
        }

        // checking bottom right
        if (i >= armThickness * 2 - 1 && j <= boardSize
                && j >= armThickness * 2 - 1 && j <= boardSize) {
          gameBoard[i][j] = SlotState.Invalid;
          score--;
        }
      }
    }
  }
}
