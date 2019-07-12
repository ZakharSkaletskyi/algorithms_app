package lv_427.logic.marian_milian;



import java.util.ArrayList;
import java.util.List;
import lv_427.logic.TaskExecutor;

public class IntrestingRow implements TaskExecutor {

  private final int LENGTH_OF_INTRESTING_ROW = 20;
  private List<Integer> sequenceOfIntrestingRow;

  public IntrestingRow() {
    sequenceOfIntrestingRow = new ArrayList<Integer>();
    generateIttrestingRowSequence(LENGTH_OF_INTRESTING_ROW);
    System.out.println(sequenceOfIntrestingRow.get(1));
    System.out.println(sequenceOfIntrestingRow.get(5));
    System.out.println(sequenceOfIntrestingRow);
  }

  public void execute() {}

  private void generateIttrestingRowSequence(int elements) {
    for (int i = 0; i < elements; i++) {
      sequenceOfIntrestingRow.add(generateValue(i));
    }
  }

  private int generateValue(int n) {
    // base case
    if (n == 0) {
      return 0;
    }
    // base case
    if (n == 1) {
      return 1;
    }
    // recursive step.
    return generateValue(n - 1) + 2 * generateValue(n - 2);
  }
}
