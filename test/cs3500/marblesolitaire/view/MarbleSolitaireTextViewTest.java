package cs3500.marblesolitaire.view;

import org.junit.Test;

import java.io.IOException;

import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;

import static org.junit.Assert.assertEquals;

/**
 * Public class for testing the toString() method for MarbleSolitaireTextView. Also tests the
 * renderBoard method and the renderMessage method. Tests validity and that it throws an exception
 * when anything is invalid.
 */

public class MarbleSolitaireTextViewTest {

  @Test
  public void testOneToString() {
    EnglishSolitaireModel constructor1 = new EnglishSolitaireModel();
    MarbleSolitaireTextView one = new MarbleSolitaireTextView(constructor1);
    assertEquals(one.toString(),
            "    O O O\n"
                    + "    O O O\n"
                    + "O O O O O O O\n"
                    + "O O O _ O O O\n"
                    + "O O O O O O O\n"
                    + "    O O O\n"
                    + "    O O O");
  }

  @Test
  public void testTwoToString() {
    EnglishSolitaireModel constructor2 = new EnglishSolitaireModel(2, 4);
    MarbleSolitaireTextView two = new MarbleSolitaireTextView(constructor2);
    assertEquals(two.toString(),
            "    O O O\n"
                    + "    O O O\n"
                    + "O O O O _ O O\n"
                    + "O O O O O O O\n"
                    + "O O O O O O O\n"
                    + "    O O O\n"
                    + "    O O O");
  }

  @Test
  public void testGameOverConstructor() {
    EnglishSolitaireModel constructor1 = new EnglishSolitaireModel();
    MarbleSolitaireTextView one = new MarbleSolitaireTextView(constructor1);
    constructor1.move(3, 5, 3, 3);
    constructor1.move(3, 2, 3, 4);
    constructor1.move(3, 0, 3, 2);
    constructor1.move(5, 3, 3, 3);
    constructor1.move(2, 3, 4, 3);
    constructor1.move(0, 3, 2, 3);
    assertEquals(one.toString(), "    O _ O\n" +
            "    O _ O\n" +
            "O O O O O O O\n" +
            "_ _ O _ O _ O\n" +
            "O O O O O O O\n" +
            "    O _ O\n" +
            "    O O O");
  }

  @Test
  public void testThreeToString() {
    EnglishSolitaireModel constructor3 = new EnglishSolitaireModel(5);
    MarbleSolitaireTextView three = new MarbleSolitaireTextView(constructor3);
    assertEquals(three.toString(),
            "        O O O O O\n"
                    + "        O O O O O\n"
                    + "        O O O O O\n"
                    + "        O O O O O\n"
                    + "O O O O O O O O O O O O O\n"
                    + "O O O O O O O O O O O O O\n"
                    + "O O O O O O _ O O O O O O\n"
                    + "O O O O O O O O O O O O O\n"
                    + "O O O O O O O O O O O O O\n"
                    + "        O O O O O\n"
                    + "        O O O O O\n"
                    + "        O O O O O\n"
                    + "        O O O O O");
  }

  @Test
  public void testFourToString() {
    EnglishSolitaireModel constructor4 = new EnglishSolitaireModel(5, 2, 4);
    MarbleSolitaireTextView four = new MarbleSolitaireTextView(constructor4);
    assertEquals(four.toString(),
            "        O O O O O\n"
                    + "        O O O O O\n"
                    + "        _ O O O O\n"
                    + "        O O O O O\n"
                    + "O O O O O O O O O O O O O\n"
                    + "O O O O O O O O O O O O O\n"
                    + "O O O O O O O O O O O O O\n"
                    + "O O O O O O O O O O O O O\n"
                    + "O O O O O O O O O O O O O\n"
                    + "        O O O O O\n"
                    + "        O O O O O\n"
                    + "        O O O O O\n"
                    + "        O O O O O");
  }

  @Test
  public void testFiveToString() {
    EnglishSolitaireModel constructor5 = new EnglishSolitaireModel(0, 4);
    MarbleSolitaireTextView five = new MarbleSolitaireTextView(constructor5);
    assertEquals(five.toString(),
            "    O O _\n"
                    + "    O O O\n"
                    + "O O O O O O O\n"
                    + "O O O O O O O\n"
                    + "O O O O O O O\n"
                    + "    O O O\n"
                    + "    O O O");
  }

  @Test
  public void testSixToString() {
    EnglishSolitaireModel constructor6 = new EnglishSolitaireModel(5, 8, 12);
    MarbleSolitaireTextView six = new MarbleSolitaireTextView(constructor6);
    assertEquals(six.toString(),
            "        O O O O O\n"
                    + "        O O O O O\n"
                    + "        O O O O O\n"
                    + "        O O O O O\n"
                    + "O O O O O O O O O O O O O\n"
                    + "O O O O O O O O O O O O O\n"
                    + "O O O O O O O O O O O O O\n"
                    + "O O O O O O O O O O O O O\n"
                    + "O O O O O O O O O O O O _\n"
                    + "        O O O O O\n"
                    + "        O O O O O\n"
                    + "        O O O O O\n"
                    + "        O O O O O");
  }

  @Test (expected = IllegalArgumentException.class)
  public void testNullToString() {
    new MarbleSolitaireTextView(null);
  }

  @Test
  public void testRenderMessage() throws IOException {
    EnglishSolitaireModel constructor1 = new EnglishSolitaireModel();
    MarbleSolitaireTextView one = new MarbleSolitaireTextView(constructor1);
    one.renderMessage("Hi");
    assertEquals(one.destination.toString(), "java.io.PrintStream@6b57696f");
  }

  // prints "" to the console
  @Test
  public void testRenderMessageEmpty() throws IOException {
    EnglishSolitaireModel constructor1 = new EnglishSolitaireModel();
    MarbleSolitaireTextView one = new MarbleSolitaireTextView(constructor1);
    one.renderMessage("");
    assertEquals(one.destination.toString(), "java.io.PrintStream@6b57696f");
  }

  // prints "-5" to the console, the checking doesn't happen here so it should print
  @Test
  public void testRenderMessageInvalid() throws IOException {
    EnglishSolitaireModel constructor1 = new EnglishSolitaireModel();
    MarbleSolitaireTextView one = new MarbleSolitaireTextView(constructor1);
    one.renderMessage("-5");
    assertEquals(one.destination.toString(), "java.io.PrintStream@6b57696f");
  }

  // prints the state of the board to the console
  @Test
  public void testRenderBoard() throws IOException {
    EnglishSolitaireModel constructor1 = new EnglishSolitaireModel();
    MarbleSolitaireTextView one = new MarbleSolitaireTextView(constructor1);
    one.renderBoard();
    assertEquals(one.destination.toString(), "java.io.PrintStream@6b57696f");
  }

  @Test
  public void testEuropeanOneToString() {
    EuropeanSolitaireModel constructor1 = new EuropeanSolitaireModel(5);
    MarbleSolitaireTextView one = new MarbleSolitaireTextView(constructor1);
    assertEquals("        O O O O O\n" +
            "      O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O _ O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "      O O O O O O O\n" +
            "        O O O O O", one.toString());
  }

  @Test
  public void testEuropeanTwoToString() {
    EuropeanSolitaireModel constructor1 = new EuropeanSolitaireModel(3, 2, 2);
    MarbleSolitaireTextView one = new MarbleSolitaireTextView(constructor1);
    assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O O _ O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O", one.toString());
  }

  @Test
  public void testEuropeanOneToStringAfterOneMove() {
    EuropeanSolitaireModel constructor1 = new EuropeanSolitaireModel(5);
    MarbleSolitaireTextView one = new MarbleSolitaireTextView(constructor1);
    constructor1.move(8, 6, 6, 6);
    assertEquals("        O O O O O\n" +
            "      O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O _ O O O O O O\n" +
            "O O O O O O _ O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "      O O O O O O O\n" +
            "        O O O O O", one.toString());
  }

  @Test
  public void testETwoToString() {
    EuropeanSolitaireModel constructor1 = new EuropeanSolitaireModel();
    MarbleSolitaireTextView one = new MarbleSolitaireTextView(constructor1);
    constructor1.move(5, 3, 3, 3);
    assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "  O O _ O O\n" +
            "    O O O", one.toString());
  }

  @Test
  public void testETwoToString1() {
    EuropeanSolitaireModel newConstructor = new EuropeanSolitaireModel(3);
    MarbleSolitaireTextView ten = new MarbleSolitaireTextView(newConstructor);

    newConstructor.move(3, 5, 3, 3);
    newConstructor.move(3, 2, 3, 4);
    newConstructor.move(3, 0, 3, 2);
    newConstructor.move(5, 3, 3, 3);
    newConstructor.move(2, 3, 4, 3);
    newConstructor.move(0, 3, 2, 3);
    newConstructor.move(1, 1, 1, 3);
    newConstructor.move(5, 1, 5, 3);
    newConstructor.move(1, 4, 1, 2);
    newConstructor.move(5, 4, 5, 2);
    newConstructor.move(3, 4, 1, 4);
    newConstructor.move(0, 4, 2, 4);
    newConstructor.move(1, 5, 3, 5);
    newConstructor.move(2, 3, 2, 5);
    newConstructor.move(3, 6, 3, 4);
    newConstructor.move(2, 6, 2, 4);
    newConstructor.move(3, 4, 1, 4);
    newConstructor.move(5, 5, 3, 5);
    newConstructor.move(4, 3, 4, 5);
    newConstructor.move(4, 6, 4, 4);
    newConstructor.move(2, 1, 2, 3);
    newConstructor.move(4, 1, 4, 3);
    newConstructor.move(4, 4, 4, 2);
    newConstructor.move(0, 2, 2, 2);
    newConstructor.move(3, 2, 1, 2);
    newConstructor.move(5, 2, 3, 2);
    assertEquals("    _ _ _\n" +
            "  _ O _ O _\n" +
            "O _ _ O _ _ _\n" +
            "_ _ O _ _ O _\n" +
            "O _ _ _ _ _ _\n" +
            "  _ _ _ _ _\n" +
            "    O O O", ten.toString());
  }

  @Test
  public void testTOneToString() {
    TriangleSolitaireModel constructor1 = new TriangleSolitaireModel();
    TriangleSolitaireTextView one = new TriangleSolitaireTextView(constructor1);
    assertEquals("    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O", one.toString());
  }

  @Test
  public void testTTwoToString() {
    TriangleSolitaireModel constructor1 = new TriangleSolitaireModel(8);
    TriangleSolitaireTextView one = new TriangleSolitaireTextView(constructor1);
    assertEquals("       _\n" +
            "      O O\n" +
            "     O O O\n" +
            "    O O O O\n" +
            "   O O O O O\n" +
            "  O O O O O O\n" +
            " O O O O O O O\n" +
            "O O O O O O O O", one.toString());
  }

  @Test
  public void testTriThreeToString() {
    TriangleSolitaireModel constructor1 = new TriangleSolitaireModel(6, 3, 3);
    TriangleSolitaireTextView one = new TriangleSolitaireTextView(constructor1);
    assertEquals("     O\n" +
            "    O O\n" +
            "   O O O\n" +
            "  O O O _\n" +
            " O O O O O\n" +
            "O O O O O O", one.toString());
  }

  @Test
  public void testTriFourToString() {
    TriangleSolitaireModel constructor1 = new TriangleSolitaireModel(8, 5, 5);
    TriangleSolitaireTextView one = new TriangleSolitaireTextView(constructor1);
    assertEquals("       O\n" +
            "      O O\n" +
            "     O O O\n" +
            "    O O O O\n" +
            "   O O O O O\n" +
            "  O O O O O _\n" +
            " O O O O O O O\n" +
            "O O O O O O O O", one.toString());
  }

  @Test
  public void testTriAfterOneMove() {
    TriangleSolitaireModel constructor1 = new TriangleSolitaireModel();
    TriangleSolitaireTextView one = new TriangleSolitaireTextView(constructor1);
    constructor1.move(2, 0, 0, 0);
    assertEquals("    O\n" +
            "   _ O\n" +
            "  _ O O\n" +
            " O O O O\n" +
            "O O O O O", one.toString());
  }

  @Test
  public void testTriAfterTwMoves() {
    TriangleSolitaireModel constructor1 = new TriangleSolitaireModel();
    TriangleSolitaireTextView one = new TriangleSolitaireTextView(constructor1);
    constructor1.move(2, 0, 0, 0);
    constructor1.move(2, 2, 2, 0);
    assertEquals("    O\n" +
            "   _ O\n" +
            "  O _ _\n" +
            " O O O O\n" +
            "O O O O O", one.toString());
  }
}
