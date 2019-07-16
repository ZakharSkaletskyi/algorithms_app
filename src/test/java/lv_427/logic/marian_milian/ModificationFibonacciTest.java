package lv_427.logic.marian_milian;

import mockit.Deencapsulation;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * ModificationFibonacci Test.
 *
 * @author Dmytro Dovhal
 * @version 1.0
 */
public class ModificationFibonacciTest {

  private ModificationFibonacci modificationFibonacci;
  /** Init method. */
  @Before
  public void init() {
    modificationFibonacci = new ModificationFibonacci();
  }
  /** Method: isInputDataValid(String input) has to return true */
  @Test
  public void isInputDataValidTest() {
    boolean invoke = Deencapsulation.invoke(modificationFibonacci, "isInputDataValid", "1");
    assertTrue(invoke);
  }
  /** Method: isInputDataValid(String input) has to return false */
  @Test
  public void isInputDataValidTestWithBadInput() {
    boolean invoke = Deencapsulation.invoke(modificationFibonacci, "isInputDataValid", "a");
    assertFalse(invoke);
  }
}
