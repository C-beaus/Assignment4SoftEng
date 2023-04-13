package converter;

import converter.exceptions.MalformedNumberException;
import converter.exceptions.ValueOutOfBoundsException;

/**
 * This class implements a converter that takes a string that represents a number in either the
 * Kibenian or Arabic numeral form. This class has methods that will return a value in the chosen form.
 *
 * @version 3/31/2023
 */
public class KibenianArabicConverter {

    // A string that holds the number (Kibenian or Arabic) you would like to convert
    private final String number;

    /**
     * Constructor for the KibenianArabic class that takes a string. The string should contain a valid
     * Kibenian or Arabic numeral. See the assignment instructions for what constitutes a correct input
     * and what exceptions should be raised.
     *
     * @param number A string that represents either a Kibenian or Arabic number.
     * @throws ValueOutOfBoundsException Thrown if the value is an Arabic integer that cannot be represented
     * in the Kibenian number system.
     * @throws MalformedNumberException Thrown if the value is an Kibenian number that does not conform
     * to the rules of the Kibenian number system or any other error in Arabic number input.
     */
    public KibenianArabicConverter(String number) throws MalformedNumberException, ValueOutOfBoundsException {

        // TODO check to see if the number is valid, then set it equal to the string
        this.number = number;
    }

    /**
     * Converts the number to an Arabic numeral or returns the current value as an int if it is already
     * in the Arabic form.
     *
     * @return An arabic value
     */
    public int toArabic(){
        // TODO Fill in the method's body
        return 1;
    }

    /**
     * Converts the number to an Kibenian numeral or returns the current value if it is already in the Kibenian form.
     *
     * @return A Kibenian value
     */
    public String toKibenian() {
        // TODO Fill in the method's body
        return "I";
    }

}

//public class KibenianArabicConverter {
//    private final static String[] KIBENIAN_SYMBOLS = {"_", "L", "X", "V", "I"};
//    private final static int[] ARABIC_VALUES = {60, 50, 10, 5, 1};
//    private final static int MIN_ARABIC_VALUE = 1;
//    private final static int MAX_ARABIC_VALUE = 60;
//
//    private String number;
//
//    public KibenianArabicConverter(String number) throws MalformedNumberException, ValueOutOfBoundsException {
//        this.number = number;
//        validateNumber();
//    }
//
//    private void validateNumber() throws MalformedNumberException, ValueOutOfBoundsException {
//        if (!number.matches("[0-9_]+")) {
//            throw new MalformedNumberException("Number contains invalid characters: " + number);
//        }
//
//        if (number.startsWith("0")) {
//            throw new ValueOutOfBoundsException("Number cannot have leading zeros: " + number);
//        }
//
//        int arabicValue = toArabic();
//        if (arabicValue < MIN_ARABIC_VALUE || arabicValue > MAX_ARABIC_VALUE) {
//            throw new ValueOutOfBoundsException("Number is out of bounds: " + number);
//        }
//    }
//
//    public String toKibenian() {
//        int arabicValue = Integer.parseInt(number);
//        StringBuilder sb = new StringBuilder();
//
//        for (int i = 0; i < KIBENIAN_SYMBOLS.length; i++) {
//            while (arabicValue >= ARABIC_VALUES[i]) {
//                sb.append(KIBENIAN_SYMBOLS[i]);
//                arabicValue -= ARABIC_VALUES[i];
//            }
//        }
//
//        return sb.toString();
//    }
//
//    public int toArabic() {
//        int arabicValue = 0;
//        int lastArabicValue = 0;
//
//        for (int i = 0; i < number.length(); i++) {
//            char c = number.charAt(i);
//            int arabicDigitValue = getArabicDigitValue(c);
//
//            if (arabicDigitValue > lastArabicValue) {
//                arabicValue += (arabicDigitValue - 2 * lastArabicValue);
//            } else {
//                arabicValue += arabicDigitValue;
//            }
//
//            lastArabicValue = arabicDigitValue;
//        }
//
//        return arabicValue;
//    }
//
//    private int getArabicDigitValue(char kibenianSymbol) {
//        switch (kibenianSymbol) {
//            case '_':
//                return 60;
//            case 'L':
//                return 50;
//            case 'X':
//                return 10;
//            case 'V':
//                return 5;
//            case 'I':
//                return 1;
//            default:
//                throw new IllegalArgumentException("Invalid Kibenian symbol: " + kibenianSymbol);
//        }
//    }
//}
