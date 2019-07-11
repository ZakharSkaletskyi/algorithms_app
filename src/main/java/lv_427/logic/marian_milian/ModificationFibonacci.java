package lv_427.logic.marian_milian;

import java.util.ArrayList;
import java.util.List;
import lv_427.logic.AlgorithmExecutor;

public class ModificationFibonacci implements AlgorithmExecutor {
  private final int LENGTH_OF_FIBONACCI_ROW =51;
  private List<Integer> sequenceFibonacciRow;

  public ModificationFibonacci() {
    sequenceFibonacciRow = new ArrayList<Integer>();
    generateFibonacciSequence();
    System.out.println(sequenceFibonacciRow.get(6 - 1));
    System.out.print(sequenceFibonacciRow);
    System.out.println(" ");ffff
    System.out.println(sequenceFibonacciRow.size());
  }

  public void execute() {

  }

  private void generateFibonacciSequence() {
    int sum;
    sequenceFibonacciRow.add(1);
    sequenceFibonacciRow.add(1);
    sequenceFibonacciRow.add(1);
    for (int i = 3; i < LENGTH_OF_FIBONACCI_ROW - 3; i++) {
      sum = sequenceFibonacciRow.get(i - 1) + sequenceFibonacciRow.get(i - 3);
      if (sum < 0) {
        break;
      }

      sequenceFibonacciRow.add(sum); //
    }
  }
}
