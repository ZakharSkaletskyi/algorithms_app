package lv_427.logic.kateryna_horokh;

import lv_427.logic.nazar_vladyka.PathsWithoutCrossingTaskExecutor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PathsWithoutCrossingTaskExecutorTest {

  private PathsWithoutCrossingTaskExecutor paths;

  @Before
  public void init() {
    paths = new PathsWithoutCrossingTaskExecutor();
  }

  @Test(expected = NumberFormatException.class)
  public void isInputDataReturnException() {
    paths.isInputDataValid("р");
  }

  @Test
  public void isInputDataDoesNotLessThanZeroOrIsZero() {
    Assert.assertTrue(paths.isInputDataValid("2"));
    Assert.assertFalse(paths.isInputDataValid("0"));
    Assert.assertFalse(paths.isInputDataValid("-2"));
  }

  @Test
  public void isInputDataDoesNotBiggerThan52(){
    Assert.assertFalse(paths.isInputDataValid("53"));
    Assert.assertTrue(paths.isInputDataValid("52"));
  }

  @Test
  public void testEvenNumber(){
    Assert.assertEquals("10 is not odd", true, paths.isInputDataValid("10"));
  }

  @Test
  public void haveToReturnZero() {
    Assert.assertEquals(0, paths.countWays(1));
  }

  @Test
  public void haveToReturnTwo() {
    Assert.assertEquals(2, paths.countWays(4));
  }
}
