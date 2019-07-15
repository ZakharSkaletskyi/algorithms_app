package lv_427.logic.nazar_vladyka;

import java.util.Scanner;
import lv_427.logic.TaskExecutor;

/**
 * Paths without crossing.
 *
 * <p>The goal: Program to count number of ways to connect n (where n is even) points on a circle
 * such that no two connecting lines cross each other and every point is connected with one other
 * point.
 *
 * @author Nazar Vladyka
 * @version 1.0
 */
public class PathsWithoutCrossing implements TaskExecutor {
  private Scanner sc;

  public PathsWithoutCrossing() {
    this.sc = new Scanner(System.in);
  }

  /** The method which doing job us a controller(validate input data and send data to execution). */
  public void execute() {
    String input;
    boolean isInputValid;

    do {
      isInputValid = true;

      System.out.print("Please send me the even number(bigger that 0 and less than 52): ");
      input = sc.nextLine();

      try {
        validateData(input);
      } catch (NumberFormatException e) {
        System.err.println("NumberFormatException " + e.getMessage());
        isInputValid = false;
      }
    } while (!isInputValid);

    System.out.println("Result: " + countWays(Integer.parseInt(input)));
  }

  /**
   * The method check if incoming data is valid. Throw a NumberFormatException if input data is
   * invalid.
   *
   * @param input - input string data.
   */
  private void validateData(String input) {
    int number = Integer.parseInt(input);

    if (number <= 0) {
      throw new NumberFormatException("Number has to be positive");
    } else if (number > 52) {
      throw new NumberFormatException("Number is bigger than 52");
    }

    if ((number % 2) == 1) {
      throw new NumberFormatException("Number has to be even");
    }
  }

  /**
   * The method of main algorithm which calculate the number of ways to connect n points without
   * crossing.
   *
   * @param n - number of points.
   * @return int result number of ways to connect n points.
   */
  private int countWays(int n) {
    if (n == 1) {
      return 0;
    } else {

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
  }
}
