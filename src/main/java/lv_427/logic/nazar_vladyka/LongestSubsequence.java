package lv_427.logic.nazar_vladyka;

import lv_427.logic.AlgorithmExecutor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.err;

/**
 * Longest subsequence with difference one. The goal: To find how many numbers we have with
 * difference one in the maximum sub sequence
 *
 * @author Nazar Vladyka
 * @version 1.0
 * @since 2019-07-11
 */
public class LongestSubsequence implements AlgorithmExecutor {
  private Scanner sc;

  public LongestSubsequence() {
    this.sc = new Scanner(System.in);
  }

  public static void main(String[] args) {
    new LongestSubsequence().execute();
  }

  public void execute() {
    System.out.println("Hello! This is \"Longest subsequence with difference one\"");
    System.out.print("Please send me the numbers: ");

    boolean isInputWrong = true;//by default

    while (isInputWrong) {
      String input = sc.nextLine();
      String[] arrayS = input.split(" ");

      if (arrayS.length > 0) {
        isInputWrong = false;
        List<Integer> numbers = new ArrayList<Integer>();

        for (String s : arrayS) {
          try {
            numbers.add(Integer.parseInt(s));
          } catch (NumberFormatException e) {
            err.println(e);
            isInputWrong = true;
            break;
          }
        }

        if (isInputWrong) {
          System.out.print("Try again: ");
        } else {
          System.out.println("Result: " + find(numbers));
        }

      } else {
        System.out.print("Something wrong(\nTry again: ");
      }
    }
  }

  public int find(List<Integer> numbers) {
    int maxSubsequence = 0;
    int currentSubsequence = 1;

    for (int i = 0; i < numbers.size() - 1; i++) {
      if ((numbers.get(i + 1) - numbers.get(i)) == 1) {
        currentSubsequence++;
      } else {
        if (currentSubsequence > maxSubsequence) {
          maxSubsequence = currentSubsequence;
        }
        currentSubsequence = 1;
      }
    }

    if (currentSubsequence > maxSubsequence) {
      maxSubsequence = currentSubsequence;
    }
    return maxSubsequence;
  }
}
