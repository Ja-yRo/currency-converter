import java.util.*;
import java.text.DecimalFormat;

public class CurrencyConverter {

    public static void main(String[] args) {

        if (args.length < 2) {
            throw new IllegalArgumentException("Error: Please provide both an amount and a currency type.");
        }

        double amount;
        try {
            amount = Double.parseDouble(args[0]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Error: Amount should be a numeric value.");
        }

        String currency = args[1].toLowerCase();
        String result = convert(amount, currency);
        System.out.println(result);

        System.out.println("Thank you for using the converter.");
    }

    public static String convert(double amount, String currency) {
        double dollar, pound, euro;
        DecimalFormat f = new DecimalFormat("##.##");
        String result;

        // For amounts Conversion
        switch (currency) {
            case "dollars":
                pound = amount * 0.74;
                euro = amount * 0.88;
                result = amount + " Dollars = " + f.format(pound) + " Pounds, " + f.format(euro) + " Euros";
                break;
            case "pounds":
                dollar = amount * 1.36;
                euro = amount * 1.19;
                result = amount + " Pounds = " + f.format(dollar) + " Dollars, " + f.format(euro) + " Euros";
                break;
            case "euros":
                dollar = amount * 1.13;
                pound = amount * 0.84;
                result = amount + " Euros = " + f.format(dollar) + " Dollars, " + f.format(pound) + " Pounds";
                break;
            default:
                result = "Error: Unsupported currency type.";
        }
        return result;
    }
}

