package lv_427.logic.roman_zahorui;

import mockit.Deencapsulation;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Class is for testing PaintingFence class.
 *
 * @author Nazar Stasyuk
 * @version 1.0
 */
public class PaintingFenceTest {

  private PaintingFence paintingFence;

  /**
   * Init method.*/
  @Before
  public void init() {
    this.paintingFence = new PaintingFence();
  }

  /** Method for testing countWays method */
  @Test
  public void countWays() {

    long invoke = Deencapsulation.invoke(paintingFence, "countWays", 2, 4);

    assertEquals(invoke, 16L);
  }

  /** Method for testing parseStringToSize method */
  @Test
  public void parseStringToSize() {

    int[] invoke = Deencapsulation.invoke(paintingFence, "parseStringToSize", "3 x 3");
    int[] testArray = {3, 3};
    for (int i = 0; i < invoke.length; i++) {
      assertEquals(invoke[i], testArray[i]);
    }
  }

  /** Method for testing exception in parseStringToSize method */
  @Test(expected = NumberFormatException.class)
  public void parseStringToSizeException() {
    Deencapsulation.invoke(paintingFence, "parseStringToSize", "x x 3");
  }
}
