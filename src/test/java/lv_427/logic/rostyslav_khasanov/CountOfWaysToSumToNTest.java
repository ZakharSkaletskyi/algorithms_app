package lv_427.logic.rostyslav_khasanov;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
/**
 * CountOfWaysToSumToN Tester.
 *
 * @author Roman Zahorui
 * @since
 *     <pre>July 13, 2019</pre>
 *
 * @version 1.0
 */
public class CountOfWaysToSumToNTest extends TestSuite {

  private CountOfWaysToSumToN testClass;

  @Before
  public void before() {
    testClass = new CountOfWaysToSumToN();
  }

  /** Method: countWays(int[] arr, int n, int m) use with correct parameters. */
  @Test
  public void countWaysHasToReturnSix() {
    final int[] arr = new int[] {1, 5, 6};
    Assert.assertEquals(6, testClass.countWays(arr, 7, arr.length));
  }

  /**
   * Method: countWays(int[] arr, int n, int m) has to throw ArrayIndexOutOfBoundsException in case
   * where <code>int m</code> parameter is not equal to the length of the <code>int[] array</code>
   * parameter.
   */
  @Test(expected = ArrayIndexOutOfBoundsException.class)
  public void whenLengthParamMoreThenPassedArrayLength() {
    final int[] arr = new int[] {1, 5, 6};
    testClass.countWays(arr, 7, arr.length + 1);
  }

  /**
   * Method: countWays(int[] arr, int n, int m) has to throw ArrayIndexOutOfBoundsException in case
   * where <code>int[] array</code> parameter contains a negative integer parameter.
   */
  @Test(expected = ArrayIndexOutOfBoundsException.class)
  public void whenArrayContainsNegativeIntValueArrayBoundsException() {
    final int[] arr = new int[] {1, -5, 6};
    testClass.countWays(arr, 7, arr.length);
  }
}
