package lv_427.logic.kateryna_horokh;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FriendPairsTest {

  private FriendPairs friendPairs;

  @Before
  public void init() {
    friendPairs = new FriendPairs();
  }

  @Test
  public void shouldReturn4ConnectionsWhenInputIs3Friends() {
    Assert.assertEquals(4, friendPairs.findNumberOfWays("3"));
  }

  @Test
  public void passingBigNumber() {
    Assert.assertEquals(0, friendPairs.findNumberOfWays("500"));
  }

  @Test
  public void passingMaxNumberWhichWillReturnValidResult() {
    Assert.assertEquals(476894976, friendPairs.findNumberOfWays("27"));
  }
}