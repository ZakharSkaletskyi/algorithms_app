package lv_427.logic.marian_milian;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import lv_427.logic.TaskExecutor;
/**
 * Modification Fibonacci sequence.
 *
 * <p>The goal: To find which is the member of position n in Modification Fibonacci sequence .
 *
 * @author Marian Milian
 * @version 1.0
 */
public class ModificationFibonacci implements TaskExecutor {

  private final int LENGTH_OF_FIBONACCI_ROW = 20;

  private Scanner scanner;

  private List<Integer> sequenceFibonacciRow;
  /**
   * Constructor with non args, witch make declaration of empty list for storing element of sequence
   */
  public ModificationFibonacci() {
    sequenceFibonacciRow = new ArrayList<Integer>();
    this.scanner = new Scanner(System.in);
    generateFibonacciSequence();
  }
  /** The method which valid input data and controlling process. */
  public void execute() {

    String inputFromUser;
    System.out.println("Welcome in  Modification Fibonacci row ");
    while (true) {

      System.out.println(
          "Please enter n-integer of position from 1 to 20  witch you like to see  or  'q' to exit");
      inputFromUser = scanner.nextLine();
      if (inputFromUser.equalsIgnoreCase("q")) {
        break;
      }
      if (isInputDataValid(inputFromUser)) {
        System.out.println(
            "On position "
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
          "Hmm.. Looks like your input - " + "\"" + input + "\"" + " is not a number");
      return false;
    }
    if ((number > 0)) {
      return true;
    } else {
      System.err.println("Number has to be odd and has to  be positive");
      return false;
    }
  }
  /** The method witch generate modification Fibonacci sequence */
  private void generateFibonacciSequence() {
    int sum;

    for (int i = 0; i < LENGTH_OF_FIBONACCI_ROW; i++) {
      if (i < 3) {
        sequenceFibonacciRow.add(1);
        continue;
      }
      sum = sequenceFibonacciRow.get(i - 1) + sequenceFibonacciRow.get(i - 3);
      if (sum < 0) {
        break;
      }
      sequenceFibonacciRow.add(sum);
    }
  }
  /** The method witch casting input value to  correct position representation  in list  */

  private String getElementFromList(int position) {
    return sequenceFibonacciRow.get((position - 1)).toString();
  }
}
//
