package lv_427.logic.rostyslav_khasanov;

import lv_427.logic.TaskExecutor;

import java.util.Arrays;
import java.util.Scanner;

/**
 * BucketSort
 *
 * @author Rostyslav Khasanov
 * @version 1.0
 */
public class BucketSort implements TaskExecutor {

  /** Executable method. */
  public void execute() {
    Scanner sc = new Scanner(System.in);
    /** Array for int elements */
    int[] array;
    /** Array size */
    int size = 0;
    System.out.println("Enter size of array: ");

    while (true) {
      try {
        size = Integer.parseInt(sc.nextLine());
        if (size < 2) {
          System.out.println("Enter only positive numbers from 2");
        } else {

          array = getRandomArray(size);
          System.out.println(Arrays.toString(bucketSort(array, getLargestNumber(array))));
          break;
        }
      } catch (NumberFormatException e) {
        System.out.println("Enter only positive numbers from 2");
      }
    }
  }

  /**
   * Method is for bucket sort
   *
   * @param a is array of integers.
   * @param maxVal is max value in array.
   * @return returns a sort array.
   */
  private int[] bucketSort(int[] a, int maxVal) {
    int[] bucket = new int[maxVal + 1];

    for (int i = 0; i < bucket.length; i++) {
      bucket[i] = 0;
    }

    for (int i = 0; i < a.length; i++) {
      bucket[a[i]]++;
    }

    int outPos = 0;
    for (int i = 0; i < bucket.length; i++) {
      for (int j = 0; j < bucket[i]; j++) {
        a[outPos++] = i;
      }
    }
    return a;
  }

  /**
   * Method is for find largest number in array
   *
   * @param arr is array of integers.
   * @return returns largest number in array.
   */
  private int getLargestNumber(int[] arr) {
    int temp;
    int size = arr.length;
    for (int i = 0; i < size; i++) {
      for (int j = i + 1; j < size; j++) {
        if (arr[i] > arr[j]) {
          temp = arr[i];
          arr[i] = arr[j];
          arr[j] = temp;
        }
      }
    }
    return arr[size - 1];
  }

  /**
   * Method is for generate random array of integers.
   *
   * @param arrSize is size of array.
   * @return returns array of integers.
   */
  private int[] getRandomArray(int arrSize) {
    int[] list = new int[arrSize];
    for (int i = 0; i < arrSize; i++) {
      int n = (int) (Math.random() * 9 + 1);
      list[i] = n;
    }
    return list;
  }
}
