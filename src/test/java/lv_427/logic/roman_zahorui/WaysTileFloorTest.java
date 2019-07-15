package lv_427.logic.roman_zahorui;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WaysTileFloorTest {
  private WaysTileFloor waysTileFloor;

  @Before
  public void init() {
    waysTileFloor = new WaysTileFloor();
  }

  @Test
  public void shouldReturnOne() {
    Assert.assertEquals(1, waysTileFloor.getWaysToTile(2, 3));
  }

  @Test
  public void parseDataWhichNotFitPatternShouldReturnNull() {
    Assert.assertNull(waysTileFloor.parseStringToSize("4, 5"));
  }

  @Test
  public void parseInvalidRandomDataShouldReturnNull() {
    Assert.assertNull(waysTileFloor.parseStringToSize("kkkkeee"));
  }

  @Test
  public void parseValidStringShouldReturnValidResult() {
    Assert.assertArrayEquals(new int[] {4, 5}, waysTileFloor.parseStringToSize("4 x 5"));
  }

  @Test(expected = NumberFormatException.class)
  public void parseInvalidDateShouldReturnException() {
    waysTileFloor.parseStringToSize("k x 5");
  }
}