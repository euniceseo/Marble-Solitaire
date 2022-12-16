package cs3500.marblesolitaire.model.hw04;

import org.junit.Test;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState;

import static org.junit.Assert.assertEquals;

/**
 * Public class that houses tests for the public methods in EuropeanSolitaire, thoroughly tests all
 * the methods present in the EuropeanSolitaireModel class to ensure that everything is running
 * they way it is supposed to be running.
 */
public class EuropeanSolitaireModelTest {
  private EuropeanSolitaireModel constructor1 = new EuropeanSolitaireModel();
  private EuropeanSolitaireModel constructor2 = new EuropeanSolitaireModel(2, 4);
  private EuropeanSolitaireModel constructor3 = new EuropeanSolitaireModel(5);
  private EuropeanSolitaireModel constructor4 = new EuropeanSolitaireModel(3, 2, 2);
  private EuropeanSolitaireModel constructor5 = new EuropeanSolitaireModel(5, 1, 3);

  @Test
  public void testValidConstructor1() {
    assertEquals(SlotState.Empty, constructor1.getSlotAt(3, 3));
    assertEquals(SlotState.Invalid, constructor1.getSlotAt(0, 0));
    assertEquals(SlotState.Invalid, constructor1.getSlotAt(0, 1));
    assertEquals(SlotState.Marble, constructor1.getSlotAt(4, 4));
    assertEquals(SlotState.Marble, constructor1.getSlotAt(1, 1));
    assertEquals(SlotState.Marble, constructor1.getSlotAt(5, 5));
    assertEquals(7, constructor1.getBoardSize());
  }

  @Test
  public void testValidConstructor2() {
    assertEquals(SlotState.Empty, constructor2.getSlotAt(2, 4));
    assertEquals(SlotState.Invalid, constructor2.getSlotAt(0, 0));
    assertEquals(SlotState.Marble, constructor2.getSlotAt(4, 5));
    assertEquals(SlotState.Marble, constructor2.getSlotAt(1, 1));
    assertEquals(SlotState.Marble, constructor2.getSlotAt(5, 5));
    assertEquals(7, constructor2.getBoardSize());
  }

  @Test
  public void testValidConstructor3() {
    assertEquals(SlotState.Empty, constructor3.getSlotAt(6, 6));
    assertEquals(SlotState.Invalid, constructor3.getSlotAt(0, 0));
    assertEquals(SlotState.Marble, constructor3.getSlotAt(4, 4));
    assertEquals(SlotState.Marble, constructor3.getSlotAt(2, 2));
    assertEquals(SlotState.Marble, constructor3.getSlotAt(3, 3));
    assertEquals(13, constructor3.getBoardSize());
  }

  @Test
  public void testValidConstructor4() {
    assertEquals(SlotState.Empty, constructor4.getSlotAt(2, 2));
    assertEquals(SlotState.Invalid, constructor4.getSlotAt(0, 0));
    assertEquals(SlotState.Marble, constructor4.getSlotAt(4, 4));
    assertEquals(SlotState.Marble, constructor4.getSlotAt(1, 1));
    assertEquals(SlotState.Marble, constructor4.getSlotAt(5, 5));
    assertEquals(7, constructor4.getBoardSize());
  }

  @Test
  public void testGetSlotAtConstructor1() {
    assertEquals(SlotState.Marble, constructor1.getSlotAt(1, 1));
    assertEquals(SlotState.Invalid, constructor1.getSlotAt(0, 0));
    assertEquals(SlotState.Invalid, constructor1.getSlotAt(0, 1));
    assertEquals(SlotState.Marble, constructor1.getSlotAt(1, 5));
    assertEquals(SlotState.Marble, constructor1.getSlotAt(5, 1));
    assertEquals(SlotState.Marble, constructor1.getSlotAt(5, 5));
  }

  @Test (expected = IllegalArgumentException.class)
  public void testInvalidConstructor31() {
    new EuropeanSolitaireModel(4);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testInvalidConstructor32() {
    new EuropeanSolitaireModel(-2);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testInvalidConstructor33() {
    new EuropeanSolitaireModel(34);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testInvalidConstructor34() {
    new EuropeanSolitaireModel(-1);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testInvalidConstructor21() {
    new EuropeanSolitaireModel(6, 1);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testInvalidConstructor2OutofBounds1() {
    new EuropeanSolitaireModel(-1, -1);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testInvalidConstructor2OutofBounds2() {
    new EuropeanSolitaireModel(7, 7);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testInvalidConstructor22() {
    new EuropeanSolitaireModel(0, 0);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testInvalidConstructor23() {
    new EuropeanSolitaireModel(-1, 0);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testInvalidConstructor24() {
    new EuropeanSolitaireModel(1, 6);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testInvalidConstructor41() {
    new EuropeanSolitaireModel(3,6, 1);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testInvalidConstructor42() {
    new EuropeanSolitaireModel(3, 1, 6);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testInvalidConstructor4Big1() {
    new EuropeanSolitaireModel(5, 0, 0);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testInvalidConstructor4Big2() {
    new EuropeanSolitaireModel(5, 1, 11);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testInvalidConstructor4Big3() {
    new EuropeanSolitaireModel(5, 10, 1);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testInvalidConstructor4Big4() {
    new EuropeanSolitaireModel(5, 3, 0);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testInvalidConstructor4Big5() {
    new EuropeanSolitaireModel(5, 11, 11);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testInvalidConstructor4Big6() {
    new EuropeanSolitaireModel(5, 9, 12);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testInvalidConstructor4Big7() {
    new EuropeanSolitaireModel(6, 9, 12);
  }

  @Test
  public void testConstructor2Message() {
    try {
      new EuropeanSolitaireModel(0, 0);
    }
    catch (Exception e) {
      assertEquals(e.getMessage(), "Invalid position at (0, 0)");
    }
  }

  @Test
  public void testConstructor3Message() {
    try {
      new EuropeanSolitaireModel(5);
    }
    catch (Exception e) {
      assertEquals(e.getMessage(), "Arm thickness is not a positive, odd number!");
    }
  }

  @Test
  public void testGetScore() {
    assertEquals(36, constructor1.getScore());
  }


  @Test
  public void testGetScore2() {
    constructor1.move(1, 3, 3, 3);
    assertEquals(35, constructor1.getScore());
  }

  @Test
  public void testGetScoreConstructor3() {
    assertEquals(128, constructor3.getScore());
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
  public void testIsGameOverTrue() {
    constructor1.move(3, 5, 3, 3);
    constructor1.move(3, 2, 3, 4);
    constructor1.move(3, 0, 3, 2);
    constructor1.move(5, 3, 3, 3);
    constructor1.move(2, 3, 4, 3);
    constructor1.move(0, 3, 2, 3);
    constructor1.move(1, 1, 1, 3);
    constructor1.move(5, 1, 5, 3);
    constructor1.move(1, 4, 1, 2);
    constructor1.move(5, 4, 5, 2);
    constructor1.move(3, 4, 1, 4);
    constructor1.move(0, 4, 2, 4);
    constructor1.move(1, 5, 3, 5);
    constructor1.move(2, 3, 2, 5);
    constructor1.move(3, 6, 3, 4);
    constructor1.move(2, 6, 2, 4);
    constructor1.move(3, 4, 1, 4);
    constructor1.move(5, 5, 3, 5);
    constructor1.move(4, 3, 4, 5);
    constructor1.move(4, 6, 4, 4);
    constructor1.move(2, 1, 2, 3);
    constructor1.move(4, 1, 4, 3);
    constructor1.move(4, 4, 4, 2);
    constructor1.move(0, 2, 2, 2);
    constructor1.move(3, 2, 1, 2);
    constructor1.move(5, 2, 3, 2);

    assertEquals(true, constructor1.isGameOver());
  }

  @Test
  public void testIsGameOverFalse() {
    constructor1.move(3, 5, 3, 3);
    constructor1.move(3, 2, 3, 4);
    constructor1.move(3, 0, 3, 2);
    constructor1.move(5, 3, 3, 3);
    constructor1.move(2, 3, 4, 3);
    constructor1.move(0, 3, 2, 3);
    constructor1.move(1, 1, 1, 3);

    assertEquals(false, constructor1.isGameOver());
  }

  @Test
  public void testGetBoardSize1() {
    assertEquals(7, constructor1.getBoardSize());
  }

  @Test
  public void testGetBoardSize2() {
    assertEquals(13, constructor3.getBoardSize());
  }

}