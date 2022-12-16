package cs3500.marblesolitaire.model.hw04;

/**
 * Public class TriangleSolitaireModel is an implementaiton of the Triangle Solitiare Model, which
 * produces a triangular board with an empty hole.
 * An extension of the abstract marble solitaire model, overrides isValidmove and isGameOver
 * due to intrinsic differences in the code and twoDistanceChecker
 */

public class TriangleSolitaireModel extends AbstractMarbleSolitaireModel {

  // number of rows in this case
  private final int armThickness;
  private final int sRow;
  private final int sCol;

  /**
   * Constructor #1. Generates board.
   * Takes no parameters, and initialize the game board as shown
   * above (arm thickness 3 with the empty slot at the center).
   */

  public TriangleSolitaireModel() {
    this.armThickness = 5;
    this.sRow = 0;
    this.sCol = 0;
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

  public TriangleSolitaireModel(int sRow, int sCol) throws IllegalArgumentException {

    if (sRow < 0 || sCol < 0 || sRow > 4 || sCol > 4 || sCol > sRow) {
      throw new IllegalArgumentException("Invalid position at (" + sRow + ", " + sCol + ")");
    }

    this.armThickness = 5;
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

  public TriangleSolitaireModel(int armThickness) throws IllegalArgumentException {
    if (armThickness < 0) {
      throw new IllegalArgumentException("Arm thickness cannot be negative");
    }

    this.armThickness = armThickness;
    this.sRow = 0;
    this.sCol = 0;
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

  public TriangleSolitaireModel(int armThickness, int sRow, int sCol)
          throws IllegalArgumentException {

    if (armThickness < 0) {
      throw new IllegalArgumentException("Arm thickness cannot be negative");
    }

    if (sRow < 0 || sCol < 0 || sRow >= armThickness || sCol >= armThickness || sCol > sRow) {
      throw new IllegalArgumentException("Invalid position at (" + sRow + ", " + sCol + ")");
    }

    this.armThickness = armThickness;
    this.sRow = sRow;
    this.sCol = sCol;
    this.generateBoard();
  }

  @Override
  protected boolean twoDistanceChecker(int fromRow, int fromCol, int toRow, int toCol) {
    return ((Math.abs(fromRow - toRow) == 2 && Math.abs(fromCol - toCol) == 2)
            || (Math.abs(fromRow - toRow) == 2 && fromCol == toCol)
            || (Math.abs(fromCol - toCol) == 2 && fromRow == toRow));
  }

  @Override
  public int getBoardSize() {
    return armThickness;
  }

  /**
   * Generates the initial board at the beginning of the game state, assigns a slot state to every
   * possible place on the board through a nested for loop.
   */

  protected void generateBoard() {

    int boardSize = this.getBoardSize() - 1;
    this.gameBoard = new SlotState[boardSize + 1][boardSize + 1];

    // row
    for (int i = 0; i <= boardSize; i++) {

      for (int j = 0; j <= boardSize; j++) {

        gameBoard[i][j] = SlotState.Invalid;

        if (j <= i) {
          gameBoard[i][j] = SlotState.Marble;
          score++;
        }
        if (sRow == i && sCol == j) {
          gameBoard[i][j] = SlotState.Empty;
          score--;
        }
      }
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

        if (j >= 2 && this.isValidMove(i, j, i, j - 2)) {
          return false;
        }

        if (j + 2 <= boardSize && this.isValidMove(i, j, i, j + 2)) {
          return false;
        }

        if (j + 2 <= boardSize && i + 2 <= boardSize
                && this.isValidMove(i, j, i + 2, j + 2)) {
          return false;
        }

        if (j >= 2 && i >= 2
                && this.isValidMove(i, j, i - 2, j - 2)) {
          return false;
        }
      }
    }
    return true;
  }
}

