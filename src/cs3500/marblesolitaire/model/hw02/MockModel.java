package cs3500.marblesolitaire.model.hw02;

/**
 * A mock model of one of the marble solitaire models, used for testing
 * if the model is accepting inputs and putting to controller correctly.
 */
public class MockModel implements MarbleSolitaireModel {
  
  private StringBuilder log;
  
  public MockModel(StringBuilder log) {
    this.log = log;
  }

  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    log.append("move() (" + fromRow + ", " + fromCol + ", " + toRow + ", " + toCol + ")");
  }

  @Override
  public boolean isGameOver() {
    return false;
  }

  @Override
  public int getBoardSize() {
    return 0;
  }

  @Override
  public SlotState getSlotAt(int row, int col) throws IllegalArgumentException {
    log.append("getSlotAt() " + row + ", " + col);
    return null;
  }

  @Override
  public int getScore() {
    return 0;
  }
}
