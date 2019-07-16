package lv_427.logic.kateryna_horokh;

import mockit.Deencapsulation;
import mockit.Tested;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Class is for testing FriendPairs class.
 *
 * @author Nazar Vladyka
 * @version 1.0
 */
public class FriendPairsTest {
    @Tested
    private FriendPairs friendPairs;

    @Before
    public void init() {
        friendPairs = new FriendPairs();
    }

    @Test
    public void shouldReturnFalseWhenPassingStringInsteadOfNumber() {
        boolean isInputValid = Deencapsulation.invoke(friendPairs, "isInputValid", "sfs");
        assertFalse(isInputValid);
    }

    @Test
    public void shouldReturnFalseWhenPassingNegativeNumber() {
        boolean isInputValid = Deencapsulation.invoke(friendPairs, "isInputValid", "-1");
        assertFalse(isInputValid);
    }

    @Test
    public void shouldReturnFalseWhenPassingZero() {
        boolean isInputValid = Deencapsulation.invoke(friendPairs, "isInputValid", "0");
        assertFalse(isInputValid);
    }

    @Test
    public void shouldReturnFalseWhenPassingNumberBiggerThan27() {
        boolean isInputValid = Deencapsulation.invoke(friendPairs, "isInputValid", "28");
        assertFalse(isInputValid);
    }

    @Test
    public void shouldReturn4ConnectionsWhenInputIs3Friends() {
        int countOfWays = Deencapsulation.invoke(friendPairs, "findNumberOfWays", "3");
        assertEquals(4, countOfWays);
    }

    @Test
    public void passingMaxNumberWhichWillReturnValidResult() {
        int countOfWays = Deencapsulation.invoke(friendPairs, "findNumberOfWays", "27");
        assertEquals(476894976, countOfWays);
    }
}

