package lv_427.logic.nazar_stasyuk;

import lv_427.exceptions.BadSizeOfArrayException;
import mockit.Deencapsulation;
import mockit.Tested;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * MergeSort Test.
 *
 * @author Rostyslav Khasanov
 * @version 1.0
 */
public class MergeSortTest {

  @Tested private MergeSort mergeSort;

  @Before
  public void init() {
    mergeSort = new MergeSort();
  }

  /** Method: mergeSort(int[] array, int size) */
  @Test
  public void mergeSortTest() {
    final int[] arr = {9, 12, 1, 4, 2, 10, 7, 8};
    int[] sortedArray = Deencapsulation.invoke(mergeSort, "mergeSort", arr, 6);
    Assert.assertEquals(arr, sortedArray);
  }

  /** Method: fillArray(int size) has to throw BadSizeOfArrayException when parameter size < 0 */
  @Test(expected = BadSizeOfArrayException.class)
  public void mergeSortExceptionTest() throws Exception {
    int[] arr = Deencapsulation.invoke(mergeSort, "fillArray", -20);
  }

  /** Method: mergeSort(int[] array, int size) has to return null when parameter size < 2 */
  @Test
  public void mergeSortNullTest() {
    final int[] arr = {9, 12, 1, 4, 2, 10, 7, 8};
    int[] sortedArray = Deencapsulation.invoke(mergeSort, "mergeSort", arr, 1);
    Assert.assertEquals(null, sortedArray);
  }
}
