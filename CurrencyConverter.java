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

        double dollar, pound, euro;
        DecimalFormat f = new DecimalFormat("##.##");

        String currency = args[1].toLowerCase();

        // For amounts Conversion
        switch (currency) {
            case "dollars":
                pound = amount * 0.74;
                System.out.println(amount + " Dollars = " + f.format(pound) + " Pounds");
                euro = amount * 0.88;
                System.out.println(amount + " Dollars = " + f.format(euro) + " Euros");
                break;
            case "pounds":
                dollar = amount * 1.36;
                System.out.println(amount + " Pounds = " + f.format(dollar) + " Dollars");
                euro = amount * 1.19;
                System.out.println(amount + " Pounds = " + f.format(euro) + " Euros");
                break;
            case "euros":
                dollar = amount * 1.13;
                System.out.println(amount + " Euros = " + f.format(dollar) + " Dollars");
                pound = amount * 0.84;
                System.out.println(amount + " Euros = " + f.format(pound) + " Pounds");
                break;
            default:
                System.out.println("Error: Unsupported currency type.");
        }
        System.out.println("Thank you for using the converter.");
    }
}

