package lv_427.logic.kateryna_horokh;

import java.util.Scanner;

import lv_427.exceptions.WrongInputException;
import lv_427.logic.TaskExecutor;

import static lv_427.exceptions.WrongInputException.WRONG_LENGTH;

/**
 * Class for finding the longest palindromic subsequence.
 *
 * @author Kateryna Horokh
 * @version 1.0
 */
public class PalindromicSubsequence implements TaskExecutor {
  /** Scanner for reading from console. */
  private Scanner sc;

  public PalindromicSubsequence() {
    this.sc = new Scanner(System.in);
  }

  /** Method is for execute finding process. */
  public void execute() {
    String input;

    do {
      System.out.print("Enter word: ");
      input = sc.nextLine();
    } while (!isInputValid(input));

    System.out.println("Result: " + findPalindromLength(input));
  }

  public boolean isInputValid(String input) {
    char[] chars = input.toCharArray();

    if (chars.length == 0) {
      return false;
    }
    if (chars.length > 100) {
      throw new WrongInputException(WRONG_LENGTH);
    }
    return true;
  }

  /**
   * @param input - a string which have to check how many symbols has the biggest palindrome which
   *     is included.
   * @return number of length the biggest palindrome.
   */
  public int findPalindromLength(String input) {

    char[] chars = input.toCharArray();

    int[][] LP = new int[chars.length][chars.length];

    // LP[i][j] - length of palindrome from i index to j index
    // all the characters in the string are palindrome by itself of length 1.
    // So all LP[i][i] =  1
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
