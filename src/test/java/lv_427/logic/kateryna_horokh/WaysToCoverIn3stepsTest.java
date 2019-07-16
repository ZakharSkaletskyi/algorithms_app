package lv_427.logic.kateryna_horokh;

import lv_427.logic.zakhar_skaletskyi.WaysToCoverIn3steps;
import mockit.Deencapsulation;
import mockit.Tested;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Scanner;

/**
 * Class is for testing WaysToCoverIn3steps class.
 *
 * @author Kateryna Horokh
 * @version 1.0
 */
public class WaysToCoverIn3stepsTest {

  @Tested private WaysToCoverIn3steps ways;

  @Before
  public void init() {
    ways = new WaysToCoverIn3steps();
  }

  /** Method for testing getDistance method */
  @Test
  public void dateInputShouldBeNumber() {
    Scanner sc = new Scanner("3");
    int input = Deencapsulation.invoke(ways, "getDistance", sc);
    Assert.assertEquals(3, input);
  }

  /** Method for testing getDistance method */
  @Test
  public void checkIfNumberLessThan30() {
    int input = Deencapsulation.invoke(ways, "getDistance", new Scanner("31\n29"));
    Assert.assertEquals(29, input);
  }

  /** Method for testing getDistance method */
  @Test
  public void checkIfNumberIsPositive() {
    int input = Deencapsulation.invoke(ways, "getDistance", new Scanner("-1\n1"));
    Assert.assertEquals(1, input);
  }

  /** Method for testing findStep method */
  @Test
  public void shouldReturnFour() {
    int input = Deencapsulation.invoke(ways, "findStep", 3);
    Assert.assertEquals(4, input);
  }

  /** Method for testing findStep method */
  @Test
  public void shouldReturnOne() {
    int input = Deencapsulation.invoke(ways, "findStep", 0);
    int input1 = Deencapsulation.invoke(ways, "findStep", 1);
    Assert.assertEquals(1, input);
    Assert.assertEquals(1, input1);
  }

  /** Method for testing findStep method */
  @Test
  public void shouldReturnTwo() {
    int input = Deencapsulation.invoke(ways, "findStep", 2);
    Assert.assertEquals(2, input);
  }
}
