package tdd.day2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StringCalculatorTest {

    @Test
    void shouldReturnZeroForEmpty() {
        //given
        String empty = "";
        //when
        String result = new StringCalculator().add(empty);
        //then
        Assertions.assertEquals("0", result);
    }

    @Test
    void shouldReturnOneNumberForOneNumber() {
        //given
        String number = "1.23";
        //when
        String result = new StringCalculator().add(number);
        //then
        Assertions.assertEquals(number, result);
    }

    @ParameterizedTest(name = "Summing for {1} + {2} + {3} is {0}")
    @CsvSource({
               "7.02, 1.23, 2.34, 3.45",
               "7.02002, 1.23002, 2.34, 3.45",
               "-7.02, -1.23, -2.34, -3.45",
               "7.02, 1.23, 2.34, 3.45",
            }
    )
    void shouldSum3Numbers(String expected, String number1, String number2, String number3) {
        //given
        //when
        String sum = new StringCalculator().add(joinNumbers(number1, number2, number3));
        //then
        Assertions.assertEquals(expected, sum);
    }

    private String joinNumbers(String number1, String number2, String number3) {
        return Arrays.asList(number1, number2, number3).stream().collect(Collectors.joining(","));
    }
}
