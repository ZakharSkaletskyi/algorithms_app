package lv_427.logic.roman_zahorui;

public class StringParser {

    /**
     * A string to separate incoming string into two integers.
     */
    private final static String SPLIT_PATTERN = " x ";

    /**
     * The method tries to extract data from the input string.
     * Format of the input string should contains :
     * first integer value, <code>SPLIT_PATTERN</code>, second integer value.
     *
     * @param strData - input string data.
     * @return an array of integers with length == 2 or null if strData can't
     * matches the correct string.
     */
    protected static int[] parseStringToSize(String strData, int firstMin, int secondMin) throws NumberFormatException {

        String strDataInLowCase = strData.toLowerCase();
        if (strDataInLowCase.contains(SPLIT_PATTERN)) {

            String[] sizeParts = strDataInLowCase.split(SPLIT_PATTERN);
            int[] sizeArray = new int[2];

            int widthValue = Integer.valueOf(sizeParts[0]);
            int heightValue = Integer.valueOf(sizeParts[1]);

            if (widthValue >= firstMin && heightValue >= secondMin) {
                sizeArray[0] = widthValue;
                sizeArray[1] = heightValue;
                return sizeArray;
            }
        }
        return null;
    }
}
