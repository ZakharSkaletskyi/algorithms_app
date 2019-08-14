package lv_427.logic.nazar_stasyuk;

import lv_427.exceptions.BadPositionOfFibonacciSequence;
import lv_427.logic.TaskExecutor;

import java.util.Scanner;

/**
 * Class for finding number in Fibonacci sequence by position.
 *
 * @author Nazar Stasyuk
 * @version 1.0
 */
public class Fibonacci implements TaskExecutor {

  private Scanner sc;

  public Fibonacci() {
    this.sc = new Scanner(System.in);
  }

  /** Method is for execute finding process. */
  public void execute() {

    int position;

    while (true) {
      System.out.println(
          "Input \'q\' to exit or input position of number in Fibonacci array(integer): ");
      String input = sc.nextLine();

      if (input.equalsIgnoreCase("q")) {
        break;
      }

      try {
        position = Integer.valueOf(input);

        if (position <= 0) {
          System.out.println("Position has to be positive!");
          continue;
        }

      } catch (Exception e) {
        System.out.println(
            "You have to input integer to find number by position or \'q\' to exit!");
        continue;
      }

      long numberByPosition = findNumberByPosition(position);

      if (numberByPosition == -1) {
        continue;
      }

      System.out.println(
          "Member of position " + position + " in Fibonacci sequence is " + numberByPosition);
    }
  }

  /**
   * Method is for find number by position.
   *
   * @param position is position of number that you are finding.
   * @return return number by position or -1 if number is to high.
   * @exception BadPositionOfFibonacciSequence position has to be only positive
   */
  private long findNumberByPosition(int position) {
    if (position <= 0) {
      throw new BadPositionOfFibonacciSequence(
          "Position has to be positive! In your case position is " + position);
    }
    if ((position == 1) || (position == 2)) {
      return 1;
    }
    long previousNumber = 1;
    long nextNumber = 1;
    int currentPosition = 2;
    long tmp;
    while (true) {
      if (position == currentPosition) {
        return nextNumber;
      }
      if (nextNumber < 0) {
        System.out.println("Position " + position + " is to high to find the number in sequence");
        return -1;
      }
      tmp = previousNumber + nextNumber;
      previousNumber = nextNumber;
      nextNumber = tmp;
      currentPosition++;
    }
  }
}
