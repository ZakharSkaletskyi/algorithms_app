package lv_427.logic.nazar_vladyka;

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
public class LongestSubsequentTask implements TaskExecutor {
  private Scanner sc;
  private LongestSubsequentTaskExecutor executor;

  public LongestSubsequentTask() {
    this.sc = new Scanner(System.in);
    this.executor = new LongestSubsequentTaskExecutor();
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
        executor.isInputDataValid(input);
      } catch (NumberFormatException e) {
        System.err.println("NumberFormatException " + e.getMessage());
        isInputValid = false;
      }

    } while (!isInputValid);

    System.out.println("Result: " + executor.find(input));
  }
}
