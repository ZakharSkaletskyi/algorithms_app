package lv_427.logic.nazar_vladyka;

/**
 * Additional class for PathsWithoutCrossingTask.class
 *
 * @author Nazar Vladyka
 * @version 1.0
 */
public class PathsWithoutCrossingTaskExecutor {
  /**
   * The method check if incoming data is valid.
   *
   * @param input - input string data.
   * @return boolean value which shows us if data is valid.
   */
  public boolean isInputDataValid(String input) {
    int number;

    try {
      number = Integer.parseInt(input);
    } catch (NumberFormatException e) {
      System.err.println(
          "Hmm.. Looks like your number - " + "\"" + input + "\"" + " is not a number");
      return false;
    }

    if (number <= 0) {
      System.err.println(
          "Hmm.. Looks like your number - " + "\"" + number + "\"" + " is smaller than 0");
      return false;
    } else if (number > 52) {
      System.err.println(
          "Hmm.. Looks like your number - " + "\"" + number + "\"" + " is bigger than 52");
      return false;
    }

    if (((number % 2) == 0)) {
      return true;
    } else {
      System.err.println("Number has to be odd");
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
}