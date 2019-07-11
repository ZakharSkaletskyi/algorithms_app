package lv_427;

import java.util.Scanner;
import lv_427.logic.AlgorithmExecutor;
import lv_427.logic.nazar_stasyuk.Fibonacci;
import lv_427.logic.rostyslav_khasanov.CountOfWaysToSumToN;
import lv_427.logic.rostyslav_khasanov.NumAsSumOfTwoOrMorePosInt;

/**
 * Our first task.
 * @author lv-427
 * @version 1.0
 */
public class Main {

  private static final String MENU =
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
   * This is main method.
   *
   * @param args args
   */
  public static void main(String[] args) {
    AlgorithmExecutor algorithmExecutor = null;

    Scanner scanner = new Scanner(System.in);

    int select;
    String input;

    while (true) {
      System.out.println(MENU);

      input = scanner.nextLine();

      if (input.equalsIgnoreCase("q")){
        System.out.println("Bye!");
        break;
      }

      try{
        select = Integer.valueOf(input);
      }catch (Exception c){
        System.out.println("You have to input integer or \'q\' to exit!!!");
        continue;
      }

      System.out.println();
      switch (select) {
        case 1:
          algorithmExecutor = new Fibonacci();
          break;
        case 2:
          break;
        case 3:
          break;
        case 4:
          break;
        case 5: {
          algorithmExecutor = new CountOfWaysToSumToN();
        }
          break;
        case 6: {
          algorithmExecutor = new NumAsSumOfTwoOrMorePosInt();
        }
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
          System.out.println("Input integer between 1 and 19 or \'q\' to exit!");
          continue;
      }
      algorithmExecutor.execute();
    }
  }
}
