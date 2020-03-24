package tdd.day2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    @ParameterizedTest(name = "Summing for {1} is {0}")
    @CsvSource({
            "7.02, '1.23,2.34,3.45'",
            "7.02002, '1.23002,2.34,3.45'",
            "-7.02, '-1.23,-2.34,-3.45'",
            "7.02, '1.23,2.34,3.45'",
            "3.57, '1.23,2.34'",
    }
    )
    void shouldSumNumbers(String expected, String numbers) {
        //given
        //when
        String sum = new StringCalculator().add(numbers);
        //then
        Assertions.assertEquals(expected, sum);
    }

    @ParameterizedTest(name = "Summing for {1} is {0}")
    @CsvSource({
            "7.02, '1.23\n2.34\n3.45'",
            "7.02002, '1.23002\n2.34\n3.45'",
            "-7.02, '-1.23\n-2.34\n-3.45'",
            "7.05, '1.23,2.34\n3.48'",
            "3.57, '1.23\n2.34'",
    })
    void shouldSumWithNewLineSeparator(String expected, String numbers) {
        //given
        //when
        String sum = new StringCalculator().add(numbers);
        //then
        Assertions.assertEquals(expected, sum);
    }

    @ParameterizedTest(name = "Summing for {1} is {0}")
    @CsvSource({
            "Number expected but '\\n' found at position 4, '1.23\n,2.34\n3.45'",
            "Number expected but '\\n' found at position 9, '1.23\n2.34\n,3.45'",
    })
    void shouldNotSumWithConsecutiveSeparators(String expected, String numbers) {
        //given
        //when
        String sum = new StringCalculator().add(numbers);
        //then
        Assertions.assertEquals(expected, sum);
    }
}
