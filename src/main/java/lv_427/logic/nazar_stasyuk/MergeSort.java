package lv_427.logic.nazar_stasyuk;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import lv_427.exceptions.BadSizeOfArrayException;
import lv_427.logic.TaskExecutor;

/**
 * Description: class is for demo how merge sort works(It shows details when you input size 16 or
 * less).
 *
 * @author Nazar Stasyuk
 * @version 1.0
 */
public class MergeSort implements TaskExecutor {
  private final int maxRandomInt = 50;
  private final int minSizeToShowLogs = 16;
  private Scanner sc;
  private int size;

  public MergeSort() {
    this.sc = new Scanner(System.in);
  }

  /** Executable method. */
  public void execute() {
    String input;
    while (true) {
      System.out.println("Input a size of your array or \'q\' to exit");
      input = sc.nextLine();

      if (input.equalsIgnoreCase("q")) {
        break;
      }

      try {
        size = Integer.valueOf(input);
      } catch (Exception c) {
        System.out.println("You have to write size(integer)!");
        continue;
      }
      if (size > 0) {
        int[] array = fillArray(size);
        System.out.println("Array before sort: " + Arrays.toString(array));
        int[] sortedArray = mergeSort(array, size);
        System.out.println("Array after sort: " + Arrays.toString(sortedArray));
      } else {
        System.out.println("Your size has to be only positive!");
      }
    }
  }

  /**
   * Method that use recursion to divide array into pieces(that is a logic of merge sort).
   *
   * @param array - is an array that will be sorted
   * @param size - is a size of sorted array
   */
  private int[] mergeSort(int[] array, int size) {
    if (size < 2) {
      return null;
    }
    int midOfArray = size / 2;
    int[] leftArray = new int[midOfArray];
    int[] rightArray = new int[size - midOfArray];

    for (int i = 0; i < midOfArray; i++) {
      leftArray[i] = array[i];
    }
    for (int i = midOfArray; i < size; i++) {
      rightArray[i - midOfArray] = array[i];
    }
    if (this.size <= minSizeToShowLogs) {
      System.out.println(
          "Left array: "
              + Arrays.toString(leftArray)
              + "; Right array: "
              + Arrays.toString(rightArray)
              + ";");
    }
    // here i use recursion to divide left part of array
    mergeSort(leftArray, midOfArray);
    // here i use recursion to divide right part of array
    mergeSort(rightArray, size - midOfArray);

    merge(array, leftArray, rightArray, midOfArray, size - midOfArray);
    return array;
  }

  /**
   * This method used for sort left and right part of arrays.
   *
   * @param array - list that will get sorted part.
   * @param leftArray - left part of array.
   * @param rightArray - right part of array.
   * @param sizeOfLeftArray - size of left part of array.
   * @param sizeOfRightArray - size of right part of array.
   */
  private void merge(
      int[] array, int[] leftArray, int[] rightArray, int sizeOfLeftArray, int sizeOfRightArray) {

    int indexOfLeftArray = 0;
    int indexOfRightArray = 0;
    int indexOfArray = 0;

    while (indexOfLeftArray < sizeOfLeftArray && indexOfRightArray < sizeOfRightArray) {

      if (leftArray[indexOfLeftArray] <= rightArray[indexOfRightArray]) {
        array[indexOfArray++] = leftArray[indexOfLeftArray++];
      } else {
        array[indexOfArray++] = rightArray[indexOfRightArray++];
      }
    }
    while (indexOfLeftArray < sizeOfLeftArray) {
      array[indexOfArray++] = leftArray[indexOfLeftArray++];
    }
    while (indexOfRightArray < sizeOfRightArray) {
      array[indexOfArray++] = rightArray[indexOfRightArray++];
    }
  }

  /**
   * This method used to fill array with random numbers.
   *
   * @param size - size of array.
   */
  private int[] fillArray(int size) {
    if (!(size > 0)) {
      throw new BadSizeOfArrayException("Size has to be only positive! Not " + size + ".");
    }
    int[] array = new int[size];
    for (int i = 0; i < size; i++) {
      array[i] = new Random().nextInt(maxRandomInt);
    }
    return array;
  }
}
