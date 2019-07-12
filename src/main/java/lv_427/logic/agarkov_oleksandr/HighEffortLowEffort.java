package lv_427.logic.agarkov_oleksandr;

import java.util.Scanner;
import lv_427.logic.AlgorithmExecutor;

/**
 * Class to find out for each day how much you could either perform a high effort tasks or a low effort tasks.
 *
 * @author Oleksandr Agarkov
 * @version 1.0
 */
public class HighEffortLowEffort implements AlgorithmExecutor {
    /**
     * Scanner for reading from console.
     */
    private Scanner sc;

    public HighEffortLowEffort() {
        this.sc = new Scanner(System.in);
    }

    /**
     * Method is for execute finding process.
     */
    @Override
    public void execute() {

        // Returns maximum amount of task that can be
        // done till day n
        int n = 5;
        int []high = {3, 6, 8, 7, 6};
        int []low = {1, 5, 4, 5, 3};

        {
            // An array task_dp that stores the maximum
            // task done
            int[] task_dp = new int[n + 1];

            // If n = 0, no solution exists
            task_dp[0] = 0;

            // If n = 1, high effort task on that day will
            // be the solution
            task_dp[1] = high[0];

            // Fill the entire array determining which
            // task to choose on day i
            for (int i = 2; i <= n; i++)
                task_dp[i] = Math.max(high[i - 1] + task_dp[i - 2],
                        low[i - 1] + task_dp[i - 1]);
            // return task_dp[n];
        }
    }
}
