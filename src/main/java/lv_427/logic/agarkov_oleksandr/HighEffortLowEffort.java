package lv_427.logic.agarkov_oleksandr;

import java.util.Scanner;

import lv_427.logic.TaskExecutor;

/**
 * Class to find out for each day how much you could either perform a high effort tasks or a low
 * effort tasks.
 *
 * @author Oleksandr Agarkov
 * @version 1.0
 */
public class HighEffortLowEffort implements TaskExecutor {
  /** Scanner for reading from console. */
  private Scanner sc;

  private HighEffortLowEffort() {
    this.sc = new Scanner(System.in);
  }

  /** @return - Returns the maximum among the 2 numbers */
  private static int max(int x, int y) {
    return (x > y ? x : y);
  }

  /** Method is for execute finding process. */
  public void execute() {
    /**
     * @param days - quantity of days
     * @param high - range of max tasks
     * @param low - range of low tasks
     */
    try {
      System.out.println("Enter the period(in days):");
      int days = sc.nextInt();

      System.out.println("Enter amount of the high effort task:");
      int[] high = new int[days];

      for (int i = 0; i < days; i++) {
        high[i] = sc.nextInt();
      }
      System.out.println("Enter amount of the low effort task:");
      int[] low = new int[days];

      for (int i = 0; i < days; i++) {
        low[i] = sc.nextInt();
      }
      /** An array task_dp that stores the maximum task done */
      int[] task_dp = new int[days + 1];

      /** If n = 0, no solution exists */
      task_dp[0] = 0;

      /** If n = 1, high effort task on that day will be the solution */
      task_dp[1] = high[0];

      /** Fill the entire array determining which task to choose on day i */
      for (int i = 2; i <= days; i++) {
        task_dp[i] = max(high[i - 1] + task_dp[i - 2], low[i - 1] + task_dp[i - 1]);
        System.out.println(task_dp[days]);
      }
    } catch (Exception ex) {
      System.out.println("You have to input an integer\n");
    }
  }
}
