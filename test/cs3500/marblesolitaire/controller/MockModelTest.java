package cs3500.marblesolitaire.controller;

import org.junit.Test;

import java.io.StringReader;

import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MockModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

import static org.junit.Assert.assertEquals;

/**
 * Mock model test, testing for the mock model class made earlier.
 */
public class MockModelTest {

  Appendable a = new StringBuilder();
  MarbleSolitaireModel model = new EnglishSolitaireModel();
  MarbleSolitaireView view = new MarbleSolitaireTextView(model, a);

  StringBuilder log = new StringBuilder();
  MarbleSolitaireModel mock = new MockModel(log);

  @Test
  public void testMockModel() {
    Readable reader = new StringReader("2 4 4 4 q");
    MarbleSolitaireControllerImpl controller
            = new MarbleSolitaireControllerImpl(mock, view, reader);
    controller.playGame();

    assertEquals("move() (1, 3, 3, 3)", log.toString());
  }

  @Test
  public void testMockModelInvalidInputs() {
    Readable reader = new StringReader("1 2 3 4 q");
    MarbleSolitaireControllerImpl controller
            = new MarbleSolitaireControllerImpl(mock, view, reader);
    controller.playGame();

    assertEquals("move() (0, 1, 2, 3)", log.toString());
  }

  @Test
  public void testMockModelInvalidLetterInputs() {
    Readable reader = new StringReader("a b c q");
    MarbleSolitaireControllerImpl controller
            = new MarbleSolitaireControllerImpl(mock, view, reader);
    controller.playGame();

    assertEquals("", log.toString());
  }

  @Test
  public void testMockModelNegativeInput() {
    Readable reader = new StringReader("-1 q");
    MarbleSolitaireControllerImpl controller
            = new MarbleSolitaireControllerImpl(mock, view, reader);
    controller.playGame();

    assertEquals("", log.toString());
  }

  @Test(expected = IllegalStateException.class)
  public void testMockModelEmptyInput() {
    Readable reader = new StringReader("");
    MarbleSolitaireControllerImpl controller
            = new MarbleSolitaireControllerImpl(mock, view, reader);
    controller.playGame();
  }
}
