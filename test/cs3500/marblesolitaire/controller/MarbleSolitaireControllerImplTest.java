package cs3500.marblesolitaire.controller;

import org.junit.Test;

import java.io.IOException;
import java.io.StringReader;

import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

import static org.junit.Assert.assertEquals;

/**
 * Test class for the controller.
 */
public class MarbleSolitaireControllerImplTest {

  Appendable a = new StringBuilder();
  MarbleSolitaireModel model = new EnglishSolitaireModel();
  MarbleSolitaireModel bigModel = new EnglishSolitaireModel(5);
  MarbleSolitaireView view = new MarbleSolitaireTextView(model, a);
  MarbleSolitaireView bigView = new MarbleSolitaireTextView(bigModel, a);

  @Test(expected = IllegalArgumentException.class)
  public void testNullModel() {
    Readable reader = new StringReader("2 4 4 4 q");
    MarbleSolitaireControllerImpl controller =
            new MarbleSolitaireControllerImpl(null, view, reader);
    controller.playGame();
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNullView() {
    Readable reader = new StringReader("2 4 4 4 q");
    MarbleSolitaireControllerImpl controller =
            new MarbleSolitaireControllerImpl(model, null, reader);
    controller.playGame();

  }

  @Test(expected = IllegalArgumentException.class)
  public void testNullIn() {
    Readable reader = new StringReader("2 4 4 4 q");
    MarbleSolitaireControllerImpl controller
            = new MarbleSolitaireControllerImpl(model, view, null);
    controller.playGame();

  }

  @Test(expected = IllegalStateException.class)
  public void testControllerThreeNumberInputs() throws IOException {
    Readable reader = new StringReader("1 2 3");
    MarbleSolitaireControllerImpl controller
            = new MarbleSolitaireControllerImpl(model, view, reader);
    controller.playGame();
  }

  @Test(expected = IllegalStateException.class)
  public void testControllerThreeNumberValidInputs() throws IOException {
    Readable reader = new StringReader("2 4");
    MarbleSolitaireControllerImpl controller
            = new MarbleSolitaireControllerImpl(model, view, reader);
    controller.playGame();
  }

  @Test(expected = IllegalStateException.class)
  public void testControllerOver() throws IOException {
    Readable reader = new StringReader("4 6 4 4 3 4");
    MarbleSolitaireControllerImpl controller
            = new MarbleSolitaireControllerImpl(model, view, reader);
    controller.playGame();

    assertEquals("hi", a.toString());
  }

  @Test(expected = IllegalStateException.class)
  public void testControllerLetterInput() throws IOException {
    Readable reader = new StringReader("a");
    MarbleSolitaireControllerImpl controller
            = new MarbleSolitaireControllerImpl(model, view, reader);
    controller.playGame();
  }

  @Test
  public void testControllerLetterInputs() throws IOException {
    try {
      Readable reader = new StringReader("r a s f");
      MarbleSolitaireControllerImpl controller
              = new MarbleSolitaireControllerImpl(model, view, reader);
      controller.playGame();
    } catch (IllegalStateException e) {
      assertEquals(e.getMessage(), "Readable out of inputs");
    }
  }

  @Test(expected = IllegalStateException.class)
  public void testControllerWordInput() throws IOException {
    Readable reader = new StringReader("hello");
    MarbleSolitaireControllerImpl controller
            = new MarbleSolitaireControllerImpl(model, view, reader);
    controller.playGame();
  }

  @Test(expected = IllegalStateException.class)
  public void testControllerLetterAndIntInputs() throws IOException {
    Readable reader = new StringReader("f a 1 f 9");
    MarbleSolitaireControllerImpl controller
            = new MarbleSolitaireControllerImpl(model, view, reader);
    controller.playGame();
  }

  @Test
  public void testControllerNegativeNumber() throws IOException {
    try {
      Readable reader = new StringReader("-5 q");
      MarbleSolitaireControllerImpl controller
              = new MarbleSolitaireControllerImpl(model, view, reader);
      controller.playGame();
    } catch (IllegalStateException e) {
      assertEquals(e.getMessage(), "Readable out of inputs");
    }
  }

  @Test(expected = IllegalStateException.class)
  public void testControllerEmpty() throws IOException {
    Readable reader = new StringReader("");
    MarbleSolitaireControllerImpl controller
            = new MarbleSolitaireControllerImpl(model, view, reader);
    controller.playGame();
  }

  @Test
  public void testGameOver() {
    Readable reader = new StringReader("4 6 4 4 4 3 4 5 4 1 4 3 6 4 4 4 3 4 5 4 1 4 3 4 q");
    MarbleSolitaireControllerImpl controller
            = new MarbleSolitaireControllerImpl(model, view, reader);
    controller.playGame();

    assertEquals(a.toString(), "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O _ _ O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O _ _ O _ O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 30\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "_ _ O _ O _ O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 29\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "_ _ O O O _ O\n" +
            "O O O _ O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 28\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O _ O O O\n" +
            "_ _ O _ O _ O\n" +
            "O O O O O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 27\n" +
            "    O _ O\n" +
            "    O _ O\n" +
            "O O O O O O O\n" +
            "_ _ O _ O _ O\n" +
            "O O O O O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 26\n" +
            "Game over!\n" +
            "    O _ O\n" +
            "    O _ O\n" +
            "O O O O O O O\n" +
            "_ _ O _ O _ O\n" +
            "O O O O O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 26");
  }

  @Test
  public void testGameOverInvalidMixedIn() {
    Readable reader = new StringReader("4 6 4 4 " +
            "1 2 3 4 4 3 a 4 5 4 1 e 4 3 6 4 4 4 3 4 5 4 1 4 3 4 q");
    MarbleSolitaireControllerImpl controller
            = new MarbleSolitaireControllerImpl(model, view, reader);
    controller.playGame();

    assertEquals(a.toString(), "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O _ _ O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "Invalid move. Play again. :)\n" +
            "Not a positive integer. Enter a new value\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O _ _ O _ O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 30\n" +
            "Not a positive integer. Enter a new value\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "_ _ O _ O _ O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 29\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "_ _ O O O _ O\n" +
            "O O O _ O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 28\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O _ O O O\n" +
            "_ _ O _ O _ O\n" +
            "O O O O O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 27\n" +
            "    O _ O\n" +
            "    O _ O\n" +
            "O O O O O O O\n" +
            "_ _ O _ O _ O\n" +
            "O O O O O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 26\n" +
            "Game over!\n" +
            "    O _ O\n" +
            "    O _ O\n" +
            "O O O O O O O\n" +
            "_ _ O _ O _ O\n" +
            "O O O O O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 26");
  }

  @Test
  public void testControllerInvalidInputsWithinValid1() throws IOException {
    Readable reader = new StringReader("2 4 h 4 4 q");
    MarbleSolitaireControllerImpl controller
            = new MarbleSolitaireControllerImpl(model, view, reader);
    controller.playGame();

    assertEquals(a.toString(), "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Not a positive integer. Enter a new value\n" +
            "    O O O\n" +
            "    O _ O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O _ O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31");
  }

  @Test
  public void testInvalidMove() {
    Readable reader = new StringReader("1 3 4 2 q");
    MarbleSolitaireControllerImpl controller
            = new MarbleSolitaireControllerImpl(model, view, reader);
    controller.playGame();

    assertEquals(a.toString(), "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Invalid move. Play again. :)\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32");
  }

  @Test
  public void testInvalidMoveInvalidInMiddle() {
    Readable reader = new StringReader("1 3 h 4 2 q");
    MarbleSolitaireControllerImpl controller
            = new MarbleSolitaireControllerImpl(model, view, reader);
    controller.playGame();

    assertEquals(a.toString(), "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" + "Not a positive integer. Enter a new value\n" +
            "Invalid move. Play again. :)\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32");
  }

  @Test
  public void testValidMoveInvalidInMiddle() {
    Readable reader = new StringReader("g s d 2 d f a e 4 g s 4 g 4 q");
    MarbleSolitaireControllerImpl controller
            = new MarbleSolitaireControllerImpl(model, view, reader);
    controller.playGame();

    assertEquals(a.toString(), "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Not a positive integer. Enter a new value\n" +
            "Not a positive integer. Enter a new value\n" +
            "Not a positive integer. Enter a new value\n" +
            "Not a positive integer. Enter a new value\n" +
            "Not a positive integer. Enter a new value\n" +
            "Not a positive integer. Enter a new value\n" +
            "Not a positive integer. Enter a new value\n" +
            "Not a positive integer. Enter a new value\n" +
            "Not a positive integer. Enter a new value\n" +
            "Not a positive integer. Enter a new value\n" +
            "    O O O\n" +
            "    O _ O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O _ O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31");
  }

  @Test
  public void testInvalidMoveInvalidThenValid() {
    Readable reader = new StringReader("1 2 3 4 2 4 4 4 q");
    MarbleSolitaireControllerImpl controller
            = new MarbleSolitaireControllerImpl(model, view, reader);
    controller.playGame();

    assertEquals(a.toString(), "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Invalid move. Play again. :)\n" +
            "    O O O\n" +
            "    O _ O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O _ O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31");
  }

  @Test
  public void testInvalidMoveValidThenInvalid() {
    Readable reader = new StringReader("2 4 4 4 1 2 3 4 q");
    MarbleSolitaireControllerImpl controller
            = new MarbleSolitaireControllerImpl(model, view, reader);
    controller.playGame();

    assertEquals(a.toString(), "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "    O O O\n" +
            "    O _ O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "Invalid move. Play again. :)\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O _ O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31");
  }

  @Test
  public void testControllerLowerCaseQAlone() throws IOException {
    Readable reader = new StringReader("q");
    MarbleSolitaireControllerImpl controller
            = new MarbleSolitaireControllerImpl(model, view, reader);
    controller.playGame();

    assertEquals(a.toString(), "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Game quit!\n"
            + "State of game when quit:\n"
            + "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32");
  }

  @Test
  public void testControllerUpperCaseQAlone() throws IOException {
    Readable reader = new StringReader("Q");
    MarbleSolitaireControllerImpl controller
            = new MarbleSolitaireControllerImpl(model, view, reader);
    controller.playGame();

    assertEquals(a.toString(), "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Game quit!\n"
            + "State of game when quit:\n"
            + "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32");
  }

  @Test
  public void testControllerQAtBeginningValid() throws IOException {
    Readable reader = new StringReader("q 2 4 4 4");
    MarbleSolitaireControllerImpl controller
            = new MarbleSolitaireControllerImpl(model, view, reader);
    controller.playGame();

    assertEquals(a.toString(), "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32");
  }

  @Test
  public void testControllerOverWithQ() throws IOException {
    Readable reader = new StringReader("4 6 4 4 3 4 q");
    MarbleSolitaireControllerImpl controller
            = new MarbleSolitaireControllerImpl(model, view, reader);
    controller.playGame();

    assertEquals(a.toString(), "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O _ _ O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O _ _ O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31");
  }

  @Test
  public void testMoveHorizontalRight() {
    Readable reader = new StringReader("4 2 4 4 q");
    MarbleSolitaireControllerImpl controller
            = new MarbleSolitaireControllerImpl(model, view, reader);
    controller.playGame();

    assertEquals(a.toString(), "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O _ _ O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O _ _ O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31");
  }

  @Test
  public void testMoveVerticalDown() {
    Readable reader = new StringReader("2 4 4 4 q");
    MarbleSolitaireControllerImpl controller
            = new MarbleSolitaireControllerImpl(model, view, reader);
    controller.playGame();

    assertEquals(a.toString(), "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "    O O O\n" +
            "    O _ O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O _ O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31");
  }

  @Test
  public void testMoveHorizontalLeft() {
    Readable reader = new StringReader("4 6 4 4 q");
    MarbleSolitaireControllerImpl controller
            = new MarbleSolitaireControllerImpl(model, view, reader);
    controller.playGame();

    assertEquals(a.toString(), "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O _ _ O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O _ _ O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31");
  }

  @Test
  public void testMoveVerticalUp() {
    Readable reader = new StringReader("6 4 4 4 q");
    MarbleSolitaireControllerImpl controller
            = new MarbleSolitaireControllerImpl(model, view, reader);
    controller.playGame();

    assertEquals(a.toString(), "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 31");
  }

  @Test
  public void testMoveTwoValidMoves() {
    Readable reader = new StringReader("4 6 4 4 4 3 4 5 q");
    MarbleSolitaireControllerImpl controller
            = new MarbleSolitaireControllerImpl(model, view, reader);
    controller.playGame();

    assertEquals(a.toString(), "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O _ _ O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O _ _ O _ O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 30\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O _ _ O _ O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 30");
  }

  @Test
  public void testMoveThreeValidMoves() {
    Readable reader = new StringReader("4 6 4 4 4 3 4 5 4 1 4 3 q");
    MarbleSolitaireControllerImpl controller
            = new MarbleSolitaireControllerImpl(model, view, reader);
    controller.playGame();

    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O _ _ O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O _ _ O _ O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 30\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "_ _ O _ O _ O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 29\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "_ _ O _ O _ O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 29", a.toString());
  }


  @Test
  public void testMoveBigBoard() {
    Readable reader = new StringReader("5 7 7 7 q");
    MarbleSolitaireControllerImpl controller
            = new MarbleSolitaireControllerImpl(bigModel, bigView, reader);
    controller.playGame();

    assertEquals(a.toString(), "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O _ O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "Score: 104\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "O O O O O O _ O O O O O O\n" +
            "O O O O O O _ O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "Score: 103\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "O O O O O O _ O O O O O O\n" +
            "O O O O O O _ O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "Score: 103");
  }
}