package lv_427.logic.kateryna_horokh;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import lv_427.logic.TaskExecutor;

/**
 * Class for finding the longest palindromic subsequence.
 *
 * @author Kateryna Horokh
 * @version 1.0
 */
public class PalindromicSubsequence implements TaskExecutor {

  private static final Logger LOGGER = Logger.getLogger(PalindromicSubsequence.class.getName());

  private Scanner sc;

  public PalindromicSubsequence() {
    this.sc = new Scanner(System.in);
  }

  /** Method is for execute finding process. */
  public void execute() {
    String input;

    do {
      System.out.print("Please enter word: ");
      input = sc.nextLine();
    } while (!isInputValid(input));

    System.out.println("Result: " + findPalindromLength(input));
  }

  /**
   * This method check if string valid or not.
   *
   * @param input - incoming string
   * @return boolean true or false. If it returns true string is valid.
   */
  public boolean isInputValid(String input) {
    char[] chars = input.toCharArray();

    if (chars.length == 0) {
      LOGGER.log(Level.WARNING, "You didn't enter anything. Try again please.");
      return false;
    } else if (!input.matches("[a-zA-Z]+")) {
      LOGGER.log(Level.WARNING, "Your text contains numbers. Try again please.");
      return false;
    }

    if (chars.length > 100) {
      LOGGER.log(Level.WARNING, "Your text too long. Try again please.");
      return false;
    } else {
      return true;
    }
  }

  /**
   * This method for finding palindrom length.
   *
   * @param input - a string which have to check how many symbols has the biggest palindrome which
   *     is included.
   * @return number of length the biggest palindrome.
   */
  public int findPalindromLength(String input) {

    char[] chars = input.toCharArray();

    int[][] LP = new int[chars.length][chars.length];

    // LP[i][j] - length of palindrome from i index to j index
    for (int i = 0; i < chars.length; i++) {
      LP[i][i] = 1;
    }

    for (int sublen = 2; sublen <= chars.length; sublen++) {
      for (int i = 0; i <= LP.length - sublen; i++) {
        int j = i + sublen - 1;
        if (chars[i] == chars[j] && sublen == 2) {
          LP[i][j] = 2;
        } else if (chars[i] == chars[j]) {
          LP[i][j] = LP[i + 1][j - 1] + 2;
        } else {
          LP[i][j] = Math.max(LP[i + 1][j], LP[i][j - 1]);
        }
      }
    }
    return LP[0][LP.length - 1];
  }
}
