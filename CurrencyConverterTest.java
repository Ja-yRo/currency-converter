import org.junit.Test;
import static org.junit.Assert.*;

public class CurrencyConverterTest {


    @Test
    public void testNoArguments() {
        try {
            CurrencyConverter.main(new String[]{});
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("Error: Please provide both an amount and a currency type.", e.getMessage());
        }
    }

    @Test
    public void testInvalidFormatArguments() {
        try {
            CurrencyConverter.main(new String[]{"abc", "dollars"});
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("Error: Amount should be a numeric value.", e.getMessage());
        }
    }

    @Test
    public void testMissingCurrencyArgument() {
        try {
            CurrencyConverter.main(new String[]{"100"});
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("Error: Please provide both an amount and a currency type.", e.getMessage());
        }
    }

    @Test
    public void testCurrencyCaseInsensitive() {
        assertEquals("100 Dollars = 74 Pounds, 88 Euros", CurrencyConverter.convert(100, "dollars"));
        assertEquals("100 Dollars = 74 Pounds, 88 Euros", CurrencyConverter.convert(100, "DOLLARS"));
        assertEquals("100 Dollars = 74 Pounds, 88 Euros", CurrencyConverter.convert(100, "Dollars"));

        assertEquals("100 Pounds = 136 Dollars, 119 Euros", CurrencyConverter.convert(100, "pounds"));
        assertEquals("100 Pounds = 136 Dollars, 119 Euros", CurrencyConverter.convert(100, "POUNDS"));
        assertEquals("100 Pounds = 136 Dollars, 119 Euros", CurrencyConverter.convert(100, "Pounds"));

        assertEquals("100 Euros = 113 Dollars, 84 Pounds", CurrencyConverter.convert(100, "euros"));
        assertEquals("100 Euros = 113 Dollars, 84 Pounds", CurrencyConverter.convert(100, "EUROS"));
        assertEquals("100 Euros = 113 Dollars, 84 Pounds", CurrencyConverter.convert(100, "Euros"));
    }

    @Test
    public void testDollarConversions() {
        assertEquals("100 Dollars = 74 Pounds, 88 Euros", CurrencyConverter.convert(100, "dollars"));
    }

    @Test
    public void testPoundConversions() {
        assertEquals("100 Pounds = 136 Dollars, 119 Euros", CurrencyConverter.convert(100, "pounds"));
    }

    @Test
    public void testEuroConversions() {
        assertEquals("100 Euros = 113 Dollars, 84 Pounds", CurrencyConverter.convert(100, "euros"));
    }
}
