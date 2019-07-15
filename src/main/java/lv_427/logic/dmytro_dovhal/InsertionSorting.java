package lv_427.logic.dmytro_dovhal;

import java.util.Arrays;
import java.util.Scanner;
import lv_427.logic.TaskExecutor;

/**
 * Class for sorting array by insertion method.
 *
 * @author Dmytro Dovhal
 * @version 1.0
 */
public class InsertionSorting implements TaskExecutor {
  private Scanner scanner;

  public InsertionSorting() {
    this.scanner = new Scanner(System.in);
  }
  /** Method is for execute insertionSorting function. */
  public void execute() {
    while (true) {
      System.out.println("Input length of array: ");
      int amountOfElements;

      try {
        amountOfElements = Integer.valueOf(scanner.next());
        if (amountOfElements <= 0) {
          System.out.println("Invalid input length value, try again");
          continue;
        }
      } catch (Exception ex) {
        System.out.println("Invalid input length value, try again. ");
        continue;
      }

      int arrayForSorting[] = new int[amountOfElements];
      System.out.println(
          "Input elements of your array, please use \'Enter\' key after every your input ");

      for (int i = 0; i < amountOfElements; ) {
        try {
          arrayForSorting[i] = Integer.valueOf(scanner.next());
          i++;
        } catch (NumberFormatException ex) {
          System.out.println("Please input just numeric value of element");
        }
      }

      System.out.println(
          "Not sorted array: "
              + Arrays.toString(arrayForSorting)
              + "\n"
              + "Sorted array: "
              + Arrays.toString(insertionSorting(arrayForSorting))
              + "Do you want to quit? Press \'q\', else press any key...");
      String agreement = scanner.next();
      if (agreement.equalsIgnoreCase("q")) {
        break;
      }
    }
  }

  private int[] insertionSorting(int array[]) {

    int n = array.length;
    for (int i = 1; i < n; ++i) {
      int key = array[i];
      int j = i - 1;

      while (j >= 0 && array[j] > key) {
        array[j + 1] = array[j];
        j = j - 1;
      }
      array[j + 1] = key;
    }
    return array;
  }
}
