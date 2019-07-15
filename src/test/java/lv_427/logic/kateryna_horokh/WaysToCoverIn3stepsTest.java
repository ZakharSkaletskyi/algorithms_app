package lv_427.logic.kateryna_horokh;

import lv_427.logic.zakhar_skaletskyi.WaysToCoverIn3steps;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.*;

public class WaysToCoverIn3stepsTest {

  private WaysToCoverIn3steps ways;

  @Before
  public void init() {
      ways = new WaysToCoverIn3steps();
  }

  @Test
  public void isDateInputShouldBeNumber() {
      assertEquals(3, ways.getDistance(new Scanner("3")));
  }

  @Test
  public void testReturnValueForNumberZeroAndOneAndTwo() {
    assertEquals(1, ways.findStep(0));
    assertEquals(1, ways.findStep(1));
    assertEquals(2, ways.findStep(2));
  }

  @Test
  public void shouldReturnFour() {
    assertEquals(4, ways.findStep(3));
  }

  @Test
    public void isNumberLessThan30() {
//      Assert.assertTrue(ways.getDistance(29));
//      Assert.assertTrue(ways.getDistance("30"));
//      Assert.assertFalse(ways.getDistance("31"));
  }
}
