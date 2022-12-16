package cs3500.marblesolitaire.model.hw02;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState;

/**
 * Public class that houses tests for the public methods in EnglishSolitaire, thoroughly tests all
 * the methods present in the EnglishSolitaireModel class to ensure that everything is running
 * they way it is supposed to be running.
 */
public class EnglishSolitaireModelTest {

  private EnglishSolitaireModel constructor1 = new EnglishSolitaireModel();
  private EnglishSolitaireModel constructor2 = new EnglishSolitaireModel(2, 4);
  private EnglishSolitaireModel constructor3 = new EnglishSolitaireModel(5);
  private EnglishSolitaireModel constructor4 = new EnglishSolitaireModel(3, 2, 4);

  @Test
  public void testValidConstructor1() {
    assertEquals(SlotState.Empty, constructor1.getSlotAt(3, 3));
    assertEquals(SlotState.Invalid, constructor1.getSlotAt(0, 0));
    assertEquals(SlotState.Marble, constructor1.getSlotAt(4, 4));
    assertEquals(7, constructor1.getBoardSize());
    assertEquals(32, constructor1.getScore());
    assertEquals(false, constructor1.isGameOver());
  }

  @Test
  public void testValidConstructor2() {
    assertEquals(SlotState.Empty, constructor2.getSlotAt(2, 4));
    assertEquals(SlotState.Invalid, constructor2.getSlotAt(0, 0));
    assertEquals(SlotState.Marble, constructor2.getSlotAt(4, 5));
    assertEquals(7, constructor2.getBoardSize());
    assertEquals(32, constructor2.getScore());
    assertEquals(false, constructor2.isGameOver());
  }

  @Test
  public void testValidConstructor3() {
    assertEquals(SlotState.Empty, constructor3.getSlotAt(6, 6));
    assertEquals(SlotState.Invalid, constructor3.getSlotAt(0, 0));
    assertEquals(SlotState.Marble, constructor3.getSlotAt(4, 4));
    assertEquals(13, constructor3.getBoardSize());
    assertEquals(104, constructor3.getScore());
    assertEquals(false, constructor3.isGameOver());
  }

  @Test
  public void testValidConstructor4() {
    assertEquals(SlotState.Empty, constructor4.getSlotAt(2, 4));
    assertEquals(SlotState.Invalid, constructor4.getSlotAt(0, 0));
    assertEquals(SlotState.Marble, constructor4.getSlotAt(4, 4));
    assertEquals(7, constructor4.getBoardSize());
    assertEquals(32, constructor4.getScore());
    assertEquals(false, constructor4.isGameOver());
  }


  @Test(expected = IllegalArgumentException.class)
  public void testConstructor2ExceptionOutOfBounds1() {
    new EnglishSolitaireModel(-1, -1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructor2ExceptionOutOfBounds2() {
    new EnglishSolitaireModel(7, 7);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructor2ExceptionInvalid1() {
    new EnglishSolitaireModel(1, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructor2ExceptionInvalid2() {
    new EnglishSolitaireModel(5, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructor2ExceptionInvalid3() {
    new EnglishSolitaireModel(1, 6);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructor2ExceptionInvalid4() {
    new EnglishSolitaireModel(5, 6);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructor3ExceptionEvenPositive() {
    new EnglishSolitaireModel(4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructor3ExceptionEvenNegative() {
    new EnglishSolitaireModel(-2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructor3ExceptionOddNegative() {
    new EnglishSolitaireModel(-1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructor4ExceptionOutOfBounds1() {
    new EnglishSolitaireModel(3, -1, -1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructor4ExceptionOutOfBounds2() {
    new EnglishSolitaireModel(3, 7, 7);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructor4ExceptionInvalid1() {
    new EnglishSolitaireModel(5, 1, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructor4ExceptionInvalid2() {
    new EnglishSolitaireModel(3, 5, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructor4ExceptionInvalid3() {
    new EnglishSolitaireModel(3, 1, 6);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructor4ExceptionInvalid4() {
    new EnglishSolitaireModel(3, 5, 6);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructor4ExceptionEvenPositive() {
    new EnglishSolitaireModel(4, 1, 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructor4ExceptionEvenNegative() {
    new EnglishSolitaireModel(-2, 1, 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructor4ExceptionEvenNegativeOutOfBounds() {
    new EnglishSolitaireModel(-2, 7, 8);
  }

  @Test
  public void testConstructor2Message() {
    try {
      new EnglishSolitaireModel(7, 7);
    }
    catch (Exception e) {
      assertEquals(e.getMessage(), "Invalid position at (7, 7)");
    }
  }

  @Test
  public void testConstructor3Message() {
    try {
      new EnglishSolitaireModel(4);
    }
    catch (Exception e) {
      assertEquals(e.getMessage(), "Arm thickness is not a positive, odd number!");
    }
  }

  @Test
  public void testConstructor4Message1() {
    try {
      new EnglishSolitaireModel(2, 7, 7);
    }
    catch (Exception e) {
      assertEquals(e.getMessage(), "Arm thickness is not a positive, odd number!");
    }
  }

  @Test
  public void testConstructor4Message2() {
    try {
      new EnglishSolitaireModel(3, 7, 7);
    }
    catch (Exception e) {
      assertEquals(e.getMessage(), "Invalid position at (7, 7)");
    }
  }

  @Test
  public void testConstructor4Message3() {
    try {
      new EnglishSolitaireModel(2, 2, 4);
    }
    catch (Exception e) {
      assertEquals(e.getMessage(), "Arm thickness is not a positive, odd number!");
    }
  }

  @Test
  public void getSlotAt() {
    assertEquals(SlotState.Invalid, constructor1.getSlotAt(0, 0));
    assertEquals(SlotState.Empty, constructor1.getSlotAt(3, 3));
    assertEquals(SlotState.Marble, constructor1.getSlotAt(3, 5));
    assertEquals(SlotState.Empty, constructor2.getSlotAt(2, 4));
    assertEquals(SlotState.Invalid, constructor3.getSlotAt(3, 3));
    assertEquals(SlotState.Empty, constructor3.getSlotAt(6, 6));
    assertEquals(SlotState.Marble, constructor3.getSlotAt(8, 12));
    assertEquals(SlotState.Empty, constructor4.getSlotAt(2, 4));
    assertEquals(SlotState.Marble, constructor4.getSlotAt(3, 3));
  }

  @Test
  public void testMoveHorizontalRight() {
    constructor1.move(3, 1, 3, 3);
    assertEquals(SlotState.Empty, constructor1.getSlotAt(3, 1));
    assertEquals(SlotState.Empty, constructor1.getSlotAt(3, 2));
    assertEquals(SlotState.Marble, constructor1.getSlotAt(3, 3));
  }

  @Test
  public void testMoveVerticalDown() {
    constructor1.move(1, 3, 3, 3);
    assertEquals(SlotState.Empty, constructor1.getSlotAt(1, 3));
    assertEquals(SlotState.Empty, constructor1.getSlotAt(2, 3));
    assertEquals(SlotState.Marble, constructor1.getSlotAt(3, 3));
  }

  @Test
  public void testMoveHorizontalLeft() {
    constructor1.move(3, 5, 3, 3);
    assertEquals(SlotState.Empty, constructor1.getSlotAt(3, 5));
    assertEquals(SlotState.Empty, constructor1.getSlotAt(3, 4));
    assertEquals(SlotState.Marble, constructor1.getSlotAt(3, 3));
  }

  @Test
  public void testMoveVerticalUp() {
    constructor1.move(5, 3, 3, 3);
    assertEquals(SlotState.Empty, constructor1.getSlotAt(5, 3));
    assertEquals(SlotState.Empty, constructor1.getSlotAt(4, 3));
    assertEquals(SlotState.Marble, constructor1.getSlotAt(3, 3));
  }

  @Test
  public void testGetScore1() {
    constructor1.move(3, 1, 3, 3);
    assertEquals(31, constructor1.getScore());
  }

  @Test
  public void testGetScore2() {
    constructor1.move(3, 5, 3, 3);
    constructor1.move(3, 2, 3, 4);
    constructor1.move(3, 0, 3, 2);
    constructor1.move(5, 3, 3, 3);
    assertEquals(28, constructor1.getScore());
  }

  @Test
  public void testGetScore3() {
    assertEquals(3, constructor1.getScore());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMoveExceptionOutOfBounds() {
    constructor1.move(-1, -1, 0, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMoveExceptionInvalid1() {
    constructor1.move(0, 0, 0, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMoveExceptionInvalid2() {
    constructor1.move(0, 3, 0, 5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMoveExceptionInvalid3() {
    constructor1.move(0, 5, 0, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMoveExceptionNotTwo1() {
    constructor1.move(2, 2, 3, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMoveExceptionNotTwo2() {
    constructor1.move(2, 3, 2, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMoveExceptionNotTwo3() {
    constructor1.move(5, 3, 4, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMoveExceptionNotTwo4() {
    constructor1.move(3, 1, 3, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMoveExceptionDiagonal1() {
    constructor1.move(2, 2, 0, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMoveExceptionDiagonal2() {
    constructor1.move(3, 2, 2, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMoveExceptionDiagonal3() {
    constructor1.move(4, 5, 2, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMoveExceptionDiagonal4() {
    constructor3.move(8, 8, 6, 6);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMoveExceptionMoveToInvalid() {
    constructor1.move(1, 4, 1, 6);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMoveExceptionMoveToNonExistent() {
    constructor1.move(1, 4, 7, 7);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMoveExceptionMoveMorethan2() {
    constructor1.move(3, 2, 3, 5);
  }

  @Test
  public void testGetBoardSize1() {
    assertEquals(7, constructor1.getBoardSize());
  }

  @Test
  public void testGetBoardSize2() {
    assertEquals(13, constructor3.getBoardSize());
  }

  @Test
  public void testIsGameOverTrue() {
    constructor1.move(3, 5, 3, 3);
    constructor1.move(3, 2, 3, 4);
    constructor1.move(3, 0, 3, 2);
    constructor1.move(5, 3, 3, 3);
    constructor1.move(2, 3, 4, 3);
    constructor1.move(0, 3, 2, 3);

    assertEquals(true, constructor1.isGameOver());
  }

  @Test
  public void testIsGameOverFalse() {
    constructor1.move(3, 5, 3, 3);
    constructor1.move(3, 2, 3, 4);
    constructor1.move(3, 0, 3, 2);
    assertEquals(false, constructor1.isGameOver());
  }
}
