package tdd.day2;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public class StringCalculator {

    public static final String RESULT_ZERO = "0";
    private NumberParser numberParser = new NumberParser();

    public String add(String number) {
        if (number.isEmpty())
            return RESULT_ZERO;
        else return sumMany(number);
    }

    private String sumMany(String number) {
        Optional<List<BigDecimal>> numbers = numberParser.parse(number);

        if (numbers.isEmpty())
            return numberParser.getError();
        else return addNumbers(numbers.get()).toString();
    }

    private BigDecimal addNumbers(List<BigDecimal> numbers) {
        BigDecimal sum = new BigDecimal(0);
        for (BigDecimal number : numbers) {
            sum = sum.add(number);
        }
        return sum;
    }
}
