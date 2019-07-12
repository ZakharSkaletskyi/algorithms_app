package lv_427.logic.nazar_vladyka;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import lv_427.logic.AlgorithmExecutor;

/**
 * Longest subsequence with difference one.
 *
 * <p>The goal: To find how many numbers we have with difference one in the maximum sub sequence
 *
 * @author Nazar Vladyka
 * @version 1.0
 */
public class LongestSubsequent implements AlgorithmExecutor {
  private Scanner sc;

  private static final String INPUT_MESSAGE = "Please send me the numbers: ";
  private static final String OUTPUT_MESSAGE = "Result: ";

  public LongestSubsequent() {
    this.sc = new Scanner(System.in);
  }

  /** The method which doing job us a controller(validate input data and send data to execution). */
  public void execute() {
    String input;

    do {
      System.out.print(INPUT_MESSAGE);
      input = sc.nextLine();
    } while (!isInputDataValid(input));

    String[] inputArray = input.split(" ");
    List<Integer> numbers = new ArrayList<Integer>();

    for (String s : inputArray) {
      numbers.add(Integer.parseInt(s));
    }

    System.out.print(OUTPUT_MESSAGE + find(numbers));
  }

  /**
   * The method check if incoming data is valid.
   *
   * @param input - input string data.
   * @return boolean value which shows us if data is valid.
   */
  public boolean isInputDataValid(String input) {
    String[] inputStringArray = input.split(" ");

    if (inputStringArray.length == 0) {
      return false;
    } else {
      for (String s : inputStringArray) {
        try {
          Integer.parseInt(s);
        } catch (NumberFormatException e) {
          System.err.println(
              "Hmm.. Looks like your number - " + "\"" + s + "\""
                  + " is not a number , or try smaller numbers");
          return false;
        }
      }
    }

    return true;
  }

  /**
   * The method of main algorithm which calculate the longest subsequent of numbers with difference
   * 1.
   *
   * @param numbers - input List of int with numbers.
   * @return int result of longest subsequent.
   */
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
    new LongestSubsequent().execute();
  }
}