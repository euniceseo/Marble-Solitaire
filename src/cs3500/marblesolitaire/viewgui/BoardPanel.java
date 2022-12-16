package cs3500.marblesolitaire.viewgui;

import java.io.FileInputStream;
import java.awt.Image;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.io.IOException;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * Class that extends JPanel and houses most of GUI stuff.
 */
public class BoardPanel extends JPanel {
  private MarbleSolitaireModelState modelState;
  private Image emptySlot;
  private Image marbleSlot;
  private Image blankSlot;
  private final int cellDimension;
  // private int originX;
  // private int originY;

  /**
   * Constructor for this method, initializes all GUI stuff.
   * @param state model state of the board
   * @throws IllegalStateException if any icons are not found
   */
  public BoardPanel(MarbleSolitaireModelState state) throws IllegalStateException {
    super();
    this.modelState = state;
    this.setBackground(Color.WHITE);
    this.cellDimension = 50;
    try {
      emptySlot = ImageIO.read(new FileInputStream("res/empty.png"));
      emptySlot = emptySlot.getScaledInstance(cellDimension, cellDimension, Image.SCALE_DEFAULT);

      marbleSlot = ImageIO.read(new FileInputStream("res/marble.png"));
      marbleSlot = marbleSlot.getScaledInstance(cellDimension, cellDimension, Image.SCALE_DEFAULT);

      blankSlot = ImageIO.read(new FileInputStream("res/blank.png"));
      blankSlot = blankSlot.getScaledInstance(cellDimension, cellDimension, Image.SCALE_DEFAULT);

      this.setPreferredSize(
              new Dimension((this.modelState.getBoardSize() + 4) * cellDimension
                      , (this.modelState.getBoardSize() + 4) * cellDimension));
    } catch (IOException e) {
      throw new IllegalStateException("Icons not found!");
    }

  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    int originX = (int) (this.getPreferredSize().getWidth() / 2
            - this.modelState.getBoardSize() * cellDimension / 2);
    int originY = (int) (this.getPreferredSize().getHeight() / 2
            - this.modelState.getBoardSize() * cellDimension / 2);

    for (int i = 0; i < modelState.getBoardSize(); i++) {
      for (int j = 0; j < modelState.getBoardSize(); j++) {
        if (modelState.getSlotAt(i, j).equals(SlotState.Empty)) {
          g.drawImage(emptySlot, originX + (i * 50), originY + (j * 50), this);
        }

        if (modelState.getSlotAt(i, j).equals(SlotState.Invalid)) {
          g.drawImage(blankSlot, originX + (i * 50), originY + (j * 50), this);
        }

        if (modelState.getSlotAt(i, j).equals(SlotState.Marble)) {
          g.drawImage(marbleSlot, originX + (i * 50), originY + (j * 50), this);
        }
      }
    }
    //your code to the draw the board should go here. 
    //The originX and originY is the top-left of where the cell (0,0) should start
    //cellDimension is the width (and height) occupied by every cell
  }
}
