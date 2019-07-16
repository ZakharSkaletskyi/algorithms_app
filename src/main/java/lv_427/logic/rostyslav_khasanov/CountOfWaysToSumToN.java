package lv_427.logic.rostyslav_khasanov;

import lv_427.exceptions.IncorrectValueException;
import lv_427.logic.TaskExecutor;

import java.util.Scanner;

/**
 * Ways to sum to N using array elements with repetition
 *
 * <p>The goal: To find how many ways we have to represent one number with a given array of numbers
 *
 * @author Rostyslav Khasanov
 * @version 1.0
 */
public class CountOfWaysToSumToN implements TaskExecutor {

  /** Executable method. */
  public void execute() {
    Scanner sc = new Scanner(System.in);
    String str;
    int number = 0;
    /** Array for string elements */
    String strArr[];
    /** Array with integers, which consist elements of strArr after parse */
    int numbers[];

    System.out.println("Enter array of positive numbers like '1 5 2 12 1': ");
    for (; ; ) {
      str = sc.nextLine();
      strArr = str.split(" ");
      numbers = new int[strArr.length];
      try {
        for (int i = 0; i < strArr.length; i++) {
          numbers[i] = Integer.parseInt(strArr[i]);
          if (numbers[i] < 0) {
            throw new IncorrectValueException("Just positive numbers!");
          }
        }
        break;
      } catch (NumberFormatException e) {
        System.out.println("Only positive numbers in array like '1 22 4 3' !");
      } catch (IncorrectValueException e) {
        System.out.println(e.getMessage());
      }
    }
    System.out.println("Enter positive number :");
    for (; ; ) {
      try {
        number = Integer.parseInt(sc.nextLine());
        if (number < 0) {
          throw new IncorrectValueException("Just positive numbers!");
        }
        break;
      } catch (NumberFormatException e) {
        System.out.println("Enter just one positive number!");
      } catch (IncorrectValueException e) {
        System.out.println(e.getMessage());
      }
    }

    System.out.println(countWays(numbers, number));
  }

  /**
   * Method is for find how many ways we have to represent one number with a given array of numbers
   *
   * @param n is one entered positive number
   * @param arr is array of numbers.
   * @return returns a number that means how many ways we have to represent one number with a given
   *     array of numbers integers.
   */
  private int countWays(int[] arr, int n) {
    int mas[] = arr;
    int count[] = new int[n + 1];
    int m = arr.length;
    count[0] = 1;
    for (int i = 1; i <= n; i++) {
      for (int j = 0; j < m; j++) {
        if (i >= mas[j]) {
          count[i] += count[i - mas[j]];
        }
      }
    }
    return count[n];
  }
}
