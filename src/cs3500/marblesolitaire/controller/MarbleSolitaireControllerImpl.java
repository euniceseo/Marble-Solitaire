package cs3500.marblesolitaire.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

/**
 * This class is a controller for the Marble Solitaire Game. It has field of an input readable,
 * and also takes in a model and a view. The class has a playGame method that is used to play
 * the game, and the appropriate response for each action is returned to the console, or the out.
 */
public class MarbleSolitaireControllerImpl implements MarbleSolitaireController {

  private Readable in;

  private final MarbleSolitaireModel model;
  private final MarbleSolitaireView view;

  /**
   * Constructor for the controller class.
   *
   * @param model model of the game
   * @param view  current view of the given game
   * @param in    the input the user puts in
   * @throws IllegalArgumentException if any of the givens are null
   */
  public MarbleSolitaireControllerImpl(MarbleSolitaireModel model, MarbleSolitaireView view,
                                       Readable in) throws IllegalArgumentException {
    if (model == null || view == null || in == null) {
      throw new IllegalArgumentException("One of the given inputs is null");
    }

    this.in = in;
    this.model = model;
    this.view = view;

  }

  @Override
  public void playGame() throws IllegalStateException {

    ArrayList<Integer> inputs = new ArrayList<>();
    boolean quit = false;
    int tryInt;

    Scanner scan = new Scanner(this.in);

    this.transmit(view.toString() + "\n" + "Score: " + model.getScore() + "\n");

    while (!model.isGameOver() && !quit) {

      if (scan.hasNext()) {
        String s = scan.next();
        if (checkForQ(s)) {
          this.transmit("Game quit!\n" + "State of game when quit:\n" + view.toString()
                  + "\n" + "Score: " + model.getScore());
          break;
        }

        if (canBeInt(s)) {
          tryInt = Integer.parseInt(s);
          inputs.add(tryInt);
        }

        if (!canBeInt(s)) {
          this.transmit("Not a positive integer. Enter a new value" + "\n");
          continue;
        }

        if (inputs.size() % 4 == 0) {
          int fromCol = inputs.get(0);
          inputs.remove(0);
          int fromRow = inputs.get(0);
          inputs.remove(0);
          int toCol = inputs.get(0);
          inputs.remove(0);
          int toRow = inputs.get(0);
          inputs.remove(0);

          try {
            this.model.move(fromCol - 1, fromRow - 1, toCol - 1, toRow - 1);
            this.transmit(view.toString() + "\n" + "Score: " + model.getScore() + "\n");
          } catch (IllegalArgumentException a) {
            this.transmit("Invalid move. " + "Play again. :)" + "\n");
          }
        }
      }

      if (model.isGameOver()) {
        this.transmit("Game over!\n" + view.toString() + "\n" + "Score: " + model.getScore());
        quit = true;
      }

      if (!scan.hasNext() && !quit && !model.isGameOver()) {
        throw new IllegalStateException("Readable out of inputs");
      }
    }
  }

  private boolean checkForQ(String s) {
    return (s.equals("Q") || s.equals("q"));
  }

  private boolean canBeInt(String s) throws IllegalStateException {
    int tryInt;

    try {
      tryInt = Integer.parseInt(s);
      if (tryInt > 0) {
        return true;
      } else {

        this.transmit("Negative value" + "\n");
      }
    } catch (NumberFormatException i) {
      this.transmit("");
    }
    return false;
  }

  private void transmit(String message) throws IllegalStateException {
    try {
      this.view.renderMessage(message);
    } catch (IOException e) {
      throw new IllegalStateException("Cannot transmit output");
    }
  }
}