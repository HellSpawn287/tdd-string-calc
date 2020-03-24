package tdd.day2;

import java.math.BigDecimal;

public class StringCalculator {

    public static final String RESULT_ZERO = "0";

    public String add(String number) {
        if(number.isEmpty())
            return RESULT_ZERO;
        else {
            return sumMany(number);
        }
    }

    private String sumMany(String number) {
        String[] numbers = number.split("\\,");
        BigDecimal sum = addNumbers(numbers);
        return sum.toString();
    }

    private BigDecimal addNumbers(String[] numbers) {
        BigDecimal sum = new BigDecimal(0);
        for (String component: numbers) {
            sum = sum.add(new BigDecimal(component));
        }
        return sum;
    }
}
