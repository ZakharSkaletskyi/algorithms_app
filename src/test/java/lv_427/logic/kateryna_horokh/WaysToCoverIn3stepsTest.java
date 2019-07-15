package lv_427.logic.kateryna_horokh;

import lv_427.logic.zakhar_skaletskyi.WaysToCoverIn3steps;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class WaysToCoverIn3stepsTest {

  private WaysToCoverIn3steps waysToCoverIn3steps;

  @Before
  public void init() {
    waysToCoverIn3steps = new WaysToCoverIn3steps();
  }

  @Test
  public void isDateInputShouldBeNumber() {
//    Assert.assertFalse(waysToCoverIn3steps.getDistance());
//    Assert.assertTrue(waysToCoverIn3steps.getDistance());
  }

  @Test
  public void testReturnValueForNumberZeroAndOneAndTwo() {
    Assert.assertEquals(1, waysToCoverIn3steps.findStep(0));
    Assert.assertEquals(1, waysToCoverIn3steps.findStep(1));
    Assert.assertEquals(2, waysToCoverIn3steps.findStep(2));
  }

  @Test
  public void shouldReturnFour() {
    Assert.assertEquals(4, waysToCoverIn3steps.findStep(3));
  }

  @Test
    public void isNumberLessThan30() {
//      Assert.assertTrue(waysToCoverIn3steps.getDistance(29));
//      Assert.assertTrue(waysToCoverIn3steps.getDistance("30"));
//      Assert.assertFalse(waysToCoverIn3steps.getDistance("31"));
  }
}
