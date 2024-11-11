import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CurrencyConverterTest {

    // Argument Validity Tests
    @Test
    void testNoArguments() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            CurrencyConverter.main(new String[]{});
        });
        assertEquals("Error: Please provide both an amount and a currency type.", exception.getMessage());
    }

    @Test
    void testInvalidFormatArguments() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            CurrencyConverter.main(new String[]{"abc", "dollars"});
        });
        assertEquals("Error: Amount should be a numeric value.", exception.getMessage());
    }

    @Test
    void testMissingCurrencyArgument() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            CurrencyConverter.main(new String[]{"100"});
        });
        assertEquals("Error: Please provide both an amount and a currency type.", exception.getMessage());
    }


    @Test
    void testCurrencyCaseInsensitive() {
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
    void testDollarConversions() {
        assertEquals("100 Dollars = 74 Pounds, 88 Euros", CurrencyConverter.convert(100, "dollars"));
    }

    @Test
    void testPoundConversions() {
        assertEquals("100 Pounds = 136 Dollars, 119 Euros", CurrencyConverter.convert(100, "pounds"));
    }

    @Test
    void testEuroConversions() {
        assertEquals("100 Euros = 113 Dollars, 84 Pounds", CurrencyConverter.convert(100, "euros"));
    }
}