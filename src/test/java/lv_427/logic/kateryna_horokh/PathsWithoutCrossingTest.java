package lv_427.logic.kateryna_horokh;

import lv_427.logic.nazar_vladyka.PathsWithoutCrossing;
import mockit.Deencapsulation;
import mockit.Tested;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Class is for testing PathsWithoutCrossing class.
 *
 * @author Kateryna Horokh
 * @version 1.0
 */
public class PathsWithoutCrossingTest {

  @Tested private PathsWithoutCrossing paths;

  @Before
  public void init() {
    paths = new PathsWithoutCrossing();
  }

  /** Method for testing exception in validateData method */
  @Test(expected = NumberFormatException.class)
  public void isInputDataIsNumber() throws Exception {
    String input4 = Deencapsulation.invoke(paths, "validateData", "h");
  }

  /** Method for testing exception in validateData method */
  @Test(expected = NumberFormatException.class)
  public void isInputDataReturnException() throws Exception {
    String input = Deencapsulation.invoke(paths, "validateData", "54");
    String input2 = Deencapsulation.invoke(paths, "validateData", "0");
    String input3 = Deencapsulation.invoke(paths, "validateData", "-2");
  }

  /** Method for testing exception in validateData method */
  @Test(expected = NumberFormatException.class)
  public void testEvenNumber() throws Exception {
    String input = Deencapsulation.invoke(paths, "validateData", "3");
  }

  /** Method for testing countWays method */
  @Test
  public void shouldReturnZero() {
    int input = Deencapsulation.invoke(paths, "countWays", 1);
    Assert.assertEquals(0, input);
  }

  /** Method for testing countWays method */
  @Test
  public void shouldReturnTwo() {
    int input = Deencapsulation.invoke(paths, "countWays", 4);
    Assert.assertEquals(2, input);
  }
}
