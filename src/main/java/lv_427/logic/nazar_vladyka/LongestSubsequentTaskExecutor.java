package lv_427.logic.nazar_vladyka;

import java.util.ArrayList;
import java.util.List;

/**
 * Additional class for LongestSubsequentTask.class
 *
 * @author Nazar Vladyka
 * @version 1.0
 */
public class LongestSubsequentTaskExecutor {
  private static final int DIFFERENCE = 1;

  /**
   * The method check if incoming data is valid. Throw NumberFormatException if data is invalid
   *
   * @param input - input string data.
   */
  public void validateData(String input) {
    String[] inputStringArray = input.split(" ");

    for (String s : inputStringArray) {
      Integer.parseInt(s);
    }
  }

  /**
   * The method of main algorithm which calculate the longest subsequent of numbers with difference
   * 1.
   *
   * @param input - input String of numbers.
   * @return int result of longest subsequent.
   */
  public int find(String input) {
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
