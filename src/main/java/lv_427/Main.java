package lv_427;

import lv_427.Logic.AlgorithmExecutor;
import lv_427.Logic.Fibonacci;

import java.util.Scanner;

public class Main {

<<<<<<< HEAD
    private static final String MENU = "1\tFibonacci\n" +
            "2\tModification Fibonacci\n" +
            "3\tIntresting row\n" +
            "4\tLongest subsequence with difference one\n" +
            "5\tWays to sum to N using array elements with repetition\n" +
            "6\tWays to write n as sum of two or more positive integers\n" +
            "7\tWays to cover in 3 steps\n" +
            "8\tPaths without crossing\n" +
            "9\tWork to be with High-effort or with Low-effort\n" +
            "10\tThe longest palindromic subsequence\n" +
            "11\tFriend pairs\n" +
            "12\tWays to tile the floor\n" +
            "13\tPainting the fence\n" +
            "14\tOptimized painting fence: use one variable instead of a table\n" +
            "15\tInsertion Sort\n" +
            "16\tCounting Sort\n" +
            "17\tQuick Sort\n" +
            "18\tBucket Sort\n" +
            "19\tMerge Sort\n" +
            "Input your choose: ";

    public static void main(String[] args) {
        AlgorithmExecutor algorithmExecutor = null;

        Scanner scanner = new Scanner(System.in);

        int selector = -1;

        while (selector != 0) {
            System.out.println(MENU);
            selector = scanner.nextInt();
            System.out.println();
            switch (selector) {
                case 1:
                    algorithmExecutor = new Fibonacci();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    break;
                case 11:
                    break;
                case 12:
                    break;
                case 13:
                    break;
                case 14:
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
                    break;
                default:
                    continue;

            }
            algorithmExecutor.execute();
        }
    }


=======
>>>>>>> a4d020b8313880987ac49bf93765836327881aab
}

