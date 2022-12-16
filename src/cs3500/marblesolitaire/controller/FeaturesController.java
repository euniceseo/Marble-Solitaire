package cs3500.marblesolitaire.controller;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.viewgui.MarbleSolitaireGuiView;

/**
 * Implementation of the FeaturesController class.
 */
public class FeaturesController implements Features {

  private MarbleSolitaireModelState model;
  private MarbleSolitaireGuiView view;

  public FeaturesController(MarbleSolitaireModelState model, MarbleSolitaireGuiView view) {
    this.model = model;
    this.view = view;
  }

  @Override
  public void playGame(int row, int col) {
    model.getSlotAt(row, col);
    view.refresh();
    // determine if it is the from cell or to cell
    // to: make the move, view refresh
    // game over / invalid move -> view should display a message
  }
}
