package lv_427.logic.roman_zahorui;

public class StringParser {

  /** A string to separate incoming string into two integers. */
  private static final String SPLIT_PATTERN = " x ";

  /**
   * The method tries to extract data from the input string. Format of the input string should
   * contains : first integer value, <code>SPLIT_PATTERN</code>, second integer value.
   *
   * @param strData - input string data.
   * @return an array of integers with length == 2 or null if strData can't matches the correct
   *     string.
   */
  protected static int[] parseStringToSize(String strData)
      throws NumberFormatException {

    String strDataInLowCase = strData.toLowerCase();
    if (strDataInLowCase.contains(SPLIT_PATTERN)) {

      String[] integers = strDataInLowCase.split(SPLIT_PATTERN);
      int[] arr = new int[2];

      int firstVal = Integer.valueOf(integers[0]);
      int secondVal = Integer.valueOf(integers[1]);

      arr[0] = firstVal;
      arr[1] = secondVal;
      return arr;
    }
    return null;
  }
}
