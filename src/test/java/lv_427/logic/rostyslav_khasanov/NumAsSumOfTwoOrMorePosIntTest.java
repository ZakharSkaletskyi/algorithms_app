package lv_427.logic.rostyslav_khasanov;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

/**
 * NumAsSumOfTwoOrMorePosInt Tester.
 *
 * @author Roman Zahorui
 * @since
 *     <pre>July 13, 2019</pre>
 *
 * @version 1.0
 */
public class NumAsSumOfTwoOrMorePosIntTest {

  /** Method: countWays(int n) */
  @Test
  public void countWaysHasToReturnSix() {
    final NumAsSumOfTwoOrMorePosInt testClass = new NumAsSumOfTwoOrMorePosInt();
    Assert.assertEquals(6, testClass.countWays(5));
  }

  /** Method: countWays(int n) */
  @Test
  public void countWaysHasToReturnOne() {
    final NumAsSumOfTwoOrMorePosInt testClass = new NumAsSumOfTwoOrMorePosInt();
    Assert.assertEquals(1, testClass.countWays(0));
  }

  /** Method: countWays(int n) */
  @Test(expected = ArrayIndexOutOfBoundsException.class)
  public void countWaysHasToReturnOneAgain() {
    final NumAsSumOfTwoOrMorePosInt testClass = new NumAsSumOfTwoOrMorePosInt();
    testClass.countWays(-1);
  }
}
