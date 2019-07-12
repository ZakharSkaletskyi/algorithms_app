package lv_427.logic.roman_zahorui;

import java.util.Scanner;
import lv_427.logic.TaskExecutor;

/**
 * The class counts the number of ways to tile the floor of size n x m using 1 x m size tiles. Reads
 * strings from the console, converts them to integer values, and counts the result. Implements
 * TaskExecutor interface.
 *
 * @see TaskExecutor
 */
public class WaysTileFloor implements TaskExecutor {

  private static final int WIDTH_POS = 0;
  private static final int HEIGHT_POS = 1;
  private static final int WIDTH_MIN_VAL = 1;
  private static final int HEIGHT_MIN_VAL = 2;
  private static final int ARRAY_LENGTH = 2;
  private static final String SPLIT_PATTERN = " x ";
  private static final String FAIL_MESSAGE = "Try again!";
  private static final String INPUT_MESSAGE = "Input : ";
  private static final String OUTPUT_MESSAGE = "Output : ";
  private static final String TERMS_OF_USE =
      "Enter a size of a floor as n x m."
          + "\nBoth n and m must be positive integers, where n >= 1 and m >= 2. "
          + "\nExample : 4 x 3";

  private Scanner sc;

  /**
   * Constructs a new <code>WaysTileFloor</code> and creates an object of <code>Scanner</code> class
   * for further use.
   */
  public WaysTileFloor() {
    this.sc = new Scanner(System.in);
  }

  /** Uses the scanner object to read input data and prints a result to console. */
  public void execute() {
    System.out.println(TERMS_OF_USE);
    int[] floorSize = null;
    while (null == floorSize) {
      try {
        floorSize = parseStringToSize(sc.nextLine());
        if (null == floorSize) {
          System.out.println(FAIL_MESSAGE);
        }
      } catch (NumberFormatException e) {
        System.out.println(FAIL_MESSAGE);
      }
    }
    int width = floorSize[WIDTH_POS];
    int height = floorSize[HEIGHT_POS];

    String inputMsg = INPUT_MESSAGE + width + SPLIT_PATTERN + height;
    System.out.println(inputMsg);

    int amountOfWays = getWaysToTile(width, height);

    String outputStr = OUTPUT_MESSAGE + amountOfWays;
    System.out.println(outputStr);
  }

  /**
   * Implementation of the counting algorithm of ways to tile the floor of size n x m using 1 x m
   * size tiles.
   *
   * @param n - width of the floor and number of tiles.
   * @param m - height of the floor and length of a tile.
   * @return - number of ways to tile the given floor of size n x m.
   */
  public int getWaysToTile(int n, int m) {
    int[] count = new int[n + 1];
    count[0] = 0;

    int i;
    for (i = 1; i <= n; i++) {
      if (i < m) {
        count[i] = WIDTH_MIN_VAL;
      } else if (i == m) {
        count[i] = HEIGHT_MIN_VAL;
      } else {
        count[i] = count[i - 1] + count[i - m];
      }
    }
    return count[n];
  }

  /**
   * The method tries to extract data from the input string.
   *
   * @param strData - input string data.
   * @return Size of the floor as an array of integers with length == 2 or null if strData can't
   *     matches the correct string.
   */
  public int[] parseStringToSize(String strData) throws NumberFormatException {

    String strDataInLowCase = strData.toLowerCase();
    if (strDataInLowCase.contains(SPLIT_PATTERN)) {

      String[] sizeParts = strDataInLowCase.split(SPLIT_PATTERN);
      int[] sizeArray = new int[ARRAY_LENGTH];

      int widthValue = Integer.valueOf(sizeParts[WIDTH_POS]);
      int heightValue = Integer.valueOf(sizeParts[HEIGHT_POS]);

      if (widthValue >= WIDTH_MIN_VAL && heightValue >= HEIGHT_MIN_VAL) {
        sizeArray[WIDTH_POS] = widthValue;
        sizeArray[HEIGHT_POS] = heightValue;
        return sizeArray;
      }
    }
    return null;
  }
}
