import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import java.math.BigInteger;
import org.junit.jupiter.api.Test;

/**
 * Tests of Sorter objects.
 *
 * @author Your Name
 */
public class SortTester {

  // +---------+-----------------------------------------------------
  // | Globals |
  // +---------+

  Sorter sorter;

  // +-------+-------------------------------------------------------
  // | Tests |
  // +-------+

  @Test
  public void fakeTest() {
    assertTrue(true);
  } // fakeTest()

  @Test
  public void orderedStringTest() {
    String[] original = { "alpha", "bravo", "charlie", "delta", "foxtrot" };
    String[] expected = original.clone();
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // orderedStringTest

  @Test
  public void reverseOrderedStringTest() {
    String[] original = { "foxtrot", "delta", "charlie", "bravo", "alpha" };
    String[] expected = { "alpha", "bravo", "charlie", "delta", "foxtrot" };
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // orderedStringTest

  @Test
  public void emptyStringTest() {
    String[] original = { "" };
    String[] expected = { "" };
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // emptyStringTest

  @Test
  public void sameStringTest() {
    String[] original = { "same", "same", "same" };
    String[] expected = { "same", "same", "same" };
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // orderedStringTest

  @Test
  public void orderedNumberTest() {
    Integer[] original = { 1, 2, 3, 4, 5, 6, 7, 8 };
    Integer[] expected = { 1, 2, 3, 4, 5, 6, 7, 8 };
    sorter.sort(original, (x, y) -> x == y ? 0 : x < y ? -1 : 1);
    assertArrayEquals(original, expected);
  } // orderedNumberTest

  @Test
  public void noOrderNumberTest() {
    Integer[] original = { 1, 5, 2, 7, 8, 6, 3, 4 };
    Integer[] expected = { 1, 2, 3, 4, 5, 6, 7, 8 };
    sorter.sort(original, (x, y) -> x == y ? 0 : x < y ? -1 : 1);
    assertArrayEquals(original, expected);
  } // noOrderNumberTest

  @Test
  public void emptyTest() {
    Integer[] original = {};
    Integer[] expected = {};
    sorter.sort(original, (x, y) -> x == y ? 0 : x < y ? -1 : 1);
    assertArrayEquals(original, expected);
  } // emptyTest

  @Test
  public void repeatedNumberTest() {
    Integer[] original = { 1, 4, 4, 5, 1, 5, 6, 3, 6, 3};
    Integer[] expected = { 1, 1, 3, 3, 4, 4, 5, 5, 6, 6};
    sorter.sort(original, (x, y) -> x == y ? 0 : x < y ? -1 : 1);
    assertArrayEquals(original, expected);
  } // noOrderNumberTest

  @Test
  public void oneNumberTest() {
    Integer[] original = { 1 };
    Integer[] expected = { 1 };
    sorter.sort(original, (x, y) -> x == y ? 0 : x < y ? -1 : 1);
    assertArrayEquals(original, expected);
  } // oneNumberTest
} // class SortTester
