package lv_427.logic.kateryna_horokh;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import lv_427.logic.TaskExecutor;

/**
 * Class for finding the total number of ways in which friends can remain single or can be paired
 * up.
 *
 * @author Kateryna Horokh
 * @version 1.0
 */
public class FriendPairs implements TaskExecutor {

  private static final Logger LOGGER = Logger.getLogger(FriendPairs.class.getName());

  private Scanner sc;

  public FriendPairs() {
    this.sc = new Scanner(System.in);
  }

  /** Method is for execute finding process. */
  public void execute() {
    String strNum;

    do {
      System.out.print("Please send me the number for finding the total number of ways: ");
      strNum = sc.nextLine();
    } while (!isInputValid(strNum));

    System.out.println("Result: " + findNumberOfWays(strNum));
    System.out.println("To return to menu just press - Enter");
    sc.nextLine();
  }

  /**
   * This method check if string of numbers valid or not.
   *
   * @param strNum - incoming string
   * @return boolean true or false. If it returns true string is valid.
   */
  private boolean isInputValid(String strNum) {
    int integer;

    try {
      integer = Integer.parseInt(strNum);
    } catch (NumberFormatException e) {
      LOGGER.log(Level.WARNING, "You didn't enter number. Try again please.");
      return false;
    }
    if (integer == 0) {
      LOGGER.log(Level.WARNING, "You didn't enter anything. Try again please.");
      return false;
    } else if (integer > 27) {
      LOGGER.log(Level.WARNING, "You entered wrong number. Try again please.");
      return false;
    } else if (integer <= -1) {
      LOGGER.log(Level.WARNING, "Your number is less than 0. Try again please.");
      return false;
    }
    return true;
  }

  /**
   * This method for finding number of ways in which friends can remain single or can be paired *
   * up.
   *
   * @param strNum - number which have to check how many ways
   * @return number of ways in which friends can remain single or can be paired up.
   */
  private int findNumberOfWays(String strNum) {

    int resultOfInput = Integer.parseInt(strNum);

    int numberOfWays[] = new int[resultOfInput + 1];

    // Filling dp[] in bottom-up manner using recursive formula.
    for (int i = 0; i <= resultOfInput; i++) {
      if (i <= 2) numberOfWays[i] = i;
      else numberOfWays[i] = numberOfWays[i - 1] + (i - 1) * numberOfWays[i - 2];
    }
    return numberOfWays[resultOfInput];
  }
}
