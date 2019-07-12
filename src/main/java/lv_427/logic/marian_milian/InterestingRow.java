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

  private final int LENGTH_OF_INTERESTING_ROW = 20;
  private List<Integer> sequenceOfInterestingRow;

  public InterestingRow() {
    sequenceOfInterestingRow = new ArrayList<Integer>();
    generateInterestingRowSequence(LENGTH_OF_INTERESTING_ROW);
  }

  public void execute() {
    Scanner sc = new Scanner(System.in);
    String inputFromUser;
    System.out.println("Welcome in  Interesting   row ");
    do {
      System.out.println("Please enter n-integer of position from 1 to 20  witch you like to see ");
      inputFromUser = sc.nextLine();
    } while (!isInputDataValid(inputFromUser));
    System.out.println(
        "On  position "
            + inputFromUser
            + " "
            + "is number: "
            + getElementFromList(Integer.parseInt(inputFromUser)));
    System.out.println("______________");
  }

  private String getElementFromList(int position) {
    return sequenceOfInterestingRow.get((position - 1)).toString();
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
          "Hmm.. Looks like your input - " + "\"" + input + "\"" + " is not a number");
      return false;
    }

    if (input.length() > 3) {
      System.err.println("Number has to be smaller than 3 symbols!");
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
}
