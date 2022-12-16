package cs3500.marblesolitaire.model.hw04;

import org.junit.Test;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState;

import static org.junit.Assert.assertEquals;

/**
 * Public class that houses tests for the public methods in Triangle Solitaire, thoroughly tests all
 * the methods present in the TriangleSolitaireModel class to ensure that everything is running
 * they way it is supposed to be running.
 */
public class TriangleSolitaireModelTest {

  private TriangleSolitaireModel constructor1 = new TriangleSolitaireModel();
  private TriangleSolitaireModel constructor2 = new TriangleSolitaireModel(1, 1);
  private TriangleSolitaireModel constructor3 = new TriangleSolitaireModel(6);
  private TriangleSolitaireModel constructor4 = new TriangleSolitaireModel(6, 4, 2);
  private TriangleSolitaireModel constructor5 = new TriangleSolitaireModel(6, 3, 1);

  @Test
  public void testValidConstructor1() {
    assertEquals(SlotState.Empty, constructor1.getSlotAt(0, 0));
    assertEquals(SlotState.Invalid, constructor1.getSlotAt(0, 1));
    assertEquals(SlotState.Marble, constructor1.getSlotAt(4, 4));
    assertEquals(5, constructor1.getBoardSize());
    assertEquals(14, constructor1.getScore());
    assertEquals(false, constructor1.isGameOver());
  }

  @Test
  public void testValidConstructor2() {
    assertEquals(SlotState.Empty, constructor2.getSlotAt(1, 1));
    assertEquals(SlotState.Invalid, constructor2.getSlotAt(0, 1));
    assertEquals(SlotState.Marble, constructor2.getSlotAt(4, 4));
    assertEquals(5, constructor2.getBoardSize());
    assertEquals(14, constructor2.getScore());
    assertEquals(false, constructor2.isGameOver());
  }

  @Test
  public void testValidConstructor3() {
    assertEquals(SlotState.Empty, constructor3.getSlotAt(0, 0));
    assertEquals(SlotState.Invalid, constructor3.getSlotAt(0, 1));
    assertEquals(SlotState.Marble, constructor3.getSlotAt(5, 5));
    assertEquals(6, constructor3.getBoardSize());
    assertEquals(20, constructor3.getScore());
    assertEquals(false, constructor3.isGameOver());
  }

  @Test
  public void testValidConstructor4() {
    assertEquals(SlotState.Empty, constructor4.getSlotAt(4, 2));
    assertEquals(SlotState.Invalid, constructor4.getSlotAt(0, 1));
    assertEquals(SlotState.Marble, constructor4.getSlotAt(5, 5));
    assertEquals(6, constructor4.getBoardSize());
    assertEquals(20, constructor4.getScore());
    assertEquals(false, constructor4.isGameOver());
  }

  @Test (expected = IllegalArgumentException.class)
  public void testInvalidConstructorNegative() {
    new TriangleSolitaireModel(-1, -1);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testInvalidConstructorNegative2() {
    new TriangleSolitaireModel(1, -1);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testInvalidConstructorTooBig() {
    new TriangleSolitaireModel(10, 10);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testInvalidConstructorOutOfBounds() {
    new TriangleSolitaireModel(0, 1);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testInvalidConstructorOutOfBounds2() {
    new TriangleSolitaireModel(2, 3);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testInvalidConstructor3InvalidRow() {
    new TriangleSolitaireModel(5, 4);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testInvalidConstructor3InvalidCol() {
    new TriangleSolitaireModel(4, 5);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testInvalidConstructor3InvalidBoth() {
    new TriangleSolitaireModel(5, 5);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testInvalidConstructor3InvalidArmThickness1() {
    new TriangleSolitaireModel(-1);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testInvalidConstructor4InvalidArmThickness1() {
    new TriangleSolitaireModel(-1, 1, 1);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testInvalidConstructor4InvalidRowCol1() {
    new TriangleSolitaireModel(6, 6, 6);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testInvalidConstructor4InvalidRowCol2() {
    new TriangleSolitaireModel(6, 6, 5);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testInvalidConstructor4InvalidRowCol3() {
    new TriangleSolitaireModel(6, 5, 6);
  }

  @Test
  public void testConstructor2Message() {
    try {
      new TriangleSolitaireModel(0, 1);
    }
    catch (Exception e) {
      assertEquals(e.getMessage(), "Invalid position at (0, 1)");
    }
  }

  @Test
  public void testConstructor3Message() {
    try {
      new TriangleSolitaireModel(-1);
    }
    catch (Exception e) {
      assertEquals(e.getMessage(), "Arm thickness cannot be negative");
    }
  }

  @Test
  public void testGetSlotAt() {
    assertEquals(SlotState.Empty, constructor1.getSlotAt(0, 0));
    assertEquals(SlotState.Marble, constructor1.getSlotAt(1, 0));
    assertEquals(SlotState.Marble, constructor1.getSlotAt(2, 0));
    assertEquals(SlotState.Marble, constructor1.getSlotAt(3, 0));
    assertEquals(SlotState.Marble, constructor1.getSlotAt(4, 4));
  }

  @Test
  public void testGetSlotAtConstructor4() {
    assertEquals(SlotState.Empty, constructor4.getSlotAt(4, 2));
    assertEquals(SlotState.Marble, constructor4.getSlotAt(1, 0));
    assertEquals(SlotState.Marble, constructor4.getSlotAt(2, 0));
    assertEquals(SlotState.Marble, constructor4.getSlotAt(3, 0));
    assertEquals(SlotState.Marble, constructor4.getSlotAt(4, 4));
  }

  @Test
  public void testMoveFromLeft() {
    constructor4.move(4, 0, 4, 2);
    assertEquals(SlotState.Empty, constructor4.getSlotAt(4, 0));
    assertEquals(SlotState.Empty, constructor4.getSlotAt(4, 1));
    assertEquals(SlotState.Marble, constructor4.getSlotAt(4, 2));
  }

  @Test
  public void testMoveFromRight() {
    constructor4.move(4, 4, 4, 2);
    assertEquals(SlotState.Empty, constructor4.getSlotAt(4, 4));
    assertEquals(SlotState.Empty, constructor4.getSlotAt(4, 3));
    assertEquals(SlotState.Marble, constructor4.getSlotAt(4, 2));
  }

  @Test
  public void testMoveDiagonallyDownFromRight() {
    constructor4.move(2, 0, 4, 2);
    assertEquals(SlotState.Empty, constructor4.getSlotAt(2, 0));
    assertEquals(SlotState.Empty, constructor4.getSlotAt(3, 1));
    assertEquals(SlotState.Marble, constructor4.getSlotAt(4, 2));
  }

  @Test
  public void testMoveDiagonallyDownFromLeft() {
    constructor4.move(2, 2, 4, 2);
    assertEquals(SlotState.Empty, constructor4.getSlotAt(2, 2));
    assertEquals(SlotState.Empty, constructor4.getSlotAt(3, 2));
    assertEquals(SlotState.Marble, constructor4.getSlotAt(4, 2));
  }

  @Test
  public void testMoveDiagonallyUpFromRight() {
    constructor5.move(5, 3, 3, 1);
    assertEquals(SlotState.Empty, constructor5.getSlotAt(5, 3));
    assertEquals(SlotState.Empty, constructor5.getSlotAt(4, 2));
    assertEquals(SlotState.Marble, constructor5.getSlotAt(3, 1));
  }

  @Test
  public void testMoveDiagonallyUpFromLeft() {
    constructor5.move(5, 1, 3, 1);
    assertEquals(SlotState.Empty, constructor5.getSlotAt(5, 1));
    assertEquals(SlotState.Empty, constructor5.getSlotAt(4, 1));
    assertEquals(SlotState.Marble, constructor5.getSlotAt(3, 1));
  }

  @Test (expected = IllegalArgumentException.class)
  public void testInvalidMoveOneApart1() {
    constructor5.move(4, 2, 3, 1);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testInvalidMoveThreeApart() {
    constructor5.move(4, 2, 2, 0);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testInvalidMoveFromInvalid() {
    constructor5.move(3, 4, 3, 1);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testInvalidMoveToInvalid() {
    constructor5.move(5, 5, 5, 7);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testInvalidMoveTwoApart() {
    constructor1.move(2, 1, 0, 0);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testInvalidMoveNotOverMarble() {
    constructor5.move(4, 2, 2, 2);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testInvalidMoveMoveToMarble() {
    constructor1.move(4, 1, 2, 1);
  }

  @Test
  public void testGetScore() {
    assertEquals(constructor1.getScore(), 14);
  }

  @Test
  public void testGetScore2() {
    constructor1.move(2, 0, 0, 0);
    assertEquals(constructor1.getScore(), 13);
  }

  @Test
  public void testGameOverTrue() {
    constructor1.move(2, 0, 0, 0);
    constructor1.move(2, 2, 2, 0);
    constructor1.move(0, 0, 2, 2);
    constructor1.move(3, 3, 1, 1);
    constructor1.move(3, 0, 1, 0);
    constructor1.move(3, 1, 3, 3);
    constructor1.move(4, 4, 2, 2);
    constructor1.move(1, 1, 3, 3);
    constructor1.move(4, 2, 4, 4);
    constructor1.move(4, 4, 2, 2);
    constructor1.move(4, 0, 4, 2);

    assertEquals(true, constructor1.isGameOver());
  }

  @Test
  public void testGameOverFalse() {
    constructor1.move(2, 0, 0, 0);
    constructor1.move(2, 2, 2, 0);
    constructor1.move(0, 0, 2, 2);
    constructor1.move(3, 3, 1, 1);

    assertEquals(false, constructor1.isGameOver());
  }

  @Test
  public void testGetBoardSize1() {
    assertEquals(5, constructor1.getBoardSize());
  }

  @Test
  public void testGetBoardSize2() {
    assertEquals(6, constructor3.getBoardSize());
  }

}
