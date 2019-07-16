package lv_427.logic.marian_milian;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import mockit.Deencapsulation;

/**
 * Class is for testing InterestingRowTest class.
 *
 * @author Zakhar Skaletskyi
 * @version 1.0
 */
public class InterestingRowTest {
	InterestingRow interestingRow = new InterestingRow();

	/** Method for testing generateValue() method */
	@Test
	public void testGenerateValue() {
		int input = Deencapsulation.invoke(interestingRow, "generateValue", 1);
		assertEquals(1, input);
		input = Deencapsulation.invoke(interestingRow, "generateValue", 3);
		assertEquals(3, input);

	}

	/** Method for testing isInputDataValid() method */
	@Test
	public void tetIsInputDataValid() {
		boolean isValid = Deencapsulation.invoke(interestingRow, "isInputDataValid", "2");
		assertEquals(true, isValid);
		isValid = Deencapsulation.invoke(interestingRow, "isInputDataValid", "20"); //////////////
		assertEquals(true, isValid);
		isValid = Deencapsulation.invoke(interestingRow, "isInputDataValid", "1");
		assertEquals(true, isValid);
		isValid = Deencapsulation.invoke(interestingRow, "isInputDataValid", "0");
		assertEquals(false, isValid);
		isValid = Deencapsulation.invoke(interestingRow, "isInputDataValid", "d");
		assertEquals(false, isValid);
	}

	/** Method for testing getElementFromList() method */
	@Test
	public void testGetElementFromList() {
		List<Integer> sequenceOfInterestingRow = new ArrayList<Integer>();
		for (int i = 0; i < 20; i++) {
			sequenceOfInterestingRow.add(i);
		}
		Deencapsulation.setField(interestingRow, "sequenceOfInterestingRow", sequenceOfInterestingRow);
		String elementFromList = Deencapsulation.invoke(interestingRow, "getElementFromList", 2);
		assertEquals("1", elementFromList);
		elementFromList = Deencapsulation.invoke(interestingRow, "getElementFromList", 20);
		assertEquals("19", elementFromList);
		elementFromList = Deencapsulation.invoke(interestingRow, "getElementFromList", 1);
		assertEquals("0", elementFromList);
	}
}
