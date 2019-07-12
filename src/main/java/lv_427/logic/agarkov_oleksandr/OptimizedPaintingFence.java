package lv_427.logic.agarkov_oleksandr;

import java.util.Scanner;
import lv_427.logic.AlgorithmExecutor;

/**
 * Class for finding the number of ways of painting the fence
 * @author Oleksandr Agarkov
 * @version 1.0
 */

public class OptimizedPaintingFence implements AlgorithmExecutor {
    /** Scanner for reading from console. */
    private Scanner sc;
    public OptimizedPaintingFence() {
        this.sc = new Scanner(System.in);
    }

    /**
     * Method is for execute finding process.
     */
    public void execute() {
        //
        int n,k;
        System.out.println("Enter a number of fence or \'q\' to exit :");
        k = sc.nextInt();
        System.out.println("Enter a number of fence or \'q\' to exit :");
        n = sc.nextInt();

        // There are k ways to color first post
        long total = k;
        int mod = 1000000007;

        // There are 0 ways for single post to
        // violate (same color_ and k ways to
        // not violate (different color)
        int same = 0, diff = k;

        // Fill for 2 posts onwards
        for (int i = 2; i <= n; i++)
        {
            // Current same is same as previous diff
            same = diff;

            // We always have k-1 choices for next post
            diff = (int)total * (k - 1);
            diff = diff % mod;

            // Total choices till i.
            total = (same + diff) % mod;
        }
         //return total;
    }
}
