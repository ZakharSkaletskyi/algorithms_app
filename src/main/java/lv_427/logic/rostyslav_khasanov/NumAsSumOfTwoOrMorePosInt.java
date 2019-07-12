package lv_427.logic.rostyslav_khasanov;

import lv_427.logic.AlgorithmExecutor;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Ways to write n as sum of two or more positive integers
 *
 * <p>The goal: To find in how many ways is possible to calculate n with positive integers.
 *
 * @version 1.0
 */
public class NumAsSumOfTwoOrMorePosInt implements AlgorithmExecutor {
  boolean check = true;

  public void execute() {
    Scanner sc = new Scanner(System.in);

    while (check) {
      int number = 0;
      System.out.println("Enter one positive number:");
      try {
        number = Integer.parseInt(sc.nextLine());
      } catch (NumberFormatException e) {
        System.out.println("Enter just positive number!!");
      }
      System.out.println("Result: " + countWays(number) + "\n");
    }
  }

  public int countWays(int n) {
    int table[] = new int[n + 1];
    Arrays.fill(table, 0);
    table[0] = 1;
    for (int i = 1; i < n; i++) {
      for (int j = i; j <= n; j++) {
        table[j] += table[j - i];
      }
    }
    System.out.println(Arrays.toString(table));
    check = false;
    return table[n];
  }
}
