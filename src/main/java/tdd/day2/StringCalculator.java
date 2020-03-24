package tdd.day2;

import java.math.BigDecimal;

public class StringCalculator {

    public static final String RESULT_ZERO = "0";

    public String add(String number) {
        if (number.isEmpty())
            return RESULT_ZERO;
        else return sumMany(number);
    }

    private String sumMany(String number) {
        String[] numbers = parseNumbers(number);
        BigDecimal sum = addNumbers(numbers);
        return sum.toString();
    }

    private String[] parseNumbers(String number) {
        return number.split("\\,");
    }

    private BigDecimal addNumbers(String[] numbers) {
        BigDecimal sum = new BigDecimal(0);
        for (String number : numbers) {
            sum = sum.add(new BigDecimal(number.strip()));
        }
        return sum;
    }
}
