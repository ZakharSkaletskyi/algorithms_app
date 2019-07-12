package lv_427.logic.marian_milian;

import java.util.ArrayList;
import java.util.List;

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
  private final int LENGTH_OF_FIBONACCI_ROW = 51;
  private List<Integer> sequenceFibonacciRow;

  /** Empty constructor witch make declaration of empty list for storing element of sequence */
  public ModificationFibonacci() {
    sequenceFibonacciRow = new ArrayList<Integer>();
    generateFibonacciSequence();
    System.out.println(sequenceFibonacciRow.get(6 - 1));
    System.out.print(sequenceFibonacciRow);
    System.out.println(" ");
    System.out.println(sequenceFibonacciRow.size());
  }

  public void execute() {}

  /*The method witch  generate modification Fibonacci sequence
   */
  private void generateFibonacciSequence() {
    int sum;
    int position = 3;
    sequenceFibonacciRow.add(1);
    sequenceFibonacciRow.add(1);
    sequenceFibonacciRow.add(1);
    for (int i = 3; i < LENGTH_OF_FIBONACCI_ROW - position; i++) {
      sum = sequenceFibonacciRow.get(i - 1) + sequenceFibonacciRow.get(i - 3);
      if (sum < 0) {
        break;
      }
      sequenceFibonacciRow.add(sum);
    }
  }
}
