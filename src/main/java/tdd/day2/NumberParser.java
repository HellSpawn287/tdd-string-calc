package tdd.day2;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class NumberParser {
    public static final String REGEX_NUM_SEPARATOR = "\\,|\n";
    private NumberValidator validator = new NumberValidator();

    public Optional<List<BigDecimal>> parse(String numbers) {
        validator.validateInput(numbers);
        if(validator.isError())
            return Optional.ofNullable(null);
        else return Optional.of(convertToBigDecimals(parseNumbers(numbers)));
    }

    public String getError() {
        return validator.getValidationError();
    }

    private List<String> parseNumbers(String number) {
        return Arrays.asList(number.split(REGEX_NUM_SEPARATOR));
    }

    private List<BigDecimal> convertToBigDecimals(List<String> numbers) {
        List<BigDecimal> bigDecimals = new ArrayList<>();
        for (String number : numbers) {
            bigDecimals.add(new BigDecimal(number));
        }
        return bigDecimals;
    }



}
