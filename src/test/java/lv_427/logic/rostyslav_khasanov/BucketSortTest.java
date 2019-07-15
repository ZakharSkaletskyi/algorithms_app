package lv_427.logic.rostyslav_khasanov;

import mockit.Deencapsulation;
import mockit.Tested;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * BucketSort Test.
 *
 * @author Rostyslav Khasanov
 * @version 1.0
 */
public class BucketSortTest {

  @Tested private BucketSort bucketSort;

  @Before
  public void init() {
    bucketSort = new BucketSort();
  }

  /** Method: bucketSort(int[] array, int maxVal) */
  @Test
  public void bucketSortTest() {
    final int[] arrayBefore = {5, 3, 0, 2, 4, 1, 0, 5, 2, 3, 1, 4};
    final int[] arrayAfter = {0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5};
    int[] sortedArray = Deencapsulation.invoke(bucketSort, "bucketSort", arrayBefore, 5);
    Assert.assertArrayEquals(arrayAfter, sortedArray);
  }

  /** Method: getLargestNumber(int[] array) */
  @Test
  public void getLargestNumberTest() {
    final int[] array = {5, 3, 0, 2, 4, 1, 0, 5, 2, 3, 1, 4};
    int largestNumber = Deencapsulation.invoke(bucketSort, "getLargestNumber", array);
    Assert.assertEquals(5, largestNumber);
  }
}
