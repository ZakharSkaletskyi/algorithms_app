package lv_427.logic.roman_zahorui;

import lv_427.exceptions.IncorrectValueException;
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

  /** Init method. */
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

  /** Method for testing exception in countWays method*/
  @Test(expected = IncorrectValueException.class)
  public void countWaysWithMinus() {
    long invoke = Deencapsulation.invoke(paintingFence, "countWays", -1, -3);
    //assertEquals(invoke, 16L);
  }
}
