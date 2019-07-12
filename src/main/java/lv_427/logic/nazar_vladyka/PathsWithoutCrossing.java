package lv_427.logic.nazar_vladyka;

import java.util.Scanner;
import lv_427.logic.AlgorithmExecutor;

/**
 * LPaths without crossing.
 *
 * <p>The goal: Program to count number of ways to connect n (where n is even) points on a circle
 * such that no two connecting lines cross each other and every point is connected with one other
 * point.
 *
 * @author Nazar Vladyka
 * @version 1.0
 */
public class PathsWithoutCrossing implements AlgorithmExecutor {
  private Scanner sc;

  private static final String INPUT_MESSAGE =
      "Please send me the odd number(bigger that 1 and has less than 52): ";
  private static final String OUTPUT_MESSAGE = "Result: ";

  public PathsWithoutCrossing() {
    this.sc = new Scanner(System.in);
  }

  /** The method which doing job us a controller(validate input data and send data to execution). */
  public void execute() {
    String input;

    do {
      System.out.print(INPUT_MESSAGE);
      input = sc.nextLine();
    } while (!isInputDataValid(input));

    System.out.print(OUTPUT_MESSAGE + countWays(Integer.parseInt(input)));
  }

  /**
   * The method check if incoming data is valid.
   *
   * @param input - input string data.
   * @return boolean value which shows us if data is valid.
   */
  private boolean isInputDataValid(String input) {
    int number;

    try {
      number = Integer.parseInt(input);
      if (number > 52) {
        System.err.println("Hmm.. Looks like your number - "
                + "\""
                + number
                + "\""
                + " is bigger than 52");
        return false;
      }
    } catch (NumberFormatException e) {
      System.err.println(
          "Hmm.. Looks like your number - "
              + "\""
              + input
              + "\""
              + " is not a number");
      return false;
    }

    if (input.length() > 5) {
      System.err.println("Number has to be smaller than 5 symbols!");
      return false;
    }

    if (((number % 2) == 0) && (number >= 1)) {
      return true;
    } else {
      System.err.println("Number has to be odd and bigger than 1");
      return false;
    }
  }

  /**
   * The method of main algorithm which calculate the number of ways to connect n points without
   * crossing.
   *
   * @param n - number of points.
   * @return int result number of ways to connect n points.
   */
  public int countWays(int n) {
    n = n / 2;
    int[] catalan = new int[n + 1];
    catalan[0] = catalan[1] = 1;

    for (int i = 2; i <= n; i++) {
      catalan[i] = 0;
      for (int j = 0; j < i; j++) {
        catalan[i] += catalan[j] * catalan[i - j - 1];
      }
    }

    return catalan[n];
  }

  public static void main(String[] args) {
    new PathsWithoutCrossing().execute();
  }
}