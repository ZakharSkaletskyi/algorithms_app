package lv_427.logic.roman_zahorui;

import java.util.Scanner;

import lv_427.logic.TaskExecutor;

/**
 * The class counts the number of ways of painting the fence such that at most 2 adjacent posts have
 * the same color. Reads strings from the console, converts them to integer values, and counts the
 * result. Implements AlgorithmExecutor interface.
 *
 * @see TaskExecutor
 */
public class PaintingFence implements TaskExecutor {

  private static final int POSTS_MIN_VAL = 1;
  private static final int COLORS_MIN_VAL = 1;
  private static final String SPLIT_PATTERN = " x ";
  private static final String FAIL_MESSAGE = "Try again!";
  private static final String INPUT_MSG = "Input : ";
  private static final String OUTPUT_MSG = "Output : ";
  private static final String OUTPUT_MSG_MORE = " or even more!";
  private static final String TERMS_OF_USE =
      "Enter amount of posts and amount of colors as p x c. Where p = posts and c = colors."
          + "\nBoth p and c must be positive integers, where p > 0 and c > 0."
          + "\nOutput values greater than 2147483647 are not counted."
          + "\nExample : 2 x 2";

  private Scanner sc;

  /**
   * Constructs a new <code>PaintingFence</code> and creates an object of <code>Scanner</code> class
   * for further use.
   */
  public PaintingFence() {
    this.sc = new Scanner(System.in);
  }

  /** Uses the scanner object to read input data and prints a result to console. */
  public void execute() {
    System.out.println(TERMS_OF_USE);
    int postsAmount = 0;
    int colorAmount = 0;
    while (postsAmount <= 0 && colorAmount <= 0) {
      try {
        int[] amounts = parseStringToSize(sc.nextLine());
        if (null == amounts) {
          System.out.println(FAIL_MESSAGE);
        } else {
          postsAmount = amounts[0];
          colorAmount = amounts[1];
        }
      } catch (NumberFormatException e) {
        System.out.println(FAIL_MESSAGE);
      }
    }

    String inputMsg = INPUT_MSG + postsAmount + SPLIT_PATTERN + colorAmount;
    System.out.println(inputMsg);

    long amountOfWays = countWays(postsAmount, colorAmount);
    String outputStr = OUTPUT_MSG + amountOfWays;

    if (amountOfWays == Integer.MAX_VALUE) {
      outputStr += OUTPUT_MSG_MORE;
    }

    System.out.println(outputStr);
  }
  /**
   * Implementation of the counting algorithm of ways paint the fence such that at most 2 adjacent
   * posts have the same color. If output values greater than <code>Integer.MAX_VALUE</code> returns
   * 2147483647.
   *
   * @param posts - amount of given posts
   * @param colors - amount of given colors.
   * @return - number of ways to paint the fence.
   */
  public long countWays(int posts, int colors) {
    long[] subProblems = new long[posts + 1];
    subProblems[0] = 0;
    subProblems[1] = colors;

    long sameColor;
    long diffColor = colors;

    for (int i = 2; i <= posts; i++) {
      sameColor = diffColor;
      diffColor = (subProblems[i - 1] * (colors - 1));
      subProblems[i] = sameColor + diffColor;

      if (subProblems[i] > Integer.MAX_VALUE) {
        return Integer.MAX_VALUE;
      }
    }
    return subProblems[posts];
  }

  /**
   * The method tries to extract data from an input string.
   *
   * @param strData - input string data.
   * @return - an array of integers with length == 2. Represented posts amount at position 0 and
   *     сolors amount at position 1 or null if strData can't matches the correct string.
   */
  public int[] parseStringToSize(String strData) throws NumberFormatException {

    String strDataInLowCase = strData.toLowerCase();
    if (strDataInLowCase.contains(SPLIT_PATTERN)) {

      String[] sizeParts = strDataInLowCase.split(SPLIT_PATTERN);
      int[] sizeArray = new int[2];

      int widthValue = Integer.valueOf(sizeParts[0]);
      int heightValue = Integer.valueOf(sizeParts[1]);

      if (widthValue >= POSTS_MIN_VAL && heightValue >= COLORS_MIN_VAL) {
        sizeArray[0] = widthValue;
        sizeArray[1] = heightValue;
        return sizeArray;
      }
    }
    return null;
  }
}
