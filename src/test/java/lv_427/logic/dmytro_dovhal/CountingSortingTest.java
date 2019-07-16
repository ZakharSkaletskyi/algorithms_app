package lv_427.logic.dmytro_dovhal;

import mockit.Deencapsulation;
import org.junit.Before;
import org.junit.Test;

/**
 * CountingSorting Test.
 *
 * @author Dmytro Dovhal
 * @version 1.0
 */
import static org.junit.Assert.*;

public class CountingSortingTest {

  private CountingSorting countingSorting;
  /** Init method. */
  @Before
  public void init() {
    countingSorting = new CountingSorting();
  }
  /** Method: countingSorting(int[] array) has to return sorted array */
  @Test
  public void countingSortingTest() {
    final int[] inputArray = new int[] {21, 45, 78, 1, 4, 9};
    final int[] sorted = new int[] {1, 4, 9, 21, 45, 78};
    int[] invoke = Deencapsulation.invoke(countingSorting, "countingSorting", (Object) inputArray);
    assertArrayEquals(sorted, invoke);
  }
  /** Method: countingSorting(int[] array) has to return null when parameter array length < 2 */
  @Test
  public void countingSortingReturnNull() {
    int[] inputArray = new int[] {1};
    int[] invoke = Deencapsulation.invoke(countingSorting, "countingSorting", (Object) inputArray);
    assertArrayEquals(null, invoke);
  }
}
