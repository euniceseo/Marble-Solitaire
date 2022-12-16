package cs3500.marblesolitaire.controller;

/**
 * Interface MarbleSolitareController. Represents the controller for the game, has one
 * method called playGame that lets you play the game. Implementations of this game
 * have a playGame that plays the game and throws the correct exceptions if any input
 * is invalid, or an output cannot be transmitted to the console.
 */
public interface MarbleSolitaireController {

  /**
   * Plays a new game of MarbleSolitaire.
   * @throws IllegalStateException when controller unable to successfully read input/transmit output
   */
  public void playGame() throws IllegalStateException;
}
