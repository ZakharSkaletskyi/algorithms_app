package lv_427.logic.dmytro_dovhal;

import mockit.Deencapsulation;
import org.junit.Before;
import org.junit.Test;

/**
 * InsertionSorting Test.
 *
 * @author Dmytro Dovhal
 * @version 1.0
 */
import static org.junit.Assert.*;

public class InsertionSortingTest {
  private InsertionSorting insertionSorting;
  /** Init method. */
  @Before
  public void init() {
    insertionSorting = new InsertionSorting();
  }

  /** Method: insertionSorting(int[] array) has to return sorted array */
  @Test
  public void insertionSortingTest() {
    int[] input = new int[] {1, 6, 7, 4, 2};
    int[] res = new int[] {1, 2, 4, 6, 7};
    int[] invoke = Deencapsulation.invoke(insertionSorting, "insertionSorting", (Object) input);
    assertArrayEquals(res, invoke);
  }
  /** Method: insertionSorting(int[] array) has to return null when parameter array length < 2 */
  @Test
  public void insertionSortingReturnNull() {
    int[] inputArray = new int[] {1};
    int[] invoke =
        Deencapsulation.invoke(insertionSorting, "insertionSorting", (Object) inputArray);
    assertArrayEquals(null, invoke);
  }
}
