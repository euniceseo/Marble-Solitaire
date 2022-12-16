package cs3500.marblesolitaire.view;

import java.io.IOException;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState;

/**
 * Public class MarbleSolitaireTextView which houses a toString method that
 * presents the visualization of the given model state of the board.
 */
public class TriangleSolitaireTextView implements MarbleSolitaireView {

  private final MarbleSolitaireModelState state;
  protected Appendable destination;

  /**
   * Constructor for the MarbleSolitaireTextView.
   *
   * @param state the given model state of the board
   * @throws IllegalArgumentException if the provided model is null
   */
  public TriangleSolitaireTextView(MarbleSolitaireModelState state)
          throws IllegalArgumentException {

    if (state == null) {
      throw new IllegalArgumentException("Provided model is null");
    }

    this.state = state;
    this.destination = System.out;
  }

  /**
   * New constructor, takes in two parameters including an appendable.
   *
   * @param state       marble solitaire model state
   * @param destination appendable object
   */
  public TriangleSolitaireTextView(MarbleSolitaireModelState state, Appendable destination) {
    if (state == null || destination == null) {
      throw new IllegalArgumentException("One of the parameters is null");
    }

    this.state = state;
    this.destination = destination;
  }

  @Override
  public String toString() {

    // to account for 0 indexing
    int boardSize = state.getBoardSize() - 1;

    // should this be an array? how to produce the board length
    StringBuilder sb = new StringBuilder();

    // starting over for the triangular one
    // row (column?)
    for (int i = 0; i <= boardSize; i++) {

      // column (row?)
      for (int j = 0; j < i + 1; j++) {

        if (j == 0) {
          for (int k = boardSize - i; k > 0; k--) {
            String emptySpaceString = " ";
            sb.append(emptySpaceString);
          }
        }

        if (state.getSlotAt(i, j).equals(SlotState.Empty)) {

          if (j == i) {
            String emptyStringEnd = "_";
            sb.append(emptyStringEnd);
          } else {
            String emptyString = "_ ";
            sb.append(emptyString);
          }
        }

        if (state.getSlotAt(i, j).equals(SlotState.Invalid)) {
          String invalidCornerString = "";
          sb.append(invalidCornerString);
        }


        if (state.getSlotAt(i, j).equals(SlotState.Marble)) {

          if (j == i) {
            String marbleStringEnd = "O";
            sb.append(marbleStringEnd);
          } else {
            String marbleString = "O ";
            sb.append(marbleString);
          }
        }
      }

      if (i < boardSize) {
        sb.append("\n");
      }
    }

    return sb.toString();
  }

  @Override
  public void renderBoard() throws IOException {
    try {
      this.destination.append(this.state.toString());
    } catch (IOException e) {
      throw new IllegalStateException("Cannot render the board");
    }
  }

  @Override
  public void renderMessage(String message) throws IOException {
    try {
      this.destination.append(message);
    } catch (IOException e) {
      throw new IllegalStateException("Cannot render message");
    }
  }
}
