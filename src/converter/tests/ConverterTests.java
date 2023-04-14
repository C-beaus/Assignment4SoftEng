package converter.tests;

import converter.KibenianArabicConverter;
import converter.exceptions.MalformedNumberException;
import converter.exceptions.ValueOutOfBoundsException;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test cases for the KibenianArabicConverter class.
 */
public class ConverterTests {

    @Test
    public void KibenianToArabicSampleTest() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("1");
        assertEquals(converter.toKibenian(), "I");
    }

    @Test
    public void ArabicToKibenianSampleTest() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("I");
        assertEquals(converter.toArabic(), 1);
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumberTest() throws MalformedNumberException, ValueOutOfBoundsException {
        throw new MalformedNumberException("TEST");
    }

    @Test(expected = ValueOutOfBoundsException.class)
    public void valueOutOfBoundsTest() throws MalformedNumberException, ValueOutOfBoundsException {
        throw new ValueOutOfBoundsException("0");
    }

    // TODO Add more test cases
    //check if valid Kibenian format
        //Only accepts capital Kibenian and not lowercase
    @Test(expected = MalformedNumberException.class)
    public void CapitalOnlyCheck() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("x");
    }
    @Test(expected = MalformedNumberException.class)
    public void CapitalOnlyCheck_2() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("xiii");
    }
    @Test(expected = MalformedNumberException.class)
    public void CapitalOnlyCheck_3() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("i");
    }
    @Test(expected = MalformedNumberException.class)
    public void CapitalOnlyCheck_4() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("l");
    }
        //only two or less underscores
    @Test(expected = MalformedNumberException.class)
    public void ThreeUnderscoresTogether() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("X___");
    }
    @Test(expected = MalformedNumberException.class)
    public void ThreeUnderscoresSeperated() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("X__I_");
    }
    @Test
    public void TwoOrLessUnderscoresOnly2() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("X__");
        assertEquals(converter.getNumber(), "X__");
    }
    @Test
    public void TwoOrLessUnderscoresOnly2SplitUp() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("V_I_");
        assertEquals(converter.getNumber(), "V_I_");
    }
        //No leading or trailing spaces or spaces in between
    @Test(expected = MalformedNumberException.class)
    public void LeadingSpace() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter(" X");
    }
    @Test(expected = MalformedNumberException.class)
    public void TrailingSpace() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("X ");
    }
    @Test(expected = MalformedNumberException.class)
    public void SpaceInBetween() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("X I");
    }
        //Only one L but L okay in different positioning

    @Test(expected = MalformedNumberException.class)
    public void TwoLsTogether() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("LL_VI");
    }
    @Test(expected = MalformedNumberException.class)
    public void TwoLsTogetherInSecondGroup() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("XXI_LL");
    }
    
        //no negatives Arabic or Kibenian
    @Test(expected = MalformedNumberException.class)
    public void NoNegativeKibenian() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("-X_I");
    }
    @Test(expected = MalformedNumberException.class)
    public void NoNegativeKibenian_2() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("-X");
    }
    @Test(expected = MalformedNumberException.class)
    public void NoNegativeKibenian_3() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("I-");
    }
    @Test(expected = ValueOutOfBoundsException.class)
    public void NoNegativeArabic() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("-2");
//        assertEquals(converter.toKibenian(), )
    }
    @Test(expected = ValueOutOfBoundsException.class)
    public void NoNegativeArabic_2() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("-0");
    }
    // Arabic out of bounds
    @Test(expected = ValueOutOfBoundsException.class)
    public void NoNegativeArabic_3() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("3000000000");
    }
    // No Kibenian
    
    // Kibenian does not accept random other letters
    @Test(expected = MalformedNumberException.class)
    public void NoRandomLettersCheck() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("d");
    }
    @Test(expected = MalformedNumberException.class)
    public void NoRandomLettersCheck_2() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("D");
    }
    @Test(expected = MalformedNumberException.class)
    public void NoRandomLettersCheck_3() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("a");
    }
    @Test(expected = MalformedNumberException.class)
    public void NoRandomLettersCheck_4() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("A");
    }
    //Kibenian does not accept random symbols
    @Test(expected = MalformedNumberException.class)
    public void NoRandomSymbolsCheck() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("=");
    }
    @Test(expected = MalformedNumberException.class)
    public void NoRandomSymbolsCheck_2() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("+");
    }
    @Test(expected = MalformedNumberException.class)
    public void NoRandomSymbolsCheck_3() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("-");
    }
    @Test(expected = MalformedNumberException.class)
    public void NoRandomSymbolsCheck_4() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("-_");
    }
    //decimal points are malformed numbers
    @Test(expected = MalformedNumberException.class)
    public void NoDecimalPointsCheck() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("1.2");
    }
    @Test(expected = MalformedNumberException.class)
    public void NoDecimalPointsCheck_2() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("20.5");
    }
    @Test(expected = MalformedNumberException.class)
    public void NoDecimalPointsCheck_3() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("30.000001");
    }
    //No decimal points in Kibenian
    @Test(expected = MalformedNumberException.class)
    public void NoDecimalPointsCheck_K() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("X.X");
    }
    @Test(expected = MalformedNumberException.class)
    public void NoDecimalPointsCheck_K2() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("X.");
    }
    @Test(expected = MalformedNumberException.class)
    public void NoDecimalPointsCheck_K3() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter(".L");
    }
    //spaces in between letters or numbers are not accepted
        //Kibenian
    @Test(expected = MalformedNumberException.class)
    public void NoSpacesCheck() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("X I");
    }
    @Test(expected = MalformedNumberException.class)
    public void NoSpacesCheck_2() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("L   I");
    }
    @Test(expected = MalformedNumberException.class)
    public void NoSpacesCheck_3() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("X V I");
    }
        //Arabic
    @Test(expected = MalformedNumberException.class)
    public void NoSpacesCheck_A() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("1 2");
    }
    @Test(expected = MalformedNumberException.class)
    public void NoSpacesCheck_A1() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("3    5");
    }
    @Test(expected = MalformedNumberException.class)
    public void NoSpacesCheck_A2() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("2 5 7");
    }


    
    
        //Only four Xs but spaces more in separate positioning is okay
    @Test
    public void FourXsTogether() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("XXXX");
        Assert.assertEquals(converter.getNumber(), "XXXX");
    }
    @Test(expected = MalformedNumberException.class)
    public void FiveXsTogether() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("XXXXX");
    }
    @Test
    public void FiveXsbutDifferentPositioningCheck() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("X_XXXX");
        assertEquals(converter.toArabic(), 640);
    }
    //I can appear more than four times if in different positional groups
    @Test
    public void FiveIsbutDifferentPositioningCheck() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("I_IIII");
        assertEquals(converter.toArabic(), 64);
    }
    //More than one V okay if different groups
    @Test
    public void TwoVsbutDifferentPositioningCheck() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("V_V");
        assertEquals(converter.toArabic(), 305);
    }
    //More than one L okay if in different positional groups
    @Test
    public void OneLSeperated() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("L_L");
        Assert.assertEquals(converter.getNumber(), "L_L");
    }
    //Hanging underscore at beginning is not okay
    @Test(expected = MalformedNumberException.class)
    public void HangingUnderscoreBeginningCheck() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("_L");
    }
    //Numbers and underscores together is not accepted
    @Test(expected = MalformedNumberException.class)
    public void NumbersAndUnderscoresCheck() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("1_3");
    }
    @Test(expected = MalformedNumberException.class)
    public void NumbersAndUnderscoresCheck_2() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("_3");
    }
    @Test(expected = MalformedNumberException.class)
    public void NumbersAndUnderscoresCheck_3() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("1_");
    }
    @Test(expected = MalformedNumberException.class)
    public void NumbersAndUnderscoresCheck_4() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("3_");
    }
    @Test(expected = MalformedNumberException.class)
    public void NumbersAndUnderscoresCheck_5() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("12_4");
    }

    //decimal with Kibenian is not okay
    @Test(expected = MalformedNumberException.class)
    public void DecimalWithKibenianCheck() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("X.X");
    }
    @Test(expected = MalformedNumberException.class)
    public void DecimalWithKibenianCheck_2() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("X.");
    }
    @Test(expected = MalformedNumberException.class)
    public void DecimalWithKibenianCheck_3() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter(".X");
    }
    @Test(expected = MalformedNumberException.class)
    public void DecimalWithKibenianCheck_4() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("XI_I.I");
    }
    @Test(expected = MalformedNumberException.class)
    public void DecimalWithKibenianCheck_5() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("XI._II");
    }
    @Test(expected = MalformedNumberException.class)
    public void DecimalWithKibenianCheck_6() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("X.I_II");
    }
    @Test(expected = MalformedNumberException.class)
    public void DecimalWithKibenianCheck_7() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("XI_II.");
    }
    @Test(expected = MalformedNumberException.class)
    public void DecimalWithKibenianCheck_8() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter(".XI_II");
    }

    //Double underscore hanging is okay
    @Test
    public void DoubleHangingDecimalCheck() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("I__");
        assertEquals(converter.toArabic(), 3600);
    }
    //Kibenian input out of bounds of allowed input numbers
    @Test (expected = MalformedNumberException.class)
    public void KibenianOutOfBounds() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("LXXXXVIIII__LXXXXVIIII");
    }
    //Can separate two underscores
    @Test
    public void KibenianWithThreeSubgroups() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("I_I_I");
        assertEquals(converter.toArabic(), 3661);
    }

    //check if valid Arabic format

    //Exceptions
    @Test(expected = MalformedNumberException.class)
    public void ArabicLeadingZero() throws MalformedNumberException, ValueOutOfBoundsException {
        String leadingZero = "0123";
        KibenianArabicConverter converter = new KibenianArabicConverter(leadingZero);
        converter.toArabic();
    }
    //Kibenian to Kibenian
    @Test
    public void KibenianToKibenian1() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("I");
        assertEquals(converter.toKibenian(), "I");
    }
    @Test
    public void KibenianToKibenian5() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("V");
        assertEquals(converter.toKibenian(), "V");
    }
    @Test
    public void KibenianToKibenian10() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("X");
        assertEquals(converter.toKibenian(), "X");
    }
    @Test
    public void KibenianToKibenian50() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("L");
        assertEquals(converter.toKibenian(), "L");
    }

    //Arabic to Arabic
    @Test
    public void ArabicToArabic1() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("1");
        assertEquals(converter.toArabic(), 1);
    }
    @Test
    public void ArabicToArabic5() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("5");
        assertEquals(converter.toArabic(), 5);
    }
    @Test
    public void ArabicToArabic10() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("10");
        assertEquals(converter.toArabic(), 10);
    }
    @Test
    public void ArabicToArabic50() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("50");
        assertEquals(converter.toArabic(), 50);
    }
    //Kibenian to Arabic
    @Test
    public void KibenianToArabic5() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("V");
        assertEquals(converter.toArabic(), 5);
    }
    @Test
    public void KibenianToArabic10() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("X");
        assertEquals(converter.toArabic(), 10);
    }
    @Test
        public void KibenianToArabic50() throws MalformedNumberException, ValueOutOfBoundsException {
            KibenianArabicConverter converter = new KibenianArabicConverter("L");
            assertEquals(converter.toArabic(), 50);
        }
    @Test(expected = MalformedNumberException.class)
    public void KibenianToArabic_() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("_");
//        assertEquals(converter.toKibenian(), 0);
    }

    //Arabic to Kibenian

    @Test
    public void ArabicToKibenian5() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("5");
        assertEquals(converter.toKibenian(), "V");
    }

    @Test
    public void ArabicToKibenian10() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("10");
        assertEquals(converter.toKibenian(), "X");
    }

    @Test
    public void ArabicToKibenian50() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("50");
        assertEquals(converter.toKibenian(), "L");
    }


    //Basic Operations
        //Kibenian to Arabic
    @Test
    public void KibenianToArabicBasic1() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("XI_XXXXVIII");
        assertEquals(converter.toArabic(), 708);
    }
        //Arabic to Kibenian
    @Test
    public void ArabicToKibenianBasic1() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("708");
        assertEquals(converter.toKibenian(), "XI_XXXXVIII");
    }
    
    //L can only appear once
        //Kibenian to Arabic
    @Test(expected = MalformedNumberException.class)
    public void KibenianToArabicLOnce() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("LL");
        converter.toArabic();
    }
        //Arabic to Kibenian
    @Test
    public void ArabicToKibenianLOnce() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("100");
        Assert.assertNotEquals("LL", converter.toKibenian());
    }

    //X only four times in a row
        //Kibenian to Arabic
    @Test(expected = MalformedNumberException.class)
    public void KibenianToArabicXFourTimes() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("XXXXX");
        converter.toArabic();
    }
        //Arabic to Kibenian
    @Test
    public void ArabicToKibenianXFourTimes() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("50");
        Assert.assertNotEquals("XXXXX", converter.toKibenian());
    }

    //V can only appear once
        //Kibenian to Arabic
    @Test(expected = MalformedNumberException.class)
    public void KibenianToArabicVOnce() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("VV");
        converter.toArabic();
    }
        //Arabic to Kibenian
    @Test
    public void ArabicToKibenianVOnce() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("10");
        Assert.assertNotEquals("VV", converter.toKibenian());
    }
    //I only four times in a row
        //Kibenian to Arabic
    @Test(expected = MalformedNumberException.class)
    public void KibenianToArabicIFourTimes() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("IIIII");
        converter.toArabic();
    }
        //Arabic to Kibenian
    @Test
    public void ArabicToKibenianIFourTimes() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("5");
        Assert.assertNotEquals("IIIII", converter.toKibenian());
    }
    //Total for subgroup can not exceed 59
        //Kibenian to Arabic
    @Test(expected = MalformedNumberException.class)
    public void KibenianToArabicSub59() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("LX");
        converter.toArabic();
    }
        //Arabic to Kibenian
    @Test
    public void ArabicToKibenianSub59() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("60");
        Assert.assertNotEquals("LX", converter.toKibenian());
    }
//    @Test
//    public void ArabicToKibenianSub59_2() throws MalformedNumberException, ValueOutOfBoundsException {
//        KibenianArabicConverter converter = new KibenianArabicConverter("60");
//        Assert.assertNotEquals("XXXXV", converter.toKibenian());
//    }
    //Check Arabic to Kibenian conversion: order of letters
    @Test
    public void ArabicToKibenianOrderCheck() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("11");
        Assert.assertNotEquals("IX", converter.toKibenian());
    }
    @Test
    public void ArabicToKibenianOrderCheck_2() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("6");
        Assert.assertNotEquals("IV", converter.toKibenian());
    }
    @Test
    public void ArabicToKibenianOrderCheck_3() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("48");
        Assert.assertNotEquals("VIIIXXXX", converter.toKibenian());
        Assert.assertNotEquals("XXXXIIIV", converter.toKibenian());
        Assert.assertNotEquals("VXXXXIII", converter.toKibenian());
        assertEquals("XXXXVIII", converter.toKibenian());
    }
    @Test
    public void ConverterNumberInBounds() throws MalformedNumberException, ValueOutOfBoundsException {
        String num = "XXV";
        KibenianArabicConverter converter = new KibenianArabicConverter("XXV");
        assertEquals(converter.getNumber(), num);
    }
    @Test(expected = MalformedNumberException.class)
    public void ConverterNumberInBounds_2() throws MalformedNumberException, ValueOutOfBoundsException {
        String num = "LX";
        KibenianArabicConverter converter = new KibenianArabicConverter("LX");
        //assertEquals(converter.getNumber(), num);
    }
    //empty check
    @Test(expected = MalformedNumberException.class)
    public void ConverterEmptyCheck() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("");
    }
    //zero check
    @Test(expected = ValueOutOfBoundsException.class)
    public void ConverterZeroCheck() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("0");
    }
    //less than zero check
    @Test(expected = ValueOutOfBoundsException.class)
    public void ConverterLessThanZeroCheck() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("-1");
    }
    //Arabic number too large check
    @Test(expected = ValueOutOfBoundsException.class)
    public void ConverterTooLargeCheck() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("216000");
    }

    @Test(expected = MalformedNumberException.class)
    public void CapitalOnlyCheck_5() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("v");
        //assertEquals(converter.getNumber(), num);
    }
    //double underscore check
    @Test
    public void DoubleUnderscore() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("I__I");
        assertEquals(converter.toArabic(), 3601);
    }
    //triple or more underscore check
    @Test(expected = MalformedNumberException.class)
    public void TripleOrMoreUnderscore() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("I___I");
//        assertEquals(converter.toArabic(), 3601);
    }

    //More for handling of underscores
    @Test (expected = MalformedNumberException.class)
    public void HangingUnderscoresOkay() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("I___I");
//        assertEquals(converter.toArabic(), 3601);
    }


}


/* Checklist of Rules handled (* = some, ** = close, *** = finished)
* L may appear only once
* X may appear up to four times in a row
* V may appear only once
* I may appear up to four times in a row
* total for the subgroup can not exceed 59
*/

/* What's left to Check
* three or more underscores in submission throws Malformed
* Only submitting an underscore throws malformed
 */

/*Notes
* fix Kibenian to Arabic as anything with two underscores to the right (even if not directly right of it) should be multiplied by 3600
* make functionality for converting arabic to arabic and kibenian to kibenian just passes back the same thing
* values out of bounds exceptions not being thrown
* underscores
* value of kibenian 60 should throw malformedNumberException
 */

//if any kibenian subgroup is greater than 59
//currently not allowing other letters in between underscores