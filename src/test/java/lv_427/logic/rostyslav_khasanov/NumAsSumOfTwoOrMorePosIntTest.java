package lv_427.logic.rostyslav_khasanov;

import mockit.Deencapsulation;
import mockit.Tested;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * NumAsSumOfTwoOrMorePosIntTest Test.
 *
 * @author Roman Zahorui
 * @version 1.0
 */
public class NumAsSumOfTwoOrMorePosIntTest {

  @Tested private NumAsSumOfTwoOrMorePosInt testClass;

  @Before
  public void init() {
    testClass = new NumAsSumOfTwoOrMorePosInt();
  }

  /** Method: countWays(int n) correct use. For input = 5, output = 6 */
  @Test
  public void countWaysShouldReturnSix() {
    int ways = Deencapsulation.invoke(testClass, "countWays", 5);
    Assert.assertEquals(6, ways);
  }

  /**
   * Method: countWays(int n) should generate NegativeArraySizeException in case
   * where (int n) argument contains a negative value.
   */
  @Test(expected = NegativeArraySizeException.class)
  public void countWaysNegativeValueException() {
    Deencapsulation.invoke(testClass, "countWays", -5);
  }
}
