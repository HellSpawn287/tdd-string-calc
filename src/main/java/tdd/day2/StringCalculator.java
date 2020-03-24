package tdd.day2;

public class StringCalculator {

    public static final String RESULT_ZERO = "0";

    public String add(String number) {
        if(number.isEmpty())
            return RESULT_ZERO;
        else return number;
    }
}
