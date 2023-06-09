package converter;

import converter.exceptions.MalformedNumberException;
import converter.exceptions.ValueOutOfBoundsException;
import lombok.Getter;
import lombok.Value;

import java.util.regex.Pattern;

/**
 * This class implements a converter that takes a string that represents a number in either the
 * Kibenian or Arabic numeral form. This class has methods that will return a value in the chosen form.
 *
 * @version 3/31/2023
 */
public class KibenianArabicConverter {

    // A string that holds the number (Kibenian or Arabic) you would like to convert
    @Getter
    private final String number;

    /**
     * Constructor for the KibenianArabic class that takes a string. The string should contain a valid
     * Kibenian or Arabic numeral. See the assignment instructions for what constitutes a correct input
     * and what exceptions should be raised.
     *
     * @param number A string that represents either a Kibenian or Arabic number.
     * @throws ValueOutOfBoundsException Thrown if the value is an Arabic integer that cannot be represented
     *                                   in the Kibenian number system.
     * @throws MalformedNumberException  Thrown if the value is an Kibenian number that does not conform
     *                                   to the rules of the Kibenian number system or any other error in Arabic number input.
     */
    public KibenianArabicConverter(String number) throws MalformedNumberException, ValueOutOfBoundsException {

        // TODO check to see if the number is valid, then set it equal to the string
        //if contains Kibenian characters run kibenian check
        /**
         * ^((L|X{0,4})(IX|IV|V?I{0,3})|X{0,4}(XC|XL|L?X{0,3})|[IVX]{1,4})?(_{1}(L|X{0,4})(IX|IV|V?I{0,3})|X{0,4}(XC|XL|L?X{0,3})|[IVX]{1,4})?(_{1}(L|X{0,4})(IX|IV|V?I{0,3})|X{0,4}(XC|XL|L?X{0,3})|[IVX]{1,4})?$
         *
         *
         * X
         * X_
         * X_X
         * X__
         * X_X_
         * X__X
         * X_X_X
         *
         * L
         * L X {0,4}
         * L X {0,4} V
         * LX {0,4} V I {0,4}
         * X {0,4} V I {0,4}
         * V I {0,4}
         * I {0,4}
         *
         */
        String string = "(L?X{0,4}(V?)(I{0,4}))";
        Pattern patternKibenian = Pattern.compile("^"+ string + "|" + string + "_"+ "|" + string + "_" + string + "|" + string + "__" + "|" + string + "_" + string + "_" + "|" + string + "__" + string + "|" + string + "_" + string + "_" + string + " $");
        Pattern test = Pattern.compile("^" + string + "__");
        if(numberIsKibenian(number)){
            if (!patternKibenian.matcher(number).matches()) {
                throw new MalformedNumberException("Number contains invalid characters: " + number);
            }
        }
        //else if contains Arabic characters run Arabic check
        else if (numberIsArabic(number)){

        }
        //neither
        else{
            throw new MalformedNumberException("Number contains invalid characters: " + number);
        }
        this.number = number;
    }

    private boolean numberIsArabic(String number) {
        Pattern isArabic = Pattern.compile("^[0-9]+$", Pattern.CASE_INSENSITIVE);
        return isArabic.matcher(number).matches();
    }

    private boolean numberIsKibenian(String number) {
        Pattern isKibenian = Pattern.compile("^[LXVI_]+$", Pattern.CASE_INSENSITIVE);
        return isKibenian.matcher(number).matches();
    }

    public String getNumber() {
        return number;
    }


    /**
     * Converts the number to an Arabic numeral or returns the current value as an int if it is already
     * in the Arabic form.
     *
     * @return An arabic value
     */
    public int toArabic() {
        // TODO Fill in the method's body
        int result = 0;
        int subTotal = 0;
        int multiplier = 1;

        for (int i = number.length() - 1; i >= 0; i--) {
            char c = number.charAt(i);

            switch (c) {
                case 'I':
                    subTotal += 1;
                    break;
                case 'V':
                    subTotal += 5;
                    break;
                case 'X':
                    subTotal += 10;
                    break;
                case 'L':
                    subTotal += 50;
                    break;
                case '_':
                    result += subTotal * multiplier;
                    subTotal = 0;

                    if (i > 1 && number.charAt(i - 2) == '_') {
                        multiplier *= 3600;
                    } else {
                        multiplier *= 60;
                    }

                    break;
            }
        }

        result += subTotal * multiplier;
        return result;
    }

    /**
     * Converts the number to an Kibenian numeral or returns the current value if it is already in the Kibenian form.
     *
     * @return A Kibenian value
     */
    public String toKibenian() throws ValueOutOfBoundsException {
        // TODO Fill in the method's body
        int numInt = Integer.parseInt(number);
        if (numInt <= 0 || numInt > 215999) {
            throw new ValueOutOfBoundsException("Number is out of bounds");
        }
        StringBuilder stringBuilder = new StringBuilder();
        int valueLeft = numInt;
        int modulus = valueLeft % 3600;
        int lastValue = valueLeft;
//        valueLeft /= 3600;
        Boolean secondUnderscore = false;
        Boolean firstUnderscore = false;
        int valueSaver = 0;
        //1 pass
        if (modulus > 0 && !(modulus == valueLeft)) {
            int valueLeft2 = lastValue - 3599;
            valueSaver = valueLeft2;
            int beforeUnderscore2 = valueLeft2 / 3600;
            if ((beforeUnderscore2 - 50) >= 0) {
                stringBuilder.append("L");
                beforeUnderscore2 -= 50;
                secondUnderscore = true;
//          int beforeTwoModulus = valueLeft2 % 3600
            }
            for (int i = 0; i < 4; i++) {
                if ((beforeUnderscore2 - 10) >= 0) {
                    stringBuilder.append("X");
                    beforeUnderscore2 -= 10;
                    secondUnderscore = true;
//            int lastValue2 = beforeTwoModulus
                }
            }
            if ((beforeUnderscore2 - 5) >= 0) {
                stringBuilder.append("V");
                beforeUnderscore2 -= 5;
                secondUnderscore = true;
            }
            for (int i = 0; i < 4; i++) {
                if ((beforeUnderscore2 - 1) >= 0) {
                    stringBuilder.append("I");
                    beforeUnderscore2 -= 1;
                    secondUnderscore = true;
//            int lastValue2 = beforeTwoModulus
                }
            }
            if (secondUnderscore) {
                stringBuilder.append("_");
                valueLeft = valueLeft - valueSaver;
//                modulus = valueLeft % 60;
            }
        } else if (modulus == 0) {
            stringBuilder.append("I_");
            valueLeft = valueLeft - 3600;
//            modulus = valueLeft % 60;
        }

        modulus = valueLeft % 60;

        //2 pass
        if (modulus > 0 && !(modulus == valueLeft)) {
            int valueLeft2 = lastValue - 60;
            valueSaver = valueLeft2;
            int beforeUnderscore2 = valueLeft2 / 60;
            if ((beforeUnderscore2 - 50) >= 0) {
                stringBuilder.append("L");
                beforeUnderscore2 -= 50;
                firstUnderscore = true;
//          int beforeTwoModulus = valueLeft2 % 3600
            }
            for (int i = 0; i < 4; i++) {
                if ((beforeUnderscore2 - 10) >= 0) {
                    stringBuilder.append("X");
                    beforeUnderscore2 -= 10;
                    firstUnderscore = true;
//            int lastValue2 = beforeTwoModulus
                }
            }
            if ((beforeUnderscore2 - 5) >= 0) {
                stringBuilder.append("V");
                beforeUnderscore2 -= 5;
                firstUnderscore = true;
            }
            for (int i = 0; i < 4; i++) {
                if ((beforeUnderscore2 - 1) >= 0) {
                    stringBuilder.append("I");
                    beforeUnderscore2 -= 1;
                    firstUnderscore = true;
//            int lastValue2 = beforeTwoModulus
                }
            }
            if (firstUnderscore) {
                stringBuilder.append("_");
                valueLeft = valueLeft - valueSaver;
            }
        } else if (modulus == 0) {
            stringBuilder.append("I_");
            valueLeft = valueLeft - 60;
        }
        //3 pass
//        int valueLeft2 = lastValue - 60;
//        valueSaver = valueLeft2;
//        int beforeUnderscore2 = valueLeft2 / 60;
        if ((valueLeft - 50) >= 0) {
            stringBuilder.append("L");
            valueLeft -= 50;
//          int beforeTwoModulus = valueLeft2 % 3600
        }
        for (int i = 0; i < 4; i++) {
            if ((valueLeft - 10) >= 0) {
                stringBuilder.append("X");
                valueLeft -= 10;
//            int lastValue2 = beforeTwoModulus
            }
        }
        if ((valueLeft - 5) >= 0) {
            stringBuilder.append("V");
            valueLeft -= 5;
        }
        for (int i = 0; i < 4; i++) {
            if ((valueLeft - 1) >= 0) {
                stringBuilder.append("I");
                valueLeft -= 1;
//            int lastValue2 = beforeTwoModulus
            }
        }
        return stringBuilder.toString();
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
