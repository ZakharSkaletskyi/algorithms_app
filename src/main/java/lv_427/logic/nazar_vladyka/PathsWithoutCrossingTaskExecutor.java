package lv_427.logic.nazar_vladyka;

/**
 * Additional class for PathsWithoutCrossingTask.class
 *
 * @author Nazar Vladyka
 * @version 1.0
 */
public class PathsWithoutCrossingTaskExecutor {
  /**
   * The method check if incoming data is valid. Throw a NumberFormatException if input data is
   * invalid.
   *
   * @param input - input string data.
   */
  public void validateData(String input) {
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
  public int countWays(int n) {
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
