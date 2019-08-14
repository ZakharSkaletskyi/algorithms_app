package lv_427.logic.nazar_vladyka;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import lv_427.logic.TaskExecutor;

/**
 * Longest subsequence with difference one.
 *
 * <p>The goal: To find how many numbers we have with difference one in the maximum sub sequence
 *
 * @author Nazar Vladyka
 * @version 1.0
 */
public class LongestSubsequent implements TaskExecutor {
  private Scanner sc;
  private static final int DIFFERENCE = 1;

  public LongestSubsequent() {
    this.sc = new Scanner(System.in);
  }

  /** The method which doing job us a controller(validate input data and send data to execution). */
  public void execute() {
    String input;
    boolean isInputValid;

    do {
      isInputValid = true;

      System.out.print("Please send me the numbers using space between them like \"1 2 3\": ");
      input = sc.nextLine();

      try {
        validateData(input);
      } catch (NumberFormatException e) {
        System.err.println("NumberFormatException " + e.getMessage());
        isInputValid = false;
      }

    } while (!isInputValid);

    System.out.println("Result: " + find(input));
  }

  /**
   * The method check if incoming data is valid. Throw NumberFormatException if data is invalid
   *
   * @param input - input string data.
   */
  private void validateData(String input) {
    String[] inputStringArray = input.split(" ");

    for (String s : inputStringArray) {
      try {
        Integer.parseInt(s);
      } catch (NumberFormatException e) {
        throw new NumberFormatException(
            "Looks like your input - " + s + ", is not a number. Try again");
      }
    }
  }

  /**
   * The method of main algorithm which calculate the longest subsequent of numbers with difference
   * 1.
   *
   * @param input - input String of numbers.
   * @return int result of longest subsequent.
   */
  private int find(String input) {
    int maxSubsequent = 0;
    int currentSubsequent = 1;

    String[] inputArray = input.split(" ");
    List<Integer> numbers = new ArrayList<Integer>();

    for (String s : inputArray) {
      numbers.add(Integer.parseInt(s));
    }

    for (int i = 0; i < numbers.size() - 1; i++) {
      if (Math.abs((numbers.get(i + 1) - numbers.get(i))) == DIFFERENCE) {
        currentSubsequent++;
      } else {
        maxSubsequent = (currentSubsequent > maxSubsequent) ? currentSubsequent : maxSubsequent;
        currentSubsequent = 1;
      }
    }

    maxSubsequent = (currentSubsequent > maxSubsequent) ? currentSubsequent : maxSubsequent;

    return maxSubsequent;
  }
}
