package cs3500.marblesolitaire.view;

import java.io.IOException;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState;


/**
 * Public class MarbleSolitaireTextView which houses a toString method that
 * presents the visualization of the given model state of the board.
 */
public class MarbleSolitaireTextView implements MarbleSolitaireView {

  private final MarbleSolitaireModelState state;
  protected Appendable destination;

  /**
   * Constructor for the MarbleSolitaireTextView.
   *
   * @param state the given model state of the board
   * @throws IllegalArgumentException if the provided model is null
   */
  public MarbleSolitaireTextView(MarbleSolitaireModelState state) throws IllegalArgumentException {

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
  public MarbleSolitaireTextView(MarbleSolitaireModelState state, Appendable destination) {
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

    // invalid boolean

    // row (column?)
    for (int i = 0; i <= boardSize; i++) {

      // column (row?)
      for (int j = 0; j <= boardSize; j++) {

        if (state.getSlotAt(i, j).equals(SlotState.Empty)) {
          if (j == boardSize
                  || state.getSlotAt(i, j + 1).equals(SlotState.Invalid)) {
            String emptyStringEnd = "_";
            sb.append(emptyStringEnd);
          } else {
            String emptyString = "_ ";
            sb.append(emptyString);
          }
        }

        if (state.getSlotAt(i, j).equals(SlotState.Invalid)) {

          if ((i >= 0
                  && i <= ((boardSize + 3) / 3) - 2
                  && j >= ((boardSize + 3) / 3) * 2 - 1
                  && j <= boardSize)

                  || (i >= ((boardSize + 3) / 3) * 2 - 1
                  && i <= boardSize
                  && j >= ((boardSize + 3) / 3) * 2 - 1
                  && j <= boardSize)) {
            String invalidCornerString = "";
            sb.append(invalidCornerString);
          } else {
            String invalidString = "  ";
            sb.append(invalidString);
          }
        }

        if (state.getSlotAt(i, j).equals(MarbleSolitaireModelState.SlotState.Marble)) {
          if (j == boardSize
                  || state.getSlotAt(i, j + 1).equals(SlotState.Invalid)) {
            String emptyStringEnd = "O";
            sb.append(emptyStringEnd);
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
