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
    /**
     * Scanner for reading from console.
     */
    private Scanner sc;

    public HighEffortLowEffort() {
        this.sc = new Scanner(System.in);
    }

    /**
     * @param days - quantity of days
     * @param high - range of max tasks
     * @param low - range of low tasks
     */
    private int days;
    private int[] high;
    private int[] low;

    /**
     * @return - Returns the maximum among the 2 numbers
     */
    private int max(int x, int y) {
        return (x > y ? x : y);
    }

    /**
     * Request the input data statements in user:
     * day,high tasks,low tasks
     */
    private void requestStatements() {
        System.out.println("Enter the period(in days):");
        days = sc.nextInt();

        System.out.println("Enter amount of the high effort task:");
        high = new int[days];

        for (int i = 0; i < days; i++) {
            high[i] = sc.nextInt();
        }
        System.out.println("Enter amount of the low effort task:");
        low = new int[days];

        for (int i = 0; i < days; i++) {
            low[i] = sc.nextInt();
        }
    }

    /**
     * Returns maximum amount of task that can be
     * done till days
     */
    private int maxTasks() {
        // An array task_dp that stores the maximum
        // task done
        int[] task_dp = new int[days + 1];

        // If days = 0, no solution exists
        task_dp[0] = 0;

        // If days = 1, high effort task on that day will
        // be the solution
        task_dp[1] = high[0];

        // Fill the entire array determining which
        // task to choose on day i
        for (int i = 2; i <= days; i++)
            task_dp[i] = Math.max(high[i - 1] + task_dp[i - 2],
                    low[i - 1] + task_dp[i - 1]);
        return task_dp[days];
    }


    /**
     * Method is for execute finding process.
     */
    public void execute() {

        try {
            requestStatements();
            System.out.println("Maximum amount of tasks you can perform within these " + days + " days is " + maxTasks());

        } catch (Exception ex) {
            System.out.println("You have to input an integer\n");
        }
    }
}
