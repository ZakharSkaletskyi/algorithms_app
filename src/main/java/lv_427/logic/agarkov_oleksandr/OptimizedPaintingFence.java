package lv_427.logic.agarkov_oleksandr;

import java.util.Scanner;

import lv_427.logic.TaskExecutor;

/**
 * Class for finding the number of ways of painting the fence
 *
 * @author Oleksandr Agarkov
 * @version 1.0
 */

public class OptimizedPaintingFence implements TaskExecutor {
    /**
     * Scanner for reading from console.
     */
    public static Scanner sc;

    public OptimizedPaintingFence() {
        this.sc = new Scanner(System.in);
    }


    private static int posts;
    private static int colors;
    /**
     * Method is for ask the user about initialize parameters
     */
    private static void AskParametres ()
    {
        System.out.println("Enter a number of posts:");
        colors = sc.nextInt();
        System.out.println("Enter a number of colors:");
        posts = sc.nextInt();

    }
    private static long countWays  ()
    {
        // There are colors ways to color first post
        long total = (long) colors;
        int mod = 1000000007;

        // There are 0 ways for single post to
        // violate (same color_ and colors ways to
        // not violate (different color)
        int same = 0, diff = colors;

        // Fill for 2 posts onwards
        for (int i = 2; i <= posts; i++)
        {
            // Current same is same as previous diff
            same = diff;

            // We always have colors-1 choices for next post
            diff = (int)total * (colors - 1);
            diff = diff % mod;

            // Total choices till i.
            total = (same + diff) % mod;
        }
        return total;
    }
    /**
     * Method is for execute finding process.
     */
    public void execute() {

        try {
            AskParametres();
            System.out.println("There are" + countWays() + "possible ways of painting "+ posts + " posts with " + colors + " colors.");
        }catch (Exception exception)
        {
            System.out.println("Error");
        }

    }
}
