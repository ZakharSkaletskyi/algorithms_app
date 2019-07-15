package lv_427.logic.marian_milian;

import lv_427.logic.TaskExecutor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Interesting row.
 *
 * <p>The goal: The goal: To find which is the member of position n in our interesting row.
 *
 * @author Marian Milian
 * @version 1.0
 */
public class InterestingRow implements TaskExecutor {
  private Scanner scanner;
  private final int LENGTH_OF_INTERESTING_ROW = 20;
  private List<Integer> sequenceOfInterestingRow;

  /**
   * Constructor with non args, witch make declaration of empty list for storing element of sequence
   */
  public InterestingRow() {
    scanner = new Scanner(System.in);
    sequenceOfInterestingRow = new ArrayList<Integer>();
    generateInterestingRowSequence(LENGTH_OF_INTERESTING_ROW);
  }

  /** The method which valid input data and controlling process. */
  public void execute() {

    String inputFromUser;
    System.out.println("Welcome in  Interesting   row ");
    while (true) {

      System.out.println(
          "Please enter n-integer of position from 1 to 20  witch you like to see or  'q' to exit");
      inputFromUser = scanner.nextLine();
      if (inputFromUser.equalsIgnoreCase("q")) {
        break;
      }
      if (isInputDataValid(inputFromUser)) {
        System.out.println(
            "On  position "
                + inputFromUser
                + " "
                + "is number: "
                + getElementFromList(Integer.parseInt(inputFromUser)));
        System.out.println("______________");

      }
    }
  }

  private boolean isInputDataValid(String input) {

    int number;

    try {
      number = Integer.parseInt(input);
      if (number > 20) {
        System.err.println(
            "Hmm.. Looks like your number - " + "\"" + number + "\"" + " is bigger than 20");
        return false;
      }
    } catch (NumberFormatException e) {
      System.err.println(
          "Hmm... Looks like your input - " + "\"" + input + "\"" + " is not a number");
      return false;
    }
    if ((number > 0)) {
      return true;
    } else {
      System.err.println("Number has to be odd and has to  be positive");
      return false;
    }
  }

  private void generateInterestingRowSequence(int elements) {
    for (int i = 0; i < elements; i++) {
      sequenceOfInterestingRow.add(generateValue(i));
    }
  }
  /**
   * The method witch generate sequence of interesting row
   *
   * @param number - element of position for witch should be generate value of Interesting row
   * @return int - value of Interesting row
   */
  private int generateValue(int number) {
    // base case
    if (number == 0) {
      return 0;
    }
    // base case
    if (number == 1) {
      return 1;
    }
    // recursive step.
    return generateValue(number - 1) + 2 * generateValue(number - 2);
  }

  /** The method witch casting input value to correct position representation in list */
  private String getElementFromList(int position) {
    return sequenceOfInterestingRow.get((position - 1)).toString();
  }
}
