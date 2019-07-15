package lv_427.logic.kateryna_horokh;

import mockit.Deencapsulation;
import mockit.Tested;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FriendPairsTest {

  @Tested
  private FriendPairs friendPairs;

  @Before
  public void init() {
    friendPairs = new FriendPairs();
  }

  @Test
  public void shouldReturn4ConnectionsWhenInputIs3Friends() {
    int countOfWays = Deencapsulation.invoke("friendPairs", "findNumberOfWays", "3");
    Assert.assertEquals(4, countOfWays);
  }

  @Test
  public void passingMaxNumberWhichWillReturnValidResult() {
    int countOfWays = Deencapsulation.invoke("friendPairs", "findNumberOfWays", "27");
    Assert.assertEquals(476894976, countOfWays);
  }
}