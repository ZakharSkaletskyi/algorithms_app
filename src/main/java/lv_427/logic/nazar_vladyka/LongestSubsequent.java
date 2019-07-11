package lv_427.logic.nazar_vladyka;

import lv_427.logic.AlgorithmExecutor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
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

  private final String INPUT_MESSAGE = "Please send me the numbers: ";
  private final String OUTPUT_MESSAGE = "Result: ";
  private final String FAIL_MESSAGE = "Something wrong(\nTry again: ";

  public LongestSubsequence() {
    this.sc = new Scanner(System.in);
  }

  public void execute() {
    System.out.print(INPUT_MESSAGE);
    String input = sc.nextLine();

    while (!isInputDataValid(input)) {
      System.out.print(FAIL_MESSAGE);
      input = sc.nextLine();
    }

    String[] inputArray = input.split(" ");
    List<Integer> numbers = new ArrayList<Integer>();

    for (String s : inputArray) {
      numbers.add(Integer.parseInt(s));
    }

    System.out.print(OUTPUT_MESSAGE + find(numbers));
  }

  public boolean isInputDataValid(String input) {
    String[] inputStringArray = input.split(" ");

    if (inputStringArray.length == 0) {
      return false;
    } else {
      for (String s : inputStringArray) {
        try {
          Integer.parseInt(s);
        } catch (NumberFormatException e) {
          System.err.println(e.toString());
          return false;
        }
      }
    }

    return true;
  }

  public int find(List<Integer> numbers) {
    int maxSubsequent = 0;
    int currentSubsequent = 1;

    for (int i = 0; i < numbers.size() - 1; i++) {
      if ((numbers.get(i + 1) - numbers.get(i)) == 1) {
        currentSubsequent++;
      } else {
        maxSubsequent = (currentSubsequent > maxSubsequent) ? currentSubsequent : maxSubsequent;
        currentSubsequent = 1;
      }
    }

    maxSubsequent = (currentSubsequent > maxSubsequent) ? currentSubsequent : maxSubsequent;

    return maxSubsequent;
  }

  public static void main(String[] args) {
    new LongestSubsequence().execute();
  }
}
