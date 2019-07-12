package lv_427;

import lv_427.logic.TaskExecutor;
import lv_427.logic.kateryna_horokh.PalindromicSubsequence;
import lv_427.logic.marian_milian.IntrestingRow;
import lv_427.logic.marian_milian.ModificationFibonacci;
import lv_427.logic.nazar_stasyuk.Fibonacci;
import lv_427.logic.nazar_stasyuk.MergeSort;
import lv_427.logic.nazar_vladyka.LongestSubsequent;
import lv_427.logic.nazar_vladyka.PathsWithoutCrossing;
import lv_427.logic.roman_zahorui.PaintingFence;
import lv_427.logic.roman_zahorui.WaysTileFloor;
import lv_427.logic.rostyslav_khasanov.CountOfWaysToSumToN;
import lv_427.logic.rostyslav_khasanov.NumAsSumOfTwoOrMorePosInt;
import lv_427.logic.zakhar_skaletskyi.WaysToCoverIn3steps;
public class TaskFactory {

    public static final String MENU =
            "1\tFibonacci\n"
                    + "2\tModification Fibonacci\n"
                    + "3\tIntresting row\n"
                    + "4\tLongest subsequence with difference one\n"
                    + "5\tWays to sum to N using array elements with repetition\n"
                    + "6\tWays to write n as sum of two or more positive integers\n"
                    + "7\tWays to cover in 3 steps\n"
                    + "8\tPaths without crossing\n"
                    + "9\tWork to be with High-effort or with Low-effort\n"
                    + "10\tThe longest palindromic subsequence\n"
                    + "11\tFriend pairs\n"
                    + "12\tWays to tile the floor\n"
                    + "13\tPainting the fence\n"
                    + "14\tOptimized painting fence: use one variable instead of a table\n"
                    + "15\tInsertion Sort\n"
                    + "16\tCounting Sort\n"
                    + "17\tQuick Sort\n"
                    + "18\tBucket Sort\n"
                    + "19\tMerge Sort\n"
                    + "q\texit\n"
                    + "Input your choose: ";

    /**
     * This is factory for our tasks.
     *
     * @param numberOfTask - number of our tasks.
     * @return instance of our tasks
     */
    public static TaskExecutor getInstance(int numberOfTask) {
        TaskExecutor taskExecutor = null;
        switch (numberOfTask) {
            case 1:
                taskExecutor = new Fibonacci();
                break;
            case 2:
                taskExecutor = new ModificationFibonacci();
                break;
            case 3:
                taskExecutor = new IntrestingRow();
                break;
            case 4:
                taskExecutor = new LongestSubsequent();
                break;
            case 5:
                taskExecutor = new CountOfWaysToSumToN();
                break;
            case 6:
                taskExecutor = new NumAsSumOfTwoOrMorePosInt();
                break;
            case 7:
            	taskExecutor = new WaysToCoverIn3steps();
                break;
            case 8:
                taskExecutor = new PathsWithoutCrossing();
                break;
            case 9:
                taskExecutor = new HighEffortLowEffort();
                break;
            case 10:
                taskExecutor = new PalindromicSubsequence();
                break;
            case 11:
                break;
            case 12:
                taskExecutor = new WaysTileFloor();
                break;
            case 13:
                taskExecutor = new PaintingFence();
                break;
            case 14:
                taskExecutor = new OptimizedPaintingFence();
                break;
            case 15:
                break;
            case 16:
                break;
            case 17:
                break;
            case 18:
                break;
            case 19:
                taskExecutor = new MergeSort();
                break;
        }
        return taskExecutor;
    }
}
