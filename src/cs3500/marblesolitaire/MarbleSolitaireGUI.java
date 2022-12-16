package cs3500.marblesolitaire;

import java.io.InputStreamReader;

import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.viewgui.MarbleSolitaireGuiView;
import cs3500.marblesolitaire.viewgui.SwingGuiView;

/**
 * Final method for the Gui version of the command.
 */
public final class MarbleSolitaireGUI {

  /**
   * Main method for the class.
   */
  public static void main(String[] args) {

    String s = "";
    int sRow = 0;
    int sCol = 0;
    int armThickness = 0;
    Readable readable = new InputStreamReader(System.in);

    EnglishSolitaireModel englishModel = new EnglishSolitaireModel(3, 3, 3);
    MarbleSolitaireGuiView englishView = new SwingGuiView(englishModel);
    // MarbleSolitaireControllerImpl englishController = new MarbleSolitaireControllerImpl
    // (englishModel, englishView, readable);
    // englishController.playGame();
  }
}

