package lv_427.logic.dmytro_dovhal;

import java.util.Arrays;
import java.util.Scanner;

import lv_427.logic.TaskExecutor;

/**
 * Class for sorting array by counting method.
 *
 * @author Dmytro Dovhal
 * @version 1.0
 */
public class CountingSorting implements TaskExecutor {
  private Scanner scanner;

  public CountingSorting() {
    this.scanner = new Scanner(System.in);
  }
  /** Method is for execute countingSorting function. */
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
        System.out.println("Invalid input length value, try again.");
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
              + Arrays.toString(countingSorting(arrayForSorting))
              + "\n"
              + "Do you want to quit? Press \'q\', else press any key...");
      String agreement = scanner.next();
      if (agreement.equalsIgnoreCase("q")) {
        break;
      }
    }
  }

  private int[] countingSorting(int[] arr) {
    if (arr.length < 2){
      return null;
    }
    int max = Arrays.stream(arr).max().getAsInt();
    int min = Arrays.stream(arr).min().getAsInt();
    int range = max - min + 1;
    int count[] = new int[range];
    int output[] = new int[arr.length];
    for (int i = 0; i < arr.length; i++) {
      count[arr[i] - min]++;
    }

    for (int i = 1; i < count.length; i++) {
      count[i] += count[i - 1];
    }

    for (int i = arr.length - 1; i >= 0; i--) {
      output[count[arr[i] - min] - 1] = arr[i];
      count[arr[i] - min]--;
    }

    for (int i = 0; i < arr.length; i++) {
      arr[i] = output[i];
    }
    return output;
  }
}
