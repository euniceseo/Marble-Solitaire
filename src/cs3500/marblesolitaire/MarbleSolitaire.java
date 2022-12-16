package cs3500.marblesolitaire;

import java.io.InputStreamReader;

import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;
import cs3500.marblesolitaire.view.TriangleSolitaireTextView;

/**
 * This MarbleSolitaire class has a main method that basically is how you play the game. The method
 * is final, and houses just that one method. It is not in any package.
 */
public final class MarbleSolitaire {

  /**
   * This program is essentially how you run the game. It takes in a String[], which is
   * the input, and parses through them and accounts for the different types it could be. It
   * accounts for the types, the '-size' argument, and the '-hole' argument
   */
  public static void main(String[] args) {

    String s = "";
    int sRow = 0;
    int sCol = 0;
    int armThickness = 0;
    Readable readable = new InputStreamReader(System.in);
    Appendable appendable = System.out;

    if (args[0].equalsIgnoreCase("english")) {
      s = args[0];
      armThickness = 3;
      sRow = (armThickness * 3 - 3) / 2;
      sCol = (armThickness * 3 - 3) / 2;
      armThickness = 3;
    }

    if (args[0].equalsIgnoreCase("european")) {
      s = args[0];
      armThickness = 3;
      sRow = (armThickness * 3 - 3) / 2;
      sCol = (armThickness * 3 - 3) / 2;
    }

    if (args[0].equalsIgnoreCase("triangular")) {
      s = args[0];
      armThickness = 5;
      sRow = 0;
      sCol = 0;
    }

    if (args.length >= 2) {

      if (args[1].equals("-size")) {
        armThickness = Integer.parseInt(args[2]);
        sRow = (armThickness * 3 - 3) / 2;
        sCol = (armThickness * 3 - 3) / 2;
      }

      if (args[1].equals("-hole")) {
        sRow = Integer.parseInt(args[2]) - 1;
        sCol = Integer.parseInt(args[3]) - 1;
      }
    }

    if (args.length >= 5) {

      if (args[4].equals("-size")) {
        armThickness = Integer.parseInt(args[5]);
      }

      if (args[3].equals("-hole")) {
        sRow = Integer.parseInt(args[4]) - 1;
        sCol = Integer.parseInt(args[5]) - 1;
      }
    }

    switch (s) {
      case "english":
        EnglishSolitaireModel englishModel = new EnglishSolitaireModel(armThickness, sRow, sCol);
        MarbleSolitaireView englishView = new MarbleSolitaireTextView(englishModel, appendable);
        MarbleSolitaireControllerImpl englishController =
                new MarbleSolitaireControllerImpl(englishModel, englishView, readable);
        englishController.playGame();
        break;

      case "european":
        EuropeanSolitaireModel europeanModel = new EuropeanSolitaireModel(armThickness, sRow, sCol);
        MarbleSolitaireView europeanView = new MarbleSolitaireTextView(europeanModel, appendable);
        MarbleSolitaireControllerImpl europeanController =
                new MarbleSolitaireControllerImpl(europeanModel, europeanView, readable);
        europeanController.playGame();
        break;

      case "triangular":
        TriangleSolitaireModel triangularModel =
                new TriangleSolitaireModel(armThickness, sRow, sCol);
        MarbleSolitaireView triangularView =
                new TriangleSolitaireTextView(triangularModel, appendable);
        MarbleSolitaireControllerImpl triangularController =
                new MarbleSolitaireControllerImpl(triangularModel, triangularView, readable);
        triangularController.playGame();
        break;

      default:
        break;
    }
  }
}