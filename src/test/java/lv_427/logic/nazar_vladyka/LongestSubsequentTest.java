package lv_427.logic.nazar_vladyka;

import static org.junit.Assert.*;

import java.util.Scanner;
import org.junit.Test;
import mockit.Deencapsulation;

/**
 * Class is for testing LongestSubsequentTest class.
 *
 * @author Zakhar Skaletskyi
 * @version 1.0
 */
public class LongestSubsequentTest {
	LongestSubsequent longestSubsequent = new LongestSubsequent();

	/** Method for testing find() method */
	@Test
	public void testFind() {
		int longestLength = Deencapsulation.invoke(longestSubsequent, "find", "1 -1 2 -2 2 2 6 5 5 0");
		assertEquals(2, longestLength);
		longestLength = Deencapsulation.invoke(longestSubsequent, "find", "1 2 3 0 1 5 4 3 2 0");
		assertEquals(4, longestLength);
		longestLength = Deencapsulation.invoke(longestSubsequent, "find", "0");
		assertEquals(1, longestLength);
		longestLength = Deencapsulation.invoke(longestSubsequent, "find", "4");
		assertEquals(1, longestLength);
	}

	/** Method for testing not valid format input data */
	@Test
	public void testExecuteForNumberFormatException() {
		Scanner sc = new Scanner("4223231321213889889132 \n2");
		Deencapsulation.setField(longestSubsequent, "sc", sc);
		longestSubsequent.execute();

		sc = new Scanner("text\n1 4 3 -3 -2 -1 5 4");
		Deencapsulation.setField(longestSubsequent, "sc", sc);
		longestSubsequent.execute();
	}

}
