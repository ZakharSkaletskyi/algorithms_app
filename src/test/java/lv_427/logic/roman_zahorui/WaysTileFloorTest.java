package lv_427.logic.roman_zahorui;

import mockit.Deencapsulation;
import mockit.Tested;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Class is for testing WaysTileFloor class.
 *
 * @author Nazar Vladyka
 * @version 1.0
 */
public class WaysTileFloorTest {
  @Tested private WaysTileFloor waysTileFloor;

  @Before
  public void init() {
    waysTileFloor = new WaysTileFloor();
  }

  @Test
  public void shouldReturnOne() {
    int ways = Deencapsulation.invoke(waysTileFloor, "getWaysToTile", 2, 3);
    assertEquals(1, ways);
  }

  @Test
  public void passingBigNumbers() {
    int ways = Deencapsulation.invoke(waysTileFloor, "getWaysToTile", 500, 400);
    assertEquals(102, ways);
  }

  @Test
  public void passingBigNumbers2() {
    int ways = Deencapsulation.invoke(waysTileFloor, "getWaysToTile", 100000000, 2);
    assertEquals(2147483647, ways);
  }
}