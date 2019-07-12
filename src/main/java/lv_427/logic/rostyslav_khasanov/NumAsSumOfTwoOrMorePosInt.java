package lv_427.logic.rostyslav_khasanov;

import lv_427.logic.TaskExecutor;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Ways to write n as sum of two or more positive integers
 *
 * <p>The goal: To find in how many ways is possible to calculate n with positive integers.
 *
 * @author Rostyslav Khasanov
 * @version 1.0
 */
public class NumAsSumOfTwoOrMorePosInt implements TaskExecutor {
  boolean check = true;

  /** Executable method.*/
  public void execute() {
    Scanner sc = new Scanner(System.in);

    while (check) {
      int number = 0;
      System.out.println("Enter one positive number:");
      while (check) {
        try {
          number = Integer.parseInt(sc.nextLine());
          check = false;
        } catch (Exception e) {
          System.out.println("Enter just one positive number!");
        }
      }
      check = true;
      System.out.println("Result: " + countWays(number) + "\n");
    }
  }

  /**
   * Method is for find how many ways is possible to calculate number n with positive integers.
   *
   * @param n is entered positive number.
   * @return returns a number that means how many ways is possible to calculate n with positive
   *     integers.
   */
  public int countWays(int n) {
    int table[] = new int[n + 1];
    Arrays.fill(table, 0);
    table[0] = 1;
    for (int i = 1; i < n; i++) {
      for (int j = i; j <= n; j++) {
        table[j] += table[j - i];
      }
    }
    check = false;
    return table[n];
  }
}
