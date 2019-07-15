package lv_427.logic.roman_zahorui;

import mockit.Deencapsulation;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Class is for testing StringParser class.
 *
 * @author Nazar Stasyuk
 * @version 1.0
 */
public class StringParserTest {

  private StringParser stringParser;

  @Before
  public void init() {
    this.stringParser = new StringParser();
  }


  /** Method for testing parseStringToSize method */
  @Test
  public void parseStringToSize() {

    int[] invoke = Deencapsulation.invoke(stringParser, "parseStringToSize", "3 x 3");
    int[] testArray = {3, 3};
    for (int i = 0; i < invoke.length; i++) {
      assertEquals(invoke[i], testArray[i]);
    }
  }
  /** Method for testing exception in parseStringToSize method */
  @Test(expected = NumberFormatException.class)
  public void parseStringToSizeException() {
    Deencapsulation.invoke(stringParser, "parseStringToSize", "x x 3");
  }
}
