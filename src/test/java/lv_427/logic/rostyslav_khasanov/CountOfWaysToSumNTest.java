package lv_427.logic.rostyslav_khasanov;

import mockit.Deencapsulation;
import mockit.Tested;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * CountOfWaysToSumToN Test.
 *
 * @author Roman Zahorui
 * @version 1.0
 */
public class CountOfWaysToSumNTest {

  @Tested private CountOfWaysToSumToN testClass;

  @Before
  public void init() {
    testClass = new CountOfWaysToSumToN();
  }

  /** Method: countWays(int[] arr, int n) correct use. */
  @Test
  public void countWaysShouldReturnSix() {
    final int[] arr = {1, 5, 6};
    int ways = Deencapsulation.invoke(testClass, "countWays", arr, 7);
    Assert.assertEquals(6, ways);
  }

  /**
   * Method: countWays(int[] arr, int n) should generate ArrayIndexOutOfBoundsException in case
   * where int[] arr argument contain some negative values.
   */
  @Test(expected = ArrayIndexOutOfBoundsException.class)
  public void countWaysNegativeValInArray() {
    final int[] arr = {1, 5, -6};
    Deencapsulation.invoke(testClass, "countWays", arr, 7);
  }

  /**
   * Method: countWays(int[] arr, int n) should generate NegativeArraySizeException in case where
   * int n argument is negative value.
   */
  @Test(expected = NegativeArraySizeException.class)
  public void countWaysNegativeRepresentedVal() {
    final int[] arr = {1, 5, 6};
    Deencapsulation.invoke(testClass, "countWays", arr, -7);
  }
}
