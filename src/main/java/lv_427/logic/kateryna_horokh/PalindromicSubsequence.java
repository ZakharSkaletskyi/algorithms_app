package lv_427.logic.kateryna_horokh;

import java.util.Scanner;

import lv_427.exceptions.WrongLengthOfString;
import lv_427.logic.AlgorithmExecutor;

/**
 * Class for finding the longest palindromic subsequence.
 *
 * @author Kateryna Horokh
 * @version 1.0
 */
public class PalindromicSubsequence implements AlgorithmExecutor {
  /** Scanner for reading from console. */
  private Scanner sc;

  public PalindromicSubsequence() {
    this.sc = new Scanner(System.in);
  }

  /** Method is for execute finding process. */
  public void execute() {

    String input = sc.nextLine();

    char[] chars = input.toCharArray();

    if (chars.length > 100) {
      try {
        throw new WrongLengthOfString(
            "String has not contain more than 100 characters. Try again please.");
      } catch (WrongLengthOfString wrongLengthOfString) {
        wrongLengthOfString.printStackTrace();
      }
    }

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
    System.out.println(LP[0][LP.length - 1]);
  }
}
