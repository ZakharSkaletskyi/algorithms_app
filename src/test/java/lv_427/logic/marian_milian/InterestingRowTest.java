package lv_427.logic.marian_milian;

import mockit.Deencapsulation;
import org.junit.Before;
import org.junit.Test;

/**
 * InterestingRow Test.
 *
 * @author Dmytro Dovhal
 * @version 1.0
 */
import static org.junit.Assert.*;

public class InterestingRowTest {

  private InterestingRow interestingRow;
  /** Init method. */
  @Before
  public void init() {
    interestingRow = new InterestingRow();
  }
  /** Method: isInputDataValid(String input) has to return true */
  @Test
  public void isInputDataValidTest() {
    boolean invoke = Deencapsulation.invoke(interestingRow, "isInputDataValid", "1");
    assertTrue(invoke);
  }
  /** Method: isInputDataValid(String input) has to return false */
  @Test
  public void isInputDataValidTestWithBadInput() {
    boolean invoke = Deencapsulation.invoke(interestingRow, "isInputDataValid", "a");
    assertFalse(invoke);
  }
  /** Method: generateValue(int elements) has to return 0 */
  @Test
  public void generateValueTestWithNullInput() {
    int invoke = Deencapsulation.invoke(interestingRow, "generateValue", 0);
    assertEquals(0, invoke);
  }
  /** Method: generateValue(int elements) has to return 1 */
  @Test
  public void generateValueTestWithInputOne() {
    int invoke = Deencapsulation.invoke(interestingRow, "generateValue", 1);
    assertEquals(1, invoke);
  }
  /** Method: generateValue(int elements) has to return new generated value */
  @Test
  public void generateValueTest() {
    int invoke = Deencapsulation.invoke(interestingRow, "generateValue", 4);
    assertEquals(5, invoke);
  }
}
