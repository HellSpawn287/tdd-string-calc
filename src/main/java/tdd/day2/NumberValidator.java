package tdd.day2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberValidator {
    public static final String REGEX_INVALID_SEPARATOR = "\n,";
    public static final String INVALID_SEPARATOR_ERROR = "Number expected but '\\n' found at position %d";
    private String validationError = "";

    public void validateInput(String number) {
        int invalidSeparatorPosition = getInvalidSeparatorPosition(number);
        if (invalidSeparatorPosition >= 0)
            validationError = String.format(INVALID_SEPARATOR_ERROR, invalidSeparatorPosition);
    }

    public boolean isError() {
        return !validationError.isEmpty();
    }

    public String getValidationError() {
        return validationError;
    }

    private int getInvalidSeparatorPosition(String number) {
        Pattern pattern = Pattern.compile(REGEX_INVALID_SEPARATOR);
        Matcher matcher = pattern.matcher(number);
        if (matcher.find())
            return matcher.start();
        else return -1;
    }
}
