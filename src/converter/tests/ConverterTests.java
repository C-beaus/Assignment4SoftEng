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
    //Exceptions
    @Test(expected = ValueOutOfBoundsException.class)
    public void ArabicLeadingZero() throws MalformedNumberException, ValueOutOfBoundsException {
        String leadingZero = "0123";
        KibenianArabicConverter converter = new KibenianArabicConverter(leadingZero);
        converter.toArabic();
    }
    //Kibenian to Kibenian
    @Test
    public void KibenianToKibenian1() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("I");
        assertEquals(converter.toArabic(), "I");
    }
    @Test
    public void KibenianToKibenian5() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("V");
        assertEquals(converter.toArabic(), "V");
    }
    @Test
    public void KibenianToKibenian10() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("X");
        assertEquals(converter.toArabic(), "X");
    }
    @Test
    public void KibenianToKibenian50() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("L");
        assertEquals(converter.toArabic(), "L");
    }

    //Arabic to Arabic
    @Test
    public void ArabicToArabic1() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("1");
        assertEquals(converter.toKibenian(), 1);
    }
    @Test
    public void ArabicToArabic5() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("5");
        assertEquals(converter.toKibenian(), 5);
    }
    @Test
    public void ArabicToArabic10() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("10");
        assertEquals(converter.toKibenian(), 10);
    }
    @Test
    public void ArabicToArabic50() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("50");
        assertEquals(converter.toKibenian(), 50);
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
    @Test
    public void KibenianToArabic_() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("_");
        assertEquals(converter.toKibenian(), 60);
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
        assertEquals(converter.toKibenian(), "708");
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
    @Test(expected = MalformedNumberException.class)
    public void KibenianToArabicSub59() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("LX");
        converter.toArabic();
    }
}


/*Checklist of Rules handled (* = some, ** = close, *** = finished)
* L may appear only once
* X may appear up to four times in a row
* V may appear only once
* I may appear up to four times in a row
*
*/

