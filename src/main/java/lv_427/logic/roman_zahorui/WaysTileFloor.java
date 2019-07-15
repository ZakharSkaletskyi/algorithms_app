package lv_427.logic.roman_zahorui;

import java.util.Scanner;

import lv_427.exceptions.IncorrectValueException;
import lv_427.logic.TaskExecutor;

/**
 * The class counts the number of ways to tile the floor of size n x m using 1 x m size tiles. Reads
 * strings from the console, converts them to integer values, and counts the result. Implements
 * TaskExecutor interface.
 *
 * @see TaskExecutor
 */
public class WaysTileFloor implements TaskExecutor {

  private static final int WIDTH_MIN_VAL = 1;
  private static final int HEIGHT_MIN_VAL = 2;
  private static final String FAIL_MESSAGE = "Try again!";
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
        floorSize = StringParser.parseStringToSize(sc.nextLine());
        if (null == floorSize) {
          System.out.println(FAIL_MESSAGE);
        } else {
          if (floorSize[0] < WIDTH_MIN_VAL || floorSize[1] < HEIGHT_MIN_VAL) {
            System.out.println(FAIL_MESSAGE);
            floorSize = null;
          }
        }
      } catch (NumberFormatException e) {
        System.out.println(FAIL_MESSAGE);
      }
    }
    int width = floorSize[0];
    int height = floorSize[1];

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
  private int getWaysToTile(int n, int m) {
    if (n < 0 || m < 0) {
      throw new IncorrectValueException("An input value can't be negative.");
    }
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
}
