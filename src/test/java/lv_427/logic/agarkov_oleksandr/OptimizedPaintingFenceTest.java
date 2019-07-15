package lv_427.logic.agarkov_oleksandr;

import mockit.Deencapsulation;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Class is for testing OptimizedPaintingFence class.
 *
 * @author Nazar Stasyuk
 * @version 1.0
 */
public class OptimizedPaintingFenceTest {

  /** Method for testing countWays method */
  @Test
  public void countWays() {
    OptimizedPaintingFence mock = new OptimizedPaintingFence();

    Deencapsulation.setField(mock, "posts", 2);
    Deencapsulation.setField(mock, "colors", 4);

    long result = Deencapsulation.invoke(mock, "countWays");
    assertEquals(result, 16);
  }
}
